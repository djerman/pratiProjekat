package rs.prati.core.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

/**
 * Веза између објеката и група у оквиру одређеног претплатника и организације.
 */
@Entity
@Table(name = "cb_grupeObjekti")
public class CbGrupeObjekti extends BaseEntity {

    /**
     * Претплатник коме припада ова веза.
     */
    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "gopretplatnikId", nullable = false)
    private AbSistemPretplatnici pretplatnik;

    /**
     * Организација у оквиру претплатника (може бити null).
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "goorganizacijaId")
    private AcOrganizacije organizacija;

    /**
     * Група објеката.
     */
    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "gogrupaId", nullable = false)
    private BeGrupe grupa;

    /**
     * Објекат који припада групи.
     */
    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "goobjekatId", nullable = false)
    private BbObjekti objekat;

    /**
     * Време креирања записа.
     */
    @NotNull
    @CreationTimestamp
    @Column(name = "kreirano", updatable = false)
    private LocalDateTime kreirano;

    /**
     * Време последње измене записа.
     */
    @NotNull
    @UpdateTimestamp
    @Column(name = "izmenjeno")
    private LocalDateTime izmenjeno;

    // --- Гетери и сетери ---

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

    public BeGrupe getGrupa() {
        return grupa;
    }

    public void setGrupa(BeGrupe grupa) {
        this.grupa = grupa;
    }

    public BbObjekti getObjekat() {
        return objekat;
    }

    public void setObjekat(BbObjekti objekat) {
        this.objekat = objekat;
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
