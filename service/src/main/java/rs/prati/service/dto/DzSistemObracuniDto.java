package rs.prati.service.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * DTO за ентитет DzSistemObracuni (системски обрачуни за објекте).
 */
public class DzSistemObracuniDto extends BaseDto {

    /** Датум обрачуна. */
    private LocalDate datum;

    /** ID објекта (BbObjekti). */
    private Long objekatId;

    /** Вредност километража са GPS-а. */
    private Float odoGPS;

    /** Пређена километража по GPS-у. */
    private Float gpsKm;

    /** Просечна брзина. */
    private Integer brzinaProsecna;

    /** Максимална брзина. */
    private Integer brzinaMaks;

    /** Пређени километри по OBD-у. */
    private Integer obdKm;

    /** Укупна километража са OBD-а. */
    private Integer odoObd;

    /** Укупна потрошња. */
    private Float potrosnjaUkupna;

    /** Просечна потрошња. */
    private Float potrosnjaProsek;

    /** Просечан RPM. */
    private Integer rpmProsek;

    /** Максималан RPM. */
    private Integer rpmMaks;

    /** Просечно оптерећење. */
    private Float opterecenjeProsek;

    /** Максимално оптерећење. */
    private Float opterecenjeMaks;

    /** Просечна температура. */
    private Integer tempProsek;

    /** Максимална температура. */
    private Integer tempMaks;

    /** Датум и време креирања. */
    private LocalDateTime kreirano;

    /** Датум и време измене. */
    private LocalDateTime izmenjeno;

    // ГЕТЕРИ И СЕТЕРИ

    public LocalDate getDatum() {
        return datum;
    }

    public void setDatum(LocalDate datum) {
        this.datum = datum;
    }

    public Long getObjekatId() {
        return objekatId;
    }

    public void setObjekatId(Long objekatId) {
        this.objekatId = objekatId;
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
