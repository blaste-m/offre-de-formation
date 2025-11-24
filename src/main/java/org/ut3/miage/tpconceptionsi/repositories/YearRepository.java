package org.ut3.miage.tpconceptionsi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.ut3.miage.tpconceptionsi.models.Year;
import org.ut3.miage.tpconceptionsi.models.YearId;

public interface YearRepository extends JpaRepository<Year, YearId> {
}
