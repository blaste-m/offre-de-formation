package org.ut3.miage.tpconceptionsi.requests;

public record UECreationRequest(
        String name,
        int ects,
        int cm,
        int td,
        int tp
) {
}
