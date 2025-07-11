package rs.prati.core.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "cg_obd")
public class CgObd extends BaseEntity {

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "objekatId", nullable = false)
    private BbObjekti objekat;

    @Column(name = "datumVreme")
    private LocalDateTime datumVreme;

    @Column(name = "rpm")
    private Integer rpm;

    @Column(name = "temperatura")
    private Integer temperatura;

    @Column(name = "opterecenje")
    private Float opterecenje;

    @Column(name = "gas")
    private Float gas;

    @Column(name = "nivoGoriva")
    private Float nivoGoriva;

    @Column(name = "akumulator")
    private Float akumulator;

    @Column(name = "tripKm")
    private Float tripKm;

    @Column(name = "tripGorivo")
    private Float tripGorivo;

    @Column(name = "ukupnoVreme")
    private Float ukupnoVreme;

    @Column(name = "ukupnoKm")
    private Integer ukupnoKm;

    @Column(name = "ukupnoGorivo")
    private Float ukupnoGorivo;

    @Column(name = "prosecnaPotrosnja")
    private Float prosecnaPotrosnja;

    @Size(max = 45)
    @Column(name = "greske", length = 45)
    private String greske;

    @CreationTimestamp
    @Column(name = "kreirano", updatable = false)
    private LocalDateTime kreirano;

    @UpdateTimestamp
    @Column(name = "izmenjeno")
    private LocalDateTime izmenjeno;

    // --- Getteri i setteri ---

    public BbObjekti getObjekat() {
        return objekat;
    }

    public void setObjekat(BbObjekti objekat) {
        this.objekat = objekat;
    }

    public LocalDateTime getDatumVreme() {
        return datumVreme;
    }

    public void setDatumVreme(LocalDateTime datumVreme) {
        this.datumVreme = datumVreme;
    }

    public Integer getRpm() {
        return rpm;
    }

    public void setRpm(Integer rpm) {
        this.rpm = rpm;
    }

    public Integer getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(Integer temperatura) {
        this.temperatura = temperatura;
    }

    public Float getOpterecenje() {
        return opterecenje;
    }

    public void setOpterecenje(Float opterecenje) {
        this.opterecenje = opterecenje;
    }

    public Float getGas() {
        return gas;
    }

    public void setGas(Float gas) {
        this.gas = gas;
    }

    public Float getNivoGoriva() {
        return nivoGoriva;
    }

    public void setNivoGoriva(Float nivoGoriva) {
        this.nivoGoriva = nivoGoriva;
    }

    public Float getAkumulator() {
        return akumulator;
    }

    public void setAkumulator(Float akumulator) {
        this.akumulator = akumulator;
    }

    public Float getTripKm() {
        return tripKm;
    }

    public void setTripKm(Float tripKm) {
        this.tripKm = tripKm;
    }

    public Float getTripGorivo() {
        return tripGorivo;
    }

    public void setTripGorivo(Float tripGorivo) {
        this.tripGorivo = tripGorivo;
    }

    public Float getUkupnoVreme() {
        return ukupnoVreme;
    }

    public void setUkupnoVreme(Float ukupnoVreme) {
        this.ukupnoVreme = ukupnoVreme;
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

    public Float getProsecnaPotrosnja() {
        return prosecnaPotrosnja;
    }

    public void setProsecnaPotrosnja(Float prosecnaPotrosnja) {
        this.prosecnaPotrosnja = prosecnaPotrosnja;
    }

    public String getGreske() {
        return greske;
    }

    public void setGreske(String greske) {
        this.greske = greske;
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
}
