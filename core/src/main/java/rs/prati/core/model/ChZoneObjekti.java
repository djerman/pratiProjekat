package rs.prati.core.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

/**
 * Ентитет који представља везу између зоне и објеката.
 */
@Entity
@Table(name = "ch_zoneObjekti")
public class ChZoneObjekti extends BaseEntity {

    /** Веза ка претплатнику */
    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "zopretplatnikId", nullable = false)
    private AbSistemPretplatnici zopretplatnik;

    /** Веза ка организацији */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "zoorganizacijaId")
    private AcOrganizacije zoorganizacija;

    /** Веза ка зони */
    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "zonaId", nullable = false)
    private BfZone zona;

    /** Веза ка објекту */
    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "objekatId", nullable = false)
    private BbObjekti objekat;

    /** Да ли је улаз у зону */
    @NotNull
    @Column(name = "ulaz", nullable = false)
    private Boolean ulaz;

    /** Да ли је излаз из зоне */
    @NotNull
    @Column(name = "izlaz", nullable = false)
    private Boolean izlaz;

    /** Да ли је асоцијација активна */
    @Column(name = "aktivan")
    private Boolean aktivan;

    /** Датум и време креирања */
    @CreationTimestamp
    @Column(name = "kreirano", updatable = false)
    private LocalDateTime kreirano;

    /** Датум и време последње измене */
    @UpdateTimestamp
    @Column(name = "izmenjeno")
    private LocalDateTime izmenjeno;

    /** Да ли је обрисан */
    @Column(name = "izbrisan")
    private Boolean izbrisan;

    // Гетери и сетери

    public AbSistemPretplatnici getZopretplatnik() {
        return zopretplatnik;
    }

    public void setZopretplatnik(AbSistemPretplatnici zopretplatnik) {
        this.zopretplatnik = zopretplatnik;
    }

    public AcOrganizacije getZoorganizacija() {
        return zoorganizacija;
    }

    public void setZoorganizacija(AcOrganizacije zoorganizacija) {
        this.zoorganizacija = zoorganizacija;
    }

    public BfZone getZona() {
        return zona;
    }

    public void setZona(BfZone zona) {
        this.zona = zona;
    }

    public BbObjekti getObjekat() {
        return objekat;
    }

    public void setObjekat(BbObjekti objekat) {
        this.objekat = objekat;
    }

    public Boolean getUlaz() {
        return ulaz;
    }

    public void setUlaz(Boolean ulaz) {
        this.ulaz = ulaz;
    }

    public Boolean getIzlaz() {
        return izlaz;
    }

    public void setIzlaz(Boolean izlaz) {
        this.izlaz = izlaz;
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
