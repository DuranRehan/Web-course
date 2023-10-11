package be.he2b.quizz.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class QuestionDto {
    int questionNumber;
    String questionText;
    Long nbPositiveAnswers;
    Long nbNegativeAnswers;
}
