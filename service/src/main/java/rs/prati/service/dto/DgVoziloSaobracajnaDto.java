package rs.prati.service.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * DTO за ентитет DgVoziloSaobracajna (саобраћајна дозвола возила).
 */
public class DgVoziloSaobracajnaDto extends BaseDto {

    /** ID претплатника */
    private Long pretplatnikId;

    /** ID организације */
    private Long organizacijaId;

    /** ID возила */
    private Long voziloId;

    /** Број саобраћајне дозволе */
    private String brojSaobracajne;

    /** Датум издавања */
    private LocalDate datumIzdavanja;

    /** Орган издавања */
    private String izdao;

    /** Хомологација */
    private String homologacija;

    /** Број шасије */
    private String sasija;

    /** Број мотора */
    private String brojMotora;

    /** Снага мотора */
    private Double snagaMotora;

    /** Запремина мотора */
    private Integer zapreminaMotora;

    /** Запремина резервоара */
    private Integer zapreminaRezervoara;

    /** Запремина AdBlue резервоара */
    private Integer zapreminaRezervoaraAdBlue;

    /** Боја возила */
    private String boja;

    /** Маса возила */
    private String masa;

    /** Укупна маса */
    private String ukupnaMasa;

    /** Категорија возила */
    private String kategorija;

    /** Носивост */
    private String nosivost;

    /** Број места за седење */
    private Integer mestaSedenja;

    /** ID друге саобраћајне (ако постоји) */
    private Long saobracajna2Id;

    /** Датум и време креирања */
    private LocalDateTime kreirano;

    /** Датум и време последње измене */
    private LocalDateTime izmenjeno;

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

    public Long getVoziloId() {
        return voziloId;
    }

    public void setVoziloId(Long voziloId) {
        this.voziloId = voziloId;
    }

    public String getBrojSaobracajne() {
        return brojSaobracajne;
    }

    public void setBrojSaobracajne(String brojSaobracajne) {
        this.brojSaobracajne = brojSaobracajne;
    }

    public LocalDate getDatumIzdavanja() {
        return datumIzdavanja;
    }

    public void setDatumIzdavanja(LocalDate datumIzdavanja) {
        this.datumIzdavanja = datumIzdavanja;
    }

    public String getIzdao() {
        return izdao;
    }

    public void setIzdao(String izdao) {
        this.izdao = izdao;
    }

    public String getHomologacija() {
        return homologacija;
    }

    public void setHomologacija(String homologacija) {
        this.homologacija = homologacija;
    }

    public String getSasija() {
        return sasija;
    }

    public void setSasija(String sasija) {
        this.sasija = sasija;
    }

    public String getBrojMotora() {
        return brojMotora;
    }

    public void setBrojMotora(String brojMotora) {
        this.brojMotora = brojMotora;
    }

    public Double getSnagaMotora() {
        return snagaMotora;
    }

    public void setSnagaMotora(Double snagaMotora) {
        this.snagaMotora = snagaMotora;
    }

    public Integer getZapreminaMotora() {
        return zapreminaMotora;
    }

    public void setZapreminaMotora(Integer zapreminaMotora) {
        this.zapreminaMotora = zapreminaMotora;
    }

    public Integer getZapreminaRezervoara() {
        return zapreminaRezervoara;
    }

    public void setZapreminaRezervoara(Integer zapreminaRezervoara) {
        this.zapreminaRezervoara = zapreminaRezervoara;
    }

    public Integer getZapreminaRezervoaraAdBlue() {
        return zapreminaRezervoaraAdBlue;
    }

    public void setZapreminaRezervoaraAdBlue(Integer zapreminaRezervoaraAdBlue) {
        this.zapreminaRezervoaraAdBlue = zapreminaRezervoaraAdBlue;
    }

    public String getBoja() {
        return boja;
    }

    public void setBoja(String boja) {
        this.boja = boja;
    }

    public String getMasa() {
        return masa;
    }

    public void setMasa(String masa) {
        this.masa = masa;
    }

    public String getUkupnaMasa() {
        return ukupnaMasa;
    }

    public void setUkupnaMasa(String ukupnaMasa) {
        this.ukupnaMasa = ukupnaMasa;
    }

    public String getKategorija() {
        return kategorija;
    }

    public void setKategorija(String kategorija) {
        this.kategorija = kategorija;
    }

    public String getNosivost() {
        return nosivost;
    }

    public void setNosivost(String nosivost) {
        this.nosivost = nosivost;
    }

    public Integer getMestaSedenja() {
        return mestaSedenja;
    }

    public void setMestaSedenja(Integer mestaSedenja) {
        this.mestaSedenja = mestaSedenja;
    }

    public Long getSaobracajna2Id() {
        return saobracajna2Id;
    }

    public void setSaobracajna2Id(Long saobracajna2Id) {
        this.saobracajna2Id = saobracajna2Id;
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
