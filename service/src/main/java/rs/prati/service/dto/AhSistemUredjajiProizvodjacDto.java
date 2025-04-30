package rs.prati.service.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

/**
 * DTO класа за ентитет AhSistemUredjajiProizvodjac.
 * Користи се за пренос података о произвођачима уређаја.
 * Наслеђује заједничка поља из BaseDto.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AhSistemUredjajiProizvodjacDto extends BaseDto {

    /** Назив произвођача. */
    @NotNull
    @Size(max = 100)
    private String naziv;

    /** Адреса произвођача. */
    @Size(max = 100)
    private String adresa;

    /** Опис произвођача. */
    private String opis;

    /**
     * Враћа назив произвођача.
     *
     * @return назив
     */
    public String getNaziv() {
        return naziv;
    }

    /**
     * Поставља назив произвођача.
     *
     * @param naziv назив
     */
    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    /**
     * Враћа адресу произвођача.
     *
     * @return адреса
     */
    public String getAdresa() {
        return adresa;
    }

    /**
     * Поставља адресу произвођача.
     *
     * @param adresa адреса
     */
    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    /**
     * Враћа опис произвођача.
     *
     * @return опис
     */
    public String getOpis() {
        return opis;
    }

    /**
     * Поставља опис произвођача.
     *
     * @param opis опис
     */
    public void setOpis(String opis) {
        this.opis = opis;
    }
}
