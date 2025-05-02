package rs.prati.core.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.time.LocalDateTime;

/**
 * Ентитет који представља кориснике у систему.
 */
@Entity
@Table(name = "ba_korisnici")
public class BaKorisnici extends BaseEntity {

    /** Име корисника. */
    @NotNull
    @Size(max = 50)
    @Column(name = "ime")
    private String ime;

    /** Презиме корисника. */
    @NotNull
    @Size(max = 50)
    @Column(name = "prezime")
    private String prezime;

    /** Да ли је корисник обичан корисник. */
    @NotNull
    @Column(name = "korisnik", columnDefinition = "TINYINT(1)")
    private Boolean korisnik;

    /** Емаил адреса. */
    @NotNull
    @Size(max = 100)
    @Email
    @Column(name = "email")
    private String email;

    /** Лозинка. */
    @NotNull
    @Size(max = 255)
    @Column(name = "lozinka")
    private String lozinka;

    /** Телефон. */
    @Size(max = 30)
    @Column(name = "telefon")
    private String telefon;

    /** Мобилни. */
    @Size(max = 30)
    @Column(name = "mobilni")
    private String mobilni;

    /** iButton ID. */
    @Size(max = 50)
    @Column(name = "ibutton")
    private String ibutton;

    /** Да ли је возач. */
    @NotNull
    @Column(name = "vozac", columnDefinition = "TINYINT(1)")
    private Boolean vozac;

    /** Да ли је администратор. */
    @NotNull
    @Column(name = "admin", columnDefinition = "TINYINT(1)")
    private Boolean admin;

    /** Да ли је системски корисник. */
    @NotNull
    @Column(name = "sistem", columnDefinition = "TINYINT(1)")
    private Boolean sistem;

    /** Да ли је налог активан. */
    @NotNull
    @Column(name = "aktivan", columnDefinition = "TINYINT(1)")
    private Boolean aktivan;

    /** Датум до ког је налог активан. */
    @Column(name = "aktivanDo")
    private LocalDateTime aktivanDo;

    /** Повезан претплатник. */
    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pretplatnikId", nullable = false)
    private AbSistemPretplatnici pretplatnik;

    /** Повезана организација (опционо). */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "organizacijaId")
    private AcOrganizacije organizacija;

    /** URL до слике. */
    @Size(max = 255)
    @Column(name = "slikaUrl")
    private String slikaUrl;

    // --- Getери и Setери ---

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public Boolean getKorisnik() {
        return korisnik;
    }

    public void setKorisnik(Boolean korisnik) {
        this.korisnik = korisnik;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLozinka() {
        return lozinka;
    }

    public void setLozinka(String lozinka) {
        this.lozinka = lozinka;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public String getMobilni() {
        return mobilni;
    }

    public void setMobilni(String mobilni) {
        this.mobilni = mobilni;
    }

    public String getIbutton() {
        return ibutton;
    }

    public void setIbutton(String ibutton) {
        this.ibutton = ibutton;
    }

    public Boolean getVozac() {
        return vozac;
    }

    public void setVozac(Boolean vozac) {
        this.vozac = vozac;
    }

    public Boolean getAdmin() {
        return admin;
    }

    public void setAdmin(Boolean admin) {
        this.admin = admin;
    }

    public Boolean getSistem() {
        return sistem;
    }

    public void setSistem(Boolean sistem) {
        this.sistem = sistem;
    }

    public Boolean getAktivan() {
        return aktivan;
    }

    public void setAktivan(Boolean aktivan) {
        this.aktivan = aktivan;
    }

    public LocalDateTime getAktivanDo() {
        return aktivanDo;
    }

    public void setAktivanDo(LocalDateTime aktivanDo) {
        this.aktivanDo = aktivanDo;
    }

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

    public String getSlikaUrl() {
        return slikaUrl;
    }

    public void setSlikaUrl(String slikaUrl) {
        this.slikaUrl = slikaUrl;
    }
}
