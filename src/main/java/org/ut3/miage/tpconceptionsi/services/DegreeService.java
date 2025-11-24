package org.ut3.miage.tpconceptionsi.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.ut3.miage.tpconceptionsi.models.Degree;
import org.ut3.miage.tpconceptionsi.parsers.DegreeArgumentParser;
import org.ut3.miage.tpconceptionsi.repositories.DegreeRepository;
import org.ut3.miage.tpconceptionsi.requests.DegreeCreationRequest;
import org.ut3.miage.tpconceptionsi.utils.degree.DegreeFactory;
import org.ut3.miage.tpconceptionsi.validators.DegreeValidator;

@Service
@RequiredArgsConstructor
public class DegreeService {
    private final DegreeRepository degreeRepository;
    private final DegreeFactory degreeFactory = new DegreeFactory();
    private final DegreeValidator degreeValidator = new DegreeValidator();
    private final DegreeArgumentParser degreeArgumentParser = new DegreeArgumentParser();

    public String create(String... args) {
        try {
            DegreeCreationRequest request = degreeArgumentParser.parse(args);
            degreeValidator.validate(request);

            Degree degree = degreeFactory.create(request);
            degreeRepository.save(degree);

            return "Degree created: " + degree.getName();
        } catch (IllegalArgumentException e) {
            return e.getMessage();
        } catch (Exception e) {
            return "Error while creating degree: " + e.getMessage();
        }
    }
}
