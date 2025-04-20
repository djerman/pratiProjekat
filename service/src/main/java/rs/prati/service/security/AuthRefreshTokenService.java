package rs.prati.service.security;

import rs.prati.core.model.AuthRefreshToken;
import rs.prati.core.model.BaKorisnici;
import rs.prati.service.repository.AuthRefreshTokenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

/**
 * Сервис који управља refresh токенима.
 * Омогућава креирање, верификацију и брисање refresh токена.
 */
@Service
public class AuthRefreshTokenService {

    private final AuthRefreshTokenRepository refreshTokenRepository;

    public AuthRefreshTokenService(AuthRefreshTokenRepository refreshTokenRepository) {
        this.refreshTokenRepository = refreshTokenRepository;
    }

    /**
     * Генерише и чува нови refresh токен за датог корисника.
     *
     * @param korisnik корисник за кога се генерише токен
     * @return креирани refresh токен
     */
    public AuthRefreshToken createRefreshToken(BaKorisnici korisnik) {
        AuthRefreshToken token = new AuthRefreshToken();
        token.setKorisnik(korisnik);
        token.setToken(UUID.randomUUID().toString()); // случајни уникатни стринг
        token.setExpiryDate(LocalDateTime.now().plusDays(7)); // важи 7 дана
        token.setCreatedAt(LocalDateTime.now());

        return refreshTokenRepository.save(token);
    }

    /**
     * Проналази refresh токен по вредности.
     *
     * @param token вредност refresh токена
     * @return опциони објекат
     */
    public Optional<AuthRefreshToken> findByToken(String token) {
        return refreshTokenRepository.findByToken(token);
    }

    /**
     * Проверава да ли је токен истекао.
     * Ако јесте — брише га и баца RuntimeException.
     *
     * @param token refresh токен који се проверава
     * @return исти токен ако није истекао
     */
    public AuthRefreshToken verifyExpiration(AuthRefreshToken token) {
        if (token.getExpiryDate().isBefore(LocalDateTime.now())) {
            refreshTokenRepository.delete(token);
            throw new RuntimeException("Refresh токен је истекао. Поново се пријавите.");
        }
        return token;
    }

    /**
     * Брише све refresh токене повезане са корисником.
     *
     * @param korisnik корисник чији се токени бришу
     * @return број обрисаних записа
     */
    public int deleteByKorisnik(BaKorisnici korisnik) {
        return refreshTokenRepository.deleteByKorisnik(korisnik);
    }
}
