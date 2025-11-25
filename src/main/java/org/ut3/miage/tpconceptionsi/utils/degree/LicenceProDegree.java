package org.ut3.miage.tpconceptionsi.utils.degree;

import org.ut3.miage.tpconceptionsi.enums.DegreeType;
import org.ut3.miage.tpconceptionsi.models.Degree;
import org.ut3.miage.tpconceptionsi.models.Year;
import org.ut3.miage.tpconceptionsi.models.YearId;

import java.util.ArrayList;
import java.util.HashSet;

public class LicenceProDegree {

    public Degree create(String name, int maxEtu) {

        Degree degree = new Degree(name, DegreeType.LICENCE_PRO, new ArrayList<>(), maxEtu, 60);

        Year year = new Year(1, degree);
        degree.getYears().add(year);

        return degree;
    }
}
