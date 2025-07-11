package rs.prati.core.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.time.LocalDateTime;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

/**
 * Ентитет који представља налог за вожњу/путовање возила.
 */
@Entity
@Table(name = "cl_voziloNalog")
public class ClVoziloNalog extends BaseEntity {

    /** Претплатник коме припада налог */
    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pretplatnikId", nullable = false)
    private AbSistemPretplatnici pretplatnik;

    /** Организација у оквиру претплатника */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "organizacijaId")
    private AcOrganizacije organizacija;

    /** Број налога */
    @Size(max = 45)
    @Column(name = "brojNaloga", length = 45)
    private String brojNaloga;

    /** Возило */
    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "voziloId", nullable = false)
    private CjVozilo vozilo;

    /** Место поласка */
    @Size(max = 45)
    @Column(name = "odMesta", length = 45)
    private String odMesta;

    /** Место доласка */
    @Size(max = 45)
    @Column(name = "doMesta", length = 45)
    private String doMesta;

    /** Међу тачке (стајалишта, градови) */
    @Size(max = 45)
    @Column(name = "medjuTacke", length = 45)
    private String medjuTacke;

    /** Очекивани полазак */
    @Column(name = "ocekivaniPolazak")
    private LocalDateTime ocekivaniPolazak;

    /** Очекивани долазак */
    @Column(name = "ocekivaniDolazak")
    private LocalDateTime ocekivaniDolazak;

    /** Возач */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "vozacId")
    private CiVozaci vozac;

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

    public String getBrojNaloga() {
        return brojNaloga;
    }

    public void setBrojNaloga(String brojNaloga) {
        this.brojNaloga = brojNaloga;
    }

    public CjVozilo getVozilo() {
        return vozilo;
    }

    public void setVozilo(CjVozilo vozilo) {
        this.vozilo = vozilo;
    }

    public String getOdMesta() {
        return odMesta;
    }

    public void setOdMesta(String odMesta) {
        this.odMesta = odMesta;
    }

    public String getDoMesta() {
        return doMesta;
    }

    public void setDoMesta(String doMesta) {
        this.doMesta = doMesta;
    }

    public String getMedjuTacke() {
        return medjuTacke;
    }

    public void setMedjuTacke(String medjuTacke) {
        this.medjuTacke = medjuTacke;
    }

    public LocalDateTime getOcekivaniPolazak() {
        return ocekivaniPolazak;
    }

    public void setOcekivaniPolazak(LocalDateTime ocekivaniPolazak) {
        this.ocekivaniPolazak = ocekivaniPolazak;
    }

    public LocalDateTime getOcekivaniDolazak() {
        return ocekivaniDolazak;
    }

    public void setOcekivaniDolazak(LocalDateTime ocekivaniDolazak) {
        this.ocekivaniDolazak = ocekivaniDolazak;
    }

    public CiVozaci getVozac() {
        return vozac;
    }

    public void setVozac(CiVozaci vozac) {
        this.vozac = vozac;
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
