
package rs.prati.core.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "ab_sistemPretplatnici")
public class AbSistemPretplatnici extends BaseEntity {

    @Column(name = "naziv")
    private String naziv;

    @Column(name = "sistem")
    private Boolean sistem;

    @Column(name = "email")
    private String email;

    @Column(name = "aktivan")
    private Boolean aktivan;

    @Column(name = "aktivanDo")
    private LocalDate aktivanDo;

    @Column(name = "apiKey")
    private String apiKey;

    @Column(name = "tip")
    private Boolean tip;

    @Column(name = "nadzorId")
    private Long nadzorId;

    @Column(name = "gMapa")
    private Boolean gMapa;

    // Getтери и сеттери

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public Boolean getSistem() {
        return sistem;
    }

    public void setSistem(Boolean sistem) {
        this.sistem = sistem;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getAktivan() {
        return aktivan;
    }

    public void setAktivan(Boolean aktivan) {
        this.aktivan = aktivan;
    }

    public LocalDate getAktivanDo() {
        return aktivanDo;
    }

    public void setAktivanDo(LocalDate aktivanDo) {
        this.aktivanDo = aktivanDo;
    }

    public String getApiKey() {
        return apiKey;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

    public Boolean getTip() {
        return tip;
    }

    public void setTip(Boolean tip) {
        this.tip = tip;
    }

    public Long getNadzorId() {
        return nadzorId;
    }

    public void setNadzorId(Long nadzorId) {
        this.nadzorId = nadzorId;
    }

    public Boolean getGMapa() {
        return gMapa;
    }

    public void setGMapa(Boolean gMapa) {
        this.gMapa = gMapa;
    }
}
