package rs.prati.service.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.ReportingPolicy;

import rs.prati.core.model.AbSistemPretplatnici;
import rs.prati.core.model.AcOrganizacije;
import rs.prati.core.model.BfZone;
import rs.prati.service.dto.BfZoneDto;

/**
 * MapStruct мапер за ентитет BfZone и његов DTO.
 */
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface BfZoneMapper extends EntityMapper<BfZone, BfZoneDto> {

    /**
     * Мапира ентитет у DTO.
     */
    @Override
    @Mappings({
        @Mapping(source = "pretplatnik.id", target = "pretplatnikId"),
        @Mapping(source = "organizacija.id", target = "organizacijaId")
    })
    BfZoneDto toDto(BfZone entity);

    /**
     * Мапира DTO у ентитет.
     */
    @Override
    @Mappings({
        @Mapping(target = "pretplatnik", expression = "java(mapPretplatnik(dto.getPretplatnikId()))"),
        @Mapping(target = "organizacija", expression = "java(mapOrganizacija(dto.getOrganizacijaId()))")
    })
    BfZone toEntity(BfZoneDto dto);

    /**
     * Помоћни метод за мапирање претплатника по ID-у.
     */
    default AbSistemPretplatnici mapPretplatnik(Long id) {
        if (id == null) return null;
        AbSistemPretplatnici p = new AbSistemPretplatnici();
        p.setId(id);
        return p;
    }

    /**
     * Помоћни метод за мапирање организације по ID-у.
     */
    default AcOrganizacije mapOrganizacija(Long id) {
        if (id == null) return null;
        AcOrganizacije o = new AcOrganizacije();
        o.setId(id);
        return o;
    }
}
