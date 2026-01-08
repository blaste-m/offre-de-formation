package org.ut3.miage.tpconceptionsi.models;

import lombok.*;

import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@RequiredArgsConstructor
public class DegreeId implements Serializable {

    private String name;
    private int year;

    public DegreeId(String name, int year) {
        this.name = name;
        this.year = year;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DegreeId degreeId)) return false;
        return year == degreeId.year && Objects.equals(name, degreeId.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, year);
    }

}