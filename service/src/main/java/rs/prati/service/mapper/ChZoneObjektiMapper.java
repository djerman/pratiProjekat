package rs.prati.service.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.ReportingPolicy;
import rs.prati.core.model.AbSistemPretplatnici;
import rs.prati.core.model.AcOrganizacije;
import rs.prati.core.model.BfZone;
import rs.prati.core.model.BbObjekti;
import rs.prati.core.model.ChZoneObjekti;
import rs.prati.service.dto.ChZoneObjektiDto;

/**
 * MapStruct мапер за ентитет ChZoneObjekti и његов DTO.
 */
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ChZoneObjektiMapper extends EntityMapper<ChZoneObjekti, ChZoneObjektiDto> {

    @Override
    @Mappings({
        @Mapping(source = "zopretplatnik.id", target = "zopretplatnikId"),
        @Mapping(source = "zoorganizacija.id", target = "zoorganizacijaId"),
        @Mapping(source = "zona.id", target = "zonaId"),
        @Mapping(source = "objekat.id", target = "objekatId")
    })
    ChZoneObjektiDto toDto(ChZoneObjekti entity);

    @Override
    @Mappings({
        @Mapping(target = "zopretplatnik", expression = "java(mapPretplatnik(dto.getZopretplatnikId()))"),
        @Mapping(target = "zoorganizacija", expression = "java(mapOrganizacija(dto.getZoorganizacijaId()))"),
        @Mapping(target = "zona", expression = "java(mapZona(dto.getZonaId()))"),
        @Mapping(target = "objekat", expression = "java(mapObjekat(dto.getObjekatId()))")
    })
    ChZoneObjekti toEntity(ChZoneObjektiDto dto);

    // Помоћне методе за ID→Entity (користи се само setId)

    default AbSistemPretplatnici mapPretplatnik(Long id) {
        if (id == null) return null;
        AbSistemPretplatnici p = new AbSistemPretplatnici();
        p.setId(id);
        return p;
    }

    default AcOrganizacije mapOrganizacija(Long id) {
        if (id == null) return null;
        AcOrganizacije o = new AcOrganizacije();
        o.setId(id);
        return o;
    }

    default BfZone mapZona(Long id) {
        if (id == null) return null;
        BfZone z = new BfZone();
        z.setId(id);
        return z;
    }

    default BbObjekti mapObjekat(Long id) {
        if (id == null) return null;
        BbObjekti obj = new BbObjekti();
        obj.setId(id);
        return obj;
    }
}
