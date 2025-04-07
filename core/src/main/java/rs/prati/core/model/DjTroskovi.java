package rs.prati.core.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.time.LocalDateTime;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "dj_troskovi")
public class DjTroskovi {

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

    @Column(name = "racunId")
    private Long racunId;

    @NotNull
    @Column(name = "datumVreme")
    private LocalDateTime datumVreme;

    @NotNull
    @Column(name = "partnerId")
    private Long partnerId;

    @Size(max = 45)
    @Column(name = "brojRacuna")
    private String brojRacuna;

    @NotNull
    @Column(name = "objekatId")
    private Long objekatId;

    @Column(name = "tipServisa")
    private Integer tipServisa;

    @Column(name = "tipGorivaId")
    private Long tipGorivaId;

    @NotNull
    @Column(name = "kolicina")
    private Float kolicina;

    @NotNull
    @Column(name = "cena")
    private Float cena;

    @NotNull
    @Column(name = "pdvProcenat")
    private Integer pdvProcenat;

    @NotNull
    @Column(name = "pdvIznos")
    private Float pdvIznos;

    @NotNull
    @Column(name = "ukupno")
    private Float ukupno;

    @Size(max = 45)
    @Column(name = "opis")
    private String opis;

    @NotNull
    @Column(name = "izbrisan")
    private Boolean izbrisan;

    @Column(name = "kreirano", updatable = false)
    @CreationTimestamp
    private LocalDateTime kreirano;

    @Column(name = "izmenjeno")
    @UpdateTimestamp
    private LocalDateTime izmenjeno;

    // Getters and setters to be added

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

    public Long getRacunId() {
        return racunId;
    }

    public void setRacunId(Long racunId) {
        this.racunId = racunId;
    }

    public LocalDateTime getDatumVreme() {
        return datumVreme;
    }

    public void setDatumVreme(LocalDateTime datumVreme) {
        this.datumVreme = datumVreme;
    }

    public Long getPartnerId() {
        return partnerId;
    }

    public void setPartnerId(Long partnerId) {
        this.partnerId = partnerId;
    }

    public String getBrojRacuna() {
        return brojRacuna;
    }

    public void setBrojRacuna(String brojRacuna) {
        this.brojRacuna = brojRacuna;
    }

    public Long getObjekatId() {
        return objekatId;
    }

    public void setObjekatId(Long objekatId) {
        this.objekatId = objekatId;
    }

    public Integer getTipServisa() {
        return tipServisa;
    }

    public void setTipServisa(Integer tipServisa) {
        this.tipServisa = tipServisa;
    }

    public Long getTipGorivaId() {
        return tipGorivaId;
    }

    public void setTipGorivaId(Long tipGorivaId) {
        this.tipGorivaId = tipGorivaId;
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
