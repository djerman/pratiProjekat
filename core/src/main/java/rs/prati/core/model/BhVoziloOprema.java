package rs.prati.core.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

/**
 * Опис опреме која може бити придружена возилима у власништву претплатника.
 */
@Entity
@Table(name = "bh_voziloOprema")
public class BhVoziloOprema extends BaseEntity {

    /**
     * Претплатник коме припада ова опрема.
     */
    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pretplatnikId", nullable = false)
    private AbSistemPretplatnici pretplatnik;

    /**
     * Назив опреме.
     */
    @NotNull
    @Size(max = 45)
    @Column(name = "naziv")
    private String naziv;

    /**
     * Опис опреме.
     */
    @Size(max = 45)
    @Column(name = "opis")
    private String opis;

    // --- Гетери и сетери ---

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
}
