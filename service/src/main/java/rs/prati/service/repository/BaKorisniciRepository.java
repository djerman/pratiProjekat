package rs.prati.service.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rs.prati.core.model.BaKorisnici;

/**
 * Репозиторијум за приступ подацима ентитета BaKorisnici.
 */
@Repository
public interface BaKorisniciRepository extends JpaRepository<BaKorisnici, Long>{
	
	Optional<BaKorisnici> findByEmail(String email);
	
}
