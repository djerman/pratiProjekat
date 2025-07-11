package rs.prati.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rs.prati.core.model.DjTroskovi;

import java.util.List;

/**
 * Репозиторијум за ентитет DjTroskovi (трошак).
 */
@Repository
public interface DjTroskoviRepository extends JpaRepository<DjTroskovi, Long> {

    /**
     * Враћа све трошкове који нису обрисани, сортиране по ID-у опадајуће.
     */
    List<DjTroskovi> findByIzbrisanFalseOrderByIdDesc();

    /**
     * Враћа све трошкове за одређени објекат.
     */
    List<DjTroskovi> findByObjekatIdAndIzbrisanFalseOrderByIdDesc(Long objekatId);

    /**
     * Враћа све трошкове за одређеног партнера.
     */
    List<DjTroskovi> findByPartnerIdAndIzbrisanFalseOrderByIdDesc(Long partnerId);

    /**
     * Враћа све трошкове за одређеног претплатника.
     */
    List<DjTroskovi> findByPretplatnikIdAndIzbrisanFalseOrderByIdDesc(Long pretplatnikId);
}
