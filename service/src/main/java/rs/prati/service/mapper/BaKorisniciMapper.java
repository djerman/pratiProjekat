package rs.prati.service.mapper;

import org.mapstruct.Mapper;
import rs.prati.core.model.BaKorisnici;
import rs.prati.service.dto.BaKorisniciDto;

/**
 * MapStruct мапер за ентитет BaKorisnici и његов DTO.
 */
@Mapper(componentModel = "spring")
public interface BaKorisniciMapper extends EntityMapper<BaKorisnici, BaKorisniciDto> {
	
}
