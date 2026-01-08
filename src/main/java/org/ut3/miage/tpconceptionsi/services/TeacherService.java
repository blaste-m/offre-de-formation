package org.ut3.miage.tpconceptionsi.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.ut3.miage.tpconceptionsi.models.Teacher;
import org.ut3.miage.tpconceptionsi.parsers.TeacherArgumentParser;
import org.ut3.miage.tpconceptionsi.repositories.TeacherRepository;
import org.ut3.miage.tpconceptionsi.requests.TeacherCreationRequest;
import org.ut3.miage.tpconceptionsi.utils.teacher.TeacherFactory;
import org.ut3.miage.tpconceptionsi.validators.TeacherCreationValidator;

@Service
@RequiredArgsConstructor
public class TeacherService {

    private final TeacherRepository teacherRepository;
    private final TeacherCreationValidator validator;
    private final TeacherArgumentParser parser;
    private final TeacherFactory factory;

    Teacher createTeacher(String... args) {

        TeacherCreationRequest request = parser.parse(args);
        validator.validate(request);

        Teacher teacher = factory.create(request);

        if (teacherRepository.existsByNomIgnoreCase(request.nom()))
            throw new IllegalArgumentException(
                    "Error: the value provided for <name> is already used as an ID for another teacher"
            );

        return teacherRepository.save(teacher);
    }

}
