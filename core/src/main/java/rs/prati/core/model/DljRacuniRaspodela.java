package rs.prati.core.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

/**
 * Ентитет који представља расподелу износа по рачунима (n:n).
 */
@Entity
@Table(name = "dlj_racuniRaspodela")
public class DljRacuniRaspodela extends BaseEntity {

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

    /** Веза ка ентитету DjRacuni (страни кључ racunId). */
    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "racunId", nullable = false)
    private DjRacuni racun;

    /** Износ расподеле */
    @NotNull
    @Column(name = "iznos", nullable = false)
    private Float iznos;

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

    public DjRacuni getRacun() {
        return racun;
    }

    public void setRacun(DjRacuni racun) {
        this.racun = racun;
    }

    public Float getIznos() {
        return iznos;
    }

    public void setIznos(Float iznos) {
        this.iznos = iznos;
    }
}
