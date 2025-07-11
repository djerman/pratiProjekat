package rs.prati.service.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.ReportingPolicy;
import rs.prati.core.model.AbSistemPretplatnici;
import rs.prati.core.model.AcOrganizacije;
import rs.prati.core.model.CjVozilo;
import rs.prati.core.model.DgVoziloSaobracajna;
import rs.prati.service.dto.DgVoziloSaobracajnaDto;

/**
 * MapStruct мапер за ентитет DgVoziloSaobracajna и његов DTO.
 */
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface DgVoziloSaobracajnaMapper extends EntityMapper<DgVoziloSaobracajna, DgVoziloSaobracajnaDto> {

    @Override
    @Mappings({
        @Mapping(source = "pretplatnik.id", target = "pretplatnikId"),
        @Mapping(source = "organizacija.id", target = "organizacijaId"),
        @Mapping(source = "vozilo.id", target = "voziloId"),
        @Mapping(source = "saobracajna2.id", target = "saobracajna2Id")
    })
    DgVoziloSaobracajnaDto toDto(DgVoziloSaobracajna entity);

    @Override
    @Mappings({
        @Mapping(target = "pretplatnik", expression = "java(mapPretplatnik(dto.getPretplatnikId()))"),
        @Mapping(target = "organizacija", expression = "java(mapOrganizacija(dto.getOrganizacijaId()))"),
        @Mapping(target = "vozilo", expression = "java(mapVozilo(dto.getVoziloId()))"),
        @Mapping(target = "saobracajna2", expression = "java(mapSaobracajna2(dto.getSaobracajna2()))")
    })
    DgVoziloSaobracajna toEntity(DgVoziloSaobracajnaDto dto);

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

    default CjVozilo mapVozilo(Long id) {
        if (id == null) return null;
        CjVozilo e = new CjVozilo();
        e.setId(id);
        return e;
    }

    default DgVoziloSaobracajna mapSaobracajna2(Long id) {
        if (id == null) return null;
        DgVoziloSaobracajna e = new DgVoziloSaobracajna();
        e.setId(id);
        return e;
    }
}
