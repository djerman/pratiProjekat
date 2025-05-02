package rs.prati.service.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

/**
 * DTO класа за уређаје (BcUredjaji).
 */
public class BcUredjajiDto extends BaseDto {

    /** ИД претплатника. */
    @NotNull
    private Long pretplatnikId;

    /** ИД организације. */
    private Long organizacijaId;

    /** ИД модела уређаја. */
    @NotNull
    private Long modelId;

    /** Серијски број уређаја. */
    @NotNull
    @Size(max = 30)
    private String serijskiBr;

    /** Унутрашњи код уређаја. */
    @NotNull
    @Size(max = 30)
    private String kod;

    /** ИД објекта на који је уређај повезан (ако постоји). */
    private Long objekatId;

    /** Да ли је уређај тренутно заузет. */
    private Boolean zauzet;

    /** Да ли је уређај активан. */
    @NotNull
    private Boolean aktivan;

    /** Опис уређаја. */
    private String opis;

    // --- Гетери и Сетери ---

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

    public Long getModelId() {
        return modelId;
    }

    public void setModelId(Long modelId) {
        this.modelId = modelId;
    }

    public String getSerijskiBr() {
        return serijskiBr;
    }

    public void setSerijskiBr(String serijskiBr) {
        this.serijskiBr = serijskiBr;
    }

    public String getKod() {
        return kod;
    }

    public void setKod(String kod) {
        this.kod = kod;
    }

    public Long getObjekatId() {
        return objekatId;
    }

    public void setObjekatId(Long objekatId) {
        this.objekatId = objekatId;
    }

    public Boolean getZauzet() {
        return zauzet;
    }

    public void setZauzet(Boolean zauzet) {
        this.zauzet = zauzet;
    }

    public Boolean getAktivan() {
        return aktivan;
    }

    public void setAktivan(Boolean aktivan) {
        this.aktivan = aktivan;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }
}
