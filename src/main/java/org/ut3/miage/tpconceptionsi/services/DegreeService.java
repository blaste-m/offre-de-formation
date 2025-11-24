package org.ut3.miage.tpconceptionsi.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
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
    private final DegreeRepository degreeRepository;
    private final YearRepository yearRepository;
    private final DegreeFactory factory = new DegreeFactory();
    private final DegreeArgumentParser parser = new DegreeArgumentParser();
    private final DegreeCreationValidator validator = new DegreeCreationValidator();

    public Degree degree = null;
    public Year year = null;

    public String createDegree(String... args) {
        try {
            DegreeCreationRequest request = parser.parseCreateDegree(args);
            validator.validate(request);

            Degree degree = factory.create(request);
            degreeRepository.save(degree);

            return "Degree created: " + degree.getName();
        } catch (IllegalArgumentException e) {
            return e.getMessage();
        } catch (Exception e) {
            return "Error while creating degree: " + e.getMessage();
        }
    }


    public String selectDegree(String... args) {

        try {
            String degreeName = parser.parseSelectDegree(args);
            degree = degreeRepository.findById(degreeName)
                    .orElseThrow(() -> new IllegalArgumentException("Degree " + degreeName + " not found"));

            return "Degree selected: " + degree.toString();
        } catch (IllegalArgumentException e) {
            return e.getMessage();
        } catch (Exception e) {
            return "Error while selecting degree: " + e.getMessage();
        }
    }

    public String selectYear(String... args) {

        try {
            if (degree == null)
                return "No degree selected. Please select a degree first";

            int yearNumber = parser.parseSelectYear(degree, args);

            year = yearRepository.findById(new YearId(degree.getName(), yearNumber)).get();

            return "Year " + yearNumber + " selected for degree " + degree.getName();
        } catch (IllegalArgumentException e) {
            return e.getMessage();
        } catch (Exception e) {
            return "Error while selecting year: " + e.getMessage();
        }

    }
}
