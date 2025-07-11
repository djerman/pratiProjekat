package rs.prati.core.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

/**
 * Ентитет који представља примање опреме у оквиру примопредаје возила.
 */
@Entity
@Table(name = "da_voziloOpremaPrijem")
public class DaVoziloOpremaPrijem extends BaseEntity {

    /** Претплатник */
    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pretplatnikId", nullable = false)
    private AbSistemPretplatnici pretplatnik;

    /** Организација */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "organizacijaId")
    private AcOrganizacije organizacija;

    /** Примопредаја на коју се односи пријем опреме */
    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "primoPredajaId", nullable = false)
    private CkVoziloPrimoPredaja primoPredaja;

    /** Опреама која се пријављује */
    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "opremaId", nullable = false)
    private BhVoziloOprema oprema;

    /** Количина */
    @NotNull
    @Column(name = "kolicina", nullable = false)
    private Integer kolicina;

    // Гетери и сетери

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

    public CkVoziloPrimoPredaja getPrimoPredaja() {
        return primoPredaja;
    }

    public void setPrimoPredaja(CkVoziloPrimoPredaja primoPredaja) {
        this.primoPredaja = primoPredaja;
    }

    public BhVoziloOprema getOprema() {
        return oprema;
    }

    public void setOprema(BhVoziloOprema oprema) {
        this.oprema = oprema;
    }

    public Integer getKolicina() {
        return kolicina;
    }

    public void setKolicina(Integer kolicina) {
        this.kolicina = kolicina;
    }
}
