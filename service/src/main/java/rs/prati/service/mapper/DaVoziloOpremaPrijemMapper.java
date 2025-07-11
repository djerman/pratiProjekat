package rs.prati.service.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.ReportingPolicy;

import rs.prati.core.model.AbSistemPretplatnici;
import rs.prati.core.model.AcOrganizacije;
import rs.prati.core.model.CkVoziloPrimoPredaja;
import rs.prati.core.model.BhVoziloOprema;
import rs.prati.core.model.DaVoziloOpremaPrijem;
import rs.prati.service.dto.DaVoziloOpremaPrijemDto;

/**
 * MapStruct мапер за ентитет DaVoziloOpremaPrijem и његов DTO.
 */
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface DaVoziloOpremaPrijemMapper extends EntityMapper<DaVoziloOpremaPrijem, DaVoziloOpremaPrijemDto> {

    @Override
    @Mappings({
        @Mapping(source = "pretplatnik.id", target = "pretplatnikId"),
        @Mapping(source = "organizacija.id", target = "organizacijaId"),
        @Mapping(source = "primoPredaja.id", target = "primoPredajaId"),
        @Mapping(source = "oprema.id", target = "opremaId")
    })
    DaVoziloOpremaPrijemDto toDto(DaVoziloOpremaPrijem entity);

    @Override
    @Mappings({
        @Mapping(target = "pretplatnik", expression = "java(mapPretplatnik(dto.getPretplatnikId()))"),
        @Mapping(target = "organizacija", expression = "java(mapOrganizacija(dto.getOrganizacijaId()))"),
        @Mapping(target = "primoPredaja", expression = "java(mapPrimoPredaja(dto.getPrimoPredajaId()))"),
        @Mapping(target = "oprema", expression = "java(mapOprema(dto.getOpremaId()))")
    })
    DaVoziloOpremaPrijem toEntity(DaVoziloOpremaPrijemDto dto);

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

    default CkVoziloPrimoPredaja mapPrimoPredaja(Long id) {
        if (id == null) return null;
        CkVoziloPrimoPredaja e = new CkVoziloPrimoPredaja();
        e.setId(id);
        return e;
    }

    default BhVoziloOprema mapOprema(Long id) {
        if (id == null) return null;
        BhVoziloOprema e = new BhVoziloOprema();
        e.setId(id);
        return e;
    }
}
