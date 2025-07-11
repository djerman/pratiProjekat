package rs.prati.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rs.prati.core.model.DzSistemObracuni;

import java.util.List;

/**
 * Репозиторијум за ентитет DzSistemObracuni (системски обрачуни објекта).
 */
@Repository
public interface DzSistemObracuniRepository extends JpaRepository<DzSistemObracuni, Long> {

    /**
     * Враћа све обрачуне за одређени објекат, најновији први.
     */
    List<DzSistemObracuni> findByObjekat_IdOrderByDatumDesc(Long objekatId);

    /**
     * Враћа све обрачуне за датум.
     */
    List<DzSistemObracuni> findByDatumOrderByObjekat_Id(Long datum);

    // Додај по потреби нове методе ако ти требају
}
