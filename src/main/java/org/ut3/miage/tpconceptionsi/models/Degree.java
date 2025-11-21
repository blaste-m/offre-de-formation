package org.ut3.miage.tpconceptionsi.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.ut3.miage.tpconceptionsi.enums.DegreeType;

@Data @Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="diplôme")
public class Degree {

    @Id private String name;
    private DegreeType type;
    private int year;
    private int maxEtu;
    private int ects;

}
