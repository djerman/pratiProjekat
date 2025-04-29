package rs.prati.service.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.time.LocalDate;

/**
 * DTO класа за ентитет AbSistemPretplatnici.
 * Користи се за пренос података између слојева апликације.
 * Наслеђује заједничка поља из BaseDto (id, version, izbrisan, kreirano, izmenjeno).
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AbSistemPretplatniciDto extends BaseDto {

    /** Назив претплатника. */
    @Size(max = 255)
    @NotNull
    private String naziv;

    /** Да ли је системски претплатник. */
    private Boolean sistem;

    /** Електронска пошта претплатника. */
    @Size(max = 255)
    private String email;

    /** Да ли је претплатник активан. */
    private Boolean aktivan;

    /** Датум до када је активан. */
    private LocalDate aktivanDo;

    /** API кључ за интеграцију. */
    @Size(max = 255)
    private String apiKey;

    /** Тип претплатника. */
    private Boolean tip;

    /** ID надзорне организације. */
    private Long nadzorId;

    /** Да ли користи Google мапе. */
    private Boolean gMapa;

    // Геттер-и и сеттер-и

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public Boolean getSistem() {
        return sistem;
    }

    public void setSistem(Boolean sistem) {
        this.sistem = sistem;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getAktivan() {
        return aktivan;
    }

    public void setAktivan(Boolean aktivan) {
        this.aktivan = aktivan;
    }

    public LocalDate getAktivanDo() {
        return aktivanDo;
    }

    public void setAktivanDo(LocalDate aktivanDo) {
        this.aktivanDo = aktivanDo;
    }

    public String getApiKey() {
        return apiKey;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

    public Boolean getTip() {
        return tip;
    }

    public void setTip(Boolean tip) {
        this.tip = tip;
    }

    public Long getNadzorId() {
        return nadzorId;
    }

    public void setNadzorId(Long nadzorId) {
        this.nadzorId = nadzorId;
    }

    public Boolean getGMapa() {
        return gMapa;
    }

    public void setGMapa(Boolean gMapa) {
        this.gMapa = gMapa;
    }
}
