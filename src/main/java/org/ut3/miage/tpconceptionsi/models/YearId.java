package org.ut3.miage.tpconceptionsi.models;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Embeddable
@Setter @Getter
@NoArgsConstructor
@AllArgsConstructor
public class YearId {
    private String degree;
    private int year;
}
