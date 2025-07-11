package rs.prati.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rs.prati.core.model.DeVozaciLicna;

import java.util.List;

/**
 * Репозиторијум за ентитет DeVozaciLicna.
 */
@Repository
public interface DeVozaciLicnaRepository extends JpaRepository<DeVozaciLicna, Long> {

    /**
     * Враћа све лицне карте које нису обрисане.
     */
    List<DeVozaciLicna> findByIzbrisanFalseOrderByIdDesc();

    /**
     * Враћа све лицне карте за датог корисника (по ID).
     */
    List<DeVozaciLicna> findByKorisnik_IdAndIzbrisanFalseOrderByIdDesc(Long korisnikId);

    /**
     * Враћа све лицне карте за датог претплатника (по ID).
     */
    List<DeVozaciLicna> findByPretplatnik_IdAndIzbrisanFalseOrderByIdDesc(Long pretplatnikId);
}
