package rs.prati.service.dto;

import java.time.LocalDateTime;

/**
 * DTO за ентитет CfJavljanjaPoslednja.
 * Представља последње познато јављање сваког објекта.
 */
public class CfJavljanjaPoslednjaDto extends BaseDto {

    /** ID објекта (уређаја или возила) */
    private Long objekatId;

    /** Датум и време последњег јављања */
    private LocalDateTime datumVreme;

    /** Географска дужина */
    private Double lon;

    /** Географска ширина */
    private Double lat;

    /** Правaц кретања */
    private Float pravac;

    /** Надморска висина */
    private Float visina;

    /** Брзина у km/h */
    private Integer brzina;

    /** ID аларма у моменту јављања (ако постоји) */
    private Long alarmId;

    /** Виртуелна километража */
    private Float virtualOdo;

    /** Додатни подаци о догађају (JSON, опис итд.) */
    private String eventData;

    /** Зона у којој се уређај налази */
    private Long zona;

    /** ID корисника повезаног са јављањем */
    private Long korisnikId;

    /** Статус контакта */
    private Boolean kontakt;

    /** iButton вредност (идентификација возача) */
    private String ibutton;

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

    public Long getKorisnikId() {
        return korisnikId;
    }

    public void setKorisnikId(Long korisnikId) {
        this.korisnikId = korisnikId;
    }

    public Boolean getKontakt() {
        return kontakt;
    }

    public void setKontakt(Boolean kontakt) {
        this.kontakt = kontakt;
    }

    public String getIbutton() {
        return ibutton;
    }

    public void setIbutton(String ibutton) {
        this.ibutton = ibutton;
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
