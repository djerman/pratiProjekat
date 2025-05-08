package rs.prati.core.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

/**
 * Ентитет који представља групе у систему.
 */
@Entity
@Table(name = "be_grupe")
public class BeGrupe extends BaseEntity {

    /** Назив групе */
    @NotNull
    @Size(max = 100)
    @Column(name = "naziv", length = 100, nullable = false)
    private String naziv;

    /** Опис групе */
    @Size(max = 255)
    @Column(name = "opis", length = 255)
    private String opis;

    /** Претплатник коме група припада */
    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pretplatnik_id", nullable = false)
    private AbSistemPretplatnici pretplatnik;

    /** Организација у оквиру претплатника */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "organizacija_id")
    private AcOrganizacije organizacija;

    // Гетери и сетери

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
} 
