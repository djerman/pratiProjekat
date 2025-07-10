package rs.prati.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rs.prati.core.model.CeJavljanja;

import java.util.List;

/**
 * Репозиторијум за ентитет CeJavljanja.
 */
@Repository
public interface CeJavljanjaRepository extends JpaRepository<CeJavljanja, Long> {

    /**
     * Враћа сва важећа јављања, по времену силазно.
     */
    List<CeJavljanja> findByValidTrueOrderByDatumVremeDesc();

    /**
     * Враћа сва јављања за задати објекат.
     */
    List<CeJavljanja> findByObjekat_IdOrderByDatumVremeDesc();

    /**
     * Враћа јављања за објекат у последњих X сати (пример: кроз датум).
     * → Може се касније додати query методом ако затреба.
     */
}
