package rs.prati.core.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Table(name = "di_predjeniPut")
public class DiPredjeniPut {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotNull
    @Column(name = "objekatId")
    private Long objekatId;

    @NotNull
    @Column(name = "datum")
    private LocalDate datum;

    @NotNull
    @Column(name = "virtualOdo")
    private Float virtualOdo;

    @NotNull
    @Column(name = "ukupnoKm")
    private Integer ukupnoKm;

    @NotNull
    @Column(name = "ukupnoGorivo")
    private Float ukupnoGorivo;

    @NotNull
    @Column(name = "prosPotGps")
    private Float prosPotGps;

    @NotNull
    @Column(name = "prosPot")
    private Float prosPot;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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
