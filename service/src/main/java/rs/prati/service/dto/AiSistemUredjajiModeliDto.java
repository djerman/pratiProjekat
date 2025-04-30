package rs.prati.service.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

/**
 * DTO класа за ентитет AiSistemUredjajiModeli.
 * Користи се за пренос података о моделима уређаја.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AiSistemUredjajiModeliDto extends BaseDto {

    /** Идентификатор произвођача. */
    @NotNull
    private Long proizvodjacId;

    /** Назив модела уређаја. */
    @NotNull
    @Size(max = 100)
    private String naziv;

    /** Опис модела уређаја. */
    private String opis;

    /** Да ли подржава другу SIM картицу. */
    @NotNull
    private Boolean sim2;

    /** Да ли подржава OBD интерфејс. */
    @NotNull
    private Boolean obd;

    /** Да ли подржава обрачун. */
    @NotNull
    private Boolean obracun;

    public Long getProizvodjacId() {
        return proizvodjacId;
    }

    public void setProizvodjacId(Long proizvodjacId) {
        this.proizvodjacId = proizvodjacId;
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

    public Boolean getSim2() {
        return sim2;
    }

    public void setSim2(Boolean sim2) {
        this.sim2 = sim2;
    }

    public Boolean getObd() {
        return obd;
    }

    public void setObd(Boolean obd) {
        this.obd = obd;
    }

    public Boolean getObracun() {
        return obracun;
    }

    public void setObracun(Boolean obracun) {
        this.obracun = obracun;
    }
}
