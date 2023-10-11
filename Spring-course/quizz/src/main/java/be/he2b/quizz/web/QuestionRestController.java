package be.he2b.quizz.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import be.he2b.quizz.business.QuizzService;
import be.he2b.quizz.model.Question;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/question")
public class QuestionRestController {
    @Autowired
    QuizzService quizzService;

    @GetMapping("/textContaining")
    public ResponseEntity<List<Question>> getQuestionTextContaining(@RequestParam(required = false,defaultValue = "") String like) {
        if (like == null) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
        try {
            List<Question> questions = quizzService.getQuestionTextContaining(like);
            return ResponseEntity.ok(questions);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
