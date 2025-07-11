package rs.prati.core.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;

/**
 * Ентитет који представља укупно пређени пут и потрошњу за објекат.
 */
@Entity
@Table(name = "di_predjeniPut")
public class DiPredjeniPut extends BaseEntity {

    /** Веза ка објекту (страни кључ objekatId). */
    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "objekatId", nullable = false)
    private BbObjekti objekat;

    /** Датум */
    @NotNull
    @Column(name = "datum", nullable = false)
    private LocalDate datum;

    /** Виртуелни километража */
    @NotNull
    @Column(name = "virtualOdo", nullable = false)
    private Float virtualOdo;

    /** Укупно пређених километара */
    @NotNull
    @Column(name = "ukupnoKm", nullable = false)
    private Integer ukupnoKm;

    /** Укупно потрошеног горива */
    @NotNull
    @Column(name = "ukupnoGorivo", nullable = false)
    private Float ukupnoGorivo;

    /** Просечна потрошња (GPS) */
    @NotNull
    @Column(name = "prosPotGps", nullable = false)
    private Float prosPotGps;

    /** Просечна потрошња */
    @NotNull
    @Column(name = "prosPot", nullable = false)
    private Float prosPot;

    // Гетери и сетери

    public BbObjekti getObjekat() {
        return objekat;
    }

    public void setObjekat(BbObjekti objekat) {
        this.objekat = objekat;
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
