package rs.prati.service.mapper;

import org.mapstruct.Mapper;
import rs.prati.core.model.AbSistemPretplatnici;
import rs.prati.service.dto.AbSistemPretplatniciDto;

/**
 * MapStruct интерфејс за мапирање између ентитета AbSistemPretplatnici и DTO класе.
 */
@Mapper(componentModel = "spring")
public interface AbSistemPretplatniciMapper {
    AbSistemPretplatniciDto toDto(AbSistemPretplatnici entity);
    AbSistemPretplatnici toEntity(AbSistemPretplatniciDto dto);
}
