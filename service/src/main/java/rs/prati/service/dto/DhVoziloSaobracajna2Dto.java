package rs.prati.service.dto;

import java.time.LocalDateTime;

/**
 * DTO за ентитет DhVoziloSaobracajna2 (додатни подаци саобраћајне дозволе).
 */
public class DhVoziloSaobracajna2Dto extends BaseDto {

    /** ID претплатника */
    private Long pretplatnikId;

    /** ID организације */
    private Long organizacijaId;

    /** ID саобраћајне дозволе */
    private Long saobracajnaId;

    /** Власник */
    private String vlasnik;

    /** Адреса власника */
    private String adresaVlasnika;

    /** ЈМБГ власника */
    private String jmbgVlasnika;

    /** Корисник */
    private String korisnik;

    /** Адреса корисника */
    private String adresaKorisnika;

    /** Димензије гума */
    private String dimenzijeGuma;

    /** Притисак гуме */
    private String pritisakGume;

    /** Димензије товара */
    private String dimenzijeTovara;

    /** Однос снага/маса */
    private String odnosSnagaMasa;

    /** Места стајање */
    private String mestaStajanje;

    /** Купљено/Донирано од */
    private String kupljenoDoniranoOd;

    /** Набављено по рачуну/сертификату */
    private String nabavljenoPoRacunuSert;

    /** Добављач/Донатор */
    private String dobavljacDonator;

    /** Датум и време креирања */
    private LocalDateTime kreirano;

    /** Датум и време измене */
    private LocalDateTime izmenjeno;

    /** Ознака обрисаности */
    private Boolean izbrisan;

    // ГЕТЕРИ И СЕТЕРИ

    public Long getPretplatnikId() {
        return pretplatnikId;
    }

    public void setPretplatnikId(Long pretplatnikId) {
        this.pretplatnikId = pretplatnikId;
    }

    public Long getOrganizacijaId() {
        return organizacijaId;
    }

    public void setOrganizacijaId(Long organizacijaId) {
        this.organizacijaId = organizacijaId;
    }

    public Long getSaobracajnaId() {
        return saobracajnaId;
    }

    public void setSaobracajnaId(Long saobracajnaId) {
        this.saobracajnaId = saobracajnaId;
    }

    public String getVlasnik() {
        return vlasnik;
    }

    public void setVlasnik(String vlasnik) {
        this.vlasnik = vlasnik;
    }

    public String getAdresaVlasnika() {
        return adresaVlasnika;
    }

    public void setAdresaVlasnika(String adresaVlasnika) {
        this.adresaVlasnika = adresaVlasnika;
    }

    public String getJmbgVlasnika() {
        return jmbgVlasnika;
    }

    public void setJmbgVlasnika(String jmbgVlasnika) {
        this.jmbgVlasnika = jmbgVlasnika;
    }

    public String getKorisnik() {
        return korisnik;
    }

    public void setKorisnik(String korisnik) {
        this.korisnik = korisnik;
    }

    public String getAdresaKorisnika() {
        return adresaKorisnika;
    }

    public void setAdresaKorisnika(String adresaKorisnika) {
        this.adresaKorisnika = adresaKorisnika;
    }

    public String getDimenzijeGuma() {
        return dimenzijeGuma;
    }

    public void setDimenzijeGuma(String dimenzijeGuma) {
        this.dimenzijeGuma = dimenzijeGuma;
    }

    public String getPritisakGume() {
        return pritisakGume;
    }

    public void setPritisakGume(String pritisakGume) {
        this.pritisakGume = pritisakGume;
    }

    public String getDimenzijeTovara() {
        return dimenzijeTovara;
    }

    public void setDimenzijeTovara(String dimenzijeTovara) {
        this.dimenzijeTovara = dimenzijeTovara;
    }

    public String getOdnosSnagaMasa() {
        return odnosSnagaMasa;
    }

    public void setOdnosSnagaMasa(String odnosSnagaMasa) {
        this.odnosSnagaMasa = odnosSnagaMasa;
    }

    public String getMestaStajanje() {
        return mestaStajanje;
    }

    public void setMestaStajanje(String mestaStajanje) {
        this.mestaStajanje = mestaStajanje;
    }

    public String getKupljenoDoniranoOd() {
        return kupljenoDoniranoOd;
    }

    public void setKupljenoDoniranoOd(String kupljenoDoniranoOd) {
        this.kupljenoDoniranoOd = kupljenoDoniranoOd;
    }

    public String getNabavljenoPoRacunuSert() {
        return nabavljenoPoRacunuSert;
    }

    public void setNabavljenoPoRacunuSert(String nabavljenoPoRacunuSert) {
        this.nabavljenoPoRacunuSert = nabavljenoPoRacunuSert;
    }

    public String getDobavljacDonator() {
        return dobavljacDonator;
    }

    public void setDobavljacDonator(String dobavljacDonator) {
        this.dobavljacDonator = dobavljacDonator;
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

    public Boolean getIzbrisan() {
        return izbrisan;
    }

    public void setIzbrisan(Boolean izbrisan) {
        this.izbrisan = izbrisan;
    }
}
