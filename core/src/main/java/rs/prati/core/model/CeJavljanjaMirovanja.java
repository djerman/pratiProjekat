package rs.prati.core.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import java.time.LocalDateTime;

/**
 * Ентитет који представља јављања у стању мировања – задња позната позиција пре паузе.
 */
@Entity
@Table(name = "ce_javljanja_mirovanja")
public class CeJavljanjaMirovanja extends BaseEntity {

    /** Објекат (возило, уређај) који је стао */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "objekatId", nullable = false)
    private BbObjekti objekat;

    /** Датум и време мировања */
    @Column(name = "datumVreme")
    private LocalDateTime datumVreme;

    /** Географска дужина */
    @Column(name = "lon")
    private Double lon;

    /** Географска ширина */
    @Column(name = "lat")
    private Double lat;

    /** Правaц кретања у моменту заустављања */
    @Column(name = "pravac")
    private Float pravac;

    /** Надморска висина у метрима */
    @Column(name = "visina")
    private Float visina;

    /** Брзина у моменту мировања (очекивано 0 или минимална) */
    @Column(name = "brzina")
    private Integer brzina;

    /** Статус контакта (да ли је мотор искључен) */
    @Column(name = "kontakt")
    private Boolean kontakt;

    /** Аларм који је евентуално активиран у тренутку мировања */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "alarmId")
    private AdSistemAlarmi alarm;

    /** Виртуелни бројач километраже */
    @Column(name = "virtualOdo")
    private Float virtualOdo;

    /** Додатни подаци о догађају (опис, JSON итд.) */
    @Size(max = 255)
    @Column(name = "eventData", length = 255)
    private String eventData;

    /** Зона у којој се уређај налазио при миру */
    @Column(name = "zona")
    private Long zona;

    /** iButton вредност (идентификација возача при миру) */
    @Size(max = 100)
    @Column(name = "ibutton", length = 100)
    private String ibutton;

    /** Корисник који је регистровао или је везан за стање мировања */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "korisnikId")
    private BaKorisnici korisnik;

    // ГЕТЕРИ И СЕТЕРИ

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

    public AdSistemAlarmi getAlarm() {
        return alarm;
    }

    public void setAlarm(AdSistemAlarmi alarm) {
        this.alarm = alarm;
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

    public BaKorisnici getKorisnik() {
        return korisnik;
    }

    public void setKorisnik(BaKorisnici korisnik) {
        this.korisnik = korisnik;
    }
}
