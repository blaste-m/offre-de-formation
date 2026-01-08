package org.ut3.miage.tpconceptionsi.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class UE {
    @Id
    private String name;

    private int ects;

    private int cm;

    private int td;

    private int tp;

    @ManyToMany(mappedBy = "ues")
    private Set<Degree> degrees = new HashSet<>();

    @ManyToMany(mappedBy = "ues")
    private Set<Teacher> teachers = new HashSet<>();

    public void addDegree(Degree degree) {
        this.degrees.add(degree);
        degree.getUes().add(this);
    }

    public void addTeacher(Teacher teacher) {
        this.teachers.add(teacher);
        teacher.getUes().add(this);
    }
}
