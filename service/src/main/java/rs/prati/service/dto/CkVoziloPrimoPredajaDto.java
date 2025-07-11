package rs.prati.service.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * DTO за ентитет CkVoziloPrimoPredaja.
 * Представља примопредају возила између возача.
 */
public class CkVoziloPrimoPredajaDto extends BaseDto {

    /** ИД претплатника */
    private Long pretplatnikId;

    /** ИД организације */
    private Long organizacijaId;

    /** Број записника/примопредаје */
    private String broj;

    /** Датум примопредаје */
    private LocalDate datum;

    /** ИД возила */
    private Long voziloId;

    /** ИД возача који предаје */
    private Long vozacPredaja;

    /** ИД администратора */
    private Long administrator;

    /** ИД возача који прима */
    private Long vozacPrijem;

    /** Коментар или напомена */
    private String komentar;

    /** Датум и време креирања */
    private LocalDateTime kreirano;

    /** Датум и време последње измене */
    private LocalDateTime izmenjeno;

    /** Да ли је запис означен као обрисан */
    private Boolean izbrisan;

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

    public String getBroj() {
        return broj;
    }

    public void setBroj(String broj) {
        this.broj = broj;
    }

    public LocalDate getDatum() {
        return datum;
    }

    public void setDatum(LocalDate datum) {
        this.datum = datum;
    }

    public Long getVoziloId() {
        return voziloId;
    }

    public void setVoziloId(Long voziloId) {
        this.voziloId = voziloId;
    }

    public Long getVozacPredaja() {
        return vozacPredaja;
    }

    public void setVozacPredaja(Long vozacPredaja) {
        this.vozacPredaja = vozacPredaja;
    }

    public Long getAdministrator() {
        return administrator;
    }

    public void setAdministrator(Long administrator) {
        this.administrator = administrator;
    }

    public Long getVozacPrijem() {
        return vozacPrijem;
    }

    public void setVozacPrijem(Long vozacPrijem) {
        this.vozacPrijem = vozacPrijem;
    }

    public String getKomentar() {
        return komentar;
    }

    public void setKomentar(String komentar) {
        this.komentar = komentar;
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
