package rs.prati.core.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

/**
 * Ентитет који представља уређаје у систему.
 */
@Entity
@Table(name = "bc_uredjaji")
public class BcUredjaji extends BaseEntity {

    /** Претплатник коме уређај припада. */
    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pretplatnik_id", nullable = false)
    private AbSistemPretplatnici pretplatnik;

    /** Организација у оквиру претплатника. */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "organizacija_id")
    private AcOrganizacije organizacija;

    /** Модел уређаја. */
    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "model_id", nullable = false)
    private AiSistemUredjajiModeli model;

    /** Серијски број уређаја. */
    @NotNull
    @Size(max = 30)
    @Column(name = "serijski_br", nullable = false)
    private String serijskiBr;

    /** Интерни код уређаја. */
    @NotNull
    @Size(max = 30)
    @Column(name = "kod", nullable = false)
    private String kod;

    /** Објекат на који је уређај повезан. */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "objekat_id")
    private BbObjekti objekat;

    /** Да ли је уређај тренутно заузет (системски израчун). */
    @NotNull
    @Column(name = "zauzet", nullable = false, columnDefinition = "TINYINT(1)")
    private Boolean zauzet = false;

    /** Да ли је уређај активан. */
    @NotNull
    @Column(name = "aktivan", nullable = false, columnDefinition = "TINYINT(1)")
    private Boolean aktivan;

    /** Опис уређаја. */
    @Size(max = 100)
    @Column(name = "opis")
    private String opis;

    /** Време креирања. */
    @CreationTimestamp
    @Column(name = "kreirano", updatable = false)
    private LocalDateTime kreirano;

    /** Време последње измене. */
    @UpdateTimestamp
    @Column(name = "izmenjeno")
    private LocalDateTime izmenjeno;

    /** Логичко брисање. */
    @NotNull
    @Column(name = "izbrisan", nullable = false, columnDefinition = "TINYINT(1)")
    private Boolean izbrisan = false;

    // --- Гетери и Сетери ---

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

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

    public AiSistemUredjajiModeli getModel() {
        return model;
    }

    public void setModel(AiSistemUredjajiModeli model) {
        this.model = model;
    }

    public String getSerijskiBr() {
        return serijskiBr;
    }

    public void setSerijskiBr(String serijskiBr) {
        this.serijskiBr = serijskiBr;
    }

    public String getKod() {
        return kod;
    }

    public void setKod(String kod) {
        this.kod = kod;
    }

    public BbObjekti getObjekat() {
        return objekat;
    }

    public void setObjekat(BbObjekti objekat) {
        this.objekat = objekat;
    }

    public Boolean getZauzet() {
        return zauzet;
    }

    public void setZauzet(Boolean zauzet) {
        this.zauzet = zauzet;
    }

    public Boolean getAktivan() {
        return aktivan;
    }

    public void setAktivan(Boolean aktivan) {
        this.aktivan = aktivan;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
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
