package rs.prati.service.dto;

import jakarta.validation.constraints.NotNull;

/**
 * DTO за ентитет CbGrupeObjekti – представља повезаност објеката и група.
 */
public class CbGrupeObjektiDto extends BaseDto {

    /**
     * ИД претплатника.
     */
    @NotNull
    private Long pretplatnikId;

    /**
     * ИД организације (може бити null).
     */
    private Long organizacijaId;

    /**
     * ИД групе.
     */
    @NotNull
    private Long grupaId;

    /**
     * ИД објекта.
     */
    @NotNull
    private Long objekatId;

    // --- Гетери и сетери ---

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

    public Long getGrupaId() {
        return grupaId;
    }

    public void setGrupaId(Long grupaId) {
        this.grupaId = grupaId;
    }

    public Long getObjekatId() {
        return objekatId;
    }

    public void setObjekatId(Long objekatId) {
        this.objekatId = objekatId;
    }
}
