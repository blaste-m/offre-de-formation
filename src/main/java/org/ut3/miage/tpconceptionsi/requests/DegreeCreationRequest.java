package org.ut3.miage.tpconceptionsi.requests;

import org.ut3.miage.tpconceptionsi.enums.DegreeType;

public record DegreeCreationRequest (
        DegreeType type,
        String name,
        int year,
        int maxEtu,
        int ects
) { }
