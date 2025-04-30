package rs.prati.service.mapper;

import org.mapstruct.Mapper;
import rs.prati.core.model.AiSistemUredjajiModeli;
import rs.prati.service.dto.AiSistemUredjajiModeliDto;

/**
 * MapStruct мапер за ентитет AiSistemUredjajiModeli и његов DTO.
 */
@Mapper(componentModel = "spring")
public interface AiSistemUredjajiModeliMapper extends EntityMapper<AiSistemUredjajiModeli, AiSistemUredjajiModeliDto> {
	
}
