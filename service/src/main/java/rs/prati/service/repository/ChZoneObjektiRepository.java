package rs.prati.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rs.prati.core.model.ChZoneObjekti;

/**
 * Репозиторијум за ентитет ChZoneObjekti – повезаност зона и објеката.
 */
@Repository
public interface ChZoneObjektiRepository extends JpaRepository<ChZoneObjekti, Long> {

    // Овде по потреби додајеш custom методе, нпр:
    // List<ChZoneObjekti> findByZona_IdAndIzbrisanFalse(Long zonaId);
}
