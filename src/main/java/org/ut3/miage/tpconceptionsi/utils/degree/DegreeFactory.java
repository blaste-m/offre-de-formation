package org.ut3.miage.tpconceptionsi.utils.degree;

import org.springframework.stereotype.Component;
import org.ut3.miage.tpconceptionsi.enums.DegreeType;
import org.ut3.miage.tpconceptionsi.models.Degree;
import org.ut3.miage.tpconceptionsi.requests.DegreeCreationRequest;

import java.util.HashSet;

@Component
public class DegreeFactory {

    public Degree create(DegreeCreationRequest request) {

        String name = request.name();
        DegreeType type = request.type();
        int maxEtu = request.maxEtu();
        int year = request.year();
        int ects = request.ects();

        return new Degree(
                name,
                type,
                year,
                maxEtu,
                ects,
                new HashSet<>()
        );
    }
}
