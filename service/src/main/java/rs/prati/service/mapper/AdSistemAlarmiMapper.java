package rs.prati.service.mapper;

import org.mapstruct.Mapper;
import rs.prati.core.model.AdSistemAlarmi;
import rs.prati.service.dto.AdSistemAlarmiDto;

/**
 * MapStruct мапер за ентитет AdSistemAlarmi и његов DTO.
 */
@Mapper(componentModel = "spring")
public interface AdSistemAlarmiMapper extends EntityMapper<AdSistemAlarmi, AdSistemAlarmiDto> {
	
}
