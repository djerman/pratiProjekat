package rs.prati.service.dto;

import java.time.LocalDateTime;

/**
 * DTO за ентитет ChZoneObjekti.
 * Представља повезаност зоне и објекта са додатним статусима.
 */
public class ChZoneObjektiDto extends BaseDto {

    /** ID претплатника */
    private Long zopretplatnikId;

    /** ID организације */
    private Long zoorganizacijaId;

    /** ID зоне */
    private Long zonaId;

    /** ID објекта */
    private Long objekatId;

    /** Да ли је улаз у зону */
    private Boolean ulaz;

    /** Да ли је излаз из зоне */
    private Boolean izlaz;

    /** Да ли је асоцијација активна */
    private Boolean aktivan;

    /** Датум и време креирања */
    private LocalDateTime kreirano;

    /** Датум и време последње измене */
    private LocalDateTime izmenjeno;

    /** Да ли је запис означен као обрисан */
    private Boolean izbrisan;

    // Гетери и сетери

    public Long getZopretplatnikId() {
        return zopretplatnikId;
    }

    public void setZopretplatnikId(Long zopretplatnikId) {
        this.zopretplatnikId = zopretplatnikId;
    }

    public Long getZoorganizacijaId() {
        return zoorganizacijaId;
    }

    public void setZoorganizacijaId(Long zoorganizacijaId) {
        this.zoorganizacijaId = zoorganizacijaId;
    }

    public Long getZonaId() {
        return zonaId;
    }

    public void setZonaId(Long zonaId) {
        this.zonaId = zonaId;
    }

    public Long getObjekatId() {
        return objekatId;
    }

    public void setObjekatId(Long objekatId) {
        this.objekatId = objekatId;
    }

    public Boolean getUlaz() {
        return ulaz;
    }

    public void setUlaz(Boolean ulaz) {
        this.ulaz = ulaz;
    }

    public Boolean getIzlaz() {
        return izlaz;
    }

    public void setIzlaz(Boolean izlaz) {
        this.izlaz = izlaz;
    }

    public Boolean getAktivan() {
        return aktivan;
    }

    public void setAktivan(Boolean aktivan) {
        this.aktivan = aktivan;
    }

    public LocalDateTime getKreirano() {
        return kreirano;
    }

    public void setKreirano(LocalDateTime kreirano) {
        this.kreirano = kreirano;
    }

    public LocalDateTime getIzmenjeno() {
        return izmenjeno;
    }

    public void setIzmenjeno(LocalDateTime izmenjeno) {
        this.izmenjeno = izmenjeno;
    }

    public Boolean getIzbrisan() {
        return izbrisan;
    }

    public void setIzbrisan(Boolean izbrisan) {
        this.izbrisan = izbrisan;
    }
}
