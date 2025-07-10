package rs.prati.service.dto;

import java.time.LocalDateTime;

/**
 * DTO за ентитет CeJavljanjaMirovanja.
 * Представља податке о мирујућим стањима објеката (нпр. последња позната позиција пре заустављања).
 */
public class CeJavljanjaMirovanjaDto extends BaseDto {

    /** ID објекта који је стао */
    private Long objekatId;

    /** Датум и време јављања */
    private LocalDateTime datumVreme;

    /** Географска дужина */
    private Double lon;

    /** Географска ширина */
    private Double lat;

    /** Правaц кретања у моменту заустављања */
    private Float pravac;

    /** Надморска висина */
    private Float visina;

    /** Брзина у моменту заустављања */
    private Integer brzina;

    /** Да ли је контакт укључен */
    private Boolean kontakt;

    /** ID аларма (ако постоји) */
    private Long alarmId;

    /** Виртуелни бројач километраже */
    private Float virtualOdo;

    /** Додатни подаци о догађају */
    private String eventData;

    /** ID зоне у којој је стање мировања */
    private Long zona;

    /** iButton вредност за идентификацију возача */
    private String ibutton;

    /** ID корисника повезаног са догађајем */
    private Long korisnikId;

    /** Датум и време креирања */
    private LocalDateTime kreirano;

    /** Датум и време измене */
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

    public Float getPravac() {
        return pravac;
    }

    public void setPravac(Float pravac) {
        this.pravac = pravac;
    }

    public Float getVisina() {
        return visina;
    }

    public void setVisina(Float visina) {
        this.visina = visina;
    }

    public Integer getBrzina() {
        return brzina;
    }

    public void setBrzina(Integer brzina) {
        this.brzina = brzina;
    }

    public Boolean getKontakt() {
        return kontakt;
    }

    public void setKontakt(Boolean kontakt) {
        this.kontakt = kontakt;
    }

    public Long getAlarmId() {
        return alarmId;
    }

    public void setAlarmId(Long alarmId) {
        this.alarmId = alarmId;
    }

    public Float getVirtualOdo() {
        return virtualOdo;
    }

    public void setVirtualOdo(Float virtualOdo) {
        this.virtualOdo = virtualOdo;
    }

    public String getEventData() {
        return eventData;
    }

    public void setEventData(String eventData) {
        this.eventData = eventData;
    }

    public Long getZona() {
        return zona;
    }

    public void setZona(Long zona) {
        this.zona = zona;
    }

    public String getIbutton() {
        return ibutton;
    }

    public void setIbutton(String ibutton) {
        this.ibutton = ibutton;
    }

    public Long getKorisnikId() {
        return korisnikId;
    }

    public void setKorisnikId(Long korisnikId) {
        this.korisnikId = korisnikId;
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
