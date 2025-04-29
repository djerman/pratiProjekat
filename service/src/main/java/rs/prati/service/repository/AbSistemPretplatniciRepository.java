package rs.prati.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rs.prati.core.model.AbSistemPretplatnici;

/**
 * Репозиторијум за приступ подацима ентитета AbSistemPretplatnici.
 */
@Repository
public interface AbSistemPretplatniciRepository extends JpaRepository<AbSistemPretplatnici, Long> {
    // Овде се могу додавати custom query методе ако буде потребно.
}
