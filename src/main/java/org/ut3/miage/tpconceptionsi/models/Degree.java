package org.ut3.miage.tpconceptionsi.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.ut3.miage.tpconceptionsi.enums.DegreeType;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@IdClass(DegreeId.class)
public class Degree {
    @Id
    private String name;

    @Enumerated(EnumType.STRING)
    private DegreeType type;

    @Id
    private int year;

    private int maxEtu;

    private int ects;

    @ManyToMany(cascade = CascadeType.PERSIST)
    private Set<UE> ues = new HashSet<>();

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
