package rs.prati.core.model;

import jakarta.persistence.*;

@Entity
@Table(name = "aa_sistem")
public class AaSistem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "vlasnik")
    private String vlasnik;

    @Column(name = "adresaVlasnika")
    private String adresaVlasnika;

    @Column(name = "sajtVlasnika")
    private String sajtVlasnika;

    @Column(name = "telVlasnika")
    private String telVlasnika;

    @Column(name = "emailVlasnika")
    private String emailVlasnika;

    @Column(name = "api")
    private String api;

    @Column(name = "serverMape", columnDefinition = "TINYINT(1)")
    private Boolean serverMape;

    @Column(name = "adresaServeraMape")
    private String adresaServeraMape;

    @Column(name = "nominatimAdresa")
    private String nominatimAdresa;

    @Column(name = "emailServer")
    private String emailServer;

    @Column(name = "emailServerPort")
    private Integer emailServerPort;

    @Column(name = "emailKorisnik")
    private String emailKorisnik;

    @Column(name = "emailLozinka")
    private String emailLozinka;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getVlasnik() {
        return vlasnik;
    }

    public void setVlasnik(String vlasnik) {
        this.vlasnik = vlasnik;
    }

    public String getAdresaVlasnika() {
        return adresaVlasnika;
    }

    public void setAdresaVlasnika(String adresaVlasnika) {
        this.adresaVlasnika = adresaVlasnika;
    }

    public String getSajtVlasnika() {
        return sajtVlasnika;
    }

    public void setSajtVlasnika(String sajtVlasnika) {
        this.sajtVlasnika = sajtVlasnika;
    }

    public String getTelVlasnika() {
        return telVlasnika;
    }

    public void setTelVlasnika(String telVlasnika) {
        this.telVlasnika = telVlasnika;
    }

    public String getEmailVlasnika() {
        return emailVlasnika;
    }

    public void setEmailVlasnika(String emailVlasnika) {
        this.emailVlasnika = emailVlasnika;
    }

    public String getApi() {
        return api;
    }

    public void setApi(String api) {
        this.api = api;
    }

    public Boolean getServerMape() {
        return serverMape;
    }

    public void setServerMape(Boolean serverMape) {
        this.serverMape = serverMape;
    }

    public String getAdresaServeraMape() {
        return adresaServeraMape;
    }

    public void setAdresaServeraMape(String adresaServeraMape) {
        this.adresaServeraMape = adresaServeraMape;
    }

    public String getNominatimAdresa() {
        return nominatimAdresa;
    }

    public void setNominatimAdresa(String nominatimAdresa) {
        this.nominatimAdresa = nominatimAdresa;
    }

    public String getEmailServer() {
        return emailServer;
    }

    public void setEmailServer(String emailServer) {
        this.emailServer = emailServer;
    }

    public Integer getEmailServerPort() {
        return emailServerPort;
    }

    public void setEmailServerPort(Integer emailServerPort) {
        this.emailServerPort = emailServerPort;
    }

    public String getEmailKorisnik() {
        return emailKorisnik;
    }

    public void setEmailKorisnik(String emailKorisnik) {
        this.emailKorisnik = emailKorisnik;
    }

    public String getEmailLozinka() {
        return emailLozinka;
    }

    public void setEmailLozinka(String emailLozinka) {
        this.emailLozinka = emailLozinka;
    }
}
