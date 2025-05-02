package rs.prati.service.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.ReportingPolicy;
import rs.prati.core.model.AcOrganizacije;
import rs.prati.service.dto.AcOrganizacijeDto;

/**
 * MapStruct мапер за ентитет AcOrganizacije и његов DTO.
 * Омогућава конверзију између ентитетске и DTO репрезентације.
 */
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface AcOrganizacijeMapper extends EntityMapper<AcOrganizacije, AcOrganizacijeDto> {

    /**
     * Конвертује ентитет у DTO.
     * Извлачи ID из ентитета претплатника.
     *
     * @param entity ентитет организације
     * @return DTO објекат
     */
    @Override
    @Mappings({
        @Mapping(source = "pretplatnik.id", target = "pretplatnikId")
    })
    AcOrganizacijeDto toDto(AcOrganizacije entity);

    /**
     * Конвертује DTO у ентитет.
     * Креира ентитет претплатника само са ID-ем.
     *
     * @param dto DTO објекат
     * @return ентитет организације
     */
    @Override
    @Mappings({
        @Mapping(source = "pretplatnikId", target = "pretplatnik.id")
    })
    AcOrganizacije toEntity(AcOrganizacijeDto dto);
}
