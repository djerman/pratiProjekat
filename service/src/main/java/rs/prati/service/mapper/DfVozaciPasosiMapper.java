package rs.prati.service.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.ReportingPolicy;
import rs.prati.core.model.*;
import rs.prati.service.dto.DfVozaciPasosiDto;

/**
 * MapStruct мапер за ентитет DfVozaciPasosi и његов DTO.
 */
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface DfVozaciPasosiMapper extends EntityMapper<DfVozaciPasosi, DfVozaciPasosiDto> {

    @Override
    @Mappings({
        @Mapping(source = "pretplatnik.id", target = "pretplatnikId"),
        @Mapping(source = "organizacija.id", target = "organizacijaId"),
        @Mapping(source = "korisnik.id", target = "korisnikId")
    })
    DfVozaciPasosiDto toDto(DfVozaciPasosi entity);

    @Override
    @Mappings({
        @Mapping(target = "pretplatnik", expression = "java(mapPretplatnik(dto.getPretplatnikId()))"),
        @Mapping(target = "organizacija", expression = "java(mapOrganizacija(dto.getOrganizacijaId()))"),
        @Mapping(target = "korisnik", expression = "java(mapKorisnik(dto.getKorisnikId()))")
    })
    DfVozaciPasosi toEntity(DfVozaciPasosiDto dto);

    // Помоћне методе за ID → Entity

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

    default BaKorisnici mapKorisnik(Long id) {
        if (id == null) return null;
        BaKorisnici e = new BaKorisnici();
        e.setId(id);
        return e;
    }
}
