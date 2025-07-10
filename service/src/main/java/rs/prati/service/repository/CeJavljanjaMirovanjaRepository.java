package rs.prati.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rs.prati.core.model.CeJavljanjaMirovanja;

import java.util.List;

/**
 * Репозиторијум за ентитет CeJavljanjaMirovanja.
 */
@Repository
public interface CeJavljanjaMirovanjaRepository extends JpaRepository<CeJavljanjaMirovanja, Long> {

    /**
     * Враћа сва мировања за задати објекат.
     */
    List<CeJavljanjaMirovanja> findByObjekat_IdOrderByDatumVremeDesc();

    /**
     * Враћа сва валидна мировања.
     */
    List<CeJavljanjaMirovanja> findByValidTrueOrderByDatumVremeDesc();
}