package rs.prati.service.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import rs.prati.core.model.BfZone;

/**
 * Репозиторијум за ентитет BfZone.
 */
public interface BfZoneRepository extends JpaRepository<BfZone, Long> {

    /**
     * Враћа све зоне за задатог претплатника које нису обрисане.
     */
    List<BfZone> findByPretplatnik_IdAndIzbrisanFalse(Long pretplatnikId);
}
