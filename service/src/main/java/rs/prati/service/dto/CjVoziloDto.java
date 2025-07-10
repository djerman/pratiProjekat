package rs.prati.service.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * DTO за ентитет CjVozilo.
 * Представља основне податке о возилу.
 */
public class CjVoziloDto extends BaseDto {

    /** ID претплатника */
    private Long pretplatnikId;

    /** ID организације */
    private Long organizacijaId;

    /** ID објекта (уређаја у возилу) */
    private Long objekatId;

    /** Регистрација возила */
    private String registracija;

    /** Марка возила */
    private String marka;

    /** Модел возила */
    private String model;

    /** Тип возила */
    private String tip;

    /** Година производње */
    private Integer godina;

    /** ID типа горива */
    private Long gorivo;

    /** Запремина резервоара */
    private Integer rezervoar;

    /** Просечна потрошња */
    private Float potrosnja;

    /** Да ли је теретно возило */
    private Boolean teretno;

    /** Број саобраћајне дозволе */
    private String brojSaobracajne;

    /** ID саобраћајне дозволе (документа) */
    private Long saobracajnaId;

    /** Серијски број шасије/уређаја */
    private String serijskiBroj;

    /** Датум регистрације */
    private LocalDate datumRegistracije;

    /** Интервал малог сервиса (km) */
    private Integer maliServisKm;

    /** Интервал малог сервиса (месеци) */
    private Integer maliServisMeseci;

    /** Интервал великог сервиса (km) */
    private Integer velikiServisKm;

    /** Интервал великог сервиса (месеци) */
    private Integer velikiServisMeseci;

    /** Датум последње регистрације */
    private LocalDate datumPoslednjeRegistracije;

    /** Датум последњег малог сервиса */
    private LocalDate maliPoslednjiDatum;

    /** Километража малог сервиса (GPS) */
    private Float maliPoslednjiGPSkm;

    /** Километража малог сервиса (OBD) */
    private Integer maliPoslednjiOBDkm;

    /** Датум последњег великог сервиса */
    private LocalDate velikiPoslednjiDatum;

    /** Километража великог сервиса (GPS) */
    private Float velikiPoslednjiGPSkm;

    /** Километража великог сервиса (OBD) */
    private Integer velikiPoslednjiOBDkm;

    /** Да ли је запис означен као обрисан */
    private Boolean izbrisan;

    /** Датум и време креирања */
    private LocalDateTime kreirano;

    /** Датум и време последње измене */
    private LocalDateTime izmenjeno;

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

    public Long getObjekatId() {
        return objekatId;
    }

    public void setObjekatId(Long objekatId) {
        this.objekatId = objekatId;
    }

    public String getRegistracija() {
        return registracija;
    }

    public void setRegistracija(String registracija) {
        this.registracija = registracija;
    }

    public String getMarka() {
        return marka;
    }

    public void setMarka(String marka) {
        this.marka = marka;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getTip() {
        return tip;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }

    public Integer getGodina() {
        return godina;
    }

    public void setGodina(Integer godina) {
        this.godina = godina;
    }

    public Long getGorivo() {
        return gorivo;
    }

    public void setGorivo(Long gorivo) {
        this.gorivo = gorivo;
    }

    public Integer getRezervoar() {
        return rezervoar;
    }

    public void setRezervoar(Integer rezervoar) {
        this.rezervoar = rezervoar;
    }

    public Float getPotrosnja() {
        return potrosnja;
    }

    public void setPotrosnja(Float potrosnja) {
        this.potrosnja = potrosnja;
    }

    public Boolean getTeretno() {
        return teretno;
    }

    public void setTeretno(Boolean teretno) {
        this.teretno = teretno;
    }

    public String getBrojSaobracajne() {
        return brojSaobracajne;
    }

    public void setBrojSaobracajne(String brojSaobracajne) {
        this.brojSaobracajne = brojSaobracajne;
    }

    public Long getSaobracajnaId() {
        return saobracajnaId;
    }

    public void setSaobracajnaId(Long saobracajnaId) {
        this.saobracajnaId = saobracajnaId;
    }

    public String getSerijskiBroj() {
        return serijskiBroj;
    }

    public void setSerijskiBroj(String serijskiBroj) {
        this.serijskiBroj = serijskiBroj;
    }

    public LocalDate getDatumRegistracije() {
        return datumRegistracije;
    }

    public void setDatumRegistracije(LocalDate datumRegistracije) {
        this.datumRegistracije = datumRegistracije;
    }

    public Integer getMaliServisKm() {
        return maliServisKm;
    }

    public void setMaliServisKm(Integer maliServisKm) {
        this.maliServisKm = maliServisKm;
    }

    public Integer getMaliServisMeseci() {
        return maliServisMeseci;
    }

    public void setMaliServisMeseci(Integer maliServisMeseci) {
        this.maliServisMeseci = maliServisMeseci;
    }

    public Integer getVelikiServisKm() {
        return velikiServisKm;
    }

    public void setVelikiServisKm(Integer velikiServisKm) {
        this.velikiServisKm = velikiServisKm;
    }

    public Integer getVelikiServisMeseci() {
        return velikiServisMeseci;
    }

    public void setVelikiServisMeseci(Integer velikiServisMeseci) {
        this.velikiServisMeseci = velikiServisMeseci;
    }

    public LocalDate getDatumPoslednjeRegistracije() {
        return datumPoslednjeRegistracije;
    }

    public void setDatumPoslednjeRegistracije(LocalDate datumPoslednjeRegistracije) {
        this.datumPoslednjeRegistracije = datumPoslednjeRegistracije;
    }

    public LocalDate getMaliPoslednjiDatum() {
        return maliPoslednjiDatum;
    }

    public void setMaliPoslednjiDatum(LocalDate maliPoslednjiDatum) {
        this.maliPoslednjiDatum = maliPoslednjiDatum;
    }

    public Float getMaliPoslednjiGPSkm() {
        return maliPoslednjiGPSkm;
    }

    public void setMaliPoslednjiGPSkm(Float maliPoslednjiGPSkm) {
        this.maliPoslednjiGPSkm = maliPoslednjiGPSkm;
    }

    public Integer getMaliPoslednjiOBDkm() {
        return maliPoslednjiOBDkm;
    }

    public void setMaliPoslednjiOBDkm(Integer maliPoslednjiOBDkm) {
        this.maliPoslednjiOBDkm = maliPoslednjiOBDkm;
    }

    public LocalDate getVelikiPoslednjiDatum() {
        return velikiPoslednjiDatum;
    }

    public void setVelikiPoslednjiDatum(LocalDate velikiPoslednjiDatum) {
        this.velikiPoslednjiDatum = velikiPoslednjiDatum;
    }

    public Float getVelikiPoslednjiGPSkm() {
        return velikiPoslednjiGPSkm;
    }

    public void setVelikiPoslednjiGPSkm(Float velikiPoslednjiGPSkm) {
        this.velikiPoslednjiGPSkm = velikiPoslednjiGPSkm;
    }

    public Integer getVelikiPoslednjiOBDkm() {
        return velikiPoslednjiOBDkm;
    }

    public void setVelikiPoslednjiOBDkm(Integer velikiPoslednjiOBDkm) {
        this.velikiPoslednjiOBDkm = velikiPoslednjiOBDkm;
    }

    public Boolean getIzbrisan() {
        return izbrisan;
    }

    public void setIzbrisan(Boolean izbrisan) {
        this.izbrisan = izbrisan;
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
