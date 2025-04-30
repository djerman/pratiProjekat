package rs.prati.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rs.prati.core.model.AhSistemUredjajiProizvodjac;

/**
 * Репозиторијум за приступ подацима ентитета AhSistemUredjajiProizvodjac.
 */
@Repository
public interface AhSistemUredjajiProizvodjacRepository extends JpaRepository<AhSistemUredjajiProizvodjac, Long> {
    // Овде се могу додавати специфични упити ако буде потребно.
}
