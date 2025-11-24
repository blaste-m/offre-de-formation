package org.ut3.miage.tpconceptionsi.validators;

import org.ut3.miage.tpconceptionsi.requests.DegreeCreationRequest;

public class DegreeCreationValidator {

    public void validate(DegreeCreationRequest request) throws IllegalArgumentException {
        validateMaxEtu(request.maxEtu());
    }

    private void validateMaxEtu(int maxEtu) {
        if (maxEtu <= 0) {
            throw new IllegalArgumentException("Invalid argument <max etu>"
                    + "\n<max etu> must be a positive integer"
            );
        }
    }
}
