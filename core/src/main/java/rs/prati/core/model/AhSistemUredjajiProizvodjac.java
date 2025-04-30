package rs.prati.core.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

/**
 * Ентитет који представља произвођаче уређаја.
 */
@Entity
@Table(name = "ah_sistemUredjajiProizvodjac")
public class AhSistemUredjajiProizvodjac extends BaseEntity {

    /** Назив произвођача. */
    @NotNull
    @Size(max = 100)
    @Column(name = "naziv")
    private String naziv;

    /** Адреса произвођача. */
    @Size(max = 100)
    @Column(name = "adresa")
    private String adresa;

    /** Опис произвођача. */
    @Column(name = "opis")
    private String opis;

    /** Враћа назив произвођача. */
    public String getNaziv() {
        return naziv;
    }

    /** Поставља назив произвођача. */
    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    /** Враћа адресу произвођача. */
    public String getAdresa() {
        return adresa;
    }

    /** Поставља адресу произвођача. */
    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    /** Враћа опис произвођача. */
    public String getOpis() {
        return opis;
    }

    /** Поставља опис произвођача. */
    public void setOpis(String opis) {
        this.opis = opis;
    }
}
