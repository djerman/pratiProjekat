package rs.prati.core.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.time.LocalDateTime;

/**
 * Ентитет за евиденцију системских сесија корисника (DY системске сесије).
 */
@Entity
@Table(name = "dy_sistemSesije")
public class DySistemSesije extends BaseEntity {

    /** Веза ка ентитету AbSistemPretplatnici (страни кључ pretplatnikId). */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pretplatnikId")
    private AbSistemPretplatnici pretplatnik;

    /** Веза ка ентитету AcOrganizacije (страни кључ organizacijaId). */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "organizacijaId")
    private AcOrganizacije organizacija;

    /** Веза ка ентитету BaKorisnici (страни кључ korisnikId). */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "korisnikId")
    private BaKorisnici korisnik;

    /** Датум и време почетка сесије. */
    @Column(name = "datumPocetak")
    private LocalDateTime datumPocetak;

    /** Датум и време краја сесије. */
    @Column(name = "datumKraj")
    private LocalDateTime datumKraj;

    /** IP адреса са које је покренута сесија. */
    @Size(max = 50)
    @Column(name = "ipAdresa", length = 50)
    private String ipAdresa;

    /** Означен као обрисан. */
    @NotNull
    @Column(name = "izbrisan", nullable = false)
    private Boolean izbrisan;

    // ГЕТЕРИ И СЕТЕРИ (са JavaDoc коментарима)
    public AbSistemPretplatnici getPretplatnik() {
        return pretplatnik;
    }

    public void setPretplatnik(AbSistemPretplatnici pretplatnik) {
        this.pretplatnik = pretplatnik;
    }

    public AcOrganizacije getOrganizacija() {
        return organizacija;
    }

    public void setOrganizacija(AcOrganizacije organizacija) {
        this.organizacija = organizacija;
    }

    public BaKorisnici getKorisnik() {
        return korisnik;
    }

    public void setKorisnik(BaKorisnici korisnik) {
        this.korisnik = korisnik;
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
