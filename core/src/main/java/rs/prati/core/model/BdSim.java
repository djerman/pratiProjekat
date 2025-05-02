package rs.prati.core.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

/**
 * Ентитет који представља СИМ картицу.
 */
@Entity
@Table(name = "bd_sim")
public class BdSim extends BaseEntity {

    // Веза ка претплатнику
    @ManyToOne
    @JoinColumn(name = "pretplatnikId")
    private AbSistemPretplatnici pretplatnik;

    // Веза ка организацији
    @ManyToOne
    @JoinColumn(name = "organizacijaId")
    private AcOrganizacije organizacija;

    // Веза ка мобилном оператеру
    @ManyToOne
    @NotNull
    @JoinColumn(name = "operaterId", nullable = false)
    private AfSistemOperateri operater;

    // Веза ка уређају (опционо)
    @ManyToOne
    @JoinColumn(name = "uredjajId")
    private BcUredjaji uredjaj;

    // ICCID број картице
    @NotNull
    @Size(max = 100)
    @Column(name = "iccid", nullable = false, length = 100)
    private String iccid;

    // Број телефона
    @NotNull
    @Size(max = 30)
    @Column(name = "broj", nullable = false, length = 30)
    private String broj;

    // Да ли је картица заузета
    @NotNull
    @Column(name = "zauzet", nullable = false)
    private Boolean zauzet;

    // Да ли је активна
    @NotNull
    @Column(name = "aktivan", nullable = false)
    private Boolean aktivan;

    // Опис или белешка
    @Column(name = "opis")
    private String opis;

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

    public AfSistemOperateri getOperater() {
        return operater;
    }

    public void setOperater(AfSistemOperateri operater) {
        this.operater = operater;
    }

    public BcUredjaji getUredjaj() {
        return uredjaj;
    }

    public void setUredjaj(BcUredjaji uredjaj) {
        this.uredjaj = uredjaj;
    }

    public String getIccid() {
        return iccid;
    }

    public void setIccid(String iccid) {
        this.iccid = iccid;
    }

    public String getBroj() {
        return broj;
    }

    public void setBroj(String broj) {
        this.broj = broj;
    }

    public Boolean getZauzet() {
        return zauzet;
    }

    public void setZauzet(Boolean zauzet) {
        this.zauzet = zauzet;
    }

    public Boolean getAktivan() {
        return aktivan;
    }

    public void setAktivan(Boolean aktivan) {
        this.aktivan = aktivan;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }
}
