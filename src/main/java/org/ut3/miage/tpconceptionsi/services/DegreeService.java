package org.ut3.miage.tpconceptionsi.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.ut3.miage.tpconceptionsi.models.Degree;
import org.ut3.miage.tpconceptionsi.models.DegreeId;
import org.ut3.miage.tpconceptionsi.parsers.DegreeArgumentParser;
import org.ut3.miage.tpconceptionsi.repositories.DegreeRepository;
import org.ut3.miage.tpconceptionsi.requests.DegreeCreationRequest;
import org.ut3.miage.tpconceptionsi.utils.degree.DegreeFactory;
import org.ut3.miage.tpconceptionsi.validators.DegreeCreationValidator;

import java.util.List;


@Service
@RequiredArgsConstructor
public class DegreeService {
    private final DegreeRepository degreeRepository;
    private final DegreeFactory factory;
    private final DegreeArgumentParser parser;
    private final DegreeCreationValidator validator;

    public Degree createDegree(String... args) {
            DegreeCreationRequest request = parser.parseCreateDegree(args);
            validator.validate(request);

            Degree degree = factory.create(request);

            DegreeId degreeId = new DegreeId(degree.getName(), degree.getYear());

            if (degreeRepository.existsById(degreeId)) {
                throw new IllegalArgumentException("Error: degree " + degree.getName() + " already exists");
            }

            return degreeRepository.save(degree);
    }

    @Transactional
    public Degree selectDegree(String... args) {

        String degreeName = parser.parseSelectDegree(args);

        return degreeRepository.findFirstByNameOrderByYearAsc(degreeName)
                .orElseThrow(() -> new IllegalArgumentException("Error: degree " + degreeName + " not found"));

    }

    @Transactional Degree selectByYear(Degree degree, String... args) {

        int year = parser.parseSelectYear(degree, args);

        if (degree == null)
            throw new IllegalArgumentException(
                    "Error: no degree selected. Select a degree before selecting a year"
            );

        DegreeId degreeId = new DegreeId(degree.getName(), year);

        return degreeRepository.findById(degreeId)
                .orElseThrow(() -> new IllegalArgumentException(
                        "Error: no match found for degree name " + degree.getName() + " and year " + year
                ));
    }
}
