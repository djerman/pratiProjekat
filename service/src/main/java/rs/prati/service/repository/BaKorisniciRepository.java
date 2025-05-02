package rs.prati.service.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import rs.prati.core.model.BaKorisnici;

/**
 * Репозиторијум за приступ подацима ентитета BaKorisnici.
 */
@Repository
public interface BaKorisniciRepository extends JpaRepository<BaKorisnici, Long>{
	
	Optional<BaKorisnici> findByEmail(String email);
	
	@Query("""
			    SELECT k FROM BaKorisnici k
			    WHERE k.email = :email
			      AND (k.aktivanDo IS NULL OR k.aktivanDo > CURRENT_TIMESTAMP)
			      AND (k.sistem = true OR k.admin = true OR k.korisnik = true)
			""")
	Optional<BaKorisnici> findValidUserByEmail(@Param("email") String email);

}
