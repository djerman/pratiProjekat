package rs.prati.service.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.ReportingPolicy;
import rs.prati.core.model.BbObjekti;
import rs.prati.core.model.CgObdPoslednji;
import rs.prati.service.dto.CgObdPoslednjiDto;

/**
 * MapStruct мапер за ентитет CgObdPoslednji и његов DTO.
 */
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CgObdPoslednjiMapper extends EntityMapper<CgObdPoslednji, CgObdPoslednjiDto> {

    /**
     * Мапирање ентитета у DTO.
     */
    @Override
    @Mappings({
        @Mapping(source = "objekat.id", target = "objekatId")
    })
    CgObdPoslednjiDto toDto(CgObdPoslednji entity);

    /**
     * Мапирање DTO у ентитет.
     */
    @Override
    @Mappings({
        @Mapping(target = "objekat", expression = "java(mapObjekat(dto.getObjekatId()))")
    })
    CgObdPoslednji toEntity(CgObdPoslednjiDto dto);

    /**
     * Помоћна метода за мапирање ID → BbObjekti.
     */
    default BbObjekti mapObjekat(Long id) {
        if (id == null) return null;
        BbObjekti obj = new BbObjekti();
        obj.setId(id);
        return obj;
    }
}
