package rs.prati.service.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotNull;

/**
 * DTO класа за ентитет BbObjekti.
 * Користи се за пренос података о објектима у систему.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BbObjektiDto extends BaseDto {

    /** Идентификатор претплатника. */
    @NotNull
    private Long pretplatnikId;

    /** Идентификатор организације. */
    @NotNull
    private Long organizacijaId;

    /** Ознака објекта. */
    @NotNull
    private String oznaka;

    /** Тип објекта. */
    @NotNull
    private String tip;

    /** Време стајања (у минутима). */
    @NotNull
    private Integer vremeStajanja;

    /** Дозвољено прекорачење брзине. */
    @NotNull
    private Integer prekoracenjeBrzine;

    /** Да ли је објекат активан. */
    @NotNull
    private Boolean aktivan;

    /** Идентификатор возила ако је повезано. */
    private Long voziloId;

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

    public String getOznaka() {
        return oznaka;
    }

    public void setOznaka(String oznaka) {
        this.oznaka = oznaka;
    }

    public String getTip() {
        return tip;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }

    public Integer getVremeStajanja() {
        return vremeStajanja;
    }

    public void setVremeStajanja(Integer vremeStajanja) {
        this.vremeStajanja = vremeStajanja;
    }

    public Integer getPrekoracenjeBrzine() {
        return prekoracenjeBrzine;
    }

    public void setPrekoracenjeBrzine(Integer prekoracenjeBrzine) {
        this.prekoracenjeBrzine = prekoracenjeBrzine;
    }

    public Boolean getAktivan() {
        return aktivan;
    }

    public void setAktivan(Boolean aktivan) {
        this.aktivan = aktivan;
    }

    public Long getVoziloId() {
        return voziloId;
    }

    public void setVoziloId(Long voziloId) {
        this.voziloId = voziloId;
    }
}
