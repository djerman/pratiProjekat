package rs.prati.core.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.time.LocalDateTime;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

/**
 * Ентитет који представља додатне податке саобраћајне дозволе возила.
 */
@Entity
@Table(name = "dh_voziloSaobracajna2")
public class DhVoziloSaobracajna2 extends BaseEntity {

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pretplatnikId", nullable = false)
    private AbSistemPretplatnici pretplatnik;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "organizacijaId")
    private AcOrganizacije organizacija;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "saobracajnaId", nullable = false)
    private DgVoziloSaobracajna saobracajna;

    @Size(max = 45)
    @Column(name = "vlasnik", length = 45)
    private String vlasnik;

    @Size(max = 45)
    @Column(name = "adresaVlasnika", length = 45)
    private String adresaVlasnika;

    @Size(max = 45)
    @Column(name = "jmbgVlasnika", length = 45)
    private String jmbgVlasnika;

    @Size(max = 45)
    @Column(name = "korisnik", length = 45)
    private String korisnik;

    @Size(max = 45)
    @Column(name = "adresaKorisnika", length = 45)
    private String adresaKorisnika;

    @Size(max = 45)
    @Column(name = "dimenzijeGuma", length = 45)
    private String dimenzijeGuma;

    @Size(max = 45)
    @Column(name = "pritisakGume", length = 45)
    private String pritisakGume;

    @Size(max = 45)
    @Column(name = "dimenzijeTovara", length = 45)
    private String dimenzijeTovara;

    @Size(max = 45)
    @Column(name = "odnosSnagaMasa", length = 45)
    private String odnosSnagaMasa;

    @Size(max = 45)
    @Column(name = "mestaStajanje", length = 45)
    private String mestaStajanje;

    @Size(max = 45)
    @Column(name = "kupljenoDoniranoOd", length = 45)
    private String kupljenoDoniranoOd;

    @Size(max = 45)
    @Column(name = "nabavljenoPoRacunuSert", length = 45)
    private String nabavljenoPoRacunuSert;

    @Size(max = 45)
    @Column(name = "dobavljacDonator", length = 45)
    private String dobavljacDonator;

    @CreationTimestamp
    @Column(name = "kreirano", updatable = false)
    private LocalDateTime kreirano;

    @UpdateTimestamp
    @Column(name = "izmenjeno")
    private LocalDateTime izmenjeno;

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

    public DgVoziloSaobracajna getSaobracajna() {
        return saobracajna;
    }

    public void setSaobracajna(DgVoziloSaobracajna saobracajna) {
        this.saobracajna = saobracajna;
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
