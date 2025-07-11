package rs.prati.service.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.ReportingPolicy;
import rs.prati.core.model.AbSistemPretplatnici;
import rs.prati.core.model.AcOrganizacije;
import rs.prati.core.model.DgVoziloSaobracajna;
import rs.prati.core.model.DhVoziloSaobracajna2;
import rs.prati.service.dto.DhVoziloSaobracajna2Dto;

/**
 * MapStruct мапер за ентитет DhVoziloSaobracajna2 и његов DTO.
 */
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface DhVoziloSaobracajna2Mapper extends EntityMapper<DhVoziloSaobracajna2, DhVoziloSaobracajna2Dto> {

    @Override
    @Mappings({
        @Mapping(source = "pretplatnik.id", target = "pretplatnikId"),
        @Mapping(source = "organizacija.id", target = "organizacijaId"),
        @Mapping(source = "saobracajna.id", target = "saobracajnaId")
    })
    DhVoziloSaobracajna2Dto toDto(DhVoziloSaobracajna2 entity);

    @Override
    @Mappings({
        @Mapping(target = "pretplatnik", expression = "java(mapPretplatnik(dto.getPretplatnikId()))"),
        @Mapping(target = "organizacija", expression = "java(mapOrganizacija(dto.getOrganizacijaId()))"),
        @Mapping(target = "saobracajna", expression = "java(mapSaobracajna(dto.getSaobracajnaId()))")
    })
    DhVoziloSaobracajna2 toEntity(DhVoziloSaobracajna2Dto dto);

    // Помоћне методе за мапирање ID → Entity

    default AbSistemPretplatnici mapPretplatnik(Long id) {
        if (id == null) {
            return null;
        }
        AbSistemPretplatnici e = new AbSistemPretplatnici();
        e.setId(id);
        return e;
    }

    default AcOrganizacije mapOrganizacija(Long id) {
        if (id == null) {
            return null;
        }
        AcOrganizacije e = new AcOrganizacije();
        e.setId(id);
        return e;
    }

    default DgVoziloSaobracajna mapSaobracajna(Long id) {
        if (id == null) {
            return null;
        }
        DgVoziloSaobracajna e = new DgVoziloSaobracajna();
        e.setId(id);
        return e;
    }
}
