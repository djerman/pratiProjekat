package rs.prati.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rs.prati.core.model.DiPredjeniPut;

import java.time.LocalDate;
import java.util.List;

/**
 * Репозиторијум за ентитет DiPredjeniPut (пређени пут и потрошња).
 */
@Repository
public interface DiPredjeniPutRepository extends JpaRepository<DiPredjeniPut, Long> {

    /**
     * Враћа све записе за објекат, опадајуће по ID-у.
     */
    List<DiPredjeniPut> findByObjekatIdOrderByIdDesc(Long objekatId);

    /**
     * Враћа све записе за дати датум.
     */
    List<DiPredjeniPut> findByDatum(LocalDate datum);
}
