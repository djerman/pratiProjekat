package rs.prati.service.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.ReportingPolicy;
import rs.prati.core.model.*;
import rs.prati.service.dto.DjTroskoviDto;

/**
 * MapStruct мапер за ентитет DjTroskovi и његов DTO.
 */
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface DjTroskoviMapper extends EntityMapper<DjTroskovi, DjTroskoviDto> {

    @Override
    @Mappings({
        @Mapping(source = "pretplatnik.id", target = "pretplatnikId"),
        @Mapping(source = "organizacija.id", target = "organizacijaId"),
        @Mapping(source = "racun.id", target = "racunId"),
        @Mapping(source = "partner.id", target = "partnerId"),
        @Mapping(source = "objekat.id", target = "objekatId"),
        @Mapping(source = "tipGoriva.id", target = "tipGorivaId")
    })
    DjTroskoviDto toDto(DjTroskovi entity);

    @Override
    @Mappings({
        @Mapping(target = "pretplatnik", expression = "java(mapPretplatnik(dto.getPretplatnikId()))"),
        @Mapping(target = "organizacija", expression = "java(mapOrganizacija(dto.getOrganizacijaId()))"),
        @Mapping(target = "racun", expression = "java(mapRacun(dto.getRacunId()))"),
        @Mapping(target = "partner", expression = "java(mapPartner(dto.getPartnerId()))"),
        @Mapping(target = "objekat", expression = "java(mapObjekat(dto.getObjekatId()))"),
        @Mapping(target = "tipGoriva", expression = "java(mapTipGoriva(dto.getTipGorivaId()))")
    })
    DjTroskovi toEntity(DjTroskoviDto dto);

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

    default DjRacuni mapRacun(Long id) {
        if (id == null) return null;
        DjRacuni e = new DjRacuni();
        e.setId(id);
        return e;
    }

    default BgPartneri mapPartner(Long id) {
        if (id == null) return null;
        BgPartneri e = new BgPartneri();
        e.setId(id);
        return e;
    }

    default BbObjekti mapObjekat(Long id) {
        if (id == null) return null;
        BbObjekti e = new BbObjekti();
        e.setId(id);
        return e;
    }

    default AeSistemGoriva mapTipGoriva(Long id) {
        if (id == null) return null;
        AeSistemGoriva e = new AeSistemGoriva();
        e.setId(id);
        return e;
    }
}
