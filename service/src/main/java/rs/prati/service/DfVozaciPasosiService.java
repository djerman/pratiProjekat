package rs.prati.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import rs.prati.core.model.DfVozaciPasosi;
import rs.prati.service.common.AbstractCrudService;
import rs.prati.service.dto.DfVozaciPasosiDto;
import rs.prati.service.mapper.DfVozaciPasosiMapper;
import rs.prati.service.mapper.EntityMapper;
import rs.prati.service.repository.DfVozaciPasosiRepository;

import java.util.List;
import java.util.Optional;

/**
 * Сервис за ентитет DfVozaciPasosi (пасоши возача).
 */
@Service
public class DfVozaciPasosiService extends AbstractCrudService<DfVozaciPasosi, DfVozaciPasosiDto> {

    private final DfVozaciPasosiRepository repository;
    private final DfVozaciPasosiMapper mapper;

    public DfVozaciPasosiService(DfVozaciPasosiRepository repository, DfVozaciPasosiMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    protected JpaRepository<DfVozaciPasosi, Long> getRepository() {
        return repository;
    }

    @Override
    protected EntityMapper<DfVozaciPasosi, DfVozaciPasosiDto> getMapper() {
        return mapper;
    }

    /**
     * Чување или ажурирање пасоша.
     */
    @Transactional
    public DfVozaciPasosiDto save(DfVozaciPasosiDto dto) {
        return super.save(dto);
    }

    /**
     * Тврдо брисање по ID.
     */
    @Transactional
    public void hardDelete(Long id) {
        repository.deleteById(id);
    }

    /**
     * Меко брисање (означава као обрисан).
     */
    @Transactional
    public void markAsDeleted(Long id) {
        repository.findById(id).ifPresent(entity -> {
            entity.setIzbrisan(true);
            repository.save(entity);
        });
    }

    /**
     * Проналажење по ID.
     */
    @Transactional(readOnly = true)
    public Optional<DfVozaciPasosiDto> findById(Long id) {
        return super.findById(id);
    }

    /**
     * Враћа све не-обрисане пасоше.
     */
    @Transactional(readOnly = true)
    public List<DfVozaciPasosiDto> findAll() {
        return repository.findByIzbrisanFalseOrderByIdDesc()
                .stream()
                .map(mapper::toDto)
                .toList();
    }

    /**
     * Враћа све пасоше за датог корисника.
     */
    @Transactional(readOnly = true)
    public List<DfVozaciPasosiDto> findAllForKorisnik(Long korisnikId) {
        return repository.findByKorisnikIdAndIzbrisanFalseOrderByIdDesc(korisnikId)
                .stream()
                .map(mapper::toDto)
                .toList();
    }

    /**
     * Враћа све пасоше за датог претплатника.
     */
    @Transactional(readOnly = true)
    public List<DfVozaciPasosiDto> findAllForPretplatnik(Long pretplatnikId) {
        return repository.findByPretplatnikIdAndIzbrisanFalseOrderByIdDesc(pretplatnikId)
                .stream()
                .map(mapper::toDto)
                .toList();
    }
}
