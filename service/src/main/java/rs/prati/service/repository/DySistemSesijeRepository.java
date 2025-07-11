package rs.prati.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rs.prati.core.model.DySistemSesije;

import java.util.List;

/**
 * Репозиторијум за ентитет DySistemSesije (системске сесије корисника).
 */
@Repository
public interface DySistemSesijeRepository extends JpaRepository<DySistemSesije, Long> {

    /**
     * Враћа све не-обрисане системске сесије, опадајуће по ID.
     */
    List<DySistemSesije> findByIzbrisanFalseOrderByIdDesc();

    /**
     * Враћа све сесије за датог корисника.
     */
    List<DySistemSesije> findByKorisnik_IdAndIzbrisanFalseOrderByIdDesc(Long korisnikId);

    /**
     * Враћа све сесије за датог претплатника.
     */
    List<DySistemSesije> findByPretplatnik_IdAndIzbrisanFalseOrderByIdDesc(Long pretplatnikId);
}
