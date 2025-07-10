package rs.prati.service.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.ReportingPolicy;

import rs.prati.core.model.BbObjekti;
import rs.prati.core.model.AdSistemAlarmi;
import rs.prati.core.model.BaKorisnici;
import rs.prati.core.model.CfJavljanjaPoslednja;
import rs.prati.service.dto.CfJavljanjaPoslednjaDto;

/**
 * MapStruct мапер за ентитет CfJavljanjaPoslednja и његов DTO.
 */
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CfJavljanjaPoslednjaMapper extends EntityMapper<CfJavljanjaPoslednja, CfJavljanjaPoslednjaDto> {

    /**
     * Мапира ентитет у DTO.
     */
    @Override
    @Mappings({
        @Mapping(source = "objekat.id", target = "objekatId"),
        @Mapping(source = "alarm.id", target = "alarmId"),
        @Mapping(source = "korisnik.id", target = "korisnikId")
    })
    CfJavljanjaPoslednjaDto toDto(CfJavljanjaPoslednja entity);

    /**
     * Мапира DTO у ентитет.
     */
    @Override
    @Mappings({
        @Mapping(target = "objekat", expression = "java(mapObjekat(dto.getObjekatId()))"),
        @Mapping(target = "alarm", expression = "java(mapAlarm(dto.getAlarmId()))"),
        @Mapping(target = "korisnik", expression = "java(mapKorisnik(dto.getKorisnikId()))")
    })
    CfJavljanjaPoslednja toEntity(CfJavljanjaPoslednjaDto dto);

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
