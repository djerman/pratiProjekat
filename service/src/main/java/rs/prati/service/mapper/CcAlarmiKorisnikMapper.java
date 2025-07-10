package rs.prati.service.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.ReportingPolicy;
import rs.prati.core.model.*;
import rs.prati.service.dto.CcAlarmiKorisnikDto;

/**
 * MapStruct мапер за ентитет CcAlarmiKorisnik и његов DTO.
 */
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CcAlarmiKorisnikMapper extends EntityMapper<CcAlarmiKorisnik, CcAlarmiKorisnikDto> {

    /**
     * Мапира ентитет у DTO.
     */
    @Override
    @Mappings({
        @Mapping(source = "pretplatnik.id", target = "pretplatnikId"),
        @Mapping(source = "organizacija.id", target = "organizacijaId"),
        @Mapping(source = "korisnik.id", target = "korisnikId"),
        @Mapping(source = "objekat.id", target = "objekatId"),
        @Mapping(source = "alarm.id", target = "alarmId")
    })
    CcAlarmiKorisnikDto toDto(CcAlarmiKorisnik entity);

    /**
     * Мапира DTO у ентитет.
     */
    @Override
    @Mappings({
        @Mapping(target = "pretplatnik", expression = "java(mapPretplatnik(dto.getPretplatnikId()))"),
        @Mapping(target = "organizacija", expression = "java(mapOrganizacija(dto.getOrganizacijaId()))"),
        @Mapping(target = "korisnik", expression = "java(mapKorisnik(dto.getKorisnikId()))"),
        @Mapping(target = "objekat", expression = "java(mapObjekat(dto.getObjekatId()))"),
        @Mapping(target = "alarm", expression = "java(mapAlarm(dto.getAlarmId()))")
    })
    CcAlarmiKorisnik toEntity(CcAlarmiKorisnikDto dto);

    // --- Помоћне методе за мапирање ID → Entity ---

    default AbSistemPretplatnici mapPretplatnik(Long id) {
        if (id == null) return null;
        AbSistemPretplatnici e = new AbSistemPretplatnici();
        e.setId(id);
        return e;
    }

    default AcOrganizacije mapOrganizacija(Long id) {
        if (id == null) return null;
        AcOrganizacije e = new AcOrganizacije();
        e.setId(id);
        return e;
    }

    default BaKorisnici mapKorisnik(Long id) {
        if (id == null) return null;
        BaKorisnici e = new BaKorisnici();
        e.setId(id);
        return e;
    }

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
}
