package rs.prati.core.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

/**
 * Ентитет који представља типове система горива.
 */
@Entity
@Table(name = "ae_sistemGoriva")
public class AeSistemGoriva extends BaseEntity {

    /** Назив система горива. */
    @NotNull
    @Size(max = 45)
    @Column(name = "naziv")
    private String naziv;

    /**
     * Враћа назив система горива.
     *
     * @return назив
     */
    public String getNaziv() {
        return naziv;
    }

    /**
     * Поставља назив система горива.
     *
     * @param naziv назив система
     */
    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }
}
