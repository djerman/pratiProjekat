package rs.prati.core.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

/**
 * Партнери претплатника система.
 */
@Entity
@Table(name = "bg_partneri")
public class BgPartneri extends BaseEntity {

    /**
     * Претплатник коме припада партнер.
     */
    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pretplatnikId", nullable = false)
    private AbSistemPretplatnici pretplatnik;

    /**
     * Назив партнера.
     */
    @NotNull
    @Size(max = 45)
    @Column(name = "naziv")
    private String naziv;

    /**
     * ПИБ партнера.
     */
    @NotNull
    @Column(name = "pib")
    private Integer pib;

    /**
     * Матични број.
     */
    @Size(max = 45)
    @Column(name = "mb")
    private String mb;

    /**
     * Адреса.
     */
    @Size(max = 45)
    @Column(name = "adresa")
    private String adresa;

    /**
     * Телефон.
     */
    @Size(max = 45)
    @Column(name = "telefon")
    private String telefon;

    /**
     * Мобилни телефон.
     */
    @Size(max = 45)
    @Column(name = "mobilni")
    private String mobilni;

    /**
     * Е-пошта.
     */
    @Size(max = 45)
    @Column(name = "eposta")
    private String eposta;

    /**
     * Контакт особа.
     */
    @Size(max = 45)
    @Column(name = "kontaktOsoba")
    private String kontaktOsoba;

    // --- Гетери и сетери ---

    public AbSistemPretplatnici getPretplatnik() {
        return pretplatnik;
    }

    public void setPretplatnik(AbSistemPretplatnici pretplatnik) {
        this.pretplatnik = pretplatnik;
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
