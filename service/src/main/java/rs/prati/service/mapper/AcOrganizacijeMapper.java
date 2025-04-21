package rs.prati.service.mapper;

import org.mapstruct.Mapper;
import rs.prati.core.model.AcOrganizacije;
import rs.prati.service.dto.AcOrganizacijeDto;

/**
 * MapStruct мапер између ентитета и DTO објеката за организације.
 */
@Mapper(componentModel = "spring")
public interface AcOrganizacijeMapper {
    AcOrganizacijeDto toDto(AcOrganizacije entity);
    AcOrganizacije toEntity(AcOrganizacijeDto dto);
}
