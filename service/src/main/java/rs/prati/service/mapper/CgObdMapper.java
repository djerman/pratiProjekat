package rs.prati.service.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.ReportingPolicy;
import rs.prati.core.model.BbObjekti;
import rs.prati.core.model.CgObd;
import rs.prati.service.dto.CgObdDto;

/**
 * MapStruct мапер за ентитет CgObd и његов DTO.
 */
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CgObdMapper extends EntityMapper<CgObd, CgObdDto> {

    /**
     * Мапирање ентитет → DTO
     */
    @Override
    @Mappings({
        @Mapping(source = "objekat.id", target = "objekatId")
    })
    CgObdDto toDto(CgObd entity);

    /**
     * Мапирање DTO → ентитет
     */
    @Override
    @Mappings({
        @Mapping(target = "objekat", expression = "java(mapObjekat(dto.getObjekatId()))")
    })
    CgObd toEntity(CgObdDto dto);

    // --- Помоћна метода: Long → BbObjekti ---

    default BbObjekti mapObjekat(Long id) {
        if (id == null) return null;
        BbObjekti obj = new BbObjekti();
        obj.setId(id);
        return obj;
    }
}
