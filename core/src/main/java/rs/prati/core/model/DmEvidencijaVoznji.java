package rs.prati.core.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.time.LocalDateTime;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

/**
 * Ентитет за евиденцију вожњи (DM evidencija vožnji).
 */
@Entity
@Table(name = "dm_evidencijaVoznji")
public class DmEvidencijaVoznji extends BaseEntity {

    /** Веза ка ентитету AbSistemPretplatnici (страни кључ pretplatnikId). */
    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pretplatnikId", nullable = false)
    private AbSistemPretplatnici pretplatnik;

    /** Веза ка ентитету AcOrganizacije (страни кључ organizacijaId). */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "organizacijaId")
    private AcOrganizacije organizacija;

    /** Веза ка ентитету DnVoziloNalog (страни кључ voziloNalog). */
    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "voziloNalog", nullable = false)
    private ClVoziloNalog voziloNalog;

    /** Веза ка ентитету CjVozilo (страни кључ voziloId). */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "voziloId")
    private CjVozilo vozilo;

    /** Веза ка ентитету DfVozaci (страни кључ vozac). */
    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "vozac", nullable = false)
    private CiVozaci vozac;

    /** Регистрација возила. */
    @NotNull
    @Size(max = 45)
    @Column(name = "registracijaVozila", length = 45, nullable = false)
    private String registracijaVozila;

    /** Релација. */
    @Size(max = 45)
    @Column(name = "relacija", length = 45)
    private String relacija;

    /** Датум и време поласка. */
    @Column(name = "datumVremePolaska")
    private LocalDateTime datumVremePolaska;

    /** Датум и време доласка. */
    @Column(name = "datumVremeDolaska")
    private LocalDateTime datumVremeDolaska;

    /** Почетна километража. */
    @Column(name = "pocetnaKm")
    private Float pocetnaKm;

    /** Завршна километража. */
    @Column(name = "zavrsnaKm")
    private Float zavrsnaKm;

    /** Разлика у километражи. */
    @Column(name = "razlikaKm")
    private Float razlikaKm;

    /** Потрошња. */
    @Column(name = "potrosnja")
    private Float potrosnja;

    /** Цена горива. */
    @Column(name = "gorivoCena")
    private Float gorivoCena;

    /** Цена превоза. */
    @Column(name = "prevozCena")
    private Float prevozCena;

    /** Путни трошкови. */
    @Column(name = "putniTroskovi")
    private Float putniTroskovi;

    /** Број путног налога. */
    @Size(max = 45)
    @Column(name = "brojPutnogNaloga", length = 45)
    private String brojPutnogNaloga;

    /** Број дана. */
    @Column(name = "dana")
    private Integer dana;

    /** Број сати. */
    @Column(name = "sati")
    private Integer sati;

    /** Трошкови горива. */
    @Column(name = "troskoviGoriva")
    private Float troskoviGoriva;

    /** Укупно за превоз. */
    @Column(name = "prevozUkupno")
    private Float prevozUkupno;

    /** Превоз + путни трошак. */
    @Column(name = "prevozPutniTrosak")
    private Float prevozPutniTrosak;

    /** Извор податка. */
    @Size(max = 45)
    @Column(name = "preuzetoIz", length = 45)
    private String preuzetoIz;

    /** Врста робе. */
    @Size(max = 45)
    @Column(name = "vrstaRobe", length = 45)
    private String vrstaRobe;

    /** Kоличина. */
    @Column(name = "kolicina")
    private Integer kolicina;

    /** Магцин. */
    @Size(max = 45)
    @Column(name = "magacin", length = 45)
    private String magacin;

    /** Отпремница. */
    @Size(max = 45)
    @Column(name = "otpremnica", length = 45)
    private String otpremnica;

    /** Шифра. */
    @Size(max = 45)
    @Column(name = "sifra", length = 45)
    private String sifra;

    /** Шифра програма. */
    @Size(max = 45)
    @Column(name = "sifraPrograma", length = 45)
    private String sifraPrograma;

    /** Програм. */
    @Size(max = 45)
    @Column(name = "program", length = 45)
    private String program;

    /** Утрошено литара. */
    @Column(name = "utrosenoLitara")
    private Float utrosenoLitara;

    /** Да ли је запис закључан. */
    @NotNull
    @Column(name = "zakljucan", nullable = false)
    private Boolean zakljucan;

    /** Веза ка ентитету BaKorisnici (страни кључ uradio). */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "uradio")
    private BaKorisnici uradio;

    /** Датум и време креирања. */
    @CreationTimestamp
    @Column(name = "kreirano", updatable = false)
    private LocalDateTime kreirano;

    /** Датум и време измене. */
    @UpdateTimestamp
    @Column(name = "izmenjeno")
    private LocalDateTime izmenjeno;

    // ГЕТЕРИ И СЕТЕРИ (сви са JavaDoc коментарима)
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

    public ClVoziloNalog getVoziloNalog() {
        return voziloNalog;
    }

    public void setVoziloNalog(ClVoziloNalog voziloNalog) {
        this.voziloNalog = voziloNalog;
    }

    public CjVozilo getVozilo() {
        return vozilo;
    }

    public void setVozilo(CjVozilo vozilo) {
        this.vozilo = vozilo;
    }

    public CiVozaci getVozac() {
        return vozac;
    }

    public void setVozac(CiVozaci vozac) {
        this.vozac = vozac;
    }

    public String getRegistracijaVozila() {
        return registracijaVozila;
    }

    public void setRegistracijaVozila(String registracijaVozila) {
        this.registracijaVozila = registracijaVozila;
    }

    public String getRelacija() {
        return relacija;
    }

    public void setRelacija(String relacija) {
        this.relacija = relacija;
    }

    public LocalDateTime getDatumVremePolaska() {
        return datumVremePolaska;
    }

    public void setDatumVremePolaska(LocalDateTime datumVremePolaska) {
        this.datumVremePolaska = datumVremePolaska;
    }

    public LocalDateTime getDatumVremeDolaska() {
        return datumVremeDolaska;
    }

    public void setDatumVremeDolaska(LocalDateTime datumVremeDolaska) {
        this.datumVremeDolaska = datumVremeDolaska;
    }

    public Float getPocetnaKm() {
        return pocetnaKm;
    }

    public void setPocetnaKm(Float pocetnaKm) {
        this.pocetnaKm = pocetnaKm;
    }

    public Float getZavrsnaKm() {
        return zavrsnaKm;
    }

    public void setZavrsnaKm(Float zavrsnaKm) {
        this.zavrsnaKm = zavrsnaKm;
    }

    public Float getRazlikaKm() {
        return razlikaKm;
    }

    public void setRazlikaKm(Float razlikaKm) {
        this.razlikaKm = razlikaKm;
    }

    public Float getPotrosnja() {
        return potrosnja;
    }

    public void setPotrosnja(Float potrosnja) {
        this.potrosnja = potrosnja;
    }

    public Float getGorivoCena() {
        return gorivoCena;
    }

    public void setGorivoCena(Float gorivoCena) {
        this.gorivoCena = gorivoCena;
    }

    public Float getPrevozCena() {
        return prevozCena;
    }

    public void setPrevozCena(Float prevozCena) {
        this.prevozCena = prevozCena;
    }

    public Float getPutniTroskovi() {
        return putniTroskovi;
    }

    public void setPutniTroskovi(Float putniTroskovi) {
        this.putniTroskovi = putniTroskovi;
    }

    public String getBrojPutnogNaloga() {
        return brojPutnogNaloga;
    }

    public void setBrojPutnogNaloga(String brojPutnogNaloga) {
        this.brojPutnogNaloga = brojPutnogNaloga;
    }

    public Integer getDana() {
        return dana;
    }

    public void setDana(Integer dana) {
        this.dana = dana;
    }

    public Integer getSati() {
        return sati;
    }

    public void setSati(Integer sati) {
        this.sati = sati;
    }

    public Float getTroskoviGoriva() {
        return troskoviGoriva;
    }

    public void setTroskoviGoriva(Float troskoviGoriva) {
        this.troskoviGoriva = troskoviGoriva;
    }

    public Float getPrevozUkupno() {
        return prevozUkupno;
    }

    public void setPrevozUkupno(Float prevozUkupno) {
        this.prevozUkupno = prevozUkupno;
    }

    public Float getPrevozPutniTrosak() {
        return prevozPutniTrosak;
    }

    public void setPrevozPutniTrosak(Float prevozPutniTrosak) {
        this.prevozPutniTrosak = prevozPutniTrosak;
    }

    public String getPreuzetoIz() {
        return preuzetoIz;
    }

    public void setPreuzetoIz(String preuzetoIz) {
        this.preuzetoIz = preuzetoIz;
    }

    public String getVrstaRobe() {
        return vrstaRobe;
    }

    public void setVrstaRobe(String vrstaRobe) {
        this.vrstaRobe = vrstaRobe;
    }

    public Integer getKolicina() {
        return kolicina;
    }

    public void setKolicina(Integer kolicina) {
        this.kolicina = kolicina;
    }

    public String getMagacin() {
        return magacin;
    }

    public void setMagacin(String magacin) {
        this.magacin = magacin;
    }

    public String getOtpremnica() {
        return otpremnica;
    }

    public void setOtpremnica(String otpremnica) {
        this.otpremnica = otpremnica;
    }

    public String getSifra() {
        return sifra;
    }

    public void setSifra(String sifra) {
        this.sifra = sifra;
    }

    public String getSifraPrograma() {
        return sifraPrograma;
    }

    public void setSifraPrograma(String sifraPrograma) {
        this.sifraPrograma = sifraPrograma;
    }

    public String getProgram() {
        return program;
    }

    public void setProgram(String program) {
        this.program = program;
    }

    public Float getUtrosenoLitara() {
        return utrosenoLitara;
    }

    public void setUtrosenoLitara(Float utrosenoLitara) {
        this.utrosenoLitara = utrosenoLitara;
    }

    public Boolean getZakljucan() {
        return zakljucan;
    }

    public void setZakljucan(Boolean zakljucan) {
        this.zakljucan = zakljucan;
    }

    public BaKorisnici getUradio() {
        return uradio;
    }

    public void setUradio(BaKorisnici uradio) {
        this.uradio = uradio;
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
