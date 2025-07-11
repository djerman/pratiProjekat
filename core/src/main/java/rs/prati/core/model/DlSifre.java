package rs.prati.core.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.time.LocalDateTime;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

/**
 * Ентитет који представља шифарник за партнере (нпр. интерне шифре).
 */
@Entity
@Table(name = "dl_sifre")
public class DlSifre extends BaseEntity {

    /** Веза ка ентитету AbSistemPretplatnici (страни кључ pretplatnikId). */
    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pretplatnikId", nullable = false)
    private AbSistemPretplatnici pretplatnik;

    /** Веза ка ентитету AcOrganizacije (страни кључ organizacijaId). */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "organizacijaId")
    private AcOrganizacije organizacija;

    /** Веза ка ентитету BgPartneri (страни кључ partnerId). */
    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "partnerId", nullable = false)
    private BgPartneri partner;

    /** Шифра */
    @NotNull
    @Size(max = 45)
    @Column(name = "sifra", length = 45, nullable = false)
    private String sifra;

    /** Опис */
    @Size(max = 45)
    @Column(name = "opis", length = 45)
    private String opis;

    /** Ознака обрисаности */
    @NotNull
    @Column(name = "izbrisan", nullable = false)
    private Boolean izbrisan;

    /** Датум и време креирања */
    @CreationTimestamp
    @Column(name = "kreirano", updatable = false)
    private LocalDateTime kreirano;

    /** Датум и време измене */
    @UpdateTimestamp
    @Column(name = "izmenjeno")
    private LocalDateTime izmenjeno;

    // Гетери и сетери

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

    public BgPartneri getPartner() {
        return partner;
    }

    public void setPartner(BgPartneri partner) {
        this.partner = partner;
    }

    public String getSifra() {
        return sifra;
    }

    public void setSifra(String sifra) {
        this.sifra = sifra;
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
