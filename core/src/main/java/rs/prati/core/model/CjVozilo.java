package rs.prati.core.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.time.LocalDate;
import java.time.LocalDateTime;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "cj_vozilo")
public class CjVozilo {

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
    @Column(name = "objekatId")
    private Long objekatId;

    @NotNull
    @Size(max = 45)
    @Column(name = "registracija")
    private String registracija;

    @NotNull
    @Size(max = 45)
    @Column(name = "marka")
    private String marka;

    @NotNull
    @Size(max = 45)
    @Column(name = "model")
    private String model;

    @Size(max = 45)
    @Column(name = "tip")
    private String tip;

    @NotNull
    @Column(name = "godina")
    private Integer godina;

    @Column(name = "gorivo")
    private Long gorivo;

    @Column(name = "rezervoar")
    private Integer rezervoar;

    @Column(name = "potrosnja")
    private Float potrosnja;

    @NotNull
    @Column(name = "teretno")
    private Boolean teretno;

    @Size(max = 45)
    @Column(name = "brojSaobracajne")
    private String brojSaobracajne;

    @Column(name = "saobracajnaId")
    private Long saobracajnaId;

    @Size(max = 45)
    @Column(name = "serijskiBroj")
    private String serijskiBroj;

    @Column(name = "datumRegistracije")
    private LocalDate datumRegistracije;

    @NotNull
    @Column(name = "maliServisKm")
    private Integer maliServisKm;

    @NotNull
    @Column(name = "maliServisMeseci")
    private Integer maliServisMeseci;

    @NotNull
    @Column(name = "velikiServisKm")
    private Integer velikiServisKm;

    @NotNull
    @Column(name = "velikiServisMeseci")
    private Integer velikiServisMeseci;

    @Column(name = "datumPoslednjeRegistracije")
    private LocalDate datumPoslednjeRegistracije;

    @Column(name = "maliPoslednjiDatum")
    private LocalDate maliPoslednjiDatum;

    @NotNull
    @Column(name = "maliPoslednjiGPSkm")
    private Float maliPoslednjiGPSkm;

    @NotNull
    @Column(name = "maliPoslednjiOBDkm")
    private Integer maliPoslednjiOBDkm;

    @Column(name = "velikiPoslednjiDatum")
    private LocalDate velikiPoslednjiDatum;

    @NotNull
    @Column(name = "velikiPoslednjiGPSkm")
    private Float velikiPoslednjiGPSkm;

    @NotNull
    @Column(name = "velikiPoslednjiOBDkm")
    private Integer velikiPoslednjiOBDkm;

    @NotNull
    @Column(name = "izbrisan")
    private Boolean izbrisan;

    @Column(name = "kreirano", updatable = false)
    @CreationTimestamp
    private LocalDateTime kreirano;

    @Column(name = "izmenjeno")
    @UpdateTimestamp
    private LocalDateTime izmenjeno;

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

	public Long getObjekatId() {
		return objekatId;
	}

	public void setObjekatId(Long objekatId) {
		this.objekatId = objekatId;
	}

	public String getRegistracija() {
		return registracija;
	}

	public void setRegistracija(String registracija) {
		this.registracija = registracija;
	}

	public String getMarka() {
		return marka;
	}

	public void setMarka(String marka) {
		this.marka = marka;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getTip() {
		return tip;
	}

	public void setTip(String tip) {
		this.tip = tip;
	}

	public Integer getGodina() {
		return godina;
	}

	public void setGodina(Integer godina) {
		this.godina = godina;
	}

	public Long getGorivo() {
		return gorivo;
	}

	public void setGorivo(Long gorivo) {
		this.gorivo = gorivo;
	}

	public Integer getRezervoar() {
		return rezervoar;
	}

	public void setRezervoar(Integer rezervoar) {
		this.rezervoar = rezervoar;
	}

	public Float getPotrosnja() {
		return potrosnja;
	}

	public void setPotrosnja(Float potrosnja) {
		this.potrosnja = potrosnja;
	}

	public Boolean getTeretno() {
		return teretno;
	}

	public void setTeretno(Boolean teretno) {
		this.teretno = teretno;
	}

	public String getBrojSaobracajne() {
		return brojSaobracajne;
	}

	public void setBrojSaobracajne(String brojSaobracajne) {
		this.brojSaobracajne = brojSaobracajne;
	}

	public Long getSaobracajnaId() {
		return saobracajnaId;
	}

	public void setSaobracajnaId(Long saobracajnaId) {
		this.saobracajnaId = saobracajnaId;
	}

	public String getSerijskiBroj() {
		return serijskiBroj;
	}

	public void setSerijskiBroj(String serijskiBroj) {
		this.serijskiBroj = serijskiBroj;
	}

	public LocalDate getDatumRegistracije() {
		return datumRegistracije;
	}

	public void setDatumRegistracije(LocalDate datumRegistracije) {
		this.datumRegistracije = datumRegistracije;
	}

	public Integer getMaliServisKm() {
		return maliServisKm;
	}

	public void setMaliServisKm(Integer maliServisKm) {
		this.maliServisKm = maliServisKm;
	}

	public Integer getMaliServisMeseci() {
		return maliServisMeseci;
	}

	public void setMaliServisMeseci(Integer maliServisMeseci) {
		this.maliServisMeseci = maliServisMeseci;
	}

	public Integer getVelikiServisKm() {
		return velikiServisKm;
	}

	public void setVelikiServisKm(Integer velikiServisKm) {
		this.velikiServisKm = velikiServisKm;
	}

	public Integer getVelikiServisMeseci() {
		return velikiServisMeseci;
	}

	public void setVelikiServisMeseci(Integer velikiServisMeseci) {
		this.velikiServisMeseci = velikiServisMeseci;
	}

	public LocalDate getDatumPoslednjeRegistracije() {
		return datumPoslednjeRegistracije;
	}

	public void setDatumPoslednjeRegistracije(LocalDate datumPoslednjeRegistracije) {
		this.datumPoslednjeRegistracije = datumPoslednjeRegistracije;
	}

	public LocalDate getMaliPoslednjiDatum() {
		return maliPoslednjiDatum;
	}

	public void setMaliPoslednjiDatum(LocalDate maliPoslednjiDatum) {
		this.maliPoslednjiDatum = maliPoslednjiDatum;
	}

	public Float getMaliPoslednjiGPSkm() {
		return maliPoslednjiGPSkm;
	}

	public void setMaliPoslednjiGPSkm(Float maliPoslednjiGPSkm) {
		this.maliPoslednjiGPSkm = maliPoslednjiGPSkm;
	}

	public Integer getMaliPoslednjiOBDkm() {
		return maliPoslednjiOBDkm;
	}

	public void setMaliPoslednjiOBDkm(Integer maliPoslednjiOBDkm) {
		this.maliPoslednjiOBDkm = maliPoslednjiOBDkm;
	}

	public LocalDate getVelikiPoslednjiDatum() {
		return velikiPoslednjiDatum;
	}

	public void setVelikiPoslednjiDatum(LocalDate velikiPoslednjiDatum) {
		this.velikiPoslednjiDatum = velikiPoslednjiDatum;
	}

	public Float getVelikiPoslednjiGPSkm() {
		return velikiPoslednjiGPSkm;
	}

	public void setVelikiPoslednjiGPSkm(Float velikiPoslednjiGPSkm) {
		this.velikiPoslednjiGPSkm = velikiPoslednjiGPSkm;
	}

	public Integer getVelikiPoslednjiOBDkm() {
		return velikiPoslednjiOBDkm;
	}

	public void setVelikiPoslednjiOBDkm(Integer velikiPoslednjiOBDkm) {
		this.velikiPoslednjiOBDkm = velikiPoslednjiOBDkm;
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

    // гетери и сетери изостављени ради прегледности
    
}
