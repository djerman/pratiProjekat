package rs.prati.service.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

/**
 * DTO класа за ентитет AfSistemOperateri.
 * Користи се за пренос података о системским оператерима.
 * Наслеђује заједничка поља из BaseDto.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AfSistemOperateriDto extends BaseDto {

    /** Назив оператера. */
    @NotNull
    @Size(max = 100)
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
     * @param naziv назив оператера
     */
    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }
}
