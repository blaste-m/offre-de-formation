package org.ut3.miage.tpconceptionsi.parsers;

import org.springframework.stereotype.Component;
import org.ut3.miage.tpconceptionsi.requests.TeacherCreationRequest;

@Component
public class TeacherArgumentParser {

    public TeacherCreationRequest parse(String... args) {
        if (args.length != 2)
            throw new IllegalArgumentException(
                    "Wrong number of arguments for command CREATE TEACHER"
                            + "\nExpected 2 arguments but got " + (args.length)
                            + "\nUsage : CREATE TEACHER <name> <firstname>"
            );

        String nom = args[0];
        String prenom = args[1];

        return new TeacherCreationRequest(
                nom,
                prenom
        );
    }
}
