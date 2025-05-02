package rs.prati.service.mapper;

import org.mapstruct.*;
import rs.prati.core.model.*;
import rs.prati.service.dto.BcUredjajiDto;

/**
 * MapStruct мапер за ентитет BcUredjaji и његов DTO.
 */
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface BcUredjajiMapper extends EntityMapper<BcUredjaji, BcUredjajiDto> {

    /**
     * Мапира ентитет у DTO.
     * Поле `zauzet` се добија као резултат провере `objekat != null`.
     */
    @Override
    @Mappings({
        @Mapping(source = "pretplatnik.id", target = "pretplatnikId"),
        @Mapping(source = "organizacija.id", target = "organizacijaId"),
        @Mapping(source = "model.id", target = "modelId"),
        @Mapping(source = "objekat.id", target = "objekatId"),
        @Mapping(target = "zauzet", expression = "java(entity.getObjekat() != null)")
    })
    BcUredjajiDto toDto(BcUredjaji entity);

    /**
     * Мапира DTO у ентитет.
     * Користи ID вредности за креирање повезаних ентитета.
     */
    @Override
    @Mappings({
        @Mapping(target = "pretplatnik", source = "pretplatnikId", qualifiedByName = "mapPretplatnikFromId"),
        @Mapping(target = "organizacija", source = "organizacijaId", qualifiedByName = "mapOrganizacijaFromId"),
        @Mapping(target = "model", source = "modelId", qualifiedByName = "mapModelFromId"),
        @Mapping(target = "objekat", source = "objekatId", qualifiedByName = "mapObjekatFromId")
    })
    BcUredjaji toEntity(BcUredjajiDto dto);

    // --- Помоћне методе ---

    @Named("mapPretplatnikFromId")
    static AbSistemPretplatnici mapPretplatnikFromId(Long id) {
        if (id == null) return null;
        AbSistemPretplatnici p = new AbSistemPretplatnici();
        p.setId(id);
        return p;
    }

    @Named("mapOrganizacijaFromId")
    static AcOrganizacije mapOrganizacijaFromId(Long id) {
        if (id == null) return null;
        AcOrganizacije o = new AcOrganizacije();
        o.setId(id);
        return o;
    }

    @Named("mapModelFromId")
    static AiSistemUredjajiModeli mapModelFromId(Long id) {
        if (id == null) return null;
        AiSistemUredjajiModeli m = new AiSistemUredjajiModeli();
        m.setId(id);
        return m;
    }

    @Named("mapObjekatFromId")
    static BbObjekti mapObjekatFromId(Long id) {
        if (id == null) return null;
        BbObjekti b = new BbObjekti();
        b.setId(id);
        return b;
    }
}
