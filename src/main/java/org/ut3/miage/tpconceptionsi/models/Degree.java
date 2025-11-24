package org.ut3.miage.tpconceptionsi.models;

import jakarta.persistence.*;
import lombok.*;
import org.ut3.miage.tpconceptionsi.enums.DegreeType;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="diplôme")
public class Degree {
    @Id
    private String name;

    @Enumerated(EnumType.STRING)
    private DegreeType type;

    @OneToMany(mappedBy = "degree", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Year> years = new HashSet<>();

    private int maxEtu;
    private int ects;

}
