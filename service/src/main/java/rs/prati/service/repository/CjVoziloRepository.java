package rs.prati.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rs.prati.core.model.CjVozilo;

/**
 * Репозиторијум за ентитет CjVozilo – возила у систему.
 */
@Repository
public interface CjVoziloRepository extends JpaRepository<CjVozilo, Long> {

    // По потреби додај специфичне методе за претрагу
    // List<CjVozilo> findByPretplatnik_IdAndIzbrisanFalse(Long pretplatnikId);
}
