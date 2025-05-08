package rs.prati.service.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rs.prati.core.model.BgPartneri;

/**
 * Репозиторијум за приступ ентитету BgPartneri.
 */
@Repository
public interface BgPartneriRepository extends JpaRepository<BgPartneri, Long> {

    /**
     * Враћа све партнере који нису обрисани, сортиране по ID-ју опадајуће.
     */
    List<BgPartneri> findByIzbrisanFalseOrderByIdDesc();

    /**
     * Враћа све партнере за одређеног претплатника који нису обрисани.
     */
    List<BgPartneri> findByPretplatnik_IdAndIzbrisanFalseOrderByIdDesc();
}
