package rs.prati.service.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rs.prati.core.model.BbObjekti;

/**
 * Репозиторијум за приступ подацима ентитета BbObjekti.
 */
@Repository
public interface BbObjektiRepository extends JpaRepository<BbObjekti, Long> {
    
	Optional<BbObjekti> findByPretplatnikIdAndOznakaAndIzbrisanFalse(Long pretplatnikId, String oznaka);

}
