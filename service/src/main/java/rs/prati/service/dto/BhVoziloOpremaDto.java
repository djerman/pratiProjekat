package rs.prati.service.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

/**
 * DTO за ентитет BhVoziloOprema – описује опрему возила претплатника.
 */
public class BhVoziloOpremaDto extends BaseDto {

    /**
     * ИД претплатника коме припада опрема.
     */
    @NotNull
    private Long pretplatnikId;

    /**
     * Назив опреме.
     */
    @NotNull
    @Size(max = 45)
    private String naziv;

    /**
     * Опис опреме.
     */
    @Size(max = 45)
    private String opis;

    // --- Гетери и сетери ---

    public Long getPretplatnikId() {
        return pretplatnikId;
    }

    public void setPretplatnikId(Long pretplatnikId) {
        this.pretplatnikId = pretplatnikId;
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
