package rs.prati.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rs.prati.core.model.DlSifre;

import java.util.List;

/**
 * Репозиторијум за ентитет DlSifre (шифре партнера).
 */
@Repository
public interface DlSifreRepository extends JpaRepository<DlSifre, Long> {

    /**
     * Враћа све шифре које нису обрисане, сортиране по ID-у опадајуће.
     */
    List<DlSifre> findByIzbrisanFalseOrderByIdDesc();

    /**
     * Враћа све шифре за одређеног претплатника.
     */
    List<DlSifre> findByPretplatnikIdAndIzbrisanFalseOrderByIdDesc(Long pretplatnikId);

    /**
     * Враћа све шифре за одређеног партнера.
     */
    List<DlSifre> findByPartnerIdAndIzbrisanFalseOrderByIdDesc(Long partnerId);
}
