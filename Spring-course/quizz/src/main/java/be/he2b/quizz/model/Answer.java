package be.he2b.quizz.model;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnore;

import groovyjarjarantlr4.v4.runtime.misc.NotNull;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Getter
@Setter
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "answer_generator")
    @SequenceGenerator(name = "answer_generator", sequenceName = "answer_seq", allocationSize = 1)

    private Integer id;
    @ManyToOne
    @JoinColumn(name = "question_number", nullable = false, referencedColumnName = "number")
    @JsonIgnore
    private Question question;
    private boolean agree;
    @NotNull
    private LocalDate dateAdded;

    public String toString() {
        return "~\n\nAnswer(id=" + this.getId() + ", agree=" + this.isAgree() + ", dateAdded=" + this.getDateAdded() + ")\n";
    }
}
