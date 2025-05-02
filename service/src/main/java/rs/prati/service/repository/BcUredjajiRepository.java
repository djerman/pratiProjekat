package rs.prati.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rs.prati.core.model.BcUredjaji;

import java.util.List;
import java.util.Optional;

/**
 * Репозиторијум за ентитет BcUredjaji.
 */
@Repository
public interface BcUredjajiRepository extends JpaRepository<BcUredjaji, Long> {

    /**
     * Проналази уређај по серијском броју и претплатнику, ако није обрисан.
     */
    Optional<BcUredjaji> findByPretplatnik_IdAndSerijskiBrAndIzbrisanFalse(Long pretplatnikId, String serijskiBr);

    /**
     * Проналази све активне и слободне уређаје за датог претплатника (администраторски приступ).
     */
    List<BcUredjaji> findByPretplatnik_IdAndObjekatIsNullAndAktivanTrueAndIzbrisanFalse(Long pretplatnikId);

    /**
     * Проналази све активне и слободне уређаје у систему (системски приступ).
     */
    List<BcUredjaji> findByObjekatIsNullAndAktivanTrueAndIzbrisanFalse();

    /**
     * Проналази све активне уређаје за претплатника (без обзира на везу са објектом).
     */
    List<BcUredjaji> findByPretplatnik_IdAndAktivanTrueAndIzbrisanFalse(Long pretplatnikId);
    
    /**
     * 
     * @return
     */
    List<BcUredjaji> findByIzbrisanFalse();

}

