package org.ut3.miage.tpconceptionsi.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.ut3.miage.tpconceptionsi.enums.DegreeType;

import java.util.ArrayList;
import java.util.List;

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
    private List<Year> years = new ArrayList<>();

    private int maxEtu;
    private int ects;

    @Override
    public String toString() {
        return "{ " +
                "name='" + name + '\'' +
                ", type=" + type.toString() +
                ", maxEtu=" + maxEtu +
                ", ects=" + ects +
                " }";
    }
}
