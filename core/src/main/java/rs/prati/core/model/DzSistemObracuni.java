package rs.prati.core.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalDateTime;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

/**
 * Ентитет који представља системске обрачуне за објекте (дневни извештај вожње, потрошње, брзине и слично).
 */
@Entity
@Table(name = "dz_sistemObracuni")
public class DzSistemObracuni extends BaseEntity {

    /** Датум обрачуна. */
    @Column(name = "datum")
    private LocalDate datum;

    /** Веза ка ентитету BbObjekti (страни кључ objekatId). */
    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "objekatId", nullable = false)
    private BbObjekti objekat;

    /** Вредност километража са GPS-а. */
    @NotNull
    @Column(name = "odoGPS", nullable = false)
    private Float odoGPS;

    /** Пређена километража по GPS-у. */
    @NotNull
    @Column(name = "gpsKm", nullable = false)
    private Float gpsKm;

    /** Просечна брзина. */
    @NotNull
    @Column(name = "brzinaProsecna", nullable = false)
    private Integer brzinaProsecna;

    /** Максимална брзина. */
    @NotNull
    @Column(name = "brzinaMaks", nullable = false)
    private Integer brzinaMaks;

    /** Пређени километри по OBD-у. */
    @NotNull
    @Column(name = "obdKm", nullable = false)
    private Integer obdKm;

    /** Укупна километража са OBD-а. */
    @NotNull
    @Column(name = "odoObd", nullable = false)
    private Integer odoObd;

    /** Укупна потрошња. */
    @NotNull
    @Column(name = "potrosnjaUkupna", nullable = false)
    private Float potrosnjaUkupna;

    /** Просечна потрошња. */
    @NotNull
    @Column(name = "potrosnjaProsek", nullable = false)
    private Float potrosnjaProsek;

    /** Просечан RPM. */
    @NotNull
    @Column(name = "rpmProsek", nullable = false)
    private Integer rpmProsek;

    /** Максималан RPM. */
    @NotNull
    @Column(name = "rpmMaks", nullable = false)
    private Integer rpmMaks;

    /** Просечно оптерећење. */
    @NotNull
    @Column(name = "opterecenjeProsek", nullable = false)
    private Float opterecenjeProsek;

    /** Максимално оптерећење. */
    @NotNull
    @Column(name = "opterecenjeMaks", nullable = false)
    private Float opterecenjeMaks;

    /** Просечна температура. */
    @NotNull
    @Column(name = "tempProsek", nullable = false)
    private Integer tempProsek;

    /** Максимална температура. */
    @NotNull
    @Column(name = "tempMaks", nullable = false)
    private Integer tempMaks;

    /** Датум и време креирања. */
    @CreationTimestamp
    @Column(name = "kreirano", updatable = false)
    private LocalDateTime kreirano;

    /** Датум и време измене. */
    @UpdateTimestamp
    @Column(name = "izmenjeno")
    private LocalDateTime izmenjeno;

    // ГЕТЕРИ И СЕТЕРИ

    public LocalDate getDatum() {
        return datum;
    }

    public void setDatum(LocalDate datum) {
        this.datum = datum;
    }

    public BbObjekti getObjekat() {
        return objekat;
    }

    public void setObjekat(BbObjekti objekat) {
        this.objekat = objekat;
    }

    public Float getOdoGPS() {
        return odoGPS;
    }

    public void setOdoGPS(Float odoGPS) {
        this.odoGPS = odoGPS;
    }

    public Float getGpsKm() {
        return gpsKm;
    }

    public void setGpsKm(Float gpsKm) {
        this.gpsKm = gpsKm;
    }

    public Integer getBrzinaProsecna() {
        return brzinaProsecna;
    }

    public void setBrzinaProsecna(Integer brzinaProsecna) {
        this.brzinaProsecna = brzinaProsecna;
    }

    public Integer getBrzinaMaks() {
        return brzinaMaks;
    }

    public void setBrzinaMaks(Integer brzinaMaks) {
        this.brzinaMaks = brzinaMaks;
    }

    public Integer getObdKm() {
        return obdKm;
    }

    public void setObdKm(Integer obdKm) {
        this.obdKm = obdKm;
    }

    public Integer getOdoObd() {
        return odoObd;
    }

    public void setOdoObd(Integer odoObd) {
        this.odoObd = odoObd;
    }

    public Float getPotrosnjaUkupna() {
        return potrosnjaUkupna;
    }

    public void setPotrosnjaUkupna(Float potrosnjaUkupna) {
        this.potrosnjaUkupna = potrosnjaUkupna;
    }

    public Float getPotrosnjaProsek() {
        return potrosnjaProsek;
    }

    public void setPotrosnjaProsek(Float potrosnjaProsek) {
        this.potrosnjaProsek = potrosnjaProsek;
    }

    public Integer getRpmProsek() {
        return rpmProsek;
    }

    public void setRpmProsek(Integer rpmProsek) {
        this.rpmProsek = rpmProsek;
    }

    public Integer getRpmMaks() {
        return rpmMaks;
    }

    public void setRpmMaks(Integer rpmMaks) {
        this.rpmMaks = rpmMaks;
    }

    public Float getOpterecenjeProsek() {
        return opterecenjeProsek;
    }

    public void setOpterecenjeProsek(Float opterecenjeProsek) {
        this.opterecenjeProsek = opterecenjeProsek;
    }

    public Float getOpterecenjeMaks() {
        return opterecenjeMaks;
    }

    public void setOpterecenjeMaks(Float opterecenjeMaks) {
        this.opterecenjeMaks = opterecenjeMaks;
    }

    public Integer getTempProsek() {
        return tempProsek;
    }

    public void setTempProsek(Integer tempProsek) {
        this.tempProsek = tempProsek;
    }

    public Integer getTempMaks() {
        return tempMaks;
    }

    public void setTempMaks(Integer tempMaks) {
        this.tempMaks = tempMaks;
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
