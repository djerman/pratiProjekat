package rs.prati.service.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

/**
 * DTO за ентитет BgPartneri – представља податке о партнерима претплатника.
 */
public class BgPartneriDto extends BaseDto {

    /**
     * ИД претплатника коме припада партнер.
     */
    @NotNull
    private Long pretplatnikId;

    /**
     * Назив партнера.
     */
    @NotNull
    @Size(max = 45)
    private String naziv;

    /**
     * ПИБ партнера.
     */
    @NotNull
    private Integer pib;

    /**
     * Матични број.
     */
    @Size(max = 45)
    private String mb;

    /**
     * Адреса.
     */
    @Size(max = 45)
    private String adresa;

    /**
     * Телефон.
     */
    @Size(max = 45)
    private String telefon;

    /**
     * Мобилни телефон.
     */
    @Size(max = 45)
    private String mobilni;

    /**
     * Е-пошта.
     */
    @Size(max = 45)
    private String eposta;

    /**
     * Контакт особа.
     */
    @Size(max = 45)
    private String kontaktOsoba;

    // --- Гетери и сетери ---

    public Long getPretplatnikId() {
        return pretplatnikId;
    }

    public void setPretplatnikId(Long pretplatnikId) {
        this.pretplatnikId = pretplatnikId;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public Integer getPib() {
        return pib;
    }

    public void setPib(Integer pib) {
        this.pib = pib;
    }

    public String getMb() {
        return mb;
    }

    public void setMb(String mb) {
        this.mb = mb;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
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

    public String getEposta() {
        return eposta;
    }

    public void setEposta(String eposta) {
        this.eposta = eposta;
    }

    public String getKontaktOsoba() {
        return kontaktOsoba;
    }

    public void setKontaktOsoba(String kontaktOsoba) {
        this.kontaktOsoba = kontaktOsoba;
    }
}
