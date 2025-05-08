package rs.prati.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rs.prati.core.model.CbGrupeObjekti;

import java.util.List;

/**
 * Репозиторијум за ентитет CbGrupeObjekti.
 */
@Repository
public interface CbGrupeObjektiRepository extends JpaRepository<CbGrupeObjekti, Long> {

    /**
     * Враћа све везе објеката и група које нису обрисане.
     */
    List<CbGrupeObjekti> findByIzbrisanFalseOrderByIdDesc();

    /**
     * Враћа све везе за одређеног претплатника које нису обрисане.
     */
    List<CbGrupeObjekti> findByPretplatnik_IdAndIzbrisanFalseOrderByIdDesc();
}
