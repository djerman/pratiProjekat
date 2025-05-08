package rs.prati.service.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.ReportingPolicy;

import rs.prati.core.model.AbSistemPretplatnici;
import rs.prati.core.model.AcOrganizacije;
import rs.prati.core.model.BaKorisnici;
import rs.prati.core.model.BeGrupe;
import rs.prati.core.model.CaGrupeKorisnici;
import rs.prati.service.dto.CaGrupeKorisniciDto;

/**
 * MapStruct мапер за ентитет CaGrupeKorisnici и његов DTO.
 */
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CaGrupeKorisniciMapper extends EntityMapper<CaGrupeKorisnici, CaGrupeKorisniciDto> {

    /**
     * Мапира ентитет у DTO.
     */
    @Override
    @Mappings({
        @Mapping(source = "pretplatnik.id", target = "pretplatnikId"),
        @Mapping(source = "organizacija.id", target = "organizacijaId"),
        @Mapping(source = "grupa.id", target = "grupaId"),
        @Mapping(source = "korisnik.id", target = "korisnikId")
    })
    CaGrupeKorisniciDto toDto(CaGrupeKorisnici entity);

    /**
     * Мапира DTO у ентитет.
     */
    @Override
    @Mappings({
        @Mapping(target = "pretplatnik", expression = "java(mapPretplatnik(dto.getPretplatnikId()))"),
        @Mapping(target = "organizacija", expression = "java(mapOrganizacija(dto.getOrganizacijaId()))"),
        @Mapping(target = "grupa", expression = "java(mapGrupa(dto.getGrupaId()))"),
        @Mapping(target = "korisnik", expression = "java(mapKorisnik(dto.getKorisnikId()))")
    })
    CaGrupeKorisnici toEntity(CaGrupeKorisniciDto dto);

    // --- Помоћне методе за ентитете по ID-у ---

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

    default BeGrupe mapGrupa(Long id) {
        if (id == null) return null;
        BeGrupe e = new BeGrupe();
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
