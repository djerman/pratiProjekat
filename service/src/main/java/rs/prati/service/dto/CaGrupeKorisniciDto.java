package rs.prati.service.dto;

import jakarta.validation.constraints.NotNull;

/**
 * DTO за ентитет CaGrupeKorisnici – повезује кориснике и групе возила.
 */
public class CaGrupeKorisniciDto extends BaseDto {

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
     * ИД групе возила.
     */
    @NotNull
    private Long grupaId;

    /**
     * ИД корисника.
     */
    @NotNull
    private Long korisnikId;

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

    public Long getKorisnikId() {
        return korisnikId;
    }

    public void setKorisnikId(Long korisnikId) {
        this.korisnikId = korisnikId;
    }
}
