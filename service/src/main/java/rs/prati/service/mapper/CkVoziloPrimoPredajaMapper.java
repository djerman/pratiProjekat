package rs.prati.service.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.ReportingPolicy;
import rs.prati.core.model.*;
import rs.prati.service.dto.CkVoziloPrimoPredajaDto;

/**
 * MapStruct мапер за ентитет CkVoziloPrimoPredaja и његов DTO.
 */
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CkVoziloPrimoPredajaMapper extends EntityMapper<CkVoziloPrimoPredaja, CkVoziloPrimoPredajaDto> {

    /**
     * Мапира ентитет у DTO.
     */
    @Override
    @Mappings({
        @Mapping(source = "pretplatnik.id", target = "pretplatnikId"),
        @Mapping(source = "organizacija.id", target = "organizacijaId"),
        @Mapping(source = "vozilo.id", target = "voziloId"),
        @Mapping(source = "vozacPredaja.id", target = "vozacPredaja"),
        @Mapping(source = "administrator.id", target = "administrator"),
        @Mapping(source = "vozacPrijem.id", target = "vozacPrijem")
    })
    CkVoziloPrimoPredajaDto toDto(CkVoziloPrimoPredaja entity);

    /**
     * Мапира DTO у ентитет.
     */
    @Override
    @Mappings({
        @Mapping(target = "pretplatnik", expression = "java(mapPretplatnik(dto.getPretplatnikId()))"),
        @Mapping(target = "organizacija", expression = "java(mapOrganizacija(dto.getOrganizacijaId()))"),
        @Mapping(target = "vozilo", expression = "java(mapVozilo(dto.getVoziloId()))"),
        @Mapping(target = "vozacPredaja", expression = "java(mapVozac(dto.getVozacPredaja()))"),
        @Mapping(target = "administrator", expression = "java(mapKorisnik(dto.getAdministrator()))"),
        @Mapping(target = "vozacPrijem", expression = "java(mapVozac(dto.getVozacPrijem()))")
    })
    CkVoziloPrimoPredaja toEntity(CkVoziloPrimoPredajaDto dto);

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

    default BaKorisnici mapKorisnik(Long id) {
        if (id == null) return null;
        BaKorisnici e = new BaKorisnici();
        e.setId(id);
        return e;
    }
}
