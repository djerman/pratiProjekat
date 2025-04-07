package rs.prati.core.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.time.LocalDateTime;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "dm_evidencijaVoznji")
public class DmEvidencijaVoznji {

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
    @Column(name = "voziloNalog")
    private Long voziloNalog;

    @Column(name = "voziloId")
    private Long voziloId;

    @NotNull
    @Column(name = "vozac")
    private Long vozac;

    @NotNull
    @Size(max = 45)
    @Column(name = "registracijaVozila")
    private String registracijaVozila;

    @Size(max = 45)
    @Column(name = "relacija")
    private String relacija;

    @Column(name = "datumVremePolaska")
    private LocalDateTime datumVremePolaska;

    @Column(name = "datumVremeDolaska")
    private LocalDateTime datumVremeDolaska;

    @Column(name = "pocetnaKm")
    private Float pocetnaKm;

    @Column(name = "zavrsnaKm")
    private Float zavrsnaKm;

    @Column(name = "razlikaKm")
    private Float razlikaKm;

    @Column(name = "potrosnja")
    private Float potrosnja;

    @Column(name = "gorivoCena")
    private Float gorivoCena;

    @Column(name = "prevozCena")
    private Float prevozCena;

    @Column(name = "putniTroskovi")
    private Float putniTroskovi;

    @Size(max = 45)
    @Column(name = "brojPutnogNaloga")
    private String brojPutnogNaloga;

    @Column(name = "dana")
    private Integer dana;

    @Column(name = "sati")
    private Integer sati;

    @Column(name = "troskoviGoriva")
    private Float troskoviGoriva;

    @Column(name = "prevozUkupno")
    private Float prevozUkupno;

    @Column(name = "prevozPutniTrosak")
    private Float prevozPutniTrosak;

    @Size(max = 45)
    @Column(name = "preuzetoIz")
    private String preuzetoIz;

    @Size(max = 45)
    @Column(name = "vrstaRobe")
    private String vrstaRobe;

    @Column(name = "kolicina")
    private Integer kolicina;

    @Size(max = 45)
    @Column(name = "magacin")
    private String magacin;

    @Size(max = 45)
    @Column(name = "otpremnica")
    private String otpremnica;

    @Size(max = 45)
    @Column(name = "sifra")
    private String sifra;

    @Size(max = 45)
    @Column(name = "sifraPrograma")
    private String sifraPrograma;

    @Size(max = 45)
    @Column(name = "program")
    private String program;

    @Column(name = "utrosenoLitara")
    private Float utrosenoLitara;

    @NotNull
    @Column(name = "zakljucan")
    private Boolean zakljucan;

    @Column(name = "uradio")
    private Long uradio;

    @Column(name = "kreirano", updatable = false)
    @CreationTimestamp
    private LocalDateTime kreirano;

    @Column(name = "izmenjeno")
    @UpdateTimestamp
    private LocalDateTime izmenjeno;

    // Getteri i setteri по договореном формату иду накнадно

    public String getRelacija() {
        return relacija;
    }

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

	public Long getVoziloNalog() {
		return voziloNalog;
	}

	public void setVoziloNalog(Long voziloNalog) {
		this.voziloNalog = voziloNalog;
	}

	public Long getVoziloId() {
		return voziloId;
	}

	public void setVoziloId(Long voziloId) {
		this.voziloId = voziloId;
	}

	public Long getVozac() {
		return vozac;
	}

	public void setVozac(Long vozac) {
		this.vozac = vozac;
	}

	public String getRegistracijaVozila() {
		return registracijaVozila;
	}

	public void setRegistracijaVozila(String registracijaVozila) {
		this.registracijaVozila = registracijaVozila;
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

    public Long getUradio() {
        return uradio;
    }

    public void setUradio(Long uradio) {
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
