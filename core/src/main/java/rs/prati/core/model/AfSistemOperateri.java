package rs.prati.core.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

/**
 * Ентитет који представља системске оператере.
 */
@Entity
@Table(name = "af_sistemOperateri")
public class AfSistemOperateri extends BaseEntity {

    /** Назив оператера. */
    @NotNull
    @Size(max = 100)
    @Column(name = "naziv")
    private String naziv;

    /**
     * Враћа назив оператера.
     *
     * @return назив
     */
    public String getNaziv() {
        return naziv;
    }

    /**
     * Поставља назив оператера.
     *
     * @param naziv назив
     */
    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }
}
