package rs.prati.core.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "ai_sistemUredjajiModeli")
public class AiSistemUredjajiModeli {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Version
    @NotNull
    @Column(name = "version")
    private Integer version;

    @NotNull
    @Column(name = "proizvodjacId")
    private Long proizvodjacId;

    @NotNull
    @Size(max = 100)
    @Column(name = "naziv")
    private String naziv;

    @Column(name = "opis")
    private String opis;

    @NotNull
    @Column(name = "sim2", columnDefinition = "TINYINT(1)")
    private Boolean sim2;

    @NotNull
    @Column(name = "obd")
    private Boolean obd;

    @NotNull
    @Column(name = "obracun")
    private Boolean obracun;

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

    public Long getProizvodjacId() {
        return proizvodjacId;
    }

    public void setProizvodjacId(Long proizvodjacId) {
        this.proizvodjacId = proizvodjacId;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public Boolean getSim2() {
        return sim2;
    }

    public void setSim2(Boolean sim2) {
        this.sim2 = sim2;
    }

    public Boolean getObd() {
        return obd;
    }

    public void setObd(Boolean obd) {
        this.obd = obd;
    }

    public Boolean getObracun() {
        return obracun;
    }

    public void setObracun(Boolean obracun) {
        this.obracun = obracun;
    }

    public Boolean getIzbrisan() {
        return izbrisan;
    }

    public void setIzbrisan(Boolean izbrisan) {
        this.izbrisan = izbrisan;
    }
}
