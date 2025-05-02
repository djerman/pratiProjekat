package rs.prati.core.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

/**
 * Ентитет који представља моделе уређаја.
 */
@Entity
@Table(name = "ai_sistemUredjajiModeli")
public class AiSistemUredjajiModeli extends BaseEntity {

    /** Произвођач уређаја. */
    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "proizvodjacId", nullable = false)
    private AhSistemUredjajiProizvodjac proizvodjac;

    /** Назив модела уређаја. */
    @NotNull
    @Size(max = 100)
    @Column(name = "naziv")
    private String naziv;

    /** Опис модела уређаја. */
    @Column(name = "opis")
    private String opis;

    /** Да ли подржава другу SIM картицу. */
    @NotNull
    @Column(name = "sim2", columnDefinition = "TINYINT(1)")
    private Boolean sim2;

    /** Да ли подржава OBD интерфејс. */
    @NotNull
    @Column(name = "obd")
    private Boolean obd;

    /** Да ли подржава обрачун. */
    @NotNull
    @Column(name = "obracun")
    private Boolean obracun;

    // --- Getери и Setери ---

    public AhSistemUredjajiProizvodjac getProizvodjac() {
        return proizvodjac;
    }

    public void setProizvodjac(AhSistemUredjajiProizvodjac proizvodjac) {
        this.proizvodjac = proizvodjac;
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

    public Boolean getSim2() {
        return sim2;
    }

    public void setSim2(Boolean sim2) {
        this.sim2 = sim2;
    }

    public Boolean getObd() {
        return obd;
    }

    public void setObd(Boolean obd) {
        this.obd = obd;
    }

    public Boolean getObracun() {
        return obracun;
    }

    public void setObracun(Boolean obracun) {
        this.obracun = obracun;
    }
}
