package rs.prati.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rs.prati.core.model.DxObjektiPoslednje;

import java.util.List;

/**
 * Репозиторијум за ентитет DxObjektiPoslednje (подaци о последњим сервисима, регистрацији и километражи објекта).
 */
@Repository
public interface DxObjektiPoslednjeRepository extends JpaRepository<DxObjektiPoslednje, Long> {

    /**
     * Враћа све податке за одређени објекат (по objekat.id), опадајуће по ID-у.
     */
    List<DxObjektiPoslednje> findByObjekat_IdOrderByIdDesc(Long objekatId);
}
