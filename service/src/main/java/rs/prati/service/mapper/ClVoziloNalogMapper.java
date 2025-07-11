package rs.prati.service.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.ReportingPolicy;
import rs.prati.core.model.AbSistemPretplatnici;
import rs.prati.core.model.AcOrganizacije;
import rs.prati.core.model.CiVozaci;
import rs.prati.core.model.CjVozilo;
import rs.prati.core.model.ClVoziloNalog;
import rs.prati.service.dto.ClVoziloNalogDto;

/**
 * MapStruct мапер за ентитет ClVoziloNalog и његов DTO.
 */
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ClVoziloNalogMapper extends EntityMapper<ClVoziloNalog, ClVoziloNalogDto> {

    /**
     * Мапира ентитет у DTO.
     */
    @Override
    @Mappings({
        @Mapping(source = "pretplatnik.id", target = "pretplatnikId"),
        @Mapping(source = "organizacija.id", target = "organizacijaId"),
        @Mapping(source = "vozilo.id", target = "voziloId"),
        @Mapping(source = "vozac.id", target = "vozacId")
    })
    ClVoziloNalogDto toDto(ClVoziloNalog entity);

    /**
     * Мапира DTO у ентитет.
     */
    @Override
    @Mappings({
        @Mapping(target = "pretplatnik", expression = "java(mapPretplatnik(dto.getPretplatnikId()))"),
        @Mapping(target = "organizacija", expression = "java(mapOrganizacija(dto.getOrganizacijaId()))"),
        @Mapping(target = "vozilo", expression = "java(mapVozilo(dto.getVoziloId()))"),
        @Mapping(target = "vozac", expression = "java(mapVozac(dto.getVozacId()))")
    })
    ClVoziloNalog toEntity(ClVoziloNalogDto dto);

    // --- Помоћне методе за мапирање ID → Entity ---

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

    default CjVozilo mapVozilo(Long id) {
        if (id == null) return null;
        CjVozilo e = new CjVozilo();
        e.setId(id);
        return e;
    }

    default CiVozaci mapVozac(Long id) {
        if (id == null) return null;
        CiVozaci e = new CiVozaci();
        e.setId(id);
        return e;
    }
}
