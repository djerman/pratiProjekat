package rs.prati.core.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "ad_sistemAlarmi")
public class AdSistemAlarmi {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Version
    @NotNull
    @Column(name = "version")
    private Integer version;

    @NotNull
    @Size(max = 30)
    @Column(name = "naziv")
    private String naziv;

    @Size(max = 100)
    @Column(name = "opis")
    private String opis;

    @NotNull
    @Size(max = 20)
    @Column(name = "sifra")
    private String sifra;

    @NotNull
    @Column(name = "adresa")
    private Boolean adresa;

    @NotNull
    @Column(name = "pregled")
    private Boolean pregled;

    @NotNull
    @Column(name = "prikaz")
    private Boolean prikaz;

    @NotNull
    @Column(name = "alarmiranje")
    private Boolean alarmiranje;

    @NotNull
    @Column(name = "aktivan")
    private Boolean aktivan;

    @NotNull
    @Column(name = "izbrisan")
    private Boolean izbrisan;

    @NotNull
    @Column(name = "email")
    private Boolean email;

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

    public Boolean getIzbrisan() {
        return izbrisan;
    }

    public void setIzbrisan(Boolean izbrisan) {
        this.izbrisan = izbrisan;
    }

    public Boolean getEmail() {
        return email;
    }

    public void setEmail(Boolean email) {
        this.email = email;
    }
}
