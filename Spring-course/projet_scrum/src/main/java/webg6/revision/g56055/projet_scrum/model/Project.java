package webg6.revision.g56055.projet_scrum.model;

import java.util.List;

import groovy.transform.EqualsAndHashCode;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class Project {
    @Id
    private String name;
    private Boolean active;
    @OneToMany(fetch = FetchType.EAGER,mappedBy = "project")
    List<Sprint> sprints;
}
