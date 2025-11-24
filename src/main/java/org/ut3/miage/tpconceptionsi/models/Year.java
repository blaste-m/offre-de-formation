package org.ut3.miage.tpconceptionsi.models;

import jakarta.persistence.*;
import lombok.*;
import org.ut3.miage.tpconceptionsi.enums.DegreeType;

import java.util.Set;

@Entity
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "année")
public class Year {
    @EmbeddedId
    private YearId id;

    @ManyToOne
    private Degree degree;

    public Year(int year, Degree degree) {
        this.degree = degree;
        this.id.setYear(year);
        this.id.setDegree(degree.getName());
    }

}
