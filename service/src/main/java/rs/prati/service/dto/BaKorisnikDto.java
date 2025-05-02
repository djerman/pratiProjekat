package rs.prati.service.dto;

import java.util.List;

/**
 * DTO класа која представља корисника након пријаве.
 * Садржи само податке који су потребни UI-ју.
 */
public class BaKorisnikDto {

    private Long id;
    private String email;
    private String ime;
    private List<String> uloge;
    private Long pretplatnikId;

    public BaKorisnikDto() {}

    public BaKorisnikDto(Long id, String email, String ime, List<String> uloge, Long pretplatnikId) {
        this.id = id;
        this.email = email;
        this.ime = ime;
        this.uloge = uloge;
        this.pretplatnikId = pretplatnikId;
    }

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public String getEmail() { return email; }

    public void setEmail(String email) { this.email = email; }

    public String getIme() { return ime; }

    public void setIme(String ime) { this.ime = ime; }

    public List<String> getUloge() { return uloge; }

    public void setUloge(List<String> uloge) { this.uloge = uloge; }

    public Long getPretplatnikId() { return pretplatnikId; }

    public void setPretplatnikId(Long pretplatnikId) { this.pretplatnikId = pretplatnikId; }
}
