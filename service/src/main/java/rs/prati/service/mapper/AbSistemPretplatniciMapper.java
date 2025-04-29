package rs.prati.service.mapper;

import org.mapstruct.Mapper;
import rs.prati.core.model.AbSistemPretplatnici;
import rs.prati.service.dto.AbSistemPretplatniciDto;

/**
 * MapStruct мапер за ентитет AbSistemPretplatnici и његов DTO.
 */
@Mapper(componentModel = "spring")
public interface AbSistemPretplatniciMapper extends EntityMapper<AbSistemPretplatnici, AbSistemPretplatniciDto> {
	
}
