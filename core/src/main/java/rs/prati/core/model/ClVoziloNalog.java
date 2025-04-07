package rs.prati.core.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.time.LocalDateTime;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "cl_voziloNalog")
public class ClVoziloNalog {

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

    @Size(max = 45)
    @Column(name = "brojNaloga")
    private String brojNaloga;

    @NotNull
    @Column(name = "voziloId")
    private Long voziloId;

    @Size(max = 45)
    @Column(name = "odMesta")
    private String odMesta;

    @Size(max = 45)
    @Column(name = "doMesta")
    private String doMesta;

    @Size(max = 45)
    @Column(name = "medjuTacke")
    private String medjuTacke;

    @Column(name = "ocekivaniPolazak")
    private LocalDateTime ocekivaniPolazak;

    @Column(name = "ocekivaniDolazak")
    private LocalDateTime ocekivaniDolazak;

    @Column(name = "vozacId")
    private Long vozacId;

    @Size(max = 45)
    @Column(name = "komentar")
    private String komentar;

    @Column(name = "kreirano", updatable = false)
    @CreationTimestamp
    private LocalDateTime kreirano;

    @Column(name = "izmenjeno")
    @UpdateTimestamp
    private LocalDateTime izmenjeno;

    @NotNull
    @Column(name = "izbrisan")
    private Boolean izbrisan;

    
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

    public String getBrojNaloga() {
        return brojNaloga;
    }

    public void setBrojNaloga(String brojNaloga) {
        this.brojNaloga = brojNaloga;
    }

    public Long getVoziloId() {
        return voziloId;
    }

    public void setVoziloId(Long voziloId) {
        this.voziloId = voziloId;
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

    public Long getVozacId() {
        return vozacId;
    }

    public void setVozacId(Long vozacId) {
        this.vozacId = vozacId;
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
