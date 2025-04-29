package rs.prati.service.mapper;

import org.mapstruct.Mapper;
import rs.prati.core.model.AcOrganizacije;
import rs.prati.service.dto.AcOrganizacijeDto;

/**
 * MapStruct мапер за ентитет AcOrganizacije и његов DTO.
 */
@Mapper(componentModel = "spring")
public interface AcOrganizacijeMapper extends EntityMapper<AcOrganizacije, AcOrganizacijeDto> {
	
}
