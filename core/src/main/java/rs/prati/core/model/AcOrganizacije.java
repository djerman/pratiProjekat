package rs.prati.core.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

/**
 * Ентитет који представља организационе јединице претплатника.
 */
@Entity
@Table(name = "ac_organizacije")
public class AcOrganizacije extends BaseEntity {

    /** Претплатник коме организација припада. */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pretplatnikId", nullable = false)
    @NotNull
    private AbSistemPretplatnici pretplatnik;

    /** Назив организације. */
    @NotNull
    @Size(max = 255)
    @Column(name = "naziv", nullable = false, length = 255)
    private String naziv;

    /** Опис организације. */
    @Size(max = 255)
    @Column(name = "opis", length = 255)
    private String opis;

    /** Да ли је организација активна. */
    @NotNull
    @Column(name = "aktivan", nullable = false)
    private Boolean aktivan = true;

    // Getери и Setери

    public AbSistemPretplatnici getPretplatnik() {
        return pretplatnik;
    }

    public void setPretplatnik(AbSistemPretplatnici pretplatnik) {
        this.pretplatnik = pretplatnik;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public Boolean getAktivan() {
        return aktivan;
    }

    public void setAktivan(Boolean aktivan) {
        this.aktivan = aktivan;
    }
}
