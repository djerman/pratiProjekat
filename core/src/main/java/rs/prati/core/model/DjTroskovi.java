package rs.prati.core.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.time.LocalDateTime;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

/**
 * Ентитет који представља трошак (гориво/сервис итд.).
 */
@Entity
@Table(name = "dj_troskovi")
public class DjTroskovi extends BaseEntity {

    /** Веза ка ентитету AbSistemPretplatnici (страни кључ pretplatnikId). */
    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pretplatnikId", nullable = false)
    private AbSistemPretplatnici pretplatnik;

    /** Веза ка ентитету AcOrganizacije (страни кључ organizacijaId). */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "organizacijaId")
    private AcOrganizacije organizacija;

    /** Веза ка ентитету DjRacuni (страни кључ racunId). */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "racunId")
    private DjRacuni racun;

    /** Датум и време трошка. */
    @NotNull
    @Column(name = "datumVreme", nullable = false)
    private LocalDateTime datumVreme;

    /** Веза ка ентитету BgPartneri (страни кључ partnerId). */
    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "partnerId", nullable = false)
    private BgPartneri partner;

    /** Број рачуна (текстуално) */
    @Size(max = 45)
    @Column(name = "brojRacuna", length = 45)
    private String brojRacuna;

    /** Веза ка ентитету BbObjekti (страни кључ objekatId). */
    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "objekatId", nullable = false)
    private BbObjekti objekat;

    /** Тип сервиса (шифарник) */
    @Column(name = "tipServisa")
    private Integer tipServisa;

    /** Веза ка ентитету BaTipGoriva (страни кључ tipGorivaId). */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tipGorivaId")
    private AeSistemGoriva tipGoriva;

    /** Kоличина */
    @NotNull
    @Column(name = "kolicina", nullable = false)
    private Float kolicina;

    /** Цена */
    @NotNull
    @Column(name = "cena", nullable = false)
    private Float cena;

    /** ПДВ проценат */
    @NotNull
    @Column(name = "pdvProcenat", nullable = false)
    private Integer pdvProcenat;

    /** ПДВ износ */
    @NotNull
    @Column(name = "pdvIznos", nullable = false)
    private Float pdvIznos;

    /** Укупно */
    @NotNull
    @Column(name = "ukupno", nullable = false)
    private Float ukupno;

    /** Опис */
    @Size(max = 45)
    @Column(name = "opis", length = 45)
    private String opis;

    /** Ознака обрисаности */
    @NotNull
    @Column(name = "izbrisan", nullable = false)
    private Boolean izbrisan;

    /** Датум и време креирања */
    @CreationTimestamp
    @Column(name = "kreirano", updatable = false)
    private LocalDateTime kreirano;

    /** Датум и време измене */
    @UpdateTimestamp
    @Column(name = "izmenjeno")
    private LocalDateTime izmenjeno;

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

    public DjRacuni getRacun() {
        return racun;
    }

    public void setRacun(DjRacuni racun) {
        this.racun = racun;
    }

    public LocalDateTime getDatumVreme() {
        return datumVreme;
    }

    public void setDatumVreme(LocalDateTime datumVreme) {
        this.datumVreme = datumVreme;
    }

    public BgPartneri getPartner() {
        return partner;
    }

    public void setPartner(BgPartneri partner) {
        this.partner = partner;
    }

    public String getBrojRacuna() {
        return brojRacuna;
    }

    public void setBrojRacuna(String brojRacuna) {
        this.brojRacuna = brojRacuna;
    }

    public BbObjekti getObjekat() {
        return objekat;
    }

    public void setObjekat(BbObjekti objekat) {
        this.objekat = objekat;
    }

    public Integer getTipServisa() {
        return tipServisa;
    }

    public void setTipServisa(Integer tipServisa) {
        this.tipServisa = tipServisa;
    }

    public AeSistemGoriva getTipGoriva() {
        return tipGoriva;
    }

    public void setTipGoriva(AeSistemGoriva tipGoriva) {
        this.tipGoriva = tipGoriva;
    }

    public Float getKolicina() {
        return kolicina;
    }

    public void setKolicina(Float kolicina) {
        this.kolicina = kolicina;
    }

    public Float getCena() {
        return cena;
    }

    public void setCena(Float cena) {
        this.cena = cena;
    }

    public Integer getPdvProcenat() {
        return pdvProcenat;
    }

    public void setPdvProcenat(Integer pdvProcenat) {
        this.pdvProcenat = pdvProcenat;
    }

    public Float getPdvIznos() {
        return pdvIznos;
    }

    public void setPdvIznos(Float pdvIznos) {
        this.pdvIznos = pdvIznos;
    }

    public Float getUkupno() {
        return ukupno;
    }

    public void setUkupno(Float ukupno) {
        this.ukupno = ukupno;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
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
