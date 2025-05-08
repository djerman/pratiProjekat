package rs.prati.service.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import rs.prati.core.model.BeGrupe;

public interface BeGrupeRepository extends JpaRepository<BeGrupe, Long>{

    /**
     * Проналази све групе за датог претплатника које нису обрисане.
     */
    List<BeGrupe> findByPretplatnik_IdAndIzbrisanFalse(Long pretplatnikId);
    
}
