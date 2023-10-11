package webg6.revision.g56055.projet_scrum.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import groovy.transform.EqualsAndHashCode;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class Story {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "story_generator")
    @SequenceGenerator(name = "story_generator", sequenceName = "story_seq", allocationSize = 100)
    private int id;
    private String title;
    @Min(1)
    private int estimate;
    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER)
    private Sprint sprint;
}
