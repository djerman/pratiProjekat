package rs.prati.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rs.prati.core.model.CkVoziloPrimoPredaja;

import java.util.List;

/**
 * Репозиторијум за ентитет CkVoziloPrimoPredaja.
 */
@Repository
public interface CkVoziloPrimoPredajaRepository extends JpaRepository<CkVoziloPrimoPredaja, Long> {

    /**
     * Враћа све необрисане примопредаје, најновије прво.
     */
    List<CkVoziloPrimoPredaja> findByIzbrisanFalseOrderByIdDesc();

    /**
     * Враћа све примопредаје за задатог претплатника.
     */
    List<CkVoziloPrimoPredaja> findByPretplatnikIdAndIzbrisanFalseOrderByIdDesc(Long pretplatnikId);
}
