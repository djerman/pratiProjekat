package rs.prati.core.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

/**
 * Ентитет који представља refresh токен повезан са корисником.
 * Користи се за обнављање access токена када претходни истекне.
 */
@Entity
@Table(name = "auth_refresh_token")
public class AuthRefreshToken {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Повезани корисник (из табеле ba_korisnici).
     */
    @ManyToOne
    @JoinColumn(name = "korisnik_id", nullable = false)
    private BaKorisnici korisnik;

    /**
     * Вредност refresh токена (у текстуалном облику).
     */
    @Column(nullable = false, columnDefinition = "TEXT")
    private String token;

    /**
     * Датум и време када токен истиче.
     */
    @Column(name = "expiry_date", nullable = false)
    private LocalDateTime expiryDate;

    /**
     * Датум и време креирања токена.
     */
    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt = LocalDateTime.now();

    // Гетери и сетери

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BaKorisnici getKorisnik() {
        return korisnik;
    }

    public void setKorisnik(BaKorisnici korisnik) {
        this.korisnik = korisnik;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public LocalDateTime getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(LocalDateTime expiryDate) {
        this.expiryDate = expiryDate;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
