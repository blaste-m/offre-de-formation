package org.ut3.miage.tpconceptionsi.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.ut3.miage.tpconceptionsi.models.Degree;
import org.ut3.miage.tpconceptionsi.repositories.DegreeRepository;
import org.ut3.miage.tpconceptionsi.utils.DegreeFactory;

@Service
@RequiredArgsConstructor
public class DegreeService {
    private final DegreeRepository degreeRepository;

    public String createDegree(String... args) {
        try {
            Degree degree = new DegreeFactory().create(args);
            degreeRepository.save(degree);
            return "Degree created: " + degree.getName();
        } catch (IllegalArgumentException e) {
            return e.getMessage();
        } catch (Exception e) {
            return "Error while creating degree: " + e.getMessage();
        }
    }



}
