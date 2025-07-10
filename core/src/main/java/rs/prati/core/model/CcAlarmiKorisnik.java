package rs.prati.core.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

/**
 * Ентитет који представља везу између корисника и аларма.
 * Дефинише начин обавештавања (е‑маил, интерно) и статус.
 */
@Entity
@Table(name = "cc_alarmiKorisnik")
public class CcAlarmiKorisnik extends BaseEntity {

    /** Претплатник коме овај податак припада */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pretplatnikId", nullable = false)
    private AbSistemPretplatnici pretplatnik;

    /** Организација (ако постоји) у оквиру претплатника */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "organizacijaId")
    private AcOrganizacije organizacija;

    /** Корисник на кога се односи аларм */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "korisnikId", nullable = false)
    private BaKorisnici korisnik;

    /** Објекат на који се односи аларм */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "objekatId", nullable = false)
    private BbObjekti objekat;

    /** Аларм који је повезан са корисником */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "alarmId", nullable = false)
    private AdSistemAlarmi alarm;

    /** Да ли се корисник обавештава путем е‑маила */
    @NotNull
    @Column(name = "email", nullable = false)
    private Boolean email;

    /** Да ли се приказује интерно обавештење у систему */
    @NotNull
    @Column(name = "obavestenje", nullable = false)
    private Boolean obavestenje;

    /** Да ли је веза активна */
    @NotNull
    @Column(name = "aktivan", nullable = false)
    private Boolean aktivan;

    /** Датум и време креирања записа (аутоматски) */
    @CreationTimestamp
    @Column(name = "kreirano", updatable = false)
    private LocalDateTime kreirano;

    /** Датум и време последње измене записа (аутоматски) */
    @UpdateTimestamp
    @Column(name = "izmenjeno")
    private LocalDateTime izmenjeno;

    // ГЕТЕРИ И СЕТЕРИ

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

    public BbObjekti getObjekat() {
        return objekat;
    }

    public void setObjekat(BbObjekti objekat) {
        this.objekat = objekat;
    }

    public AdSistemAlarmi getAlarm() {
        return alarm;
    }

    public void setAlarm(AdSistemAlarmi alarm) {
        this.alarm = alarm;
    }

    public Boolean getEmail() {
        return email;
    }

    public void setEmail(Boolean email) {
        this.email = email;
    }

    public Boolean getObavestenje() {
        return obavestenje;
    }

    public void setObavestenje(Boolean obavestenje) {
        this.obavestenje = obavestenje;
    }

    public Boolean getAktivan() {
        return aktivan;
    }

    public void setAktivan(Boolean aktivan) {
        this.aktivan = aktivan;
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
