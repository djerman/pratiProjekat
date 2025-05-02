package rs.prati.core.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

/**
 * Ентитет који представља објекте у систему (нпр. возила, уређаје).
 */
@Entity
@Table(name = "bb_objekti")
public class BbObjekti extends BaseEntity {

    /** Претплатник коме припада објекат. */
    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pretplatnik_id", nullable = false)
    private AbSistemPretplatnici pretplatnik;

    /** Организација у оквиру претплатника. */
    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "organizacija_id", nullable = false)
    private AcOrganizacije organizacija;

    /** Ознака објекта. */
    @NotNull
    @Size(max = 100)
    @Column(name = "oznaka")
    private String oznaka;

    /** Тип објекта. */
    @NotNull
    @Size(max = 50)
    @Column(name = "tip")
    private String tip;

    /** Време стајања у минутима. */
    @NotNull
    @Column(name = "vreme_stajanja")
    private Integer vremeStajanja;

    /** Прекорачење брзине у km/h. */
    @NotNull
    @Column(name = "prekoracenje_brzine")
    private Integer prekoracenjeBrzine;

    /** Да ли је објекат активан. */
    @NotNull
    @Column(name = "aktivan", columnDefinition = "TINYINT(1)")
    private Boolean aktivan;

    /** Возило повезано са овим објектом. */
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "vozilo_id")
    private CjVozilo vozilo;

    // --- Гетери и Сетери ---

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

    public String getOznaka() {
        return oznaka;
    }

    public void setOznaka(String oznaka) {
        this.oznaka = oznaka;
    }

    public String getTip() {
        return tip;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }

    public Integer getVremeStajanja() {
        return vremeStajanja;
    }

    public void setVremeStajanja(Integer vremeStajanja) {
        this.vremeStajanja = vremeStajanja;
    }

    public Integer getPrekoracenjeBrzine() {
        return prekoracenjeBrzine;
    }

    public void setPrekoracenjeBrzine(Integer prekoracenjeBrzine) {
        this.prekoracenjeBrzine = prekoracenjeBrzine;
    }

    public Boolean getAktivan() {
        return aktivan;
    }

    public void setAktivan(Boolean aktivan) {
        this.aktivan = aktivan;
    }

    public CjVozilo getVozilo() {
        return vozilo;
    }

    public void setVozilo(CjVozilo vozilo) {
        this.vozilo = vozilo;
    }
}
