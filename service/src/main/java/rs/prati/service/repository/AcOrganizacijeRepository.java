package rs.prati.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rs.prati.core.model.AcOrganizacije;

/**
 * Репозиторијум за приступ подацима ентитета AcOrganizacije.
 */
@Repository
public interface AcOrganizacijeRepository extends JpaRepository<AcOrganizacije, Long> {
    // Овде се могу додавати custom query методе ако буде потребно.
}
