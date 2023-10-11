package esi5.revision.Revision.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity
public class AnnualProgram {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "annualProgram_generator")
    @SequenceGenerator(name = "annualProgram_generator", sequenceName = "annual_seq", allocationSize = 10 )
    private int id;

    @OneToMany(mappedBy = "annual_program_id")
    private List<Registration> registrations;

    @OneToOne
    @JoinColumn(name = "student_number", referencedColumnName = "number")
    private Student student;

    public String toString(){
        String s = "Registrations : ";
        for(Registration regist : registrations){
            s +=regist.getUnit_id() + " ";
        }
        return "AnnualProgram : "+id+"  "+student + " " + s;
    }
}
