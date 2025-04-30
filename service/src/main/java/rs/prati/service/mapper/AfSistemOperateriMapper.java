package rs.prati.service.mapper;

import org.mapstruct.Mapper;
import rs.prati.core.model.AfSistemOperateri;
import rs.prati.service.dto.AfSistemOperateriDto;

/**
 * MapStruct мапер за ентитет AfSistemOperateri и његов DTO.
 */
@Mapper(componentModel = "spring")
public interface AfSistemOperateriMapper extends EntityMapper<AfSistemOperateri, AfSistemOperateriDto> {
	
}
