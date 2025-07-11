package rs.prati.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rs.prati.core.model.DljRacuniRaspodela;

import java.util.List;

/**
 * Репозиторијум за ентитет DljRacuniRaspodela (расподела износа по рачунима).
 */
@Repository
public interface DljRacuniRaspodelaRepository extends JpaRepository<DljRacuniRaspodela, Long> {

    /**
     * Враћа све расподеле по партнеру.
     */
    List<DljRacuniRaspodela> findByPartnerIdOrderByIdDesc(Long partnerId);

    /**
     * Враћа све расподеле по рачуну.
     */
    List<DljRacuniRaspodela> findByRacunIdOrderByIdDesc(Long racunId);

    /**
     * Враћа све расподеле по претплатнику.
     */
    List<DljRacuniRaspodela> findByPretplatnikIdOrderByIdDesc(Long pretplatnikId);
}
