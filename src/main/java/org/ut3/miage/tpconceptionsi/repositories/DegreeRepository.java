package org.ut3.miage.tpconceptionsi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.ut3.miage.tpconceptionsi.models.Degree;

@Repository
public interface DegreeRepository extends JpaRepository<Degree, String> {
}
