package rs.prati.service.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import rs.prati.core.model.BdSim;

public interface BdSimRepository extends JpaRepository<BdSim, Long> {

    /**
     * Проналази СИМ картицу по ICCID броју и претплатнику ако није обрисана.
     */
    Optional<BdSim> findByPretplatnik_IdAndIccidAndIzbrisanFalse(Long pretplatnikId, String iccid);

    /**
     * Проналази све активне и слободне СИМ картице за датог претплатника.
     */
    List<BdSim> findByPretplatnik_IdAndUredjajIsNullAndAktivanTrueAndIzbrisanFalse(Long pretplatnikId);

    /**
     * Проналази све активне СИМ картице за датог претплатника.
     */
    List<BdSim> findByPretplatnik_IdAndAktivanTrueAndIzbrisanFalse(Long pretplatnikId);

    /**
     * Проналази све слободне (неповезане) СИМ картице у систему.
     */
    List<BdSim> findByUredjajIsNullAndAktivanTrueAndIzbrisanFalse();
    
    List<BdSim> findByPretplatnik_IdAndIzbrisanFalse(Long pretplatnikId);

}