package rs.prati.service.dto;

/**
 * DTO за ентитет CdObjektiAlarmi.
 * Представља конфигурацију аларма и сервисних интервала за појединачне објекте.
 */
public class CdObjektiAlarmiDto extends BaseDto {

    /** ИД претплатника */
    private Long pretplatnikId;

    /** ИД организације */
    private Long organizacijaId;

    /** ИД објекта */
    private Long objekatId;

    /** Ограничење брзине у km/h */
    private Integer ogranicenjeBrzine;

    /** Време неактивности у минутима */
    private Integer vremeNeaktivnost;

    /** Време за мали сервис у данима */
    private Integer vremeMaliServis;

    /** Километража за мали сервис */
    private Integer kmMaliServis;

    /** Време за велики сервис у данима */
    private Integer vremeVelikiServis;

    /** Километража за велики сервис */
    private Integer kmVelikiServis;

    /** Да ли је конфигурација активна */
    private Boolean aktivan;

    /** Да ли је запис обрисан */
    private Boolean izbrisan;

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

    public Long getObjekatId() {
        return objekatId;
    }

    public void setObjekatId(Long objekatId) {
        this.objekatId = objekatId;
    }

    public Integer getOgranicenjeBrzine() {
        return ogranicenjeBrzine;
    }

    public void setOgranicenjeBrzine(Integer ogranicenjeBrzine) {
        this.ogranicenjeBrzine = ogranicenjeBrzine;
    }

    public Integer getVremeNeaktivnost() {
        return vremeNeaktivnost;
    }

    public void setVremeNeaktivnost(Integer vremeNeaktivnost) {
        this.vremeNeaktivnost = vremeNeaktivnost;
    }

    public Integer getVremeMaliServis() {
        return vremeMaliServis;
    }

    public void setVremeMaliServis(Integer vremeMaliServis) {
        this.vremeMaliServis = vremeMaliServis;
    }

    public Integer getKmMaliServis() {
        return kmMaliServis;
    }

    public void setKmMaliServis(Integer kmMaliServis) {
        this.kmMaliServis = kmMaliServis;
    }

    public Integer getVremeVelikiServis() {
        return vremeVelikiServis;
    }

    public void setVremeVelikiServis(Integer vremeVelikiServis) {
        this.vremeVelikiServis = vremeVelikiServis;
    }

    public Integer getKmVelikiServis() {
        return kmVelikiServis;
    }

    public void setKmVelikiServis(Integer kmVelikiServis) {
        this.kmVelikiServis = kmVelikiServis;
    }

    public Boolean getAktivan() {
        return aktivan;
    }

    public void setAktivan(Boolean aktivan) {
        this.aktivan = aktivan;
    }

    public Boolean getIzbrisan() {
        return izbrisan;
    }

    public void setIzbrisan(Boolean izbrisan) {
        this.izbrisan = izbrisan;
    }
}
