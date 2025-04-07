package rs.prati.core.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.time.LocalDateTime;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "dh_voziloSaobracajna2")
public class DhVoziloSaobracajna2 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Version
    @NotNull
    @Column(name = "version")
    private Integer version;

    @NotNull
    @Column(name = "pretplatnikId")
    private Long pretplatnikId;

    @Column(name = "organizacijaId")
    private Long organizacijaId;

    @NotNull
    @Column(name = "saobracajnaId")
    private Long saobracajnaId;

    @Size(max = 45)
    @Column(name = "vlasnik")
    private String vlasnik;

    @Size(max = 45)
    @Column(name = "adresaVlasnika")
    private String adresaVlasnika;

    @Size(max = 45)
    @Column(name = "jmbgVlasnika")
    private String jmbgVlasnika;

    @Size(max = 45)
    @Column(name = "korisnik")
    private String korisnik;

    @Size(max = 45)
    @Column(name = "adresaKorisnika")
    private String adresaKorisnika;

    @Size(max = 45)
    @Column(name = "dimenzijeGuma")
    private String dimenzijeGuma;

    @Size(max = 45)
    @Column(name = "pritisakGume")
    private String pritisakGume;

    @Size(max = 45)
    @Column(name = "dimenzijeTovara")
    private String dimenzijeTovara;

    @Size(max = 45)
    @Column(name = "odnosSnagaMasa")
    private String odnosSnagaMasa;

    @Size(max = 45)
    @Column(name = "mestaStajanje")
    private String mestaStajanje;

    @Size(max = 45)
    @Column(name = "kupljenoDoniranoOd")
    private String kupljenoDoniranoOd;

    @Size(max = 45)
    @Column(name = "nabavljenoPoRacunuSert")
    private String nabavljenoPoRacunuSert;

    @Size(max = 45)
    @Column(name = "dobavljacDonator")
    private String dobavljacDonator;

    @Column(name = "kreirano", updatable = false)
    @CreationTimestamp
    private LocalDateTime kreirano;

    @Column(name = "izmenjeno")
    @UpdateTimestamp
    private LocalDateTime izmenjeno;

    @NotNull
    @Column(name = "izbrisan")
    private Boolean izbrisan;

    // Getters and setters to be added next

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

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

    public Long getSaobracajnaId() {
        return saobracajnaId;
    }

    public void setSaobracajnaId(Long saobracajnaId) {
        this.saobracajnaId = saobracajnaId;
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
