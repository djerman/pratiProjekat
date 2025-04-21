package rs.prati.service.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import rs.prati.core.model.AcOrganizacije;

/**
 * Репозиторијум за организације.
 */
public interface AcOrganizacijeRepository extends JpaRepository<AcOrganizacije, Long> {
	
	List<AcOrganizacije> findByPretplatnikId(Long pretplatnikId);
}
