package rs.prati.service.mapper;

import org.mapstruct.Mapper;
import rs.prati.core.model.AeSistemGoriva;
import rs.prati.service.dto.AeSistemGorivaDto;

/**
 * MapStruct мапер за ентитет AeSistemGoriva и његов DTO.
 */
@Mapper(componentModel = "spring")
public interface AeSistemGorivaMapper extends EntityMapper<AeSistemGoriva, AeSistemGorivaDto> {
}
