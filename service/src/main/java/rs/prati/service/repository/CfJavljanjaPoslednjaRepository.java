package rs.prati.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rs.prati.core.model.CfJavljanjaPoslednja;

import java.util.List;

/**
 * Репозиторијум за ентитет CfJavljanjaPoslednja.
 */
@Repository
public interface CfJavljanjaPoslednjaRepository extends JpaRepository<CfJavljanjaPoslednja, Long> {

    /**
     * Враћа сва последња јављања која нису обрисана, сортирана опадајуће по ID-у.
     */
    List<CfJavljanjaPoslednja> findByValidTrueOrderByIdDesc();

    /**
     * Враћа последња јављања за одређени објекат.
     */
    List<CfJavljanjaPoslednja> findByObjekat_IdOrderByIdDesc(Long objekatId);
}
