package rs.prati.core.model;

import java.io.Serializable;
import java.util.Objects;

public class DxObjektiPoslednjeId implements Serializable {

    private static final long serialVersionUID = 1L;
	private Long id;
    private Long objekatId;

    public DxObjektiPoslednjeId() {}

    public DxObjektiPoslednjeId(Long id, Long objekatId) {
        this.id = id;
        this.objekatId = objekatId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DxObjektiPoslednjeId that)) return false;
        return Objects.equals(id, that.id) && Objects.equals(objekatId, that.objekatId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, objekatId);
    }
}
