package rs.prati.service.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.Size;

/**
 * DTO класа за ентитет AaSistem.
 * Користи се за пренос података о системским параметрима.
 * Наслеђује заједничка поља из BaseDto.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AaSistemDto extends BaseDto {

    /** Назив власника система. */
    @Size(max = 255)
    private String vlasnik;

    /** Адреса власника система. */
    @Size(max = 255)
    private String adresaVlasnika;

    /** Веб сајт власника. */
    @Size(max = 255)
    private String sajtVlasnika;

    /** Број телефона власника. */
    @Size(max = 255)
    private String telVlasnika;

    /** Електронска пошта власника. */
    @Size(max = 255)
    private String emailVlasnika;

    /** API кључ за интеграције. */
    @Size(max = 255)
    private String api;

    /** Да ли се користи сервер мапе. */
    private Boolean serverMape;

    /** Адреса сервера за мапе. */
    @Size(max = 255)
    private String adresaServeraMape;

    /** Адреса Nominatim сервиса. */
    @Size(max = 255)
    private String nominatimAdresa;

    /** SMTP сервер за е-пошту. */
    @Size(max = 255)
    private String emailServer;

    /** Порт SMTP сервера. */
    private Integer emailServerPort;

    /** Корисничко име за слање е-поште. */
    @Size(max = 255)
    private String emailKorisnik;

    /** Лозинка за е-пошту. */
    @Size(max = 255)
    private String emailLozinka;

    // Геттер-и и сеттер-и

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
