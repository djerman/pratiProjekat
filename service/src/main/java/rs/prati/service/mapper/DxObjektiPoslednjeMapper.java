package rs.prati.service.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.ReportingPolicy;
import rs.prati.core.model.BbObjekti;
import rs.prati.core.model.DxObjektiPoslednje;
import rs.prati.service.dto.DxObjektiPoslednjeDto;

/**
 * MapStruct мапер за ентитет DxObjektiPoslednje и његов DTO.
 */
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface DxObjektiPoslednjeMapper extends EntityMapper<DxObjektiPoslednje, DxObjektiPoslednjeDto> {

    @Override
    @Mappings({
        @Mapping(source = "objekat.id", target = "objekatId")
    })
    DxObjektiPoslednjeDto toDto(DxObjektiPoslednje entity);

    @Override
    @Mappings({
        @Mapping(target = "objekat", expression = "java(mapObjekat(dto.getObjekatId()))")
    })
    DxObjektiPoslednje toEntity(DxObjektiPoslednjeDto dto);

    /**
     * Помоћна метода за мапирање ID → BbObjekti ентитет.
     */
    default BbObjekti mapObjekat(Long id) {
        if (id == null) return null;
        BbObjekti objekat = new BbObjekti();
        objekat.setId(id);
        return objekat;
    }
}
