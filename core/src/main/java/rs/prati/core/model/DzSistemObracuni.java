package rs.prati.core.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalDateTime;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "dz_sistemObracuni")
public class DzSistemObracuni {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Version
    @NotNull
    @Column(name = "version")
    private Integer version;

    @Column(name = "datum")
    private LocalDate datum;

    @NotNull
    @Column(name = "objekatId")
    private Long objekatId;

    @NotNull
    @Column(name = "odoGPS")
    private Float odoGPS;

    @NotNull
    @Column(name = "gpsKm")
    private Float gpsKm;

    @NotNull
    @Column(name = "brzinaProsecna")
    private Integer brzinaProsecna;

    @NotNull
    @Column(name = "brzinaMaks")
    private Integer brzinaMaks;

    @NotNull
    @Column(name = "obdKm")
    private Integer obdKm;

    @NotNull
    @Column(name = "odoObd")
    private Integer odoObd;

    @NotNull
    @Column(name = "potrosnjaUkupna")
    private Float potrosnjaUkupna;

    @NotNull
    @Column(name = "potrosnjaProsek")
    private Float potrosnjaProsek;

    @NotNull
    @Column(name = "rpmProsek")
    private Integer rpmProsek;

    @NotNull
    @Column(name = "rpmMaks")
    private Integer rpmMaks;

    @NotNull
    @Column(name = "opterecenjeProsek")
    private Float opterecenjeProsek;

    @NotNull
    @Column(name = "opterecenjeMaks")
    private Float opterecenjeMaks;

    @NotNull
    @Column(name = "tempProsek")
    private Integer tempProsek;

    @NotNull
    @Column(name = "tempMaks")
    private Integer tempMaks;

    @Column(name = "kreirano", updatable = false)
    @CreationTimestamp
    private LocalDateTime kreirano;

    @Column(name = "izmenjeno")
    @UpdateTimestamp
    private LocalDateTime izmenjeno;

    // Getери и сетери се додају у наредном кораку
}
