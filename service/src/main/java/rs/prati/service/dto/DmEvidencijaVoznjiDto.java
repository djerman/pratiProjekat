package rs.prati.service.dto;

import java.time.LocalDateTime;

/**
 * DTO за ентитет DmEvidencijaVoznji (евиденција вожњи).
 */
public class DmEvidencijaVoznjiDto extends BaseDto {

    /** ИД претплатника */
    private Long pretplatnikId;

    /** ИД организације */
    private Long organizacijaId;

    /** ИД налога за вожњу */
    private Long voziloNalogId;

    /** ИД возила */
    private Long voziloId;

    /** ИД возача */
    private Long vozacId;

    /** Регистрација возила */
    private String registracijaVozila;

    /** Релација */
    private String relacija;

    /** Датум и време поласка */
    private LocalDateTime datumVremePolaska;

    /** Датум и време доласка */
    private LocalDateTime datumVremeDolaska;

    /** Почетна километража */
    private Float pocetnaKm;

    /** Завршна километража */
    private Float zavrsnaKm;

    /** Разлика у километражи */
    private Float razlikaKm;

    /** Потрошња */
    private Float potrosnja;

    /** Цена горива */
    private Float gorivoCena;

    /** Цена превоза */
    private Float prevozCena;

    /** Путни трошкови */
    private Float putniTroskovi;

    /** Број путног налога */
    private String brojPutnogNaloga;

    /** Број дана */
    private Integer dana;

    /** Број сати */
    private Integer sati;

    /** Трошкови горива */
    private Float troskoviGoriva;

    /** Укупно за превоз */
    private Float prevozUkupno;

    /** Превоз + путни трошак */
    private Float prevozPutniTrosak;

    /** Извор податка */
    private String preuzetoIz;

    /** Врста робе */
    private String vrstaRobe;

    /** Kоличина */
    private Integer kolicina;

    /** Магцин */
    private String magacin;

    /** Отпремница */
    private String otpremnica;

    /** Шифра */
    private String sifra;

    /** Шифра програма */
    private String sifraPrograma;

    /** Програм */
    private String program;

    /** Утрошено литара */
    private Float utrosenoLitara;

    /** Да ли је запис закључан */
    private Boolean zakljucan;

    /** ИД корисника који је унео запис */
    private Long uradioId;

    /** Датум и време креирања */
    private LocalDateTime kreirano;

    /** Датум и време измене */
    private LocalDateTime izmenjeno;

    // ГЕТЕРИ И СЕТЕРИ са JavaDoc коментарима

    /** Враћа ИД претплатника. */
    public Long getPretplatnikId() {
        return pretplatnikId;
    }

    /** Поставља ИД претплатника. */
    public void setPretplatnikId(Long pretplatnikId) {
        this.pretplatnikId = pretplatnikId;
    }

    /** Враћа ИД организације. */
    public Long getOrganizacijaId() {
        return organizacijaId;
    }

    /** Поставља ИД организације. */
    public void setOrganizacijaId(Long organizacijaId) {
        this.organizacijaId = organizacijaId;
    }

    /** Враћа ИД налога за вожњу. */
    public Long getVoziloNalogId() {
        return voziloNalogId;
    }

    /** Поставља ИД налога за вожњу. */
    public void setVoziloNalogId(Long voziloNalogId) {
        this.voziloNalogId = voziloNalogId;
    }

    /** Враћа ИД возила. */
    public Long getVoziloId() {
        return voziloId;
    }

    /** Поставља ИД возила. */
    public void setVoziloId(Long voziloId) {
        this.voziloId = voziloId;
    }

    /** Враћа ИД возача. */
    public Long getVozacId() {
        return vozacId;
    }

    /** Поставља ИД возача. */
    public void setVozacId(Long vozacId) {
        this.vozacId = vozacId;
    }

    /** Враћа регистрацију возила. */
    public String getRegistracijaVozila() {
        return registracijaVozila;
    }

    /** Поставља регистрацију возила. */
    public void setRegistracijaVozila(String registracijaVozila) {
        this.registracijaVozila = registracijaVozila;
    }

    /** Враћа релацију. */
    public String getRelacija() {
        return relacija;
    }

    /** Поставља релацију. */
    public void setRelacija(String relacija) {
        this.relacija = relacija;
    }

    /** Враћа датум и време поласка. */
    public LocalDateTime getDatumVremePolaska() {
        return datumVremePolaska;
    }

    /** Поставља датум и време поласка. */
    public void setDatumVremePolaska(LocalDateTime datumVremePolaska) {
        this.datumVremePolaska = datumVremePolaska;
    }

    /** Враћа датум и време доласка. */
    public LocalDateTime getDatumVremeDolaska() {
        return datumVremeDolaska;
    }

    /** Поставља датум и време доласка. */
    public void setDatumVremeDolaska(LocalDateTime datumVremeDolaska) {
        this.datumVremeDolaska = datumVremeDolaska;
    }

    /** Враћа почетну километражу. */
    public Float getPocetnaKm() {
        return pocetnaKm;
    }

    /** Поставља почетну километражу. */
    public void setPocetnaKm(Float pocetnaKm) {
        this.pocetnaKm = pocetnaKm;
    }

    /** Враћа завршну километражу. */
    public Float getZavrsnaKm() {
        return zavrsnaKm;
    }

    /** Поставља завршну километражу. */
    public void setZavrsnaKm(Float zavrsnaKm) {
        this.zavrsnaKm = zavrsnaKm;
    }

    /** Враћа разлику у километражи. */
    public Float getRazlikaKm() {
        return razlikaKm;
    }

    /** Поставља разлику у километражи. */
    public void setRazlikaKm(Float razlikaKm) {
        this.razlikaKm = razlikaKm;
    }

    /** Враћа потрошњу. */
    public Float getPotrosnja() {
        return potrosnja;
    }

    /** Поставља потрошњу. */
    public void setPotrosnja(Float potrosnja) {
        this.potrosnja = potrosnja;
    }

    /** Враћа цену горива. */
    public Float getGorivoCena() {
        return gorivoCena;
    }

    /** Поставља цену горива. */
    public void setGorivoCena(Float gorivoCena) {
        this.gorivoCena = gorivoCena;
    }

    /** Враћа цену превоза. */
    public Float getPrevozCena() {
        return prevozCena;
    }

    /** Поставља цену превоза. */
    public void setPrevozCena(Float prevozCena) {
        this.prevozCena = prevozCena;
    }

    /** Враћа путне трошкове. */
    public Float getPutniTroskovi() {
        return putniTroskovi;
    }

    /** Поставља путне трошкове. */
    public void setPutniTroskovi(Float putniTroskovi) {
        this.putniTroskovi = putniTroskovi;
    }

    /** Враћа број путног налога. */
    public String getBrojPutnogNaloga() {
        return brojPutnogNaloga;
    }

    /** Поставља број путног налога. */
    public void setBrojPutnogNaloga(String brojPutnogNaloga) {
        this.brojPutnogNaloga = brojPutnogNaloga;
    }

    /** Враћа број дана. */
    public Integer getDana() {
        return dana;
    }

    /** Поставља број дана. */
    public void setDana(Integer dana) {
        this.dana = dana;
    }

    /** Враћа број сати. */
    public Integer getSati() {
        return sati;
    }

    /** Поставља број сати. */
    public void setSati(Integer sati) {
        this.sati = sati;
    }

    /** Враћа трошкове горива. */
    public Float getTroskoviGoriva() {
        return troskoviGoriva;
    }

    /** Поставља трошкове горива. */
    public void setTroskoviGoriva(Float troskoviGoriva) {
        this.troskoviGoriva = troskoviGoriva;
    }

    /** Враћа укупно за превоз. */
    public Float getPrevozUkupno() {
        return prevozUkupno;
    }

    /** Поставља укупно за превоз. */
    public void setPrevozUkupno(Float prevozUkupno) {
        this.prevozUkupno = prevozUkupno;
    }

    /** Враћа превоз + путни трошак. */
    public Float getPrevozPutniTrosak() {
        return prevozPutniTrosak;
    }

    /** Поставља превоз + путни трошак. */
    public void setPrevozPutniTrosak(Float prevozPutniTrosak) {
        this.prevozPutniTrosak = prevozPutniTrosak;
    }

    /** Враћа извор податка. */
    public String getPreuzetoIz() {
        return preuzetoIz;
    }

    /** Поставља извор податка. */
    public void setPreuzetoIz(String preuzetoIz) {
        this.preuzetoIz = preuzetoIz;
    }

    /** Враћа врсту робе. */
    public String getVrstaRobe() {
        return vrstaRobe;
    }

    /** Поставља врсту робе. */
    public void setVrstaRobe(String vrstaRobe) {
        this.vrstaRobe = vrstaRobe;
    }

    /** Враћа количину. */
    public Integer getKolicina() {
        return kolicina;
    }

    /** Поставља количину. */
    public void setKolicina(Integer kolicina) {
        this.kolicina = kolicina;
    }

    /** Враћа магцин. */
    public String getMagacin() {
        return magacin;
    }

    /** Поставља магцин. */
    public void setMagacin(String magacin) {
        this.magacin = magacin;
    }

    /** Враћа отпремницу. */
    public String getOtpremnica() {
        return otpremnica;
    }

    /** Поставља отпремницу. */
    public void setOtpremnica(String otpremnica) {
        this.otpremnica = otpremnica;
    }

    /** Враћа шифру. */
    public String getSifra() {
        return sifra;
    }

    /** Поставља шифру. */
    public void setSifra(String sifra) {
        this.sifra = sifra;
    }

    /** Враћа шифру програма. */
    public String getSifraPrograma() {
        return sifraPrograma;
    }

    /** Поставља шифру програма. */
    public void setSifraPrograma(String sifraPrograma) {
        this.sifraPrograma = sifraPrograma;
    }

    /** Враћа програм. */
    public String getProgram() {
        return program;
    }

    /** Поставља програм. */
    public void setProgram(String program) {
        this.program = program;
    }

    /** Враћа утрошено литара. */
    public Float getUtrosenoLitara() {
        return utrosenoLitara;
    }

    /** Поставља утрошено литара. */
    public void setUtrosenoLitara(Float utrosenoLitara) {
        this.utrosenoLitara = utrosenoLitara;
    }

    /** Враћа да ли је запис закључан. */
    public Boolean getZakljucan() {
        return zakljucan;
    }

    /** Поставља да ли је запис закључан. */
    public void setZakljucan(Boolean zakljucan) {
        this.zakljucan = zakljucan;
    }

    /** Враћа ИД корисника који је унео запис. */
    public Long getUradioId() {
        return uradioId;
    }

    /** Поставља ИД корисника који је унео запис. */
    public void setUradioId(Long uradioId) {
        this.uradioId = uradioId;
    }

    /** Враћа датум и време креирања. */
    public LocalDateTime getKreirano() {
        return kreirano;
    }

    /** Поставља датум и време креирања. */
    public void setKreirano(LocalDateTime kreirano) {
        this.kreirano = kreirano;
    }

    /** Враћа датум и време измене. */
    public LocalDateTime getIzmenjeno() {
        return izmenjeno;
    }

    /** Поставља датум и време измене. */
    public void setIzmenjeno(LocalDateTime izmenjeno) {
        this.izmenjeno = izmenjeno;
    }
}
