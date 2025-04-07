package rs.prati.core.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.time.LocalDate;
import java.time.LocalDateTime;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "cj_vozilo")
public class CjVozilo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Version
    @NotNull
    @Column(name = "version")
    private Integer version;

    @NotNull
    @Column(name = "pretplatnikId")
    private Long pretplatnikId;

    @Column(name = "organizacijaId")
    private Long organizacijaId;

    @NotNull
    @Column(name = "objekatId")
    private Long objekatId;

    @NotNull
    @Size(max = 45)
    @Column(name = "registracija")
    private String registracija;

    @NotNull
    @Size(max = 45)
    @Column(name = "marka")
    private String marka;

    @NotNull
    @Size(max = 45)
    @Column(name = "model")
    private String model;

    @Size(max = 45)
    @Column(name = "tip")
    private String tip;

    @NotNull
    @Column(name = "godina")
    private Integer godina;

    @Column(name = "gorivo")
    private Long gorivo;

    @Column(name = "rezervoar")
    private Integer rezervoar;

    @Column(name = "potrosnja")
    private Float potrosnja;

    @NotNull
    @Column(name = "teretno")
    private Boolean teretno;

    @Size(max = 45)
    @Column(name = "brojSaobracajne")
    private String brojSaobracajne;

    @Column(name = "saobracajnaId")
    private Long saobracajnaId;

    @Size(max = 45)
    @Column(name = "serijskiBroj")
    private String serijskiBroj;

    @Column(name = "datumRegistracije")
    private LocalDate datumRegistracije;

    @NotNull
    @Column(name = "maliServisKm")
    private Integer maliServisKm;

    @NotNull
    @Column(name = "maliServisMeseci")
    private Integer maliServisMeseci;

    @NotNull
    @Column(name = "velikiServisKm")
    private Integer velikiServisKm;

    @NotNull
    @Column(name = "velikiServisMeseci")
    private Integer velikiServisMeseci;

    @Column(name = "datumPoslednjeRegistracije")
    private LocalDate datumPoslednjeRegistracije;

    @Column(name = "maliPoslednjiDatum")
    private LocalDate maliPoslednjiDatum;

    @NotNull
    @Column(name = "maliPoslednjiGPSkm")
    private Float maliPoslednjiGPSkm;

    @NotNull
    @Column(name = "maliPoslednjiOBDkm")
    private Integer maliPoslednjiOBDkm;

    @Column(name = "velikiPoslednjiDatum")
    private LocalDate velikiPoslednjiDatum;

    @NotNull
    @Column(name = "velikiPoslednjiGPSkm")
    private Float velikiPoslednjiGPSkm;

    @NotNull
    @Column(name = "velikiPoslednjiOBDkm")
    private Integer velikiPoslednjiOBDkm;

    @NotNull
    @Column(name = "izbrisan")
    private Boolean izbrisan;

    @Column(name = "kreirano", updatable = false)
    @CreationTimestamp
    private LocalDateTime kreirano;

    @Column(name = "izmenjeno")
    @UpdateTimestamp
    private LocalDateTime izmenjeno;

    // гетери и сетери изостављени ради прегледности
}
