package rs.prati.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rs.prati.core.model.DbVozaciDozvole;

import java.util.List;

/**
 * Репозиторијум за ентитет DbVozaciDozvole.
 */
@Repository
public interface DbVozaciDozvoleRepository extends JpaRepository<DbVozaciDozvole, Long> {

    /**
     * Враћа све необрисане дозволе за датог корисника (возача).
     */
    List<DbVozaciDozvole> findByKorisnik_IdAndIzbrisanFalseOrderByIdDesc(Long korisnikId);

    /**
     * Враћа све необрисане дозволе за датог претплатника.
     */
    List<DbVozaciDozvole> findByPretplatnik_IdAndIzbrisanFalseOrderByIdDesc(Long pretplatnikId);
}
