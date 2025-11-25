package org.ut3.miage.tpconceptionsi.services;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.hibernate.Hibernate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.ut3.miage.tpconceptionsi.models.Degree;
import org.ut3.miage.tpconceptionsi.models.Year;
import org.ut3.miage.tpconceptionsi.models.YearId;
import org.ut3.miage.tpconceptionsi.parsers.DegreeArgumentParser;
import org.ut3.miage.tpconceptionsi.repositories.DegreeRepository;
import org.ut3.miage.tpconceptionsi.repositories.YearRepository;
import org.ut3.miage.tpconceptionsi.requests.DegreeCreationRequest;
import org.ut3.miage.tpconceptionsi.utils.degree.DegreeFactory;
import org.ut3.miage.tpconceptionsi.validators.DegreeCreationValidator;


@Service
@RequiredArgsConstructor
public class DegreeService {
    private final YearRepository yearRepository;
    private final DegreeRepository degreeRepository;
    private final DegreeFactory factory;
    private final DegreeArgumentParser parser;
    private final DegreeCreationValidator validator;

    public Degree createDegree(String... args) {
            DegreeCreationRequest request = parser.parseCreateDegree(args);
            validator.validate(request);

            Degree degree = factory.create(request);

            if (degreeRepository.existsById(degree.getName())) {
                throw new IllegalArgumentException("Degree " + degree.getName() + " already exists");
            }

            return degreeRepository.save(degree);
    }

    @Transactional
    public Degree selectDegree(String... args) {

            String degreeName = parser.parseSelectDegree(args);

            Degree degree = degreeRepository.findById(degreeName)
                    .orElseThrow(() -> new IllegalArgumentException("Degree " + degreeName + " not found"));

            Hibernate.initialize(degree.getYears());

            return degree;

    }

    @Transactional(readOnly = true)
    public Year selectYear(Degree degree, String... args) {

        int yearNumber = parser.parseSelectYear(degree, args);

        YearId yearId = new YearId(degree.getName(), yearNumber);

        Year year = yearRepository.findById(yearId)
                .orElseThrow(() -> new IllegalArgumentException("Year " + yearNumber + " not found for degree " + degree.getName()));

        Hibernate.initialize(year.getUes());

        return year;

    }
}
