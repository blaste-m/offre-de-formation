package org.ut3.miage.tpconceptionsi.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class Teacher {

    @Id
    private String nom;
    private String prenom;

    @ManyToMany(cascade = CascadeType.PERSIST)
    private Set<UE> ues = new HashSet<>();
}
