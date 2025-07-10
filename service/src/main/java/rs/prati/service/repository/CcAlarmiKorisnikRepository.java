package rs.prati.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rs.prati.core.model.CcAlarmiKorisnik;

import java.util.List;

/**
 * Репозиторијум за ентитет CcAlarmiKorisnik.
 */
@Repository
public interface CcAlarmiKorisnikRepository extends JpaRepository<CcAlarmiKorisnik, Long> {

    /**
     * Враћа све активне везе корисника и аларма које нису обрисане.
     */
    List<CcAlarmiKorisnik> findByIzbrisanFalseOrderByIdDesc();

    /**
     * Враћа све везе за одређеног претплатника које нису обрисане.
     */
    List<CcAlarmiKorisnik> findByPretplatnik_IdAndIzbrisanFalseOrderByIdDesc();
}
