package esi5.revision.Revision.model;

import groovy.transform.EqualsAndHashCode;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
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
@EqualsAndHashCode
public class Student {
    @Id
    private int number;
    @NotBlank
    private String name;
    @NotNull
    @Min(1)
    @Max(3)
    private int bloc;
    @Enumerated(EnumType.STRING)
    private Section section;

}
