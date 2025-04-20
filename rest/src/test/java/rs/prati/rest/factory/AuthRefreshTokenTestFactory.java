package rs.prati.rest.factory;

import rs.prati.core.model.AuthRefreshToken;
import rs.prati.core.model.BaKorisnici;

import java.time.LocalDateTime;

/**
 * Помоћна класа за креирање тестних refresh токена.
 */
public class AuthRefreshTokenTestFactory {

    public static AuthRefreshToken build(String token, BaKorisnici korisnik) {
        AuthRefreshToken rt = new AuthRefreshToken();
        rt.setToken(token);
        rt.setKorisnik(korisnik);
        rt.setCreatedAt(LocalDateTime.now());
        rt.setExpiryDate(LocalDateTime.now().plusDays(7));
        return rt;
    }
}
