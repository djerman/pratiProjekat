package rs.prati.service.mapper;

import org.mapstruct.Mapper;
import rs.prati.core.model.AaSistem;
import rs.prati.service.dto.AaSistemDto;

@Mapper(componentModel = "spring")
public interface AaSistemMapper {
    AaSistemDto toDto(AaSistem entity);
    AaSistem toEntity(AaSistemDto dto);
}
