package rs.prati.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rs.prati.core.model.DkProjekti;

import java.util.List;

/**
 * Репозиторијум за ентитет DkProjekti (пројекат).
 */
@Repository
public interface DkProjektiRepository extends JpaRepository<DkProjekti, Long> {

    /**
     * Враћа све пројекте који нису обрисани, сортиране по ID-у опадајуће.
     */
    List<DkProjekti> findByIzbrisanFalseOrderByIdDesc();

    /**
     * Враћа све пројекте за одређеног претплатника.
     */
    List<DkProjekti> findByPretplatnikIdAndIzbrisanFalseOrderByIdDesc(Long pretplatnikId);

    /**
     * Враћа све пројекте за одређеног партнера.
     */
    List<DkProjekti> findByPartnerIdAndIzbrisanFalseOrderByIdDesc(Long partnerId);
}
