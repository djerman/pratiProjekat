package rs.prati.core.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.time.LocalDate;
import java.time.LocalDateTime;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "ck_voziloPrimoPredaja")
public class CkVoziloPrimoPredaja {

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

    @Size(max = 45)
    @Column(name = "broj")
    private String broj;

    @NotNull
    @Column(name = "datum")
    private LocalDate datum;

    @NotNull
    @Column(name = "voziloId")
    private Long voziloId;

    @Column(name = "vozacPredaja")
    private Long vozacPredaja;

    @NotNull
    @Column(name = "administrator")
    private Long administrator;

    @NotNull
    @Column(name = "vozacPrijem")
    private Long vozacPrijem;

    @Size(max = 45)
    @Column(name = "komentar")
    private String komentar;

    @Column(name = "kreirano", updatable = false)
    @CreationTimestamp
    private LocalDateTime kreirano;

    @Column(name = "izmenjeno")
    @UpdateTimestamp
    private LocalDateTime izmenjeno;

    @NotNull
    @Column(name = "izbrisan")
    private Boolean izbrisan;

    // Гетери и сетери могу се додати по потреби
}
