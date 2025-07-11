package rs.prati.service.dto;

import java.time.LocalDateTime;

/**
 * DTO за ентитет DjTroskovi (трошак).
 */
public class DjTroskoviDto extends BaseDto {

    /** ID претплатника */
    private Long pretplatnikId;

    /** ID организације */
    private Long organizacijaId;

    /** ID рачуна */
    private Long racunId;

    /** Датум и време трошка */
    private LocalDateTime datumVreme;

    /** ID партнера */
    private Long partnerId;

    /** Број рачуна (текстуално) */
    private String brojRacuna;

    /** ID објекта */
    private Long objekatId;

    /** Тип сервиса */
    private Integer tipServisa;

    /** ID типа горива */
    private Long tipGorivaId;

    /** Kоличина */
    private Float kolicina;

    /** Цена */
    private Float cena;

    /** ПДВ проценат */
    private Integer pdvProcenat;

    /** ПДВ износ */
    private Float pdvIznos;

    /** Укупно */
    private Float ukupno;

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

    public Long getRacunId() {
        return racunId;
    }

    public void setRacunId(Long racunId) {
        this.racunId = racunId;
    }

    public LocalDateTime getDatumVreme() {
        return datumVreme;
    }

    public void setDatumVreme(LocalDateTime datumVreme) {
        this.datumVreme = datumVreme;
    }

    public Long getPartnerId() {
        return partnerId;
    }

    public void setPartnerId(Long partnerId) {
        this.partnerId = partnerId;
    }

    public String getBrojRacuna() {
        return brojRacuna;
    }

    public void setBrojRacuna(String brojRacuna) {
        this.brojRacuna = brojRacuna;
    }

    public Long getObjekatId() {
        return objekatId;
    }

    public void setObjekatId(Long objekatId) {
        this.objekatId = objekatId;
    }

    public Integer getTipServisa() {
        return tipServisa;
    }

    public void setTipServisa(Integer tipServisa) {
        this.tipServisa = tipServisa;
    }

    public Long getTipGorivaId() {
        return tipGorivaId;
    }

    public void setTipGorivaId(Long tipGorivaId) {
        this.tipGorivaId = tipGorivaId;
    }

    public Float getKolicina() {
        return kolicina;
    }

    public void setKolicina(Float kolicina) {
        this.kolicina = kolicina;
    }

    public Float getCena() {
        return cena;
    }

    public void setCena(Float cena) {
        this.cena = cena;
    }

    public Integer getPdvProcenat() {
        return pdvProcenat;
    }

    public void setPdvProcenat(Integer pdvProcenat) {
        this.pdvProcenat = pdvProcenat;
    }

    public Float getPdvIznos() {
        return pdvIznos;
    }

    public void setPdvIznos(Float pdvIznos) {
        this.pdvIznos = pdvIznos;
    }

    public Float getUkupno() {
        return ukupno;
    }

    public void setUkupno(Float ukupno) {
        this.ukupno = ukupno;
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
