package rs.prati.core.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.time.LocalDate;
import java.time.LocalDateTime;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

/**
 * Ентитет који представља саобраћајну дозволу возила.
 */
@Entity
@Table(name = "dg_voziloSaobracajna")
public class DgVoziloSaobracajna extends BaseEntity {

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pretplatnikId", nullable = false)
    private AbSistemPretplatnici pretplatnik;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "organizacijaId")
    private AcOrganizacije organizacija;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "voziloId", nullable = false)
    private CjVozilo vozilo;

    @Size(max = 45)
    @Column(name = "brojSaobracajne", length = 45)
    private String brojSaobracajne;

    @NotNull
    @Column(name = "datumIzdavanja", nullable = false)
    private LocalDate datumIzdavanja;

    @Size(max = 45)
    @Column(name = "izdao", length = 45)
    private String izdao;

    @Size(max = 45)
    @Column(name = "homologacija", length = 45)
    private String homologacija;

    @Size(max = 45)
    @Column(name = "sasija", length = 45)
    private String sasija;

    @Size(max = 45)
    @Column(name = "brojMotora", length = 45)
    private String brojMotora;

    @Column(name = "snagaMotora")
    private Double snagaMotora;

    @Column(name = "zapreminaMotora")
    private Integer zapreminaMotora;

    @Column(name = "zapreminaRezervoara")
    private Integer zapreminaRezervoara;

    @Column(name = "zapreminaRezervoaraAdBlue")
    private Integer zapreminaRezervoaraAdBlue;

    @Size(max = 45)
    @Column(name = "boja", length = 45)
    private String boja;

    @Size(max = 45)
    @Column(name = "masa", length = 45)
    private String masa;

    @Size(max = 45)
    @Column(name = "ukupnaMasa", length = 45)
    private String ukupnaMasa;

    @Size(max = 45)
    @Column(name = "kategorija", length = 45)
    private String kategorija;

    @Size(max = 45)
    @Column(name = "nosivost", length = 45)
    private String nosivost;

    @Column(name = "mestaSedenja")
    private Integer mestaSedenja;

    @ManyToOne(fetch = FetchType.LAZY)
    @Column(name = "saobracajna2Id")
    private DhVoziloSaobracajna2 saobracajna2;

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

    public CjVozilo getVozilo() {
        return vozilo;
    }

    public void setVozilo(CjVozilo vozilo) {
        this.vozilo = vozilo;
    }

    public String getBrojSaobracajne() {
        return brojSaobracajne;
    }

    public void setBrojSaobracajne(String brojSaobracajne) {
        this.brojSaobracajne = brojSaobracajne;
    }

    public LocalDate getDatumIzdavanja() {
        return datumIzdavanja;
    }

    public void setDatumIzdavanja(LocalDate datumIzdavanja) {
        this.datumIzdavanja = datumIzdavanja;
    }

    public String getIzdao() {
        return izdao;
    }

    public void setIzdao(String izdao) {
        this.izdao = izdao;
    }

    public String getHomologacija() {
        return homologacija;
    }

    public void setHomologacija(String homologacija) {
        this.homologacija = homologacija;
    }

    public String getSasija() {
        return sasija;
    }

    public void setSasija(String sasija) {
        this.sasija = sasija;
    }

    public String getBrojMotora() {
        return brojMotora;
    }

    public void setBrojMotora(String brojMotora) {
        this.brojMotora = brojMotora;
    }

    public Double getSnagaMotora() {
        return snagaMotora;
    }

    public void setSnagaMotora(Double snagaMotora) {
        this.snagaMotora = snagaMotora;
    }

    public Integer getZapreminaMotora() {
        return zapreminaMotora;
    }

    public void setZapreminaMotora(Integer zapreminaMotora) {
        this.zapreminaMotora = zapreminaMotora;
    }

    public Integer getZapreminaRezervoara() {
        return zapreminaRezervoara;
    }

    public void setZapreminaRezervoara(Integer zapreminaRezervoara) {
        this.zapreminaRezervoara = zapreminaRezervoara;
    }

    public Integer getZapreminaRezervoaraAdBlue() {
        return zapreminaRezervoaraAdBlue;
    }

    public void setZapreminaRezervoaraAdBlue(Integer zapreminaRezervoaraAdBlue) {
        this.zapreminaRezervoaraAdBlue = zapreminaRezervoaraAdBlue;
    }

    public String getBoja() {
        return boja;
    }

    public void setBoja(String boja) {
        this.boja = boja;
    }

    public String getMasa() {
        return masa;
    }

    public void setMasa(String masa) {
        this.masa = masa;
    }

    public String getUkupnaMasa() {
        return ukupnaMasa;
    }

    public void setUkupnaMasa(String ukupnaMasa) {
        this.ukupnaMasa = ukupnaMasa;
    }

    public String getKategorija() {
        return kategorija;
    }

    public void setKategorija(String kategorija) {
        this.kategorija = kategorija;
    }

    public String getNosivost() {
        return nosivost;
    }

    public void setNosivost(String nosivost) {
        this.nosivost = nosivost;
    }

    public Integer getMestaSedenja() {
        return mestaSedenja;
    }

    public void setMestaSedenja(Integer mestaSedenja) {
        this.mestaSedenja = mestaSedenja;
    }

    public DhVoziloSaobracajna2 getSaobracajna2() {
        return saobracajna2;
    }

    public void setSaobracajna2(DhVoziloSaobracajna2 saobracajna2) {
        this.saobracajna2 = saobracajna2;
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
