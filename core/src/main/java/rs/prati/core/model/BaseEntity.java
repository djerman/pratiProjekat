
package rs.prati.core.model;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

/**
 * Апстрактна базна класа коју наслеђују скоро сви ентитети у систему.
 * Садржи заједничка поља и основну контролу животног циклуса ентитета.
 */
@MappedSuperclass
public abstract class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    @Version
    protected Integer version;

    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    protected LocalDateTime kreirano;

    @UpdateTimestamp
    @Column(nullable = false)
    protected LocalDateTime izmenjeno;

    @Column(nullable = false)
    protected Boolean izbrisan = false;

    // Геттер-и и сеттер-и

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
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

    /**
     * Означава да је ентитет логички избрисан без физичког уклањања из базе.
     */
    public void oznaciIzbrisan() {
        this.izbrisan = true;
    }

}
