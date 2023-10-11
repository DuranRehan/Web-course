package be.he2b.quizz.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import be.he2b.quizz.model.Answer;
import be.he2b.quizz.model.AnswerRepository;
import be.he2b.quizz.model.Question;
import be.he2b.quizz.model.QuestionDto;
import be.he2b.quizz.model.QuestionRepository;

@Service
public class QuizzService {
    @Autowired
    private QuestionRepository questionRepository;
    @Autowired
    private AnswerRepository answerRepository;

    public List<QuestionDto> getQuestionsStats() {
        for (QuestionDto questionDto : questionRepository.findQuestionsStats()) {
            System.out.println(questionDto);
        }
        return questionRepository.findQuestionsStats();
    }

    public Question getQuestion(int number) {
        return questionRepository.findByNumberWithAnswer(number);
    }

    public void addAnswer(Answer answer, int number) {
        Question question = questionRepository.findById(number).get();
        question.getItems().add(answer);
        answer.setQuestion(question);
        answer.setDateAdded(java.time.LocalDate.now());
        answerRepository.save(answer);
    }

    public List<Question> getQuestionTextContaining(String text) {
        return questionRepository.findByTextContaining(text);
    }
}
