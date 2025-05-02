package rs.prati.service.mapper;

import org.mapstruct.*;
import rs.prati.core.model.*;
import rs.prati.service.dto.BdSimDto;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface BdSimMapper extends EntityMapper<BdSim, BdSimDto> {

    @Mappings({
        @Mapping(source = "pretplatnik.id", target = "pretplatnikId"),
        @Mapping(source = "organizacija.id", target = "organizacijaId"),
        @Mapping(source = "operater.id", target = "operaterId"),
        @Mapping(source = "uredjaj.id", target = "uredjajId"),
        @Mapping(target = "zauzet", expression = "java(entity.getUredjaj() != null)") // логика изведена јер ентитет не поставља сам
    })
    BdSimDto toDto(BdSim entity);

    @Mappings({
        @Mapping(target = "pretplatnik", source = "pretplatnikId", qualifiedByName = "mapPretplatnikFromId"),
        @Mapping(target = "organizacija", source = "organizacijaId", qualifiedByName = "mapOrganizacijaFromId"),
        @Mapping(target = "operater", source = "operaterId", qualifiedByName = "mapOperaterFromId"),
        @Mapping(target = "uredjaj", source = "uredjajId", qualifiedByName = "mapUredjajFromId")
    })
    BdSim toEntity(BdSimDto dto);

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

    @Named("mapOperaterFromId")
    static AfSistemOperateri mapOperaterFromId(Long id) {
        if (id == null) return null;
        AfSistemOperateri o = new AfSistemOperateri();
        o.setId(id);
        return o;
    }

    @Named("mapUredjajFromId")
    static BcUredjaji mapUredjajFromId(Long id) {
        if (id == null) return null;
        BcUredjaji u = new BcUredjaji();
        u.setId(id);
        return u;
    }
}