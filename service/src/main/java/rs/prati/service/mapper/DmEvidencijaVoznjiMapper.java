package rs.prati.service.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.ReportingPolicy;
import rs.prati.core.model.*;
import rs.prati.service.dto.DmEvidencijaVoznjiDto;

/**
 * MapStruct мапер за ентитет DmEvidencijaVoznji и његов DTO.
 */
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface DmEvidencijaVoznjiMapper extends EntityMapper<DmEvidencijaVoznji, DmEvidencijaVoznjiDto> {

    @Override
    @Mappings({
        @Mapping(source = "pretplatnik.id", target = "pretplatnikId"),
        @Mapping(source = "organizacija.id", target = "organizacijaId"),
        @Mapping(source = "voziloNalog.id", target = "voziloNalogId"),
        @Mapping(source = "vozilo.id", target = "voziloId"),
        @Mapping(source = "vozac.id", target = "vozacId"),
        @Mapping(source = "uradio.id", target = "uradioId")
    })
    DmEvidencijaVoznjiDto toDto(DmEvidencijaVoznji entity);

    @Override
    @Mappings({
        @Mapping(target = "pretplatnik", expression = "java(mapPretplatnik(dto.getPretplatnikId()))"),
        @Mapping(target = "organizacija", expression = "java(mapOrganizacija(dto.getOrganizacijaId()))"),
        @Mapping(target = "voziloNalog", expression = "java(mapVoziloNalog(dto.getVoziloNalogId()))"),
        @Mapping(target = "vozilo", expression = "java(mapVozilo(dto.getVoziloId()))"),
        @Mapping(target = "vozac", expression = "java(mapVozac(dto.getVozacId()))"),
        @Mapping(target = "uradio", expression = "java(mapUradio(dto.getUradioId()))")
    })
    DmEvidencijaVoznji toEntity(DmEvidencijaVoznjiDto dto);

    /** Мапирање ID → AbSistemPretplatnici. */
    default AbSistemPretplatnici mapPretplatnik(Long id) {
        if (id == null) {
            return null;
        }
        AbSistemPretplatnici e = new AbSistemPretplatnici();
        e.setId(id);
        return e;
    }

    /** Мапирање ID → AcOrganizacije. */
    default AcOrganizacije mapOrganizacija(Long id) {
        if (id == null) {
            return null;
        }
        AcOrganizacije e = new AcOrganizacije();
        e.setId(id);
        return e;
    }

    /** Мапирање ID → DnVoziloNalog. */
    default ClVoziloNalog mapVoziloNalog(Long id) {
        if (id == null) {
            return null;
        }
        ClVoziloNalog e = new ClVoziloNalog();
        e.setId(id);
        return e;
    }

    /** Мапирање ID → CjVozilo. */
    default CjVozilo mapVozilo(Long id) {
        if (id == null) {
            return null;
        }
        CjVozilo e = new CjVozilo();
        e.setId(id);
        return e;
    }

    /** Мапирање ID → DfVozaci. */
    default CiVozaci mapVozac(Long id) {
        if (id == null) {
            return null;
        }
        CiVozaci e = new CiVozaci();
        e.setId(id);
        return e;
    }

    /** Мапирање ID → BaKorisnici. */
    default BaKorisnici mapUradio(Long id) {
        if (id == null) {
            return null;
        }
        BaKorisnici e = new BaKorisnici();
        e.setId(id);
        return e;
    }
}
