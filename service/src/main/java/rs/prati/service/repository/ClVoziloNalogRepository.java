package rs.prati.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rs.prati.core.model.ClVoziloNalog;

import java.util.List;

/**
 * Репозиторијум за ентитет ClVoziloNalog.
 */
@Repository
public interface ClVoziloNalogRepository extends JpaRepository<ClVoziloNalog, Long> {

    /**
     * Враћа све налоге за одређеног претплатника који нису обрисани.
     */
    List<ClVoziloNalog> findByPretplatnikIdAndIzbrisanFalseOrderByIdDesc(Long pretplatnikId);

    /**
     * Враћа све налоге који нису обрисани.
     */
    List<ClVoziloNalog> findByIzbrisanFalseOrderByIdDesc();

    // Додај још query метода по потреби
}
