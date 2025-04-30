package rs.prati.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rs.prati.core.model.AeSistemGoriva;

/**
 * Репозиторијум за приступ подацима ентитета AeSistemGoriva.
 */
@Repository
public interface AeSistemGorivaRepository extends JpaRepository<AeSistemGoriva, Long> {
    // Овде се могу додавати custom query методе ако буде потребно.
}
