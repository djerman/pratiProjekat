package rs.prati.service.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

/**
 * DTO класа за организације. Користи се за пренос података између слојева.
 */
public class AcOrganizacijeDto extends BaseDto {

    @NotNull
    private Long pretplatnikId;

    @NotNull
    @Size(max = 255)
    private String naziv;

    @Size(max = 255)
    private String opis;

    @NotNull
    private Boolean aktivan = true;

    // Гетери и сетери
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
