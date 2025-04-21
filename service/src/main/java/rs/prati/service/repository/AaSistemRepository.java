package rs.prati.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rs.prati.core.model.AaSistem;

@Repository
public interface AaSistemRepository extends JpaRepository<AaSistem, Long> {
	
}
