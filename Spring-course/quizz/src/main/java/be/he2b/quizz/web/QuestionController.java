package be.he2b.quizz.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import be.he2b.quizz.business.QuizzService;
import be.he2b.quizz.model.Answer;
import be.he2b.quizz.model.Question;
import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class QuestionController {
    @Autowired
    private QuizzService quizzService;

    @GetMapping("/")
    public String home(Model model) { 
        model.addAttribute("questions", quizzService.getQuestionsStats());
        return "home";
    }

    @GetMapping("/details")
    public String detail(Model model, @RequestParam("id") int number) {
        model.addAttribute("entity_answer", new Answer());
        model.addAttribute("question", quizzService.getQuestion(number));
        return "detail";
    }

    @PostMapping("/question/addAnswer")
    public String addAnswer(Model model, Answer answer,@RequestParam("question") int number) {
        quizzService.addAnswer(answer,number);
        return "redirect:/details?id=" + number;
    }
}
