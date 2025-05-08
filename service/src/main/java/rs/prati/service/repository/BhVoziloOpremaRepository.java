package rs.prati.service.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rs.prati.core.model.BhVoziloOprema;

/**
 * Репозиторијум за ентитет BhVoziloOprema.
 */
@Repository
public interface BhVoziloOpremaRepository extends JpaRepository<BhVoziloOprema, Long> {

    /**
     * Враћа сву опрему која није обрисана, сортирану опадајуће по ID-ју.
     */
    List<BhVoziloOprema> findByIzbrisanFalseOrderByIdDesc();

    /**
     * Враћа сву опрему за одређеног претплатника која није обрисана.
     */
    List<BhVoziloOprema> findByPretplatnik_IdAndIzbrisanFalseOrderByIdDesc();
}
