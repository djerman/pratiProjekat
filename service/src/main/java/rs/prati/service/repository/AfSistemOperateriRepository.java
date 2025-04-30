package rs.prati.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rs.prati.core.model.AfSistemOperateri;

/**
 * Репозиторијум за приступ подацима ентитета AfSistemOperateri.
 */
@Repository
public interface AfSistemOperateriRepository extends JpaRepository<AfSistemOperateri, Long> {
    // Могуће проширење са специфичним упитима ако буде потребно.
}
