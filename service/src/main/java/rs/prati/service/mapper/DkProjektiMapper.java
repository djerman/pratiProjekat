package rs.prati.service.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.ReportingPolicy;
import rs.prati.core.model.*;
import rs.prati.service.dto.DkProjektiDto;

/**
 * MapStruct мапер за ентитет DkProjekti и његов DTO.
 */
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface DkProjektiMapper extends EntityMapper<DkProjekti, DkProjektiDto> {

    @Override
    @Mappings({
        @Mapping(source = "pretplatnik.id", target = "pretplatnikId"),
        @Mapping(source = "organizacija.id", target = "organizacijaId"),
        @Mapping(source = "partner.id", target = "partnerId")
    })
    DkProjektiDto toDto(DkProjekti entity);

    @Override
    @Mappings({
        @Mapping(target = "pretplatnik", expression = "java(mapPretplatnik(dto.getPretplatnikId()))"),
        @Mapping(target = "organizacija", expression = "java(mapOrganizacija(dto.getOrganizacijaId()))"),
        @Mapping(target = "partner", expression = "java(mapPartner(dto.getPartnerId()))")
    })
    DkProjekti toEntity(DkProjektiDto dto);

    default AbSistemPretplatnici mapPretplatnik(Long id) {
        if (id == null) return null;
        AbSistemPretplatnici e = new AbSistemPretplatnici();
        e.setId(id);
        return e;
    }

    default AcOrganizacije mapOrganizacija(Long id) {
        if (id == null) return null;
        AcOrganizacije e = new AcOrganizacije();
        e.setId(id);
        return e;
    }

    default BgPartneri mapPartner(Long id) {
        if (id == null) return null;
        BgPartneri e = new BgPartneri();
        e.setId(id);
        return e;
    }
}
