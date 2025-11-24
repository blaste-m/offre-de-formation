package org.ut3.miage.tpconceptionsi.utils.degree;

import org.ut3.miage.tpconceptionsi.enums.DegreeType;
import org.ut3.miage.tpconceptionsi.models.Degree;
import org.ut3.miage.tpconceptionsi.models.Year;

import java.util.HashSet;

public class LicenceDegree {

    private final DegreeType type = DegreeType.LICENCE;
    private final int ects = 180;

    public Degree create(String name, int maxEtu) {

        Degree degree = new Degree(name, type, new HashSet<>(), maxEtu, ects);

        Year y1 = new Year("L1 " + name, degree);
        Year y2 = new Year("L2 " + name, degree);
        Year y3 = new Year("L3 " + name, degree);

        degree.getYears().add(y1);
        degree.getYears().add(y2);
        degree.getYears().add(y3);

        return degree;
    }
}
