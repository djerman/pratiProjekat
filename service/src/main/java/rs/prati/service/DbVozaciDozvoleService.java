package rs.prati.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import rs.prati.core.model.DbVozaciDozvole;
import rs.prati.service.common.AbstractCrudService;
import rs.prati.service.dto.DbVozaciDozvoleDto;
import rs.prati.service.mapper.DbVozaciDozvoleMapper;
import rs.prati.service.mapper.EntityMapper;
import rs.prati.service.repository.DbVozaciDozvoleRepository;

import java.util.List;
import java.util.Optional;

/**
 * Сервис за обраду ентитета DbVozaciDozvole.
 */
@Service
public class DbVozaciDozvoleService extends AbstractCrudService<DbVozaciDozvole, DbVozaciDozvoleDto> {

    private final DbVozaciDozvoleRepository repository;
    private final DbVozaciDozvoleMapper mapper;

    public DbVozaciDozvoleService(DbVozaciDozvoleRepository repository, DbVozaciDozvoleMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    protected JpaRepository<DbVozaciDozvole, Long> getRepository() {
        return repository;
    }

    @Override
    protected EntityMapper<DbVozaciDozvole, DbVozaciDozvoleDto> getMapper() {
        return mapper;
    }

    /**
     * Чување нове или постојеће дозволе.
     */
    @Transactional
    public DbVozaciDozvoleDto save(DbVozaciDozvoleDto dto) {
        return super.save(dto);
    }

    /**
     * Проналажење дозволе по ID-у.
     */
    @Transactional(readOnly = true)
    public Optional<DbVozaciDozvoleDto> findById(Long id) {
        return super.findById(id);
    }

    /**
     * Враћа све дозволе за датог корисника (возача).
     */
    @Transactional(readOnly = true)
    public List<DbVozaciDozvoleDto> findByKorisnik(Long korisnikId) {
        return repository.findByKorisnik_IdAndIzbrisanFalseOrderByIdDesc(korisnikId)
                .stream()
                .map(mapper::toDto)
                .toList();
    }

    /**
     * Враћа све дозволе за датог претплатника.
     */
    @Transactional(readOnly = true)
    public List<DbVozaciDozvoleDto> findByPretplatnik(Long pretplatnikId) {
        return repository.findByPretplatnik_IdAndIzbrisanFalseOrderByIdDesc(pretplatnikId)
                .stream()
                .map(mapper::toDto)
                .toList();
    }
}
