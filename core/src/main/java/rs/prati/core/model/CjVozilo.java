package rs.prati.core.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.time.LocalDate;
import java.time.LocalDateTime;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

/**
 * Ентитет који представља возило у систему.
 */
@Entity
@Table(name = "cj_vozilo")
public class CjVozilo extends BaseEntity {

    /** Веза ка претплатнику */
    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pretplatnikId", nullable = false)
    private AbSistemPretplatnici pretplatnik;

    /** Веза ка организацији */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "organizacijaId")
    private AcOrganizacije organizacija;

    /** Веза ка објекту (уређају у возилу) */
    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "objekatId", nullable = false)
    private BbObjekti objekat;

    /** Регистрација возила */
    @NotNull
    @Size(max = 45)
    @Column(name = "registracija", length = 45, nullable = false)
    private String registracija;

    /** Марка возила */
    @NotNull
    @Size(max = 45)
    @Column(name = "marka", length = 45, nullable = false)
    private String marka;

    /** Модел возила */
    @NotNull
    @Size(max = 45)
    @Column(name = "model", length = 45, nullable = false)
    private String model;

    /** Тип возила */
    @Size(max = 45)
    @Column(name = "tip", length = 45)
    private String tip;

    /** Година производње */
    @NotNull
    @Column(name = "godina", nullable = false)
    private Integer godina;

    /** Тип горива (ID везаног ентитета ако постоји) */
    @Column(name = "gorivo")
    private Long gorivo;

    /** Запремина резервоара */
    @Column(name = "rezervoar")
    private Integer rezervoar;

    /** Просечна потрошња */
    @Column(name = "potrosnja")
    private Float potrosnja;

    /** Да ли је теретно возило */
    @NotNull
    @Column(name = "teretno", nullable = false)
    private Boolean teretno;

    /** Број саобраћајне дозволе */
    @Size(max = 45)
    @Column(name = "brojSaobracajne", length = 45)
    private String brojSaobracajne;

    /** Саобраћајна дозвола (ID документа ако постоји) */
    @Column(name = "saobracajnaId")
    private Long saobracajnaId;

    /** Серијски број шасије/уређаја */
    @Size(max = 45)
    @Column(name = "serijskiBroj", length = 45)
    private String serijskiBroj;

    /** Датум регистрације */
    @Column(name = "datumRegistracije")
    private LocalDate datumRegistracije;

    /** Интервал малог сервиса (km) */
    @NotNull
    @Column(name = "maliServisKm", nullable = false)
    private Integer maliServisKm;

    /** Интервал малог сервиса (месеци) */
    @NotNull
    @Column(name = "maliServisMeseci", nullable = false)
    private Integer maliServisMeseci;

    /** Интервал великог сервиса (km) */
    @NotNull
    @Column(name = "velikiServisKm", nullable = false)
    private Integer velikiServisKm;

    /** Интервал великог сервиса (месеци) */
    @NotNull
    @Column(name = "velikiServisMeseci", nullable = false)
    private Integer velikiServisMeseci;

    /** Датум последње регистрације */
    @Column(name = "datumPoslednjeRegistracije")
    private LocalDate datumPoslednjeRegistracije;

    /** Датум последњег малог сервиса */
    @Column(name = "maliPoslednjiDatum")
    private LocalDate maliPoslednjiDatum;

    /** Километража малог сервиса (GPS) */
    @NotNull
    @Column(name = "maliPoslednjiGPSkm", nullable = false)
    private Float maliPoslednjiGPSkm;

    /** Километража малог сервиса (OBD) */
    @NotNull
    @Column(name = "maliPoslednjiOBDkm", nullable = false)
    private Integer maliPoslednjiOBDkm;

    /** Датум последњег великог сервиса */
    @Column(name = "velikiPoslednjiDatum")
    private LocalDate velikiPoslednjiDatum;

    /** Километража великог сервиса (GPS) */
    @NotNull
    @Column(name = "velikiPoslednjiGPSkm", nullable = false)
    private Float velikiPoslednjiGPSkm;

    /** Километража великог сервиса (OBD) */
    @NotNull
    @Column(name = "velikiPoslednjiOBDkm", nullable = false)
    private Integer velikiPoslednjiOBDkm;

    /** Да ли је запис означен као обрисан */
    @NotNull
    @Column(name = "izbrisan", nullable = false)
    private Boolean izbrisan;

    /** Датум и време креирања */
    @CreationTimestamp
    @Column(name = "kreirano", updatable = false)
    private LocalDateTime kreirano;

    /** Датум и време последње измене */
    @UpdateTimestamp
    @Column(name = "izmenjeno")
    private LocalDateTime izmenjeno;

    // Гетери и сетери (у више линија, не у једној!)

    public AbSistemPretplatnici getPretplatnik() {
        return pretplatnik;
    }

    public void setPretplatnik(AbSistemPretplatnici pretplatnik) {
        this.pretplatnik = pretplatnik;
    }

    public AcOrganizacije getOrganizacija() {
        return organizacija;
    }

    public void setOrganizacija(AcOrganizacije organizacija) {
        this.organizacija = organizacija;
    }

    public BbObjekti getObjekat() {
        return objekat;
    }

    public void setObjekat(BbObjekti objekat) {
        this.objekat = objekat;
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
