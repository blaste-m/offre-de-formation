package org.ut3.miage.tpconceptionsi.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.ut3.miage.tpconceptionsi.enums.DegreeType;
import org.ut3.miage.tpconceptionsi.models.Degree;
import org.ut3.miage.tpconceptionsi.repositories.DegreeRepository;

@Service
@RequiredArgsConstructor
public class DegreeService {
    private final DegreeRepository degreeRepository;

    public String createDegree(String... args) {

        String name = args[0];
        DegreeType type = DegreeType.valueOf(args[1]);
        int year = Integer.parseInt(args[2]);
        int maxEtu = Integer.parseInt(args[3]);
        int ects = Integer.parseInt(args[4]);

        Degree degree = new Degree(
                name, type, year, maxEtu, ects
        );

        degreeRepository.save(degree);

        return "Success";
    }
}
