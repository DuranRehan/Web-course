package esi5.revision.Revision.model;

import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
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
public class Unit {
    @Id
    private String id;
    @NotBlank
    private String title;
    @NotNull
    @Min(1)
    @Max(6)
    private int semester;
    @Min(1)
    private int ects;
    @NotEmpty
    @ElementCollection
    @Enumerated(EnumType.STRING)
    private Set<Section> sections;

    @OneToMany(mappedBy = "unit_id")
    @JsonIgnore
    private List<Registration> registrations;

    public String toString() {
        return "Unit : " + id + " " + title + " " + semester + " " + ects + " " + sections;
    }

}
