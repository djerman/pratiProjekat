package rs.prati.service.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.ReportingPolicy;
import rs.prati.core.model.BbObjekti;
import rs.prati.core.model.DzSistemObracuni;
import rs.prati.service.dto.DzSistemObracuniDto;

/**
 * MapStruct мапер за ентитет DzSistemObracuni и његов DTO.
 */
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface DzSistemObracuniMapper extends EntityMapper<DzSistemObracuni, DzSistemObracuniDto> {

    @Override
    @Mappings({
        @Mapping(source = "objekat.id", target = "objekatId")
    })
    DzSistemObracuniDto toDto(DzSistemObracuni entity);

    @Override
    @Mappings({
        @Mapping(target = "objekat", expression = "java(mapObjekat(dto.getObjekatId()))")
    })
    DzSistemObracuni toEntity(DzSistemObracuniDto dto);

    /**
     * Помоћна метода: мапира ID у BbObjekti ентитет (само ID сетује).
     */
    default BbObjekti mapObjekat(Long id) {
        if (id == null) return null;
        BbObjekti o = new BbObjekti();
        o.setId(id);
        return o;
    }
}
