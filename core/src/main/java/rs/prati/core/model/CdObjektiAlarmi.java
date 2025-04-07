package rs.prati.core.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "cd_objektiAlarmi")
public class CdObjektiAlarmi {

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

    @Column(name = "objekatId")
    private Long objekatId;

    @Column(name = "ogranicenjeBrzine")
    private Integer ogranicenjeBrzine;

    @Column(name = "vremeNeaktivnost")
    private Integer vremeNeaktivnost;

    @Column(name = "vremeMaliServis")
    private Integer vremeMaliServis;

    @Column(name = "kmMaliServis")
    private Integer kmMaliServis;

    @Column(name = "vremeVelikiServis")
    private Integer vremeVelikiServis;

    @Column(name = "kmVelikiServis")
    private Integer kmVelikiServis;

    @NotNull
    @Column(name = "aktivan")
    private Boolean aktivan;

    @Column(name = "kreirano", updatable = false)
    @CreationTimestamp
    private LocalDateTime kreirano;

    @Column(name = "izmenjeno")
    @UpdateTimestamp
    private LocalDateTime izmenjeno;

    @NotNull
    @Column(name = "izbrisan")
    private Boolean izbrisan;

    // Getters and Setters

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

    public Integer getOgranicenjeBrzine() {
        return ogranicenjeBrzine;
    }

    public void setOgranicenjeBrzine(Integer ogranicenjeBrzine) {
        this.ogranicenjeBrzine = ogranicenjeBrzine;
    }

    public Integer getVremeNeaktivnost() {
        return vremeNeaktivnost;
    }

    public void setVremeNeaktivnost(Integer vremeNeaktivnost) {
        this.vremeNeaktivnost = vremeNeaktivnost;
    }

    public Integer getVremeMaliServis() {
        return vremeMaliServis;
    }

    public void setVremeMaliServis(Integer vremeMaliServis) {
        this.vremeMaliServis = vremeMaliServis;
    }

    public Integer getKmMaliServis() {
        return kmMaliServis;
    }

    public void setKmMaliServis(Integer kmMaliServis) {
        this.kmMaliServis = kmMaliServis;
    }

    public Integer getVremeVelikiServis() {
        return vremeVelikiServis;
    }

    public void setVremeVelikiServis(Integer vremeVelikiServis) {
        this.vremeVelikiServis = vremeVelikiServis;
    }

    public Integer getKmVelikiServis() {
        return kmVelikiServis;
    }

    public void setKmVelikiServis(Integer kmVelikiServis) {
        this.kmVelikiServis = kmVelikiServis;
    }

    public Boolean getAktivan() {
        return aktivan;
    }

    public void setAktivan(Boolean aktivan) {
        this.aktivan = aktivan;
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
