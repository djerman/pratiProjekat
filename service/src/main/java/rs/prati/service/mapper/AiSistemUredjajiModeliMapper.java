package rs.prati.service.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.ReportingPolicy;
import rs.prati.core.model.AiSistemUredjajiModeli;
import rs.prati.service.dto.AiSistemUredjajiModeliDto;

/**
 * MapStruct мапер за ентитет AiSistemUredjajiModeli и његов DTO.
 * Користи се за конверзију између ентитета и DTO објеката.
 */
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface AiSistemUredjajiModeliMapper extends EntityMapper<AiSistemUredjajiModeli, AiSistemUredjajiModeliDto> {

    /**
     * Конвертује ентитет у DTO.
     * Извлачи ID произвођача из ентитета.
     */
    @Override
    @Mappings({
        @Mapping(source = "proizvodjac.id", target = "proizvodjacId")
    })
    AiSistemUredjajiModeliDto toDto(AiSistemUredjajiModeli entity);

    /**
     * Конвертује DTO у ентитет.
     * Подешава ID као под-објекат произвођача.
     */
    @Override
    @Mappings({
        @Mapping(source = "proizvodjacId", target = "proizvodjac.id")
    })
    AiSistemUredjajiModeli toEntity(AiSistemUredjajiModeliDto dto);
}
