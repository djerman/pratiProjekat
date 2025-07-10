package rs.prati.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rs.prati.core.model.CiVozaci;

/**
 * Репозиторијум за ентитет CiVozaci – возачи у систему.
 */
@Repository
public interface CiVozaciRepository extends JpaRepository<CiVozaci, Long> {

    // Овде по потреби додај специфичне методе за претрагу
    // List<CiVozaci> findByPretplatnik_IdAndIzbrisanFalse(Long pretplatnikId);
}
