package rs.prati.service.dto;

import java.time.LocalDateTime;

/**
 * DTO за ентитет CgObd.
 * Представља OBD (On-Board Diagnostics) податке возила.
 */
public class CgObdDto extends BaseDto {

    /** ID објекта (уређаја или возила) */
    private Long objekatId;

    /** Датум и време јављања */
    private LocalDateTime datumVreme;

    /** Број обртаја у минуту (RPM) */
    private Integer rpm;

    /** Температура мотора (у °C) */
    private Integer temperatura;

    /** Оптерећење мотора у процентима */
    private Float opterecenje;

    /** Положај гаса у процентима */
    private Float gas;

    /** Ниво горива у процентима */
    private Float nivoGoriva;

    /** Напон акумулатора у V */
    private Float akumulator;

    /** Пређени километри у овој вожњи */
    private Float tripKm;

    /** Потрошено гориво у овој вожњи */
    private Float tripGorivo;

    /** Укупно време рада мотора (у сатима) */
    private Float ukupnoVreme;

    /** Укупна пређена километража */
    private Integer ukupnoKm;

    /** Укупно потрошено гориво */
    private Float ukupnoGorivo;

    /** Просечна потрошња (npr. l/100km) */
    private Float prosecnaPotrosnja;

    /** Дијагностичке грешке (OBD кодови) */
    private String greske;

    /** Датум и време креирања */
    private LocalDateTime kreirano;

    /** Датум и време последње измене */
    private LocalDateTime izmenjeno;

    // ГЕТЕРИ И СЕТЕРИ

    public Long getObjekatId() {
        return objekatId;
    }

    public void setObjekatId(Long objekatId) {
        this.objekatId = objekatId;
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
