package rs.prati.service.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.time.LocalDateTime;

/**
 * DTO класа за ентитет BaKorisnici.
 * Користи се за пренос података о корисницима система.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BaKorisniciDto extends BaseDto {

    /** Име корисника. */
    @NotNull
    @Size(max = 50)
    private String ime;

    /** Презиме корисника. */
    @NotNull
    @Size(max = 50)
    private String prezime;

    /** Да ли је означен као корисник. */
    @NotNull
    private Boolean korisnik;

    /** Емаил адреса корисника. */
    @NotNull
    @Size(max = 100)
    @Email
    private String email;

    /** Лозинка корисника. */
    @NotNull
    @Size(max = 255)
    private String lozinka;

    /** Телефон корисника. */
    @Size(max = 30)
    private String telefon;

    /** Мобилни телефон корисника. */
    @Size(max = 30)
    private String mobilni;

    /** iButton идентификатор. */
    @Size(max = 50)
    private String ibutton;

    /** Да ли је корисник возач. */
    @NotNull
    private Boolean vozac;

    /** Да ли је администратор. */
    @NotNull
    private Boolean admin;

    /** Да ли је системски корисник. */
    @NotNull
    private Boolean sistem;

    /** Да ли је корисник активан. */
    @NotNull
    private Boolean aktivan;

    /** Време до када је налог активан. */
    private LocalDateTime aktivanDo;

    /** Идентификатор претплатника (FK). */
    private Long pretplatnikId;

    /** Идентификатор организације (FK). */
    private Long organizacijaId;

    /** URL до слике профила. */
    @Size(max = 255)
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

    public Long getPretplatnikId() {
        return pretplatnikId;
    }

    public void setPretplatnikId(Long pretplatnikId) {
        this.pretplatnikId = pretplatnikId;
    }

    public Long getOrganizacijaId() {
        return organizacijaId;
    }

    public void setOrganizacijaId(Long organizacijaId) {
        this.organizacijaId = organizacijaId;
    }

    public String getSlikaUrl() {
        return slikaUrl;
    }

    public void setSlikaUrl(String slikaUrl) {
        this.slikaUrl = slikaUrl;
    }
}
