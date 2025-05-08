package rs.prati.service.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

/**
 * DTO за ентитет BeGrupe.
 */
public class BeGrupeDto extends BaseDto {

    /** Назив групе */
    @NotNull
    @Size(max = 100)
    private String naziv;

    /** Опис групе */
    @Size(max = 255)
    private String opis;

    /** ИД претплатника */
    @NotNull
    private Long pretplatnikId;

    /** ИД организације */
    private Long organizacijaId;

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

    public Long getPretplatnikId() {
        return pretplatnikId;
    }

    public void setPretplatnikId(Long pretplatnikId) {
        this.pretplatnikId = pretplatnikId;
    }

    public Long getOrganizacijaId() {
        return organizacijaId;
    }

    public void setOrganizacijaId(Long organizacijaId) {
        this.organizacijaId = organizacijaId;
    }
}