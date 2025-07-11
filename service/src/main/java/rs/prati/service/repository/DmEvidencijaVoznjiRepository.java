package rs.prati.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rs.prati.core.model.DmEvidencijaVoznji;

import java.util.List;

/**
 * Репозиторијум за ентитет DmEvidencijaVoznji (евиденција вожњи).
 */
@Repository
public interface DmEvidencijaVoznjiRepository extends JpaRepository<DmEvidencijaVoznji, Long> {

    /**
     * Враћа све евиденције које нису обрисане, сортиране по ID-у опадајуће.
     */
    List<DmEvidencijaVoznji> findByPretplatnikIdAndZakljucanFalseOrderByIdDesc(Long pretplatnikId);

    /**
     * Враћа све евиденције за дату организацију.
     */
    List<DmEvidencijaVoznji> findByOrganizacijaIdAndZakljucanFalseOrderByIdDesc(Long organizacijaId);

    // Додај додатне методе по потреби.
}
