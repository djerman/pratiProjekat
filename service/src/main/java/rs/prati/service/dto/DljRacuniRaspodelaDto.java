package rs.prati.service.dto;

/**
 * DTO за ентитет DljRacuniRaspodela (расподела износа по рачунима).
 */
public class DljRacuniRaspodelaDto extends BaseDto {

    /** ID претплатника */
    private Long pretplatnikId;

    /** ID организације */
    private Long organizacijaId;

    /** ID партнера */
    private Long partnerId;

    /** ID рачуна */
    private Long racunId;

    /** Износ расподеле */
    private Float iznos;

    // Гетери и сетери

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

    public Long getPartnerId() {
        return partnerId;
    }

    public void setPartnerId(Long partnerId) {
        this.partnerId = partnerId;
    }

    public Long getRacunId() {
        return racunId;
    }

    public void setRacunId(Long racunId) {
        this.racunId = racunId;
    }

    public Float getIznos() {
        return iznos;
    }

    public void setIznos(Float iznos) {
        this.iznos = iznos;
    }
}
