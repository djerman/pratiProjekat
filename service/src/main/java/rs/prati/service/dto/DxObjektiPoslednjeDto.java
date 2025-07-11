package rs.prati.service.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * DTO за ентитет DxObjektiPoslednje (подаци о последњим сервисима, регистрацији и километражи објекта).
 */
public class DxObjektiPoslednjeDto extends BaseDto {

    /** ID објекта (BbObjekti) */
    private Long objekatId;

    /** Датум последњег малог сервиса */
    private LocalDate maliServis;

    /** Километража на малом сервису */
    private Integer maliKm;

    /** Датум последњег великог сервиса */
    private LocalDate velikiServis;

    /** Километража на великом сервису */
    private Integer velikiKm;

    /** Датум последње регистрације */
    private LocalDate registracija;

    /** Датум и време креирања */
    private LocalDateTime kreirano;

    /** Датум и време измене */
    private LocalDateTime izmenjeno;

    // ГЕТЕРИ И СЕТЕРИ

    public Long getObjekatId() {
        return objekatId;
    }

    public void setObjekatId(Long objekatId) {
        this.objekatId = objekatId;
    }

    public LocalDate getMaliServis() {
        return maliServis;
    }

    public void setMaliServis(LocalDate maliServis) {
        this.maliServis = maliServis;
    }

    public Integer getMaliKm() {
        return maliKm;
    }

    public void setMaliKm(Integer maliKm) {
        this.maliKm = maliKm;
    }

    public LocalDate getVelikiServis() {
        return velikiServis;
    }

    public void setVelikiServis(LocalDate velikiServis) {
        this.velikiServis = velikiServis;
    }

    public Integer getVelikiKm() {
        return velikiKm;
    }

    public void setVelikiKm(Integer velikiKm) {
        this.velikiKm = velikiKm;
    }

    public LocalDate getRegistracija() {
        return registracija;
    }

    public void setRegistracija(LocalDate registracija) {
        this.registracija = registracija;
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
}
