package rs.prati.service.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

/**
 * DTO класа за ентитет AcOrganizacije.
 * Користи се за пренос података између слојева апликације.
 * Наслеђује заједничка поља из BaseDto (id, version, izbrisan, kreirano, izmenjeno).
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AcOrganizacijeDto extends BaseDto {

    /** ИД претплатника ком организација припада. */
    @NotNull
    private Long pretplatnikId;

    /** Назив организације. */
    @NotNull
    @Size(max = 255)
    private String naziv;

    /** Опис организације. */
    @Size(max = 255)
    private String opis;

    /** Да ли је организација активна. */
    @NotNull
    private Boolean aktivan;

    // Геттер-и и сеттер-и

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

    public Boolean getAktivan() {
        return aktivan;
    }

    public void setAktivan(Boolean aktivan) {
        this.aktivan = aktivan;
    }
}
