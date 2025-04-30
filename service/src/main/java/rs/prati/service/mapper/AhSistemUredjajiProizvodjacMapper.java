package rs.prati.service.mapper;

import org.mapstruct.Mapper;
import rs.prati.core.model.AhSistemUredjajiProizvodjac;
import rs.prati.service.dto.AhSistemUredjajiProizvodjacDto;

/**
 * MapStruct мапер за ентитет AhSistemUredjajiProizvodjac и његов DTO.
 */
@Mapper(componentModel = "spring")
public interface AhSistemUredjajiProizvodjacMapper extends EntityMapper<AhSistemUredjajiProizvodjac, AhSistemUredjajiProizvodjacDto> {
	
}
