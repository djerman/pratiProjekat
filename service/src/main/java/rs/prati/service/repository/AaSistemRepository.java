package rs.prati.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rs.prati.core.model.AaSistem;

/**
 * Репозиторијум за приступ ентитету AaSistem.
 */
@Repository
public interface AaSistemRepository extends JpaRepository<AaSistem, Integer> {
    // Нема додатних метода; користимо findById(1) за приступ систему
}
