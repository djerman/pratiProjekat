package rs.prati.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rs.prati.core.model.DdVozaciLicence;
import rs.prati.core.model.BaKorisnici;
import rs.prati.core.model.AbSistemPretplatnici;

import java.util.List;

/**
 * Репозиторијум за ентитет DdVozaciLicence.
 */
@Repository
public interface DdVozaciLicenceRepository extends JpaRepository<DdVozaciLicence, Long> {

    /**
     * Враћа све лиценце које нису обрисане.
     */
    List<DdVozaciLicence> findByIzbrisanFalseOrderByIdDesc();

    /**
     * Враћа све лиценце за датог корисника.
     */
    List<DdVozaciLicence> findByKorisnikAndIzbrisanFalseOrderByIdDesc(BaKorisnici korisnik);

    /**
     * Враћа све лиценце за датог претплатника.
     */
    List<DdVozaciLicence> findByPretplatnikAndIzbrisanFalseOrderByIdDesc(AbSistemPretplatnici pretplatnik);
}
