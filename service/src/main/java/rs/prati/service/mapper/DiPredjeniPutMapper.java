package rs.prati.service.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.ReportingPolicy;
import rs.prati.core.model.BbObjekti;
import rs.prati.core.model.DiPredjeniPut;
import rs.prati.service.dto.DiPredjeniPutDto;

/**
 * MapStruct мапер за ентитет DiPredjeniPut и његов DTO.
 */
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface DiPredjeniPutMapper extends EntityMapper<DiPredjeniPut, DiPredjeniPutDto> {

    @Override
    @Mappings({
        @Mapping(source = "objekat.id", target = "objekatId")
    })
    DiPredjeniPutDto toDto(DiPredjeniPut entity);

    @Override
    @Mappings({
        @Mapping(target = "objekat", expression = "java(mapObjekat(dto.getObjekatId()))")
    })
    DiPredjeniPut toEntity(DiPredjeniPutDto dto);

    // Помоћна метода за мапирање ID → Entity

    default BbObjekti mapObjekat(Long id) {
        if (id == null) {
            return null;
        }
        BbObjekti e = new BbObjekti();
        e.setId(id);
        return e;
    }
}
