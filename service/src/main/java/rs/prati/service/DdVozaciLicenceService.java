package rs.prati.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import rs.prati.core.model.BaKorisnici;
import rs.prati.core.model.AbSistemPretplatnici;
import rs.prati.core.model.DdVozaciLicence;
import rs.prati.service.common.AbstractCrudService;
import rs.prati.service.dto.DdVozaciLicenceDto;
import rs.prati.service.mapper.DdVozaciLicenceMapper;
import rs.prati.service.mapper.EntityMapper;
import rs.prati.service.repository.DdVozaciLicenceRepository;

import java.util.List;

/**
 * Сервис за обраду лиценци возача.
 */
@Service
public class DdVozaciLicenceService extends AbstractCrudService<DdVozaciLicence, DdVozaciLicenceDto> {

    private final DdVozaciLicenceRepository repository;
    private final DdVozaciLicenceMapper mapper;

    public DdVozaciLicenceService(DdVozaciLicenceRepository repository, DdVozaciLicenceMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    protected DdVozaciLicenceRepository getRepository() {
        return repository;
    }

    @Override
    protected EntityMapper<DdVozaciLicence, DdVozaciLicenceDto> getMapper() {
        return mapper;
    }

    /**
     * Враћа све лиценце за датог корисника.
     */
    @Transactional(readOnly = true)
    public List<DdVozaciLicenceDto> findAllForKorisnik(Long korisnikId) {
        BaKorisnici korisnik = new BaKorisnici();
        korisnik.setId(korisnikId);
        return repository.findByKorisnikAndIzbrisanFalseOrderByIdDesc(korisnik)
                .stream()
                .map(mapper::toDto)
                .toList();
    }

    /**
     * Враћа све лиценце за датог претплатника.
     */
    @Transactional(readOnly = true)
    public List<DdVozaciLicenceDto> findAllForPretplatnik(Long pretplatnikId) {
        AbSistemPretplatnici pretplatnik = new AbSistemPretplatnici();
        pretplatnik.setId(pretplatnikId);
        return repository.findByPretplatnikAndIzbrisanFalseOrderByIdDesc(pretplatnik)
                .stream()
                .map(mapper::toDto)
                .toList();
    }
}
