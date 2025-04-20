package rs.prati.service.repository;

import rs.prati.core.model.AuthRefreshToken;
import rs.prati.core.model.BaKorisnici;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Репозиторијум за рад са табелом auth_refresh_token.
 * Омогућава проналажење, брисање и чување refresh токена.
 */
@Repository
public interface AuthRefreshTokenRepository extends JpaRepository<AuthRefreshToken, Long> {

    /**
     * Проналази refresh токен на основу његове вредности (текста).
     *
     * @param token вредност токена
     * @return опциони објекат са токеном
     */
    Optional<AuthRefreshToken> findByToken(String token);

    /**
     * Брише све refresh токене повезане са датим корисником.
     *
     * @param korisnik корисник чије токене бришемо
     * @return број обрисаних редова
     */
    int deleteByKorisnik(BaKorisnici korisnik);
}

