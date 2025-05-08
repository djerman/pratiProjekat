package rs.prati.service.mapper;

import org.mapstruct.*;
import rs.prati.core.model.BeGrupe;
import rs.prati.service.dto.BeGrupeDto;
import rs.prati.core.model.AbSistemPretplatnici;
import rs.prati.core.model.AcOrganizacije;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface BeGrupeMapper extends EntityMapper<BeGrupe, BeGrupeDto> {

    @Mappings({
        @Mapping(source = "pretplatnik.id", target = "pretplatnikId"),
        @Mapping(source = "organizacija.id", target = "organizacijaId")
    })
    BeGrupeDto toDto(BeGrupe entity);

    @Mappings({
        @Mapping(source = "pretplatnikId", target = "pretplatnik", qualifiedByName = "mapPretplatnikFromId"),
        @Mapping(source = "organizacijaId", target = "organizacija", qualifiedByName = "mapOrganizacijaFromId")
    })
    BeGrupe toEntity(BeGrupeDto dto);

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
}