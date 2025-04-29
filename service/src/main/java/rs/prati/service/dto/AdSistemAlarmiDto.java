package rs.prati.service.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

/**
 * DTO класа за ентитет AdSistemAlarmi.
 * Користи се за пренос података између слојева апликације.
 * Наслеђује заједничка поља из BaseDto (id, version, izbrisan, kreirano, izmenjeno).
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AdSistemAlarmiDto extends BaseDto {

    /** Назив аларма (нпр. "Прекорачење брзине"). */
    @NotNull
    @Size(max = 30)
    private String naziv;

    /** Опис аларма (детаљније информације о аларму). */
    @Size(max = 100)
    private String opis;

    /** Шифра аларма која се користи у систему. */
    @NotNull
    @Size(max = 20)
    private String sifra;

    /** Да ли се аларм односи на адресу (локацију). */
    @NotNull
    private Boolean adresa;

    /** Да ли је омогућен преглед аларма. */
    @NotNull
    private Boolean pregled;

    /** Да ли ће се аларм приказивати у корисничком интерфејсу. */
    @NotNull
    private Boolean prikaz;

    /** Да ли ће се активирати алармирање (нпр. звучни сигнал, нотификација). */
    @NotNull
    private Boolean alarmiranje;

    /** Да ли је аларм активан. */
    @NotNull
    private Boolean aktivan;

    /** Да ли се аларм шаље путем е-поште. */
    @NotNull
    private Boolean email;

    // Геттер-и и сеттер-и

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
