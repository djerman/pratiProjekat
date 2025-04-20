package rs.prati.service.security;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import jakarta.annotation.PostConstruct;
import rs.prati.core.model.BaKorisnici;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;

@Component
public class JwtTokenProvider {

	// Тајни кључ за потписивање токена (долази из application.properties)
    @Value("${jwt.secret}")
    private String jwtSecret;

    // Време важења токена у милисекундама (нпр. 2 сата)
    @Value("${jwt.expiration}")
    private long jwtExpirationInMs;

    private Key key;

    // Иницијализација кључа након читања конфигурације
    @PostConstruct
    public void init() {
        this.key = Keys.hmacShaKeyFor(jwtSecret.getBytes());
    }

 // Генерише токен на основу email адресе (без Authentication)
    public String generateTokenFromEmail(String email) {
        Date now = new Date();
        Date expiryDate = new Date(now.getTime() + jwtExpirationInMs);

        return Jwts.builder()
                .setSubject(email)
                .setIssuedAt(now)
                .setExpiration(expiryDate)
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();
    }

    // Преоптерећена метода која прима BaKorisnici објекат
    public String generateToken(BaKorisnici korisnik) {
        return generateTokenFromEmail(korisnik.getEmail());
    }

    // Генерише JWT токен на основу аутентификованог корисника
    public String generateToken(Authentication authentication) {
        UserDetails userPrincipal = (UserDetails) authentication.getPrincipal();
        Date now = new Date();
        Date expiryDate = new Date(now.getTime() + jwtExpirationInMs);

        return Jwts.builder()
                .setSubject(userPrincipal.getUsername())
                .setIssuedAt(now)
                .setExpiration(expiryDate)
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();
    }

    // Извлачи корисничко име (email) из JWT токена
    public String getUsernameFromJWT(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }

    // Проверава да ли је токен важећи и исправно потписан
    public boolean validateToken(String authToken) {
        try {
            Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(authToken);
            return true;
        } catch (JwtException | IllegalArgumentException ex) {
            return false;
        }
    }
}
