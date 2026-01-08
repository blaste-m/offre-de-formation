package org.ut3.miage.tpconceptionsi.utils.teacher;

import org.springframework.stereotype.Component;
import org.ut3.miage.tpconceptionsi.models.Teacher;
import org.ut3.miage.tpconceptionsi.requests.TeacherCreationRequest;

import java.util.HashSet;

@Component
public class TeacherFactory {
    public Teacher create(TeacherCreationRequest request) {

        String nom = request.nom().substring(0,1).toUpperCase()
                + request.nom().substring(1).toLowerCase();

        String prenom = request.prenom().substring(0,1).toUpperCase()
                + request.prenom().substring(1).toLowerCase();

        return new Teacher(
                nom,
                prenom,
                new HashSet<>()
        );
    }
}
