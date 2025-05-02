package rs.prati.service.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.ReportingPolicy;
import rs.prati.core.model.BaKorisnici;
import rs.prati.service.dto.BaKorisniciDto;

/**
 * MapStruct мапер за ентитет BaKorisnici и његов DTO.
 * Обрађује конверзију између ентитетског модела и DTO објеката.
 */
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface BaKorisniciMapper extends EntityMapper<BaKorisnici, BaKorisniciDto> {

    /**
     * Мапира ентитет у DTO.
     * Извлачи ID вредности из повезаних ентитета.
     */
    @Override
    @Mappings({
        @Mapping(source = "pretplatnik.id", target = "pretplatnikId"),
        @Mapping(source = "organizacija.id", target = "organizacijaId")
    })
    BaKorisniciDto toDto(BaKorisnici entity);

    /**
     * Мапира DTO у ентитет.
     * Подешава ID-еве повезаних ентитета.
     */
    @Override
    @Mappings({
        @Mapping(source = "pretplatnikId", target = "pretplatnik.id"),
        @Mapping(source = "organizacijaId", target = "organizacija.id")
    })
    BaKorisnici toEntity(BaKorisniciDto dto);
}
