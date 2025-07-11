package rs.prati.service.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.ReportingPolicy;
import rs.prati.core.model.AbSistemPretplatnici;
import rs.prati.core.model.AcOrganizacije;
import rs.prati.core.model.BgPartneri;
import rs.prati.core.model.BaKorisnici;
import rs.prati.core.model.DjRacuni;
import rs.prati.service.dto.DjRacuniDto;

/**
 * MapStruct мапер за ентитет DjRacuni и његов DTO.
 */
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface DjRacuniMapper extends EntityMapper<DjRacuni, DjRacuniDto> {

    @Override
    @Mappings({
        @Mapping(source = "pretplatnik.id", target = "pretplatnikId"),
        @Mapping(source = "organizacija.id", target = "organizacijaId"),
        @Mapping(source = "partner.id", target = "partnerId"),
        @Mapping(source = "korisnik.id", target = "korisnikId")
    })
    DjRacuniDto toDto(DjRacuni entity);

    @Override
    @Mappings({
        @Mapping(target = "pretplatnik", expression = "java(mapPretplatnik(dto.getPretplatnikId()))"),
        @Mapping(target = "organizacija", expression = "java(mapOrganizacija(dto.getOrganizacijaId()))"),
        @Mapping(target = "partner", expression = "java(mapPartner(dto.getPartnerId()))"),
        @Mapping(target = "korisnik", expression = "java(mapKorisnik(dto.getKorisnikId()))")
    })
    DjRacuni toEntity(DjRacuniDto dto);

    // Помоћне методе за мапирање ID → Entity

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

    default BaKorisnici mapKorisnik(Long id) {
        if (id == null) return null;
        BaKorisnici e = new BaKorisnici();
        e.setId(id);
        return e;
    }
}
