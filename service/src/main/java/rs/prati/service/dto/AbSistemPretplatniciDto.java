package rs.prati.service.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.Email;

/**
 * DTO за ентитет AbSistemPretplatnici, користи се за пренос података ка и од REST сервиса.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AbSistemPretplatniciDto extends BaseDto {

    private String naziv;
    private Boolean sistem;

    @Email
    private String email;
    private Boolean aktivan;
    private String apiKey;
    private Boolean tip;
    private Long nadzorId;
    private Boolean gMapa;

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
