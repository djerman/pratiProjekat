package rs.prati.service.dto;

import java.time.LocalDateTime;

/**
 * DTO за ентитет DkProjekti (пројекат).
 */
public class DkProjektiDto extends BaseDto {

    /** ID претплатника */
    private Long pretplatnikId;

    /** ID организације */
    private Long organizacijaId;

    /** Назив пројекта */
    private String naziv;

    /** Шифра пројекта */
    private String sifra;

    /** ID партнера */
    private Long partnerId;

    /** Опис */
    private String opis;

    /** Ознака обрисаности */
    private Boolean izbrisan;

    /** Датум и време креирања */
    private LocalDateTime kreirano;

    /** Датум и време измене */
    private LocalDateTime izmenjeno;

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

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getSifra() {
        return sifra;
    }

    public void setSifra(String sifra) {
        this.sifra = sifra;
    }

    public Long getPartnerId() {
        return partnerId;
    }

    public void setPartnerId(Long partnerId) {
        this.partnerId = partnerId;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public Boolean getIzbrisan() {
        return izbrisan;
    }

    public void setIzbrisan(Boolean izbrisan) {
        this.izbrisan = izbrisan;
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
