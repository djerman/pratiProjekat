package rs.prati.core.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalDateTime;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

/**
 * Ентитет који представља податке о последњим сервисима, регистрацији и километражи објекта.
 */
@Entity
@Table(name = "dx_objektiPoslednje")
public class DxObjektiPoslednje extends BaseEntity {

    /** Асоцијација на BbObjekti (објекат). */
    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "objekatId", nullable = false, referencedColumnName = "id")
    private BbObjekti objekat;

    /** Датум последњег малог сервиса. */
    @Column(name = "maliServis")
    private LocalDate maliServis;

    /** Километража на малом сервису. */
    @Column(name = "maliKm")
    private Integer maliKm;

    /** Датум последњег великог сервиса. */
    @Column(name = "velikiServis")
    private LocalDate velikiServis;

    /** Километража на великом сервису. */
    @Column(name = "velikiKm")
    private Integer velikiKm;

    /** Датум последње регистрације. */
    @Column(name = "registracija")
    private LocalDate registracija;

    /** Датум и време креирања. */
    @CreationTimestamp
    @Column(name = "kreirano", updatable = false)
    private LocalDateTime kreirano;

    /** Датум и време измене. */
    @UpdateTimestamp
    @Column(name = "izmenjeno")
    private LocalDateTime izmenjeno;

    // ГЕТЕРИ И СЕТЕРИ

    public BbObjekti getObjekat() {
        return objekat;
    }

    public void setObjekat(BbObjekti objekat) {
        this.objekat = objekat;
    }

    public LocalDate getMaliServis() {
        return maliServis;
    }

    public void setMaliServis(LocalDate maliServis) {
        this.maliServis = maliServis;
    }

    public Integer getMaliKm() {
        return maliKm;
    }

    public void setMaliKm(Integer maliKm) {
        this.maliKm = maliKm;
    }

    public LocalDate getVelikiServis() {
        return velikiServis;
    }

    public void setVelikiServis(LocalDate velikiServis) {
        this.velikiServis = velikiServis;
    }

    public Integer getVelikiKm() {
        return velikiKm;
    }

    public void setVelikiKm(Integer velikiKm) {
        this.velikiKm = velikiKm;
    }

    public LocalDate getRegistracija() {
        return registracija;
    }

    public void setRegistracija(LocalDate registracija) {
        this.registracija = registracija;
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
