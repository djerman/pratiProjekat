package rs.prati.service.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

/**
 * DTO објекат за ентитет BfZone.
 */
public class BfZoneDto extends BaseDto {

    /**
     * ИД претплатника коме зона припада.
     */
    @NotNull
    private Long pretplatnikId;

    /**
     * ИД организације која је дефинисала зону (опционо).
     */
    private Long organizacijaId;

    /**
     * Назив зоне.
     */
    @NotNull
    @Size(max = 45)
    private String naziv;

    /**
     * Географска дужина центра зоне.
     */
    @NotNull
    private Double lon;

    /**
     * Географска ширина центра зоне.
     */
    @NotNull
    private Double lat;

    /**
     * Полупречник зоне у метрима.
     */
    @NotNull
    private Integer precnik;

    /**
     * Опис зоне (опционо).
     */
    @Size(max = 45)
    private String opis;

    /**
     * Статус активности зоне.
     */
    @NotNull
    private Boolean aktivan;

    // Гетери и сетери

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
