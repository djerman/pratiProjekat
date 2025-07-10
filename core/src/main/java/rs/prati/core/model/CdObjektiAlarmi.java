package rs.prati.core.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

/**
 * Ентитет који дефинише аларме и ограничења повезане са појединим објектима.
 * Садржи податке о ограничењу брзине, сервисним интервалима и статусима.
 */
@Entity
@Table(name = "cd_objektiAlarmi")
public class CdObjektiAlarmi extends BaseEntity {

    /** Претплатник коме овај податак припада */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pretplatnikId", nullable = false)
    private AbSistemPretplatnici pretplatnik;

    /** Организација у оквиру претплатника */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "organizacijaId")
    private AcOrganizacije organizacija;

    /** Објекат на који се односе аларми */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "objekatId")
    private BbObjekti objekat;

    /** Максимално дозвољено ограничење брзине (у km/h) */
    @Column(name = "ogranicenjeBrzine")
    private Integer ogranicenjeBrzine;

    /** Максимално дозвољено време неактивности (у минутима) */
    @Column(name = "vremeNeaktivnost")
    private Integer vremeNeaktivnost;

    /** Интервал за мали сервис (у данима) */
    @Column(name = "vremeMaliServis")
    private Integer vremeMaliServis;

    /** Интервал за мали сервис (у km) */
    @Column(name = "kmMaliServis")
    private Integer kmMaliServis;

    /** Интервал за велики сервис (у данима) */
    @Column(name = "vremeVelikiServis")
    private Integer vremeVelikiServis;

    /** Интервал за велики сервис (у km) */
    @Column(name = "kmVelikiServis")
    private Integer kmVelikiServis;

    /** Да ли је конфигурација активна */
    @NotNull
    @Column(name = "aktivan", nullable = false)
    private Boolean aktivan;

    /** Датум и време креирања записа */
    @CreationTimestamp
    @Column(name = "kreirano", updatable = false)
    private LocalDateTime kreirano;

    /** Датум и време последње измене */
    @UpdateTimestamp
    @Column(name = "izmenjeno")
    private LocalDateTime izmenjeno;

    /** Да ли је запис означен као обрисан */
    @NotNull
    @Column(name = "izbrisan", nullable = false)
    private Boolean izbrisan;

    // ГЕТЕРИ И СЕТЕРИ

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

    public Integer getOgranicenjeBrzine() {
        return ogranicenjeBrzine;
    }

    public void setOgranicenjeBrzine(Integer ogranicenjeBrzine) {
        this.ogranicenjeBrzine = ogranicenjeBrzine;
    }

    public Integer getVremeNeaktivnost() {
        return vremeNeaktivnost;
    }

    public void setVremeNeaktivnost(Integer vremeNeaktivnost) {
        this.vremeNeaktivnost = vremeNeaktivnost;
    }

    public Integer getVremeMaliServis() {
        return vremeMaliServis;
    }

    public void setVremeMaliServis(Integer vremeMaliServis) {
        this.vremeMaliServis = vremeMaliServis;
    }

    public Integer getKmMaliServis() {
        return kmMaliServis;
    }

    public void setKmMaliServis(Integer kmMaliServis) {
        this.kmMaliServis = kmMaliServis;
    }

    public Integer getVremeVelikiServis() {
        return vremeVelikiServis;
    }

    public void setVremeVelikiServis(Integer vremeVelikiServis) {
        this.vremeVelikiServis = vremeVelikiServis;
    }

    public Integer getKmVelikiServis() {
        return kmVelikiServis;
    }

    public void setKmVelikiServis(Integer kmVelikiServis) {
        this.kmVelikiServis = kmVelikiServis;
    }

    public Boolean getAktivan() {
        return aktivan;
    }

    public void setAktivan(Boolean aktivan) {
        this.aktivan = aktivan;
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
