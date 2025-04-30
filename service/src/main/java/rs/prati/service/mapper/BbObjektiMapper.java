package rs.prati.service.mapper;

import org.mapstruct.Mapper;
import rs.prati.core.model.BbObjekti;
import rs.prati.service.dto.BbObjektiDto;

/**
 * MapStruct мапер за ентитет BbObjekti и његов DTO.
 */
@Mapper(componentModel = "spring")
public interface BbObjektiMapper extends EntityMapper<BbObjekti, BbObjektiDto> {
	
}
