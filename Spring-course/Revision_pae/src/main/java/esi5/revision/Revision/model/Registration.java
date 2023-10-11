package esi5.revision.Revision.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Registration {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "registration_generator")
    @SequenceGenerator(name = "registration_generator", sequenceName = "registration_seq", allocationSize = 100)
    private int id;

    @NotNull
    private boolean mandatory;

    @ManyToOne
    @JoinColumn(nullable = false, name = "annual_program_id", referencedColumnName = "id")
    @JsonIgnore
    private AnnualProgram annual_program_id;

    @ManyToOne
    @JoinColumn(nullable = false, name = "unit_id", referencedColumnName = "id")
    private Unit unit_id;

    public String toString(){
        return "Registration : "+id+" "+mandatory +" " + unit_id + " ";
    }
}
