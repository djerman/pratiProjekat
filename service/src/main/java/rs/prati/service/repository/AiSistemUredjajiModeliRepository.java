package rs.prati.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rs.prati.core.model.AiSistemUredjajiModeli;

/**
 * Репозиторијум за приступ подацима ентитета AiSistemUredjajiModeli.
 */
@Repository
public interface AiSistemUredjajiModeliRepository extends JpaRepository<AiSistemUredjajiModeli, Long> {
    // Овде се могу додати специфични упити ако буде потребно.
}
