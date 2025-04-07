package rs.prati.core.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.time.LocalDateTime;

@Entity
@Table(name = "dy_sistemSesije")
public class DySistemSesije {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Version
    @NotNull
    @Column(name = "version")
    private Integer version;

    @Column(name = "pretplatnikId")
    private Long pretplatnikId;

    @Column(name = "organizacijaId")
    private Long organizacijaId;

    @Column(name = "korisnikId")
    private Long korisnikId;

    @Column(name = "datumPocetak")
    private LocalDateTime datumPocetak;

    @Column(name = "datumKraj")
    private LocalDateTime datumKraj;

    @Size(max = 50)
    @Column(name = "ipAdresa")
    private String ipAdresa;

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

    public Long getKorisnikId() {
        return korisnikId;
    }

    public void setKorisnikId(Long korisnikId) {
        this.korisnikId = korisnikId;
    }

    public LocalDateTime getDatumPocetak() {
        return datumPocetak;
    }

    public void setDatumPocetak(LocalDateTime datumPocetak) {
        this.datumPocetak = datumPocetak;
    }

    public LocalDateTime getDatumKraj() {
        return datumKraj;
    }

    public void setDatumKraj(LocalDateTime datumKraj) {
        this.datumKraj = datumKraj;
    }

    public String getIpAdresa() {
        return ipAdresa;
    }

    public void setIpAdresa(String ipAdresa) {
        this.ipAdresa = ipAdresa;
    }

    public Boolean getIzbrisan() {
        return izbrisan;
    }

    public void setIzbrisan(Boolean izbrisan) {
        this.izbrisan = izbrisan;
    }
}
