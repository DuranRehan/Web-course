package g56055.webg5.pae.model;

import java.util.List;

import org.springframework.lang.NonNull;

import groovy.transform.EqualsAndHashCode;
import jakarta.validation.constraints.Min;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class Course {
    @Id
    @NotBlank(message = "Le sigle ne peut pas être vide")
    @Pattern(regexp = "[a-zA-Z]{3,}\\d{1,}", message = "Le sigle doit comporté au minimum 3 caractères et 1 chiffre")
    private String id;

    @NotBlank(message = "Le titre ne peut pas être vide")
    private String title;

    @NonNull
    @Min(value = 1, message = "Le nombre de crédits doit être supérieur à 0")
    @Max(value = 10, message = "Le nombre de crédits doit être inférieur à 10 inclus")
    private int credits;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "course_student",joinColumns = @JoinColumn(name = "course_id", referencedColumnName = "id"),inverseJoinColumns = @JoinColumn(name = "student_id", referencedColumnName = "matricule"))
    private List<Student> students;
    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + credits;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((title == null) ? 0 : title.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Course other = (Course) obj;
        if (credits != other.credits)
            return false;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (title == null) {
            if (other.title != null)
                return false;
        } else if (!title.equals(other.title))
            return false;
        return true;
    }

}
