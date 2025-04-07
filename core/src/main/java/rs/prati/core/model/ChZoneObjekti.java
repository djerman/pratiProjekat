package rs.prati.core.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "ch_zoneObjekti")
public class ChZoneObjekti {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotNull
    @Column(name = "zopretplatnikId")
    private Long zopretplatnikId;

    @Column(name = "zoorganizacijaId")
    private Long zoorganizacijaId;

    @NotNull
    @Column(name = "zonaId")
    private Long zonaId;

    @NotNull
    @Column(name = "objekatId")
    private Long objekatId;

    @NotNull
    @Column(name = "ulaz")
    private Boolean ulaz;

    @NotNull
    @Column(name = "izlaz")
    private Boolean izlaz;

    @Column(name = "aktivan")
    private Boolean aktivan;

    @Column(name = "kreirano", updatable = false)
    @CreationTimestamp
    private LocalDateTime kreirano;

    @Column(name = "izmenjeno")
    @UpdateTimestamp
    private LocalDateTime izmenjeno;

    @Column(name = "izbrisan")
    private Boolean izbrisan;

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getZopretplatnikId() {
        return zopretplatnikId;
    }

    public void setZopretplatnikId(Long zopretplatnikId) {
        this.zopretplatnikId = zopretplatnikId;
    }

    public Long getZoorganizacijaId() {
        return zoorganizacijaId;
    }

    public void setZoorganizacijaId(Long zoorganizacijaId) {
        this.zoorganizacijaId = zoorganizacijaId;
    }

    public Long getZonaId() {
        return zonaId;
    }

    public void setZonaId(Long zonaId) {
        this.zonaId = zonaId;
    }

    public Long getObjekatId() {
        return objekatId;
    }

    public void setObjekatId(Long objekatId) {
        this.objekatId = objekatId;
    }

    public Boolean getUlaz() {
        return ulaz;
    }

    public void setUlaz(Boolean ulaz) {
        this.ulaz = ulaz;
    }

    public Boolean getIzlaz() {
        return izlaz;
    }

    public void setIzlaz(Boolean izlaz) {
        this.izlaz = izlaz;
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
