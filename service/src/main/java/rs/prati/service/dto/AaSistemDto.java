package rs.prati.service.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.Email;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class AaSistemDto {

    private Integer id;

    private String vlasnik;
    private String adresaVlasnika;
    private String sajtVlasnika;
    private String telVlasnika;

    @Email
    private String emailVlasnika;

    private String api;
    private Boolean serverMape;
    private String adresaServeraMape;
    private String nominatimAdresa;
    private String emailServer;
    private Integer emailServerPort;
    private String emailKorisnik;
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