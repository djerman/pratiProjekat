package rs.prati.service.dto;

import java.time.LocalDate;

/**
 * DTO за ентитет DiPredjeniPut (пређени пут и потрошња).
 */
public class DiPredjeniPutDto extends BaseDto {

    /** ID објекта */
    private Long objekatId;

    /** Датум */
    private LocalDate datum;

    /** Виртуелни километража */
    private Float virtualOdo;

    /** Укупно пређених километара */
    private Integer ukupnoKm;

    /** Укупно потрошеног горива */
    private Float ukupnoGorivo;

    /** Просечна потрошња (GPS) */
    private Float prosPotGps;

    /** Просечна потрошња */
    private Float prosPot;

    // Гетери и сетери

    public Long getObjekatId() {
        return objekatId;
    }

    public void setObjekatId(Long objekatId) {
        this.objekatId = objekatId;
    }

    public LocalDate getDatum() {
        return datum;
    }

    public void setDatum(LocalDate datum) {
        this.datum = datum;
    }

    public Float getVirtualOdo() {
        return virtualOdo;
    }

    public void setVirtualOdo(Float virtualOdo) {
        this.virtualOdo = virtualOdo;
    }

    public Integer getUkupnoKm() {
        return ukupnoKm;
    }

    public void setUkupnoKm(Integer ukupnoKm) {
        this.ukupnoKm = ukupnoKm;
    }

    public Float getUkupnoGorivo() {
        return ukupnoGorivo;
    }

    public void setUkupnoGorivo(Float ukupnoGorivo) {
        this.ukupnoGorivo = ukupnoGorivo;
    }

    public Float getProsPotGps() {
        return prosPotGps;
    }

    public void setProsPotGps(Float prosPotGps) {
        this.prosPotGps = prosPotGps;
    }

    public Float getProsPot() {
        return prosPot;
    }

    public void setProsPot(Float prosPot) {
        this.prosPot = prosPot;
    }
}
