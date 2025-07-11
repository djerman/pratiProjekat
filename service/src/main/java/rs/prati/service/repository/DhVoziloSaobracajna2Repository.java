package rs.prati.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rs.prati.core.model.DhVoziloSaobracajna2;

import java.util.List;

/**
 * Репозиторијум за ентитет DhVoziloSaobracajna2 (додатни подаци саобраћајне дозволе).
 */
@Repository
public interface DhVoziloSaobracajna2Repository extends JpaRepository<DhVoziloSaobracajna2, Long> {

    /**
     * Враћа све записе који нису обрисани, сортиране по ID-у опадајуће.
     */
    List<DhVoziloSaobracajna2> findByIzbrisanFalseOrderByIdDesc();

    /**
     * Враћа све записе за одређену саобраћајну дозволу.
     */
    List<DhVoziloSaobracajna2> findBySaobracajnaIdAndIzbrisanFalseOrderByIdDesc(Long saobracajnaId);

    /**
     * Враћа све записе за одређеног претплатника.
     */
    List<DhVoziloSaobracajna2> findByPretplatnikIdAndIzbrisanFalseOrderByIdDesc(Long pretplatnikId);
}
