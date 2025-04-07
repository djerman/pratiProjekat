package rs.prati.service.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import rs.prati.core.model.BaKorisnici;

public interface BaKorisniciRepository extends JpaRepository<BaKorisnici, Long>{
	
	Optional<BaKorisnici> findByEmail(String email);
	
}
