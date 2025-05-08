package rs.prati.service.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.ReportingPolicy;

import rs.prati.core.model.AbSistemPretplatnici;
import rs.prati.core.model.BhVoziloOprema;
import rs.prati.service.dto.BhVoziloOpremaDto;

/**
 * MapStruct мапер за ентитет BhVoziloOprema и његов DTO.
 */
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface BhVoziloOpremaMapper extends EntityMapper<BhVoziloOprema, BhVoziloOpremaDto> {

    /**
     * Мапира ентитет у DTO.
     */
    @Override
    @Mappings({
        @Mapping(source = "pretplatnik.id", target = "pretplatnikId")
    })
    BhVoziloOpremaDto toDto(BhVoziloOprema entity);

    /**
     * Мапира DTO у ентитет.
     */
    @Override
    @Mappings({
        @Mapping(target = "pretplatnik", expression = "java(mapPretplatnik(dto.getPretplatnikId()))")
    })
    BhVoziloOprema toEntity(BhVoziloOpremaDto dto);

    /**
     * Помоћни метод за мапирање претплатника по ID-у.
     */
    default AbSistemPretplatnici mapPretplatnik(Long id) {
        if (id == null) return null;
        AbSistemPretplatnici p = new AbSistemPretplatnici();
        p.setId(id);
        return p;
    }
}
