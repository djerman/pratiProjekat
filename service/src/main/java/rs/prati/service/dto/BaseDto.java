
package rs.prati.service.dto;

/**
 * Апстрактна базна класа коју наслеђују све DTO класе које имају заједничка поља:
 * id, version, izbrisan
 */
public abstract class BaseDto {

    protected Long id;
    protected Integer version;
    protected Boolean izbrisan;

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

    public Boolean getIzbrisan() {
        return izbrisan;
    }

    public void setIzbrisan(Boolean izbrisan) {
        this.izbrisan = izbrisan;
    }
}
