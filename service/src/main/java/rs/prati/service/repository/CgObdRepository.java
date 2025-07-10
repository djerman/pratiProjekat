package rs.prati.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rs.prati.core.model.CgObd;

/**
 * Репозиторијум за ентитет CgObd – OBD подаци возила.
 */
@Repository
public interface CgObdRepository extends JpaRepository<CgObd, Long> {

}
