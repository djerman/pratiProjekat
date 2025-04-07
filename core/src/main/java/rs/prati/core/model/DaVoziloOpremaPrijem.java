package rs.prati.core.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "da_voziloOpremaPrijem")
public class DaVoziloOpremaPrijem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotNull
    @Column(name = "pretplatnikId")
    private Long pretplatnikId;

    @Column(name = "organizacijaId")
    private Long organizacijaId;

    @NotNull
    @Column(name = "primoPredajaId")
    private Long primoPredajaId;

    @NotNull
    @Column(name = "opremaId")
    private Long opremaId;

    @NotNull
    @Column(name = "kolicina")
    private Integer kolicina;

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Long getPrimoPredajaId() {
        return primoPredajaId;
    }

    public void setPrimoPredajaId(Long primoPredajaId) {
        this.primoPredajaId = primoPredajaId;
    }

    public Long getOpremaId() {
        return opremaId;
    }

    public void setOpremaId(Long opremaId) {
        this.opremaId = opremaId;
    }

    public Integer getKolicina() {
        return kolicina;
    }

    public void setKolicina(Integer kolicina) {
        this.kolicina = kolicina;
    }
}
