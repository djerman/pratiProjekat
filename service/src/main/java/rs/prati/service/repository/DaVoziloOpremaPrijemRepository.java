package rs.prati.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rs.prati.core.model.DaVoziloOpremaPrijem;

import java.util.List;

/**
 * Репозиторијум за ентитет DaVoziloOpremaPrijem.
 */
@Repository
public interface DaVoziloOpremaPrijemRepository extends JpaRepository<DaVoziloOpremaPrijem, Long> {

    /**
     * Враћа сва примања опреме по задатом примопредаји.
     */
    List<DaVoziloOpremaPrijem> findByPrimoPredaja_Id(Long primoPredajaId);

    /**
     * Враћа сва примања опреме за задатог претплатника.
     */
    List<DaVoziloOpremaPrijem> findByPretplatnik_Id(Long pretplatnikId);
}
