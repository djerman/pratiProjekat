package rs.prati.core.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

/**
 * Ентитет који представља дефинисану гео-зону за надгледање у систему.
 */
@Entity
@Table(name = "bf_zone")
public class BfZone extends BaseEntity {

    /**
     * Претплатник коме зона припада.
     */
    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pretplatnikId", nullable = false)
    private AbSistemPretplatnici pretplatnik;

    /**
     * Организација која је дефинисала зону (опционално).
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "organizacijaId")
    private AcOrganizacije organizacija;

    /**
     * Назив зоне.
     */
    @NotNull
    @Size(max = 45)
    @Column(name = "naziv")
    private String naziv;

    /**
     * Географска дужина центра зоне.
     */
    @NotNull
    @Column(name = "lon")
    private Double lon;

    /**
     * Географска ширина центра зоне.
     */
    @NotNull
    @Column(name = "lat")
    private Double lat;

    /**
     * Полупречник зоне у метрима.
     */
    @NotNull
    @Column(name = "precnik")
    private Integer precnik;

    /**
     * Опис зоне (опционално).
     */
    @Size(max = 45)
    @Column(name = "opis")
    private String opis;

    /**
     * Статус активности зоне.
     */
    @NotNull
    @Column(name = "aktivan")
    private Boolean aktivan;

    // Гетери и сетери

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

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public Double getLon() {
        return lon;
    }

    public void setLon(Double lon) {
        this.lon = lon;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Integer getPrecnik() {
        return precnik;
    }

    public void setPrecnik(Integer precnik) {
        this.precnik = precnik;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public Boolean getAktivan() {
        return aktivan;
    }

    public void setAktivan(Boolean aktivan) {
        this.aktivan = aktivan;
    }
}
