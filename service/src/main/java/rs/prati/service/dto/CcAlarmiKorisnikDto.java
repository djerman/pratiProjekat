package rs.prati.service.dto;

import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;

/**
 * DTO за ентитет CcAlarmiKorisnik.
 * Представља податке о вези корисника и аларма, начин обавештавања и статус.
 */
public class CcAlarmiKorisnikDto extends BaseDto {

    /** ID претплатника коме овај запис припада */
    @NotNull
    private Long pretplatnikId;

    /** ID организације (ако постоји) у оквиру претплатника */
    private Long organizacijaId;

    /** ID корисника на кога се односи аларм */
    @NotNull
    private Long korisnikId;

    /** ID објекта на који се односи аларм */
    @NotNull
    private Long objekatId;

    /** ID аларма који је повезан са корисником */
    @NotNull
    private Long alarmId;

    /** Да ли се обавештење шаље путем е‑маила */
    @NotNull
    private Boolean email;

    /** Да ли се приказује интерно обавештење у систему */
    @NotNull
    private Boolean obavestenje;

    /** Да ли је веза активна */
    @NotNull
    private Boolean aktivan;

    /** Датум и време креирања записа */
    private LocalDateTime kreirano;

    /** Датум и време последње измене записа */
    private LocalDateTime izmenjeno;

    // ГЕТЕРИ И СЕТЕРИ

    public Long getPretplatnikId() {
        return pretplatnikId;
    }

    public void setPretplatnikId(Long pretplatnikId) {
        this.pretplatnikId = pretplatnikId;
    }

    public Long getOrganizacijaId() {
        return organizacijaId;
    }

    public void setOrganizacijaId(Long organizacijaId) {
        this.organizacijaId = organizacijaId;
    }

    public Long getKorisnikId() {
        return korisnikId;
    }

    public void setKorisnikId(Long korisnikId) {
        this.korisnikId = korisnikId;
    }

    public Long getObjekatId() {
        return objekatId;
    }

    public void setObjekatId(Long objekatId) {
        this.objekatId = objekatId;
    }

    public Long getAlarmId() {
        return alarmId;
    }

    public void setAlarmId(Long alarmId) {
        this.alarmId = alarmId;
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
