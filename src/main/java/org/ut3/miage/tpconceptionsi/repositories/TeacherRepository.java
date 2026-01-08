package org.ut3.miage.tpconceptionsi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.ut3.miage.tpconceptionsi.models.Teacher;

public interface TeacherRepository extends JpaRepository<Teacher, String> {
    boolean existsByNomIgnoreCase(String nom);
}
