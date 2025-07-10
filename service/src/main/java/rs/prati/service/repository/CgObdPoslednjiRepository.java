package rs.prati.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rs.prati.core.model.CgObdPoslednji;

/**
 * Репозиторијум за ентитет CgObdPoslednji – последњи OBD подаци по објекту.
 */
@Repository
public interface CgObdPoslednjiRepository extends JpaRepository<CgObdPoslednji, Long> {

    // По потреби се додају custom методе, нпр:
    // Optional<CgObdPoslednji> findByObjekat_Id(Long objekatId);
}
