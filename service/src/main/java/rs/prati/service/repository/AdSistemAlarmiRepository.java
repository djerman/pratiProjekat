package rs.prati.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rs.prati.core.model.AdSistemAlarmi;

/**
 * Репозиторијум за приступ подацима ентитета AdSistemAlarmi.
 */
@Repository
public interface AdSistemAlarmiRepository extends JpaRepository<AdSistemAlarmi, Long> {
    // Овде по потреби можемо додати custom методе ако буде потребно (нпр. findByNaziv, findByAktivan, итд.)
}

