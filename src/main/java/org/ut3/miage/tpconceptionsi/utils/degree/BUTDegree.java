package org.ut3.miage.tpconceptionsi.utils.degree;

import org.ut3.miage.tpconceptionsi.enums.DegreeType;
import org.ut3.miage.tpconceptionsi.models.Degree;
import org.ut3.miage.tpconceptionsi.models.Year;
import org.ut3.miage.tpconceptionsi.models.YearId;

import java.util.HashSet;

public class BUTDegree {

    public Degree create(String name, int maxEtu) {

        Degree degree = new Degree(name, DegreeType.BUT, new HashSet<>(), maxEtu, 180);

        for (int i = 1; i <= 3; i++) {
            Year year = new Year(new YearId(degree.getName(), i), degree);
            degree.getYears().add(year);
        }

        return degree;
    }

}
