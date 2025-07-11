package rs.prati.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rs.prati.core.model.DfVozaciPasosi;

import java.util.List;

/**
 * Репозиторијум за ентитет DfVozaciPasosi.
 */
@Repository
public interface DfVozaciPasosiRepository extends JpaRepository<DfVozaciPasosi, Long> {

    /**
     * Враћа све записе који нису обрисани.
     */
    List<DfVozaciPasosi> findByIzbrisanFalseOrderByIdDesc();

    /**
     * Враћа све пасоше за датог корисника.
     */
    List<DfVozaciPasosi> findByKorisnikIdAndIzbrisanFalseOrderByIdDesc(Long korisnikId);

    /**
     * Враћа све пасоше за датог претплатника.
     */
    List<DfVozaciPasosi> findByPretplatnikIdAndIzbrisanFalseOrderByIdDesc(Long pretplatnikId);
}
