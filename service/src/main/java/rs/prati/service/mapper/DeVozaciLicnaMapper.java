package rs.prati.service.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.ReportingPolicy;
import rs.prati.core.model.AbSistemPretplatnici;
import rs.prati.core.model.AcOrganizacije;
import rs.prati.core.model.BaKorisnici;
import rs.prati.core.model.DeVozaciLicna;
import rs.prati.service.dto.DeVozaciLicnaDto;

/**
 * MapStruct мапер за ентитет DeVozaciLicna и његов DTO.
 */
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface DeVozaciLicnaMapper extends EntityMapper<DeVozaciLicna, DeVozaciLicnaDto> {

    @Override
    @Mappings({
        @Mapping(source = "pretplatnik.id", target = "pretplatnikId"),
        @Mapping(source = "organizacija.id", target = "organizacijaId"),
        @Mapping(source = "korisnik.id", target = "korisnikId")
    })
    DeVozaciLicnaDto toDto(DeVozaciLicna entity);

    @Override
    @Mappings({
        @Mapping(target = "pretplatnik", expression = "java(mapPretplatnik(dto.getPretplatnikId()))"),
        @Mapping(target = "organizacija", expression = "java(mapOrganizacija(dto.getOrganizacijaId()))"),
        @Mapping(target = "korisnik", expression = "java(mapKorisnik(dto.getKorisnikId()))")
    })
    DeVozaciLicna toEntity(DeVozaciLicnaDto dto);

    // Помоћне методе за мапирање ID у ентитете

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
