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
    @Id
    private String id;

    @ManyToOne
    private Degree degree;

}
