package rs.prati.service.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.ReportingPolicy;
import rs.prati.core.model.AbSistemPretplatnici;
import rs.prati.core.model.AcOrganizacije;
import rs.prati.core.model.BaKorisnici;
import rs.prati.core.model.DbVozaciDozvole;
import rs.prati.service.dto.DbVozaciDozvoleDto;

/**
 * MapStruct мапер за ентитет DbVozaciDozvole и његов DTO.
 */
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface DbVozaciDozvoleMapper extends EntityMapper<DbVozaciDozvole, DbVozaciDozvoleDto> {

    @Override
    @Mappings({
        @Mapping(source = "pretplatnik.id", target = "pretplatnikId"),
        @Mapping(source = "organizacija.id", target = "organizacijaId"),
        @Mapping(source = "korisnik.id", target = "korisnikId")
    })
    DbVozaciDozvoleDto toDto(DbVozaciDozvole entity);

    @Override
    @Mappings({
        @Mapping(target = "pretplatnik", expression = "java(mapPretplatnik(dto.getPretplatnikId()))"),
        @Mapping(target = "organizacija", expression = "java(mapOrganizacija(dto.getOrganizacijaId()))"),
        @Mapping(target = "korisnik", expression = "java(mapKorisnik(dto.getKorisnikId()))")
    })
    DbVozaciDozvole toEntity(DbVozaciDozvoleDto dto);

    // Помоћне методе за мапирање ID ↔ Entity

    default AbSistemPretplatnici mapPretplatnik(Long id) {
        if (id == null) return null;
        AbSistemPretplatnici entity = new AbSistemPretplatnici();
        entity.setId(id);
        return entity;
    }

    default AcOrganizacije mapOrganizacija(Long id) {
        if (id == null) return null;
        AcOrganizacije entity = new AcOrganizacije();
        entity.setId(id);
        return entity;
    }

    default BaKorisnici mapKorisnik(Long id) {
        if (id == null) return null;
        BaKorisnici entity = new BaKorisnici();
        entity.setId(id);
        return entity;
    }
}
