package rs.prati.service.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

/**
 * DTO класа за ентитет BdSim – представља СИМ картицу.
 */
public class BdSimDto extends BaseDto {

    /** Јединствени идентификатор */
    private Long id;

    /** ИД претплатника */
    @NotNull
    private Long pretplatnikId;

    /** ИД организације */
    private Long organizacijaId;

    /** ИД мобилног оператера */
    @NotNull
    private Long operaterId;

    /** ИД уређаја повезаног са СИМ картицом */
    private Long uredjajId;

    /** ICCID број картице */
    @NotNull
    @Size(max = 100)
    private String iccid;

    /** Број телефона */
    @NotNull
    @Size(max = 30)
    private String broj;

    /** Да ли је картица заузета */
    private Boolean zauzet;

    /** Да ли је картица активна */
    @NotNull
    private Boolean aktivan;

    /** Опис или напомена */
    private String opis;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public Long getOperaterId() {
        return operaterId;
    }

    public void setOperaterId(Long operaterId) {
        this.operaterId = operaterId;
    }

    public Long getUredjajId() {
        return uredjajId;
    }

    public void setUredjajId(Long uredjajId) {
        this.uredjajId = uredjajId;
    }

    public String getIccid() {
        return iccid;
    }

    public void setIccid(String iccid) {
        this.iccid = iccid;
    }

    public String getBroj() {
        return broj;
    }

    public void setBroj(String broj) {
        this.broj = broj;
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
