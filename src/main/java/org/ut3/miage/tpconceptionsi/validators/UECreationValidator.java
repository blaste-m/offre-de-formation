package org.ut3.miage.tpconceptionsi.validators;

import org.springframework.stereotype.Component;
import org.ut3.miage.tpconceptionsi.requests.UECreationRequest;

@Component
public class UECreationValidator {

    public void validate(UECreationRequest requestm) throws IllegalArgumentException {
        validateEcts(requestm.ects());
        validateHours(requestm.cm(), "cm");
        validateHours(requestm.td(), "td");
        validateHours(requestm.tp(), "tp");
    }

    private void validateEcts(int ects) {
        if (ects <= 0) {
            throw new IllegalArgumentException("Invalid argument <ects>"
                    + "\n<ects> must be a positive integer"
            );
        }
    }

    private void validateHours(int hours, String type) {
        if (hours < 0) {
            throw new IllegalArgumentException("Invalid argument <" + type + ">"
                    + "\n<" + type + "> must be a non-negative integer"
            );
        }
    }
}
