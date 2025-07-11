package rs.prati.core.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.time.LocalDate;
import java.time.LocalDateTime;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

/**
 * Ентитет који представља пасош возача.
 */
@Entity
@Table(name = "df_vozaciPasosi")
public class DfVozaciPasosi extends BaseEntity {

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pretplatnikId", nullable = false)
    private AbSistemPretplatnici pretplatnik;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "organizacijaId")
    private AcOrganizacije organizacija;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "korisnikId", nullable = false)
    private BaKorisnici korisnik;

    @NotNull
    @Size(max = 45)
    @Column(name = "brojPasosa", length = 45, nullable = false)
    private String brojPasosa;

    @NotNull
    @Column(name = "izdato", nullable = false)
    private LocalDate izdato;

    @NotNull
    @Column(name = "vaziDo", nullable = false)
    private LocalDate vaziDo;

    @CreationTimestamp
    @Column(name = "kreirano", updatable = false)
    private LocalDateTime kreirano;

    @UpdateTimestamp
    @Column(name = "izmenjeno")
    private LocalDateTime izmenjeno;

    @NotNull
    @Column(name = "izbrisan", nullable = false)
    private Boolean izbrisan;

    // ГЕТЕРИ И СЕТЕРИ

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

    public BaKorisnici getKorisnik() {
        return korisnik;
    }

    public void setKorisnik(BaKorisnici korisnik) {
        this.korisnik = korisnik;
    }

    public String getBrojPasosa() {
        return brojPasosa;
    }

    public void setBrojPasosa(String brojPasosa) {
        this.brojPasosa = brojPasosa;
    }

    public LocalDate getIzdato() {
        return izdato;
    }

    public void setIzdato(LocalDate izdato) {
        this.izdato = izdato;
    }

    public LocalDate getVaziDo() {
        return vaziDo;
    }

    public void setVaziDo(LocalDate vaziDo) {
        this.vaziDo = vaziDo;
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

    public Boolean getIzbrisan() {
        return izbrisan;
    }

    public void setIzbrisan(Boolean izbrisan) {
        this.izbrisan = izbrisan;
    }
}
