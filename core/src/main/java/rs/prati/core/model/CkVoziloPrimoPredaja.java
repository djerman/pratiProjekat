package rs.prati.core.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.time.LocalDate;
import java.time.LocalDateTime;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

/**
 * Ентитет који представља примопредају возила између возача.
 */
@Entity
@Table(name = "ck_voziloPrimoPredaja")
public class CkVoziloPrimoPredaja extends BaseEntity {

    /** Претплатник којем припада примопредаја */
    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pretplatnikId", nullable = false)
    private AbSistemPretplatnici pretplatnik;

    /** Организација (ако постоји) */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "organizacijaId")
    private AcOrganizacije organizacija;

    /** Број записника/примопредаје */
    @Size(max = 45)
    @Column(name = "broj", length = 45)
    private String broj;

    /** Датум примопредаје */
    @NotNull
    @Column(name = "datum", nullable = false)
    private LocalDate datum;

    /** Возило на које се односи примопредаја */
    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "voziloId", nullable = false)
    private CjVozilo vozilo;

    /** Возач који предаје возило */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "vozacPredaja")
    private CiVozaci vozacPredaja;

    /** Администратор који врши примопредају */
    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "administrator", nullable = false)
    private BaKorisnici administrator;

    /** Возач који прима возило */
    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "vozacPrijem", nullable = false)
    private CiVozaci vozacPrijem;

    /** Коментар или напомена */
    @Size(max = 45)
    @Column(name = "komentar", length = 45)
    private String komentar;

    /** Датум и време креирања */
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

    public String getBroj() {
        return broj;
    }

    public void setBroj(String broj) {
        this.broj = broj;
    }

    public LocalDate getDatum() {
        return datum;
    }

    public void setDatum(LocalDate datum) {
        this.datum = datum;
    }

    public CjVozilo getVozilo() {
        return vozilo;
    }

    public void setVozilo(CjVozilo vozilo) {
        this.vozilo = vozilo;
    }

    public CiVozaci getVozacPredaja() {
        return vozacPredaja;
    }

    public void setVozacPredaja(CiVozaci vozacPredaja) {
        this.vozacPredaja = vozacPredaja;
    }

    public BaKorisnici getAdministrator() {
        return administrator;
    }

    public void setAdministrator(BaKorisnici administrator) {
        this.administrator = administrator;
    }

    public CiVozaci getVozacPrijem() {
        return vozacPrijem;
    }

    public void setVozacPrijem(CiVozaci vozacPrijem) {
        this.vozacPrijem = vozacPrijem;
    }

    public String getKomentar() {
        return komentar;
    }

    public void setKomentar(String komentar) {
        this.komentar = komentar;
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
