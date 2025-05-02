package rs.prati.service.mapper;

import org.mapstruct.*;
import rs.prati.core.model.AbSistemPretplatnici;
import rs.prati.core.model.AcOrganizacije;
import rs.prati.core.model.BbObjekti;
import rs.prati.core.model.CjVozilo;
import rs.prati.service.dto.BbObjektiDto;

/**
 * MapStruct мапер за BbObjekti и BbObjektiDto.
 */
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface BbObjektiMapper extends EntityMapper<BbObjekti, BbObjektiDto> {

    @Override
    @Mapping(target = "pretplatnikId", source = "pretplatnik.id")
    @Mapping(target = "organizacijaId", source = "organizacija.id")
    @Mapping(target = "voziloId", source = "vozilo.id")
    BbObjektiDto toDto(BbObjekti entity);

    @Override
    @Mapping(target = "pretplatnik", source = "pretplatnikId", qualifiedByName = "mapPretplatnikFromId")
    @Mapping(target = "organizacija", source = "organizacijaId", qualifiedByName = "mapOrganizacijaFromId")
    @Mapping(target = "vozilo", source = "voziloId", qualifiedByName = "mapVoziloFromId")
    BbObjekti toEntity(BbObjektiDto dto);

    @Named("mapPretplatnikFromId")
    static AbSistemPretplatnici mapPretplatnikFromId(Long id) {
        if (id == null) return null;
        AbSistemPretplatnici p = new AbSistemPretplatnici();
        p.setId(id);
        return p;
    }

    @Named("mapOrganizacijaFromId")
    static AcOrganizacije mapOrganizacijaFromId(Long id) {
        if (id == null) return null;
        AcOrganizacije o = new AcOrganizacije();
        o.setId(id);
        return o;
    }

    @Named("mapVoziloFromId")
    static CjVozilo mapVoziloFromId(Long id) {
        if (id == null) return null;
        CjVozilo v = new CjVozilo();
        v.setId(id); // ОБАВЕЗНО: у CjVozilo мора постојати public void setId(Long id)
        return v;
    }
}
