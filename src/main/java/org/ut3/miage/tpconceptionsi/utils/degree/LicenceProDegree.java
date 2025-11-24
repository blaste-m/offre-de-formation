package org.ut3.miage.tpconceptionsi.utils.degree;

import org.ut3.miage.tpconceptionsi.enums.DegreeType;
import org.ut3.miage.tpconceptionsi.models.Degree;
import org.ut3.miage.tpconceptionsi.models.Year;
import org.ut3.miage.tpconceptionsi.models.YearId;

import java.util.HashSet;

public class LicenceProDegree {

    public Degree create(String name, int maxEtu) {

        Degree degree = new Degree(name, DegreeType.LICENCE_PRO, new HashSet<>(), maxEtu, 60);

        Year year = new Year(new YearId(degree.getName(), 1), degree);
        degree.getYears().add(year);

        return degree;
    }
}
