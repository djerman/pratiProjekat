package rs.prati.core.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.time.LocalDate;
import java.time.LocalDateTime;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "dg_voziloSaobracajna")
public class DgVoziloSaobracajna {

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
    @Column(name = "voziloId")
    private Long voziloId;

    @Size(max = 45)
    @Column(name = "brojSaobracajne")
    private String brojSaobracajne;

    @NotNull
    @Column(name = "datumIzdavanja")
    private LocalDate datumIzdavanja;

    @Size(max = 45)
    @Column(name = "izdao")
    private String izdao;

    @Size(max = 45)
    @Column(name = "homologacija")
    private String homologacija;

    @Size(max = 45)
    @Column(name = "sasija")
    private String sasija;

    @Size(max = 45)
    @Column(name = "brojMotora")
    private String brojMotora;

    @Column(name = "snagaMotora")
    private Double snagaMotora;

    @Column(name = "zapreminaMotora")
    private Integer zapreminaMotora;

    @Column(name = "zapreminaRezervoara")
    private Integer zapreminaRezervoara;

    @Column(name = "zapreminaRezervoaraAdBlue")
    private Integer zapreminaRezervoaraAdBlue;

    @Size(max = 45)
    @Column(name = "boja")
    private String boja;

    @Size(max = 45)
    @Column(name = "masa")
    private String masa;

    @Size(max = 45)
    @Column(name = "ukupnaMasa")
    private String ukupnaMasa;

    @Size(max = 45)
    @Column(name = "kategorija")
    private String kategorija;

    @Size(max = 45)
    @Column(name = "nosivost")
    private String nosivost;

    @Column(name = "mestaSedenja")
    private Integer mestaSedenja;

    @Column(name = "saobracajna2Id")
    private Long saobracajna2Id;

    @Column(name = "kreirano", updatable = false)
    @CreationTimestamp
    private LocalDateTime kreirano;

    @Column(name = "izmenjeno")
    @UpdateTimestamp
    private LocalDateTime izmenjeno;

    @NotNull
    @Column(name = "izbrisan")
    private Boolean izbrisan;

    // Гетери и сетери могу се додати по потреби

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

    public Long getVoziloId() {
        return voziloId;
    }

    public void setVoziloId(Long voziloId) { 
        this.voziloId = voziloId;
    }

    public String getBrojSaobracajne() {
        return brojSaobracajne;
    }

    public void setBrojSaobracajne(String brojSaobracajne) { 
        this.brojSaobracajne = brojSaobracajne;
    }

    public LocalDate getDatumIzdavanja() {
        return datumIzdavanja;
    }

    public void setDatumIzdavanja(LocalDate datumIzdavanja) { 
        this.datumIzdavanja = datumIzdavanja;
    }

    public String getIzdao() {
        return izdao;
    }

    public void setIzdao(String izdao) { 
        this.izdao = izdao;
    }

    public String getHomologacija() {
        return homologacija;
    }

    public void setHomologacija(String homologacija) { 
        this.homologacija = homologacija;
    }

    public String getSasija() {
        return sasija;
    }

    public void setSasija(String sasija) { 
        this.sasija = sasija;
    }

    public String getBrojMotora() {
        return brojMotora;
    }

    public void setBrojMotora(String brojMotora) { 
        this.brojMotora = brojMotora;
    }

    public Double getSnagaMotora() {
        return snagaMotora;
    }

    public void setSnagaMotora(Double snagaMotora) { 
        this.snagaMotora = snagaMotora;
    }

    public Integer getZapreminaMotora() {
        return zapreminaMotora;
    }

    public void setZapreminaMotora(Integer zapreminaMotora) { 
        this.zapreminaMotora = zapreminaMotora;
    }

    public Integer getZapreminaRezervoara() {
        return zapreminaRezervoara;
    }

    public void setZapreminaRezervoara(Integer zapreminaRezervoara) { 
        this.zapreminaRezervoara = zapreminaRezervoara;
    }

    public Integer getZapreminaRezervoaraAdBlue() {
        return zapreminaRezervoaraAdBlue;
    }

    public void setZapreminaRezervoaraAdBlue(Integer zapreminaRezervoaraAdBlue) { 
        this.zapreminaRezervoaraAdBlue = zapreminaRezervoaraAdBlue;
    }

    public String getBoja() {
        return boja;
    }

    public void setBoja(String boja) { 
        this.boja = boja;
    }

    public String getMasa() {
        return masa;
    }

    public void setMasa(String masa) { 
        this.masa = masa;
    }

    public String getUkupnaMasa() {
        return ukupnaMasa;
    }

    public void setUkupnaMasa(String ukupnaMasa) { 
        this.ukupnaMasa = ukupnaMasa;
    }

    public String getKategorija() {
        return kategorija;
    }

    public void setKategorija(String kategorija) { 
        this.kategorija = kategorija;
    }

    public String getNosivost() {
        return nosivost;
    }

    public void setNosivost(String nosivost) { 
        this.nosivost = nosivost;
    }

    public Integer getMestaSedenja() {
        return mestaSedenja;
    }

    public void setMestaSedenja(Integer mestaSedenja) { 
        this.mestaSedenja = mestaSedenja;
    }

    public Long getSaobracajna2Id() {
        return saobracajna2Id;
    }

    public void setSaobracajna2Id(Long saobracajna2Id) { 
        this.saobracajna2Id = saobracajna2Id;
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
