package rs.prati.service.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * DTO за ентитет DeVozaciLicna.
 * Представља личну карту возача.
 */
public class DeVozaciLicnaDto extends BaseDto {

    /** ID претплатника */
    private Long pretplatnikId;

    /** ID организације (ако постоји) */
    private Long organizacijaId;

    /** ID корисника (возача) */
    private Long korisnikId;

    /** Број личне карте */
    private String broj;

    /** Издавалац */
    private String izdao;

    /** Датум издавања */
    private LocalDate izdato;

    /** Датум важења */
    private LocalDate vaziDo;

    /** Датум и време креирања */
    private LocalDateTime kreirano;

    /** Датум и време измене */
    private LocalDateTime izmenjeno;

    /** Статус брисања */
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

    public Long getKorisnikId() {
        return korisnikId;
    }

    public void setKorisnikId(Long korisnikId) {
        this.korisnikId = korisnikId;
    }

    public String getBroj() {
        return broj;
    }

    public void setBroj(String broj) {
        this.broj = broj;
    }

    public String getIzdao() {
        return izdao;
    }

    public void setIzdao(String izdao) {
        this.izdao = izdao;
    }

    public LocalDate getIzdato() {
        return izdato;
    }

    public void setIzdato(LocalDate izdato) {
        this.izdato = izdato;
    }

    public LocalDate getVaziDo() {
        return vaziDo;
    }

    public void setVaziDo(LocalDate vaziDo) {
        this.vaziDo = vaziDo;
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
