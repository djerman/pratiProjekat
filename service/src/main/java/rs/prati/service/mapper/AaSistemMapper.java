package rs.prati.service.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import rs.prati.core.model.AaSistem;
import rs.prati.service.dto.AaSistemDto;

/**
 * MapStruct мапер за ентитет AaSistem и његов DTO.
 */
@Mapper(componentModel = "spring")
public interface AaSistemMapper extends EntityMapper<AaSistem, AaSistemDto> {

    /**
     * Ажурира постојећи ентитет на основу DTO-а.
     *
     * @param dto DTO са новим подацима
     * @param entity постојећи ентитет који треба ажурирати
     */
    void updateEntityFromDto(AaSistemDto dto, @MappingTarget AaSistem entity);
}

