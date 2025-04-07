package rs.prati.core.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "ca_grupeKorisnici")
public class CaGrupeKorisnici {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotNull
    @Column(name = "gkpretplatnikId")
    private Long gkpretplatnikId;

    @Column(name = "gkorganizacijaId")
    private Long gkorganizacijaId;

    @NotNull
    @Column(name = "gkgrupaId")
    private Long gkgrupaId;

    @NotNull
    @Column(name = "gkkorisnikId")
    private Long gkkorisnikId;

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

    public Long getGkpretplatnikId() {
        return gkpretplatnikId;
    }

    public void setGkpretplatnikId(Long gkpretplatnikId) {
        this.gkpretplatnikId = gkpretplatnikId;
    }

    public Long getGkorganizacijaId() {
        return gkorganizacijaId;
    }

    public void setGkorganizacijaId(Long gkorganizacijaId) {
        this.gkorganizacijaId = gkorganizacijaId;
    }

    public Long getGkgrupaId() {
        return gkgrupaId;
    }

    public void setGkgrupaId(Long gkgrupaId) {
        this.gkgrupaId = gkgrupaId;
    }

    public Long getGkkorisnikId() {
        return gkkorisnikId;
    }

    public void setGkkorisnikId(Long gkkorisnikId) {
        this.gkkorisnikId = gkkorisnikId;
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
