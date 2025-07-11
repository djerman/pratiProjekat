package rs.prati.core.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.time.LocalDate;
import java.time.LocalDateTime;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

/**
 * Ентитет који представља возачке дозволе повезане са корисником.
 */
@Entity
@Table(name = "db_vozaciDozvole")
public class DbVozaciDozvole extends BaseEntity {

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pretplatnikId", nullable = false)
    private AbSistemPretplatnici pretplatnik;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "organizacijaId")
    private AcOrganizacije organizacija;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "korisnikId", nullable = false)
    private BaKorisnici korisnik;

    @NotNull
    @Column(name = "brojDozvole", nullable = false)
    private Integer brojDozvole;

    @NotNull
    @Size(max = 45)
    @Column(name = "izdao", length = 45, nullable = false)
    private String izdao;

    @NotNull
    @Column(name = "vaziDo", nullable = false)
    private LocalDate vaziDo;

    @NotNull
    @Column(name = "AM", nullable = false)
    private Boolean AM;

    @NotNull
    @Column(name = "A1", nullable = false)
    private Boolean A1;

    @NotNull
    @Column(name = "A2", nullable = false)
    private Boolean A2;

    @NotNull
    @Column(name = "A", nullable = false)
    private Boolean A;

    @NotNull
    @Column(name = "B1", nullable = false)
    private Boolean B1;

    @NotNull
    @Column(name = "B", nullable = false)
    private Boolean B;

    @NotNull
    @Column(name = "BE", nullable = false)
    private Boolean BE;

    @NotNull
    @Column(name = "C1", nullable = false)
    private Boolean C1;

    @NotNull
    @Column(name = "C1E", nullable = false)
    private Boolean C1E;

    @NotNull
    @Column(name = "C", nullable = false)
    private Boolean C;

    @NotNull
    @Column(name = "CE", nullable = false)
    private Boolean CE;

    @NotNull
    @Column(name = "D1", nullable = false)
    private Boolean D1;

    @NotNull
    @Column(name = "D1E", nullable = false)
    private Boolean D1E;

    @NotNull
    @Column(name = "D", nullable = false)
    private Boolean D;

    @NotNull
    @Column(name = "DE", nullable = false)
    private Boolean DE;

    @NotNull
    @Column(name = "F", nullable = false)
    private Boolean F;

    @NotNull
    @Column(name = "M", nullable = false)
    private Boolean M;

    @CreationTimestamp
    @Column(name = "kreirano", updatable = false)
    private LocalDateTime kreirano;

    @UpdateTimestamp
    @Column(name = "izmenjeno")
    private LocalDateTime izmenjeno;

    @NotNull
    @Column(name = "izbrisan", nullable = false)
    private Boolean izbrisan;

    // Гетери и сетери

    public AbSistemPretplatnici getPretplatnik() {
        return pretplatnik;
    }

    public void setPretplatnik(AbSistemPretplatnici pretplatnik) {
        this.pretplatnik = pretplatnik;
    }

    public AcOrganizacije getOrganizacija() {
        return organizacija;
    }

    public void setOrganizacija(AcOrganizacije organizacija) {
        this.organizacija = organizacija;
    }

    public BaKorisnici getKorisnik() {
        return korisnik;
    }

    public void setKorisnik(BaKorisnici korisnik) {
        this.korisnik = korisnik;
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

    public void setA1(Boolean A1) {
        this.A1 = A1;
    }

    public Boolean getA2() {
        return A2;
    }

    public void setA2(Boolean A2) {
        this.A2 = A2;
    }

    public Boolean getA() {
        return A;
    }

    public void setA(Boolean A) {
        this.A = A;
    }

    public Boolean getB1() {
        return B1;
    }

    public void setB1(Boolean B1) {
        this.B1 = B1;
    }

    public Boolean getB() {
        return B;
    }

    public void setB(Boolean B) {
        this.B = B;
    }

    public Boolean getBE() {
        return BE;
    }

    public void setBE(Boolean BE) {
        this.BE = BE;
    }

    public Boolean getC1() {
        return C1;
    }

    public void setC1(Boolean C1) {
        this.C1 = C1;
    }

    public Boolean getC1E() {
        return C1E;
    }

    public void setC1E(Boolean C1E) {
        this.C1E = C1E;
    }

    public Boolean getC() {
        return C;
    }

    public void setC(Boolean C) {
        this.C = C;
    }

    public Boolean getCE() {
        return CE;
    }

    public void setCE(Boolean CE) {
        this.CE = CE;
    }

    public Boolean getD1() {
        return D1;
    }

    public void setD1(Boolean D1) {
        this.D1 = D1;
    }

    public Boolean getD1E() {
        return D1E;
    }

    public void setD1E(Boolean D1E) {
        this.D1E = D1E;
    }

    public Boolean getD() {
        return D;
    }

    public void setD(Boolean D) {
        this.D = D;
    }

    public Boolean getDE() {
        return DE;
    }

    public void setDE(Boolean DE) {
        this.DE = DE;
    }

    public Boolean getF() {
        return F;
    }

    public void setF(Boolean F) {
        this.F = F;
    }

    public Boolean getM() {
        return M;
    }

    public void setM(Boolean M) {
        this.M = M;
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
