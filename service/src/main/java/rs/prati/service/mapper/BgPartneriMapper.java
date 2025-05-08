package rs.prati.service.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.ReportingPolicy;
import rs.prati.core.model.AbSistemPretplatnici;
import rs.prati.core.model.BgPartneri;
import rs.prati.service.dto.BgPartneriDto;

/**
 * MapStruct мапер за ентитет BgPartneri и његов DTO.
 */
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface BgPartneriMapper extends EntityMapper<BgPartneri, BgPartneriDto> {

    /**
     * Мапира ентитет у DTO.
     */
    @Override
    @Mappings({
        @Mapping(source = "pretplatnik.id", target = "pretplatnikId")
    })
    BgPartneriDto toDto(BgPartneri entity);

    /**
     * Мапира DTO у ентитет.
     */
    @Override
    @Mappings({
        @Mapping(target = "pretplatnik", expression = "java(mapPretplatnik(dto.getPretplatnikId()))")
    })
    BgPartneri toEntity(BgPartneriDto dto);

    /**
     * Помоћни метод за мапирање претплатника по ID-у.
     */
    default AbSistemPretplatnici mapPretplatnik(Long id) {
        if (id == null) return null;
        AbSistemPretplatnici p = new AbSistemPretplatnici();
        p.setId(id);
        return p;
    }
}
