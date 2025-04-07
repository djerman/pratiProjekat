package rs.prati.core.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "cb_grupeObjekti")
public class CbGrupeObjekti {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotNull
    @Column(name = "version")
    private Integer version;

    @NotNull
    @Column(name = "gopretplatnikId")
    private Long gopretplatnikId;

    @Column(name = "goorganizacijaId")
    private Long goorganizacijaId;

    @NotNull
    @Column(name = "gogrupaId")
    private Long gogrupaId;

    @NotNull
    @Column(name = "goobjekatId")
    private Long goobjekatId;

    @Column(name = "kreirano", updatable = false)
    @CreationTimestamp
    private LocalDateTime kreirano;

    @Column(name = "izmenjeno")
    @UpdateTimestamp
    private LocalDateTime izmenjeno;

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

    public Long getGopretplatnikId() {
        return gopretplatnikId;
    }

    public void setGopretplatnikId(Long gopretplatnikId) {
        this.gopretplatnikId = gopretplatnikId;
    }

    public Long getGoorganizacijaId() {
        return goorganizacijaId;
    }

    public void setGoorganizacijaId(Long goorganizacijaId) {
        this.goorganizacijaId = goorganizacijaId;
    }

    public Long getGogrupaId() {
        return gogrupaId;
    }

    public void setGogrupaId(Long gogrupaId) {
        this.gogrupaId = gogrupaId;
    }

    public Long getGoobjekatId() {
        return goobjekatId;
    }

    public void setGoobjekatId(Long goobjekatId) {
        this.goobjekatId = goobjekatId;
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
