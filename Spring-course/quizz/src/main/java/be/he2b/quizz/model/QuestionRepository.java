package be.he2b.quizz.model;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface QuestionRepository extends CrudRepository<Question, Integer> {
    List<Question> findByTextContaining(String searchString);

    @Query("SELECT new be.he2b.quizz.model.QuestionDto(q.number, q.text, SUM(CASE WHEN a.agree = true THEN 1 ELSE 0 END),"
            + "SUM(CASE WHEN a.agree = false THEN 1 ELSE 0 END)) "
            + "FROM Question q JOIN Answer a GROUP BY q.number, q.text ORDER BY q.number")
    List<QuestionDto> findQuestionsStats();

    @Query("SELECT q FROM Question q JOIN Answer a WHERE q.number = ?1")
    Question findByNumberWithAnswer(int number);
}
