package rs.prati.core.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import java.time.LocalDateTime;

/**
 * Ентитет који представља јављања (позиције, аларме, статuse) са возила или уређаја у реалном времену.
 */
@Entity
@Table(name = "ce_javljanja")
public class CeJavljanja extends BaseEntity {

    /** Објекат (возило, уређај) који шаље јављање */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "objekatId", nullable = false)
    private BbObjekti objekat;

    /** Датум и време јављања */
    @Column(name = "datumVreme")
    private LocalDateTime datumVreme;

    /** Географска дужина */
    @Column(name = "lon")
    private Double lon;

    /** Географска ширина */
    @Column(name = "lat")
    private Double lat;

    /** Правaц кретања у степенима (0–360) */
    @Column(name = "pravac")
    private Float pravac;

    /** Надморска висина у метрима */
    @Column(name = "visina")
    private Float visina;

    /** Брзина у km/h */
    @Column(name = "brzina")
    private Integer brzina;

    /** Статус контакта (да ли је возило упаљено) */
    @Column(name = "kontakt")
    private Boolean kontakt;

    /** Аларм повезан са јављањем (ако постоји) */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "alarmId")
    private AdSistemAlarmi alarm;

    /** Виртуелна километража */
    @Column(name = "virtualOdo")
    private Float virtualOdo;

    /** Додатни подаци о догађају (JSON, бинарни, текстуални опис итд.) */
    @Size(max = 255)
    @Column(name = "eventData", length = 255)
    private String eventData;

    /** ИД зоне у којој се уређај налази (ако је познато) */
    @Column(name = "zona")
    private Long zona;

    /** iButton вредност за идентификацију возача */
    @Size(max = 100)
    @Column(name = "ibutton", length = 100)
    private String ibutton;

    /** Корисник који је генерисао или обрадио јављање */
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
