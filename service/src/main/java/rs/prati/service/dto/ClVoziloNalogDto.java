package rs.prati.service.dto;

import java.time.LocalDateTime;

/**
 * DTO за ентитет ClVoziloNalog.
 * Представља налог за коришћење возила.
 */
public class ClVoziloNalogDto extends BaseDto {

    /** ИД претплатника */
    private Long pretplatnikId;

    /** ИД организације */
    private Long organizacijaId;

    /** Број налога */
    private String brojNaloga;

    /** ИД возила */
    private Long voziloId;

    /** Место поласка */
    private String odMesta;

    /** Место доласка */
    private String doMesta;

    /** Међу тачке (стајалишта, градови) */
    private String medjuTacke;

    /** Очекивани полазак */
    private LocalDateTime ocekivaniPolazak;

    /** Очекивани долазак */
    private LocalDateTime ocekivaniDolazak;

    /** ИД возача */
    private Long vozacId;

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

    public String getBrojNaloga() {
        return brojNaloga;
    }

    public void setBrojNaloga(String brojNaloga) {
        this.brojNaloga = brojNaloga;
    }

    public Long getVoziloId() {
        return voziloId;
    }

    public void setVoziloId(Long voziloId) {
        this.voziloId = voziloId;
    }

    public String getOdMesta() {
        return odMesta;
    }

    public void setOdMesta(String odMesta) {
        this.odMesta = odMesta;
    }

    public String getDoMesta() {
        return doMesta;
    }

    public void setDoMesta(String doMesta) {
        this.doMesta = doMesta;
    }

    public String getMedjuTacke() {
        return medjuTacke;
    }

    public void setMedjuTacke(String medjuTacke) {
        this.medjuTacke = medjuTacke;
    }

    public LocalDateTime getOcekivaniPolazak() {
        return ocekivaniPolazak;
    }

    public void setOcekivaniPolazak(LocalDateTime ocekivaniPolazak) {
        this.ocekivaniPolazak = ocekivaniPolazak;
    }

    public LocalDateTime getOcekivaniDolazak() {
        return ocekivaniDolazak;
    }

    public void setOcekivaniDolazak(LocalDateTime ocekivaniDolazak) {
        this.ocekivaniDolazak = ocekivaniDolazak;
    }

    public Long getVozacId() {
        return vozacId;
    }

    public void setVozacId(Long vozacId) {
        this.vozacId = vozacId;
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
