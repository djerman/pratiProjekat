package rs.prati.service.dto;

import java.time.LocalDateTime;

/**
 * DTO за ентитет DySistemSesije (системске сесије корисника).
 */
public class DySistemSesijeDto extends BaseDto {

    /** ID претплатника */
    private Long pretplatnikId;

    /** ID организације */
    private Long organizacijaId;

    /** ID корисника */
    private Long korisnikId;

    /** Датум и време почетка сесије */
    private LocalDateTime datumPocetak;

    /** Датум и време краја сесије */
    private LocalDateTime datumKraj;

    /** IP адреса */
    private String ipAdresa;

    /** Означен као обрисан */
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

    public LocalDateTime getDatumPocetak() {
        return datumPocetak;
    }

    public void setDatumPocetak(LocalDateTime datumPocetak) {
        this.datumPocetak = datumPocetak;
    }

    public LocalDateTime getDatumKraj() {
        return datumKraj;
    }

    public void setDatumKraj(LocalDateTime datumKraj) {
        this.datumKraj = datumKraj;
    }

    public String getIpAdresa() {
        return ipAdresa;
    }

    public void setIpAdresa(String ipAdresa) {
        this.ipAdresa = ipAdresa;
    }

    public Boolean getIzbrisan() {
        return izbrisan;
    }

    public void setIzbrisan(Boolean izbrisan) {
        this.izbrisan = izbrisan;
    }
}
