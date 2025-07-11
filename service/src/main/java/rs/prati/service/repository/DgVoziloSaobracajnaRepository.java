package rs.prati.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rs.prati.core.model.DgVoziloSaobracajna;

import java.util.List;

/**
 * Репозиторијум за ентитет DgVoziloSaobracajna (саобраћајна дозвола возила).
 */
@Repository
public interface DgVoziloSaobracajnaRepository extends JpaRepository<DgVoziloSaobracajna, Long> {

    /**
     * Враћа све саобраћајне дозволе које нису обрисане, сортиране по ID-у опадајуће.
     */
    List<DgVoziloSaobracajna> findByIzbrisanFalseOrderByIdDesc();

    /**
     * Враћа све саобраћајне дозволе за одређено возило.
     */
    List<DgVoziloSaobracajna> findByVoziloIdAndIzbrisanFalseOrderByIdDesc(Long voziloId);

    /**
     * Враћа све саобраћајне дозволе за одређеног претплатника.
     */
    List<DgVoziloSaobracajna> findByPretplatnikIdAndIzbrisanFalseOrderByIdDesc(Long pretplatnikId);
}
