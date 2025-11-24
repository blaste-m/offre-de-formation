package org.ut3.miage.tpconceptionsi.utils.degree;

import org.ut3.miage.tpconceptionsi.enums.DegreeType;
import org.ut3.miage.tpconceptionsi.models.Degree;
import org.ut3.miage.tpconceptionsi.models.Year;

import java.util.HashSet;

public class MasterDegree {

    private final DegreeType type = DegreeType.MASTER;
    private final int ects = 120;

    public Degree create(String name, int maxEtu) {

        Degree degree = new Degree(name, type, new HashSet<>(), maxEtu, ects);

        Year y1 = new Year("M1 " + name, degree);
        Year y2 = new Year("M2 " + name, degree);

        degree.getYears().add(y1);
        degree.getYears().add(y2);

        return degree;
    }
}
