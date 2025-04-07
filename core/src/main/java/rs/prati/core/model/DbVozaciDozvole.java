package rs.prati.core.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.time.LocalDate;
import java.time.LocalDateTime;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "db_vozaciDozvole")
public class DbVozaciDozvole {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Version
    @NotNull
    @Column(name = "version")
    private Integer version;

    @NotNull
    @Column(name = "pretplatnikId")
    private Long pretplatnikId;

    @Column(name = "organizacijaId")
    private Long organizacijaId;

    @NotNull
    @Column(name = "korisnikId")
    private Long korisnikId;

    @NotNull
    @Column(name = "brojDozvole")
    private Integer brojDozvole;

    @NotNull
    @Size(max = 45)
    @Column(name = "izdao")
    private String izdao;

    @NotNull
    @Column(name = "vaziDo")
    private LocalDate vaziDo;

    @NotNull @Column(name = "AM") private Boolean AM;
    @NotNull @Column(name = "A1") private Boolean A1;
    @NotNull @Column(name = "A2") private Boolean A2;
    @NotNull @Column(name = "A") private Boolean A;
    @NotNull @Column(name = "B1") private Boolean B1;
    @NotNull @Column(name = "B") private Boolean B;
    @NotNull @Column(name = "BE") private Boolean BE;
    @NotNull @Column(name = "C1") private Boolean C1;
    @NotNull @Column(name = "C1E") private Boolean C1E;
    @NotNull @Column(name = "C") private Boolean C;
    @NotNull @Column(name = "CE") private Boolean CE;
    @NotNull @Column(name = "D1") private Boolean D1;
    @NotNull @Column(name = "D1E") private Boolean D1E;
    @NotNull @Column(name = "D") private Boolean D;
    @NotNull @Column(name = "DE") private Boolean DE;
    @NotNull @Column(name = "F") private Boolean F;
    @NotNull @Column(name = "M") private Boolean M;

    @Column(name = "kreirano", updatable = false)
    @CreationTimestamp
    private LocalDateTime kreirano;

    @Column(name = "izmenjeno")
    @UpdateTimestamp
    private LocalDateTime izmenjeno;

    @NotNull
    @Column(name = "izbrisan")
    private Boolean izbrisan;

    // Getters and setters can be added as needed

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

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

    public Boolean getAM() { return AM; }
    public void setAM(Boolean AM) { this.AM = AM; }

    public Boolean getA1() { return A1; }
    public void setA1(Boolean A1) { this.A1 = A1; }

    public Boolean getA2() { return A2; }
    public void setA2(Boolean A2) { this.A2 = A2; }

    public Boolean getA() { return A; }
    public void setA(Boolean A) { this.A = A; }

    public Boolean getB1() { return B1; }
    public void setB1(Boolean B1) { this.B1 = B1; }

    public Boolean getB() { return B; }
    public void setB(Boolean B) { this.B = B; }

    public Boolean getBE() { return BE; }
    public void setBE(Boolean BE) { this.BE = BE; }

    public Boolean getC1() { return C1; }
    public void setC1(Boolean C1) { this.C1 = C1; }

    public Boolean getC1E() { return C1E; }
    public void setC1E(Boolean C1E) { this.C1E = C1E; }

    public Boolean getC() { return C; }
    public void setC(Boolean C) { this.C = C; }

    public Boolean getCE() { return CE; }
    public void setCE(Boolean CE) { this.CE = CE; }

    public Boolean getD1() { return D1; }
    public void setD1(Boolean D1) { this.D1 = D1; }

    public Boolean getD1E() { return D1E; }
    public void setD1E(Boolean D1E) { this.D1E = D1E; }

    public Boolean getD() { return D; }
    public void setD(Boolean D) { this.D = D; }

    public Boolean getDE() { return DE; }
    public void setDE(Boolean DE) { this.DE = DE; }

    public Boolean getF() { return F; }
    public void setF(Boolean F) { this.F = F; }

    public Boolean getM() { return M; }
    public void setM(Boolean M) { this.M = M; }

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
