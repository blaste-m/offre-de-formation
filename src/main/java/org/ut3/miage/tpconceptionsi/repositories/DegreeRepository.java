package org.ut3.miage.tpconceptionsi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.ut3.miage.tpconceptionsi.models.Degree;
import org.ut3.miage.tpconceptionsi.models.DegreeId;

import java.util.Optional;

@Repository
public interface DegreeRepository extends JpaRepository<Degree, DegreeId> {

    Optional<Degree> findFirstByNameOrderByYearAsc(String name);
}
