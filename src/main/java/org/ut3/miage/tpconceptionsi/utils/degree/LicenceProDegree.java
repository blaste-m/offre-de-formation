package org.ut3.miage.tpconceptionsi.utils.degree;

import org.ut3.miage.tpconceptionsi.enums.DegreeType;
import org.ut3.miage.tpconceptionsi.models.Degree;
import org.ut3.miage.tpconceptionsi.models.Year;

import java.util.HashSet;

public class LicenceProDegree {

    private final DegreeType type = DegreeType.LICENCE_PRO;
    private final int ects = 60;

    public Degree create(String name, int maxEtu) {

        Degree degree = new Degree(name, type, new HashSet<>(), maxEtu, ects);

        Year y1 = new Year("LPro " + name, degree);

        degree.getYears().add(y1);

        return degree;
    }
}
