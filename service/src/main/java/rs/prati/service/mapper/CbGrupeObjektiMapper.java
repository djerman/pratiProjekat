package rs.prati.service.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.ReportingPolicy;

import rs.prati.core.model.AbSistemPretplatnici;
import rs.prati.core.model.AcOrganizacije;
import rs.prati.core.model.BbObjekti;
import rs.prati.core.model.BeGrupe;
import rs.prati.core.model.CbGrupeObjekti;
import rs.prati.service.dto.CbGrupeObjektiDto;

/**
 * MapStruct мапер за ентитет CbGrupeObjekti и његов DTO.
 */
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CbGrupeObjektiMapper extends EntityMapper<CbGrupeObjekti, CbGrupeObjektiDto> {

    /**
     * Мапира ентитет у DTO.
     */
    @Override
    @Mappings({
        @Mapping(source = "pretplatnik.id", target = "pretplatnikId"),
        @Mapping(source = "organizacija.id", target = "organizacijaId"),
        @Mapping(source = "grupa.id", target = "grupaId"),
        @Mapping(source = "objekat.id", target = "objekatId")
    })
    CbGrupeObjektiDto toDto(CbGrupeObjekti entity);

    /**
     * Мапира DTO у ентитет.
     */
    @Override
    @Mappings({
        @Mapping(target = "pretplatnik", expression = "java(mapPretplatnik(dto.getPretplatnikId()))"),
        @Mapping(target = "organizacija", expression = "java(mapOrganizacija(dto.getOrganizacijaId()))"),
        @Mapping(target = "grupa", expression = "java(mapGrupa(dto.getGrupaId()))"),
        @Mapping(target = "objekat", expression = "java(mapObjekat(dto.getObjekatId()))")
    })
    CbGrupeObjekti toEntity(CbGrupeObjektiDto dto);

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

    default BeGrupe mapGrupa(Long id) {
        if (id == null) return null;
        BeGrupe e = new BeGrupe();
        e.setId(id);
        return e;
    }

    default BbObjekti mapObjekat(Long id) {
        if (id == null) return null;
        BbObjekti e = new BbObjekti();
        e.setId(id);
        return e;
    }
}
