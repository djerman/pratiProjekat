package rs.prati.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rs.prati.core.model.CdObjektiAlarmi;

import java.util.List;

/**
 * Репозиторијум за ентитет CdObjektiAlarmi.
 */
@Repository
public interface CdObjektiAlarmiRepository extends JpaRepository<CdObjektiAlarmi, Long> {

    /**
     * Враћа све активне и необрисане конфигурације аларма.
     */
    List<CdObjektiAlarmi> findByIzbrisanFalseOrderByIdDesc();

    /**
     * Враћа све конфигурације за задатог претплатника.
     */
    List<CdObjektiAlarmi> findByPretplatnik_IdAndIzbrisanFalseOrderByIdDesc();
}
