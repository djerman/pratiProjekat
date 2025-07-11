package rs.prati.service.dto;

/**
 * DTO за ентитет DaVoziloOpremaPrijem.
 * Представља пријем опреме приликом примопредаје возила.
 */
public class DaVoziloOpremaPrijemDto extends BaseDto {

    /** ИД претплатника */
    private Long pretplatnikId;

    /** ИД организације */
    private Long organizacijaId;

    /** ИД примопредаје */
    private Long primoPredajaId;

    /** ИД опреме */
    private Long opremaId;

    /** Количина опреме */
    private Integer kolicina;

    // ГЕТЕРИ И СЕТЕРИ

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

    public Long getPrimoPredajaId() {
        return primoPredajaId;
    }

    public void setPrimoPredajaId(Long primoPredajaId) {
        this.primoPredajaId = primoPredajaId;
    }

    public Long getOpremaId() {
        return opremaId;
    }

    public void setOpremaId(Long opremaId) {
        this.opremaId = opremaId;
    }

    public Integer getKolicina() {
        return kolicina;
    }

    public void setKolicina(Integer kolicina) {
        this.kolicina = kolicina;
    }
}
