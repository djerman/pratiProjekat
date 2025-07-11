package rs.prati.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rs.prati.core.model.DjRacuni;

import java.util.List;

/**
 * Репозиторијум за ентитет DjRacuni (рачун).
 */
@Repository
public interface DjRacuniRepository extends JpaRepository<DjRacuni, Long> {

    /**
     * Враћа све рачуне који нису обрисани, сортиране по ID-у опадајуће.
     */
    List<DjRacuni> findByIzbrisanFalseOrderByIdDesc();

    /**
     * Враћа све рачуне за одређеног партнера.
     */
    List<DjRacuni> findByPartnerIdAndIzbrisanFalseOrderByIdDesc(Long partnerId);

    /**
     * Враћа све рачуне за одређеног претплатника.
     */
    List<DjRacuni> findByPretplatnikIdAndIzbrisanFalseOrderByIdDesc(Long pretplatnikId);
}
