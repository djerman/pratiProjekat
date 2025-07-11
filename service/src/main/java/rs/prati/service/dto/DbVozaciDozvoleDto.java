package rs.prati.service.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * DTO за ентитет DbVozaciDozvole.
 * Представља податке о возачким дозволама корисника.
 */
public class DbVozaciDozvoleDto extends BaseDto {

    /** ИД претплатника */
    private Long pretplatnikId;

    /** ИД организације */
    private Long organizacijaId;

    /** ИД корисника */
    private Long korisnikId;

    /** Број возачке дозволе */
    private Integer brojDozvole;

    /** Орган који је издао дозволу */
    private String izdao;

    /** Датум до када важи дозвола */
    private LocalDate vaziDo;

    /** Категорије – AM */
    private Boolean AM;

    private Boolean A1;
    private Boolean A2;
    private Boolean A;
    private Boolean B1;
    private Boolean B;
    private Boolean BE;
    private Boolean C1;
    private Boolean C1E;
    private Boolean C;
    private Boolean CE;
    private Boolean D1;
    private Boolean D1E;
    private Boolean D;
    private Boolean DE;
    private Boolean F;
    private Boolean M;

    /** Датум и време креирања */
    private LocalDateTime kreirano;

    /** Датум и време измене */
    private LocalDateTime izmenjeno;

    /** Да ли је запис означен као обрисан */
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

    public Integer getBrojDozvole() {
        return brojDozvole;
    }

    public void setBrojDozvole(Integer brojDozvole) {
        this.brojDozvole = brojDozvole;
    }

    public String getIzdao() {
        return izdao;
    }

    public void setIzdao(String izdao) {
        this.izdao = izdao;
    }

    public LocalDate getVaziDo() {
        return vaziDo;
    }

    public void setVaziDo(LocalDate vaziDo) {
        this.vaziDo = vaziDo;
    }

    public Boolean getAM() {
        return AM;
    }

    public void setAM(Boolean AM) {
        this.AM = AM;
    }

    public Boolean getA1() {
        return A1;
    }

    public void setA1(Boolean a1) {
        A1 = a1;
    }

    public Boolean getA2() {
        return A2;
    }

    public void setA2(Boolean a2) {
        A2 = a2;
    }

    public Boolean getA() {
        return A;
    }

    public void setA(Boolean a) {
        A = a;
    }

    public Boolean getB1() {
        return B1;
    }

    public void setB1(Boolean b1) {
        B1 = b1;
    }

    public Boolean getB() {
        return B;
    }

    public void setB(Boolean b) {
        B = b;
    }

    public Boolean getBE() {
        return BE;
    }

    public void setBE(Boolean be) {
        BE = be;
    }

    public Boolean getC1() {
        return C1;
    }

    public void setC1(Boolean c1) {
        C1 = c1;
    }

    public Boolean getC1E() {
        return C1E;
    }

    public void setC1E(Boolean c1e) {
        C1E = c1e;
    }

    public Boolean getC() {
        return C;
    }

    public void setC(Boolean c) {
        C = c;
    }

    public Boolean getCE() {
        return CE;
    }

    public void setCE(Boolean ce) {
        CE = ce;
    }

    public Boolean getD1() {
        return D1;
    }

    public void setD1(Boolean d1) {
        D1 = d1;
    }

    public Boolean getD1E() {
        return D1E;
    }

    public void setD1E(Boolean d1e) {
        D1E = d1e;
    }

    public Boolean getD() {
        return D;
    }

    public void setD(Boolean d) {
        D = d;
    }

    public Boolean getDE() {
        return DE;
    }

    public void setDE(Boolean de) {
        DE = de;
    }

    public Boolean getF() {
        return F;
    }

    public void setF(Boolean f) {
        F = f;
    }

    public Boolean getM() {
        return M;
    }

    public void setM(Boolean m) {
        M = m;
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
