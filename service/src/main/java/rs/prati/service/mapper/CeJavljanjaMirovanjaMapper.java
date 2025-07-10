package rs.prati.service.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.ReportingPolicy;

import rs.prati.core.model.BbObjekti;
import rs.prati.core.model.AdSistemAlarmi;
import rs.prati.core.model.BaKorisnici;
import rs.prati.core.model.CeJavljanjaMirovanja;
import rs.prati.service.dto.CeJavljanjaMirovanjaDto;

/**
 * MapStruct мапер за ентитет CeJavljanjaMirovanja и његов DTO.
 */
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CeJavljanjaMirovanjaMapper extends EntityMapper<CeJavljanjaMirovanja, CeJavljanjaMirovanjaDto> {

    /**
     * Мапира ентитет у DTO.
     */
    @Override
    @Mappings({
        @Mapping(source = "objekat.id", target = "objekatId"),
        @Mapping(source = "alarm.id", target = "alarmId"),
        @Mapping(source = "korisnik.id", target = "korisnikId")
    })
    CeJavljanjaMirovanjaDto toDto(CeJavljanjaMirovanja entity);

    /**
     * Мапира DTO у ентитет.
     */
    @Override
    @Mappings({
        @Mapping(target = "objekat", expression = "java(mapObjekat(dto.getObjekatId()))"),
        @Mapping(target = "alarm", expression = "java(mapAlarm(dto.getAlarmId()))"),
        @Mapping(target = "korisnik", expression = "java(mapKorisnik(dto.getKorisnikId()))")
    })
    CeJavljanjaMirovanja toEntity(CeJavljanjaMirovanjaDto dto);

    // --- Помоћне методе за мапирање ID → Entity ---

    default BbObjekti mapObjekat(Long id) {
        if (id == null) return null;
        BbObjekti e = new BbObjekti();
        e.setId(id);
        return e;
    }

    default AdSistemAlarmi mapAlarm(Long id) {
        if (id == null) return null;
        AdSistemAlarmi e = new AdSistemAlarmi();
        e.setId(id);
        return e;
    }

    default BaKorisnici mapKorisnik(Long id) {
        if (id == null) return null;
        BaKorisnici e = new BaKorisnici();
        e.setId(id);
        return e;
    }
}
