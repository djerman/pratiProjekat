package rs.prati.core.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

/**
 * Повезује кориснике са групама возила у оквиру претплатника и организације.
 */
@Entity
@Table(name = "ca_grupeKorisnici")
public class CaGrupeKorisnici extends BaseEntity {

    /**
     * Претплатник коме припада ова веза.
     */
    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "gkpretplatnikId", nullable = false)
    private AbSistemPretplatnici pretplatnik;

    /**
     * Организација у оквиру претплатника (може бити null).
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "gkorganizacijaId")
    private AcOrganizacije organizacija;

    /**
     * Група возила којој корисник припада.
     */
    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "gkgrupaId", nullable = false)
    private BeGrupe grupa;

    /**
     * Корисник који је придружен групи.
     */
    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "gkkorisnikId", nullable = false)
    private BaKorisnici korisnik;

    /**
     * Време креирања записа.
     */
    @NotNull
    @CreationTimestamp
    @Column(name = "kreirano", updatable = false)
    private LocalDateTime kreirano;

    /**
     * Време последње измене.
     */
    @NotNull
    @UpdateTimestamp
    @Column(name = "izmenjeno")
    private LocalDateTime izmenjeno;

    // --- Гетери и сетери ---

    public AbSistemPretplatnici getPretplatnik() {
        return pretplatnik;
    }

    public void setPretplatnik(AbSistemPretplatnici pretplatnik) {
        this.pretplatnik = pretplatnik;
    }

    public AcOrganizacije getOrganizacija() {
        return organizacija;
    }

    public void setOrganizacija(AcOrganizacije organizacija) {
        this.organizacija = organizacija;
    }

    public BeGrupe getGrupa() {
        return grupa;
    }

    public void setGrupa(BeGrupe grupa) {
        this.grupa = grupa;
    }

    public BaKorisnici getKorisnik() {
        return korisnik;
    }

    public void setKorisnik(BaKorisnici korisnik) {
        this.korisnik = korisnik;
    }

    public LocalDateTime getKreirano() {
        return kreirano;
    }

    public void setKreirano(LocalDateTime kreirano) {
        this.kreirano = kreirano;
    }

    public LocalDateTime getIzmenjeno() {
        return izmenjeno;
    }

    public void setIzmenjeno(LocalDateTime izmenjeno) {
        this.izmenjeno = izmenjeno;
    }
}
