package rs.prati.service.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

/**
 * DTO класа за ентитет AeSistemGoriva.
 * Користи се за пренос података о системима горива.
 * Наслеђује заједничка поља из BaseDto.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AeSistemGorivaDto extends BaseDto {

    /** Назив система горива. */
    @NotNull
    @Size(max = 45)
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
