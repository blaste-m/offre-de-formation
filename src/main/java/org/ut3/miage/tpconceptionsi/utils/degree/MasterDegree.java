package org.ut3.miage.tpconceptionsi.utils.degree;

import org.ut3.miage.tpconceptionsi.enums.DegreeType;
import org.ut3.miage.tpconceptionsi.models.Degree;
import org.ut3.miage.tpconceptionsi.models.Year;
import org.ut3.miage.tpconceptionsi.models.YearId;

import java.util.HashSet;

public class MasterDegree {

    public Degree create(String name, int maxEtu) {

        Degree degree = new Degree(name, DegreeType.MASTER, new HashSet<>(), maxEtu, 120);

        for (int i = 0; i < 2; i++) {
            Year year = new Year(new YearId(degree.getName(), i + 1), degree);
            degree.getYears().add(year);
        }

        return degree;
    }
}
