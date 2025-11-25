package org.ut3.miage.tpconceptionsi.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "ue")
public class UE {
    @Id
    private String name;

    private int ects;

    private int cm;

    private int td;

    private int tp;

    @ManyToMany(mappedBy = "ues")
    private Set<Year> years;
}
