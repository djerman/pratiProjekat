package rs.prati.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rs.prati.core.model.CaGrupeKorisnici;

import java.util.List;

/**
 * Репозиторијум за ентитет CaGrupeKorisnici.
 */
@Repository
public interface CaGrupeKorisniciRepository extends JpaRepository<CaGrupeKorisnici, Long> {

    /**
     * Враћа све везе група-корисника које нису обрисане.
     */
    List<CaGrupeKorisnici> findByIzbrisanFalseOrderByIdDesc();

    /**
     * Враћа све везе за задатог претплатника које нису обрисане.
     */
    List<CaGrupeKorisnici> findByPretplatnik_IdAndIzbrisanFalseOrderByIdDesc();
}
