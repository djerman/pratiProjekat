package rs.prati.core.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalDateTime;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "dx_objektiPoslednje")
@IdClass(DxObjektiPoslednjeId.class)
public class DxObjektiPoslednje {

    @Id
    @Column(name = "id")
    private Long id;

    @Id
    @NotNull
    @Column(name = "objekatId")
    private Long objekatId;

    @Version
    @NotNull
    @Column(name = "version")
    private Integer version;

    @Column(name = "maliServis")
    private LocalDate maliServis;

    @Column(name = "maliKm")
    private Integer maliKm;

    @Column(name = "velikiServis")
    private LocalDate velikiServis;

    @Column(name = "velikiKm")
    private Integer velikiKm;

    @Column(name = "registracija")
    private LocalDate registracija;

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

    public Long getObjekatId() {
        return objekatId;
    }

    public void setObjekatId(Long objekatId) {
        this.objekatId = objekatId;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public LocalDate getMaliServis() {
        return maliServis;
    }

    public void setMaliServis(LocalDate maliServis) {
        this.maliServis = maliServis;
    }

    public Integer getMaliKm() {
        return maliKm;
    }

    public void setMaliKm(Integer maliKm) {
        this.maliKm = maliKm;
    }

    public LocalDate getVelikiServis() {
        return velikiServis;
    }

    public void setVelikiServis(LocalDate velikiServis) {
        this.velikiServis = velikiServis;
    }

    public Integer getVelikiKm() {
        return velikiKm;
    }

    public void setVelikiKm(Integer velikiKm) {
        this.velikiKm = velikiKm;
    }

    public LocalDate getRegistracija() {
        return registracija;
    }

    public void setRegistracija(LocalDate registracija) {
        this.registracija = registracija;
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
