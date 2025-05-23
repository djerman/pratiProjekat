package rs.prati.core.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

/**
 * Ентитет класа која представља дефиниције аларма у систему.
 * Сваки аларм описује врсту догађаја који може бити детектован (нпр. прекорачење брзине, губитак сигнала...).
 * Користи се за означавање типа аларма који ће бити приказан или алармиран.
 */
@Entity
@Table(name = "ad_sistemAlarmi")
public class AdSistemAlarmi extends BaseEntity {

    /** Назив аларма (нпр. "Прекорачење брзине"). */
    @NotNull
    @Size(max = 30)
    @Column(name = "naziv")
    private String naziv;

    /** Опис аларма (детаљније информације о аларму). */
    @Size(max = 100)
    @Column(name = "opis")
    private String opis;

    /** Шифра аларма која се користи у систему. */
    @NotNull
    @Size(max = 20)
    @Column(name = "sifra")
    private String sifra;

    /** Да ли се аларм односи на адресу (локацију). */
    @NotNull
    @Column(name = "adresa")
    private Boolean adresa;

    /** Да ли је омогућен преглед аларма. */
    @NotNull
    @Column(name = "pregled")
    private Boolean pregled;

    /** Да ли ће се аларм приказивати у корисничком интерфејсу. */
    @NotNull
    @Column(name = "prikaz")
    private Boolean prikaz;

    /** Да ли ће се активирати алармирање (нпр. звучни сигнал, нотификација). */
    @NotNull
    @Column(name = "alarmiranje")
    private Boolean alarmiranje;

    /** Да ли је аларм активан. */
    @NotNull
    @Column(name = "aktivan")
    private Boolean aktivan;

    /** Да ли се аларм шаље путем е-поште. */
    @NotNull
    @Column(name = "email")
    private Boolean email;

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public String getSifra() {
        return sifra;
    }

    public void setSifra(String sifra) {
        this.sifra = sifra;
    }

    public Boolean getAdresa() {
        return adresa;
    }

    public void setAdresa(Boolean adresa) {
        this.adresa = adresa;
    }

    public Boolean getPregled() {
        return pregled;
    }

    public void setPregled(Boolean pregled) {
        this.pregled = pregled;
    }

    public Boolean getPrikaz() {
        return prikaz;
    }

    public void setPrikaz(Boolean prikaz) {
        this.prikaz = prikaz;
    }

    public Boolean getAlarmiranje() {
        return alarmiranje;
    }

    public void setAlarmiranje(Boolean alarmiranje) {
        this.alarmiranje = alarmiranje;
    }

    public Boolean getAktivan() {
        return aktivan;
    }

    public void setAktivan(Boolean aktivan) {
        this.aktivan = aktivan;
    }

    public Boolean getEmail() {
        return email;
    }

    public void setEmail(Boolean email) {
        this.email = email;
    }
}
