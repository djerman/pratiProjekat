package rs.prati.service.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rs.prati.core.model.BbObjekti;

/**
 * Репозиторијум за приступ подацима ентитета BbObjekti.
 */
@Repository
public interface BbObjektiRepository extends JpaRepository<BbObjekti, Long> {

    /**
     * Проналази објекат по претплатнику, ознаци и само ако није избрисан.
     */
    Optional<BbObjekti> findByPretplatnik_IdAndOznakaAndIzbrisanFalse(Long pretplatnikId, String oznaka);
}

