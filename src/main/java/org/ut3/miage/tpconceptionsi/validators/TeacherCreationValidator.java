package org.ut3.miage.tpconceptionsi.validators;

import org.springframework.stereotype.Component;
import org.ut3.miage.tpconceptionsi.requests.TeacherCreationRequest;

@Component
public class TeacherCreationValidator {
    public void validate(TeacherCreationRequest request) {
        if (request.nom() != null && !request.nom().matches("^[\\p{L}-]+$"))
            throw new IllegalArgumentException("Error: <name> must contain only letters or hyphen");

        if (request.prenom() != null && !request.prenom().matches("^[\\p{L}-]+$"))
            throw new IllegalArgumentException("Error: <firstname> must contain only letters or hyphen");
    }
}
