package rs.prati.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import rs.prati.core.model.DySistemSesije;
import rs.prati.service.common.AbstractCrudService;
import rs.prati.service.dto.DySistemSesijeDto;
import rs.prati.service.mapper.DySistemSesijeMapper;
import rs.prati.service.mapper.EntityMapper;
import rs.prati.service.repository.DySistemSesijeRepository;

import java.util.List;
import java.util.Optional;

/**
 * Сервис за обраду ентитета DySistemSesije (системске сесије корисника).
 */
@Service
public class DySistemSesijeService extends AbstractCrudService<DySistemSesije, DySistemSesijeDto> {

    private final DySistemSesijeRepository repository;
    private final DySistemSesijeMapper mapper;

    public DySistemSesijeService(DySistemSesijeRepository repository, DySistemSesijeMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    protected JpaRepository<DySistemSesije, Long> getRepository() {
        return repository;
    }

    @Override
    protected EntityMapper<DySistemSesije, DySistemSesijeDto> getMapper() {
        return mapper;
    }

    /**
     * Чување или ажурирање сесије.
     */
    @Transactional
    public DySistemSesijeDto save(DySistemSesijeDto dto) {
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
     * Меко брисање (означава као обрисано).
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
    public Optional<DySistemSesijeDto> findById(Long id) {
        return super.findById(id);
    }

    /**
     * Враћа све не-обрисане сесије.
     */
    @Transactional(readOnly = true)
    public List<DySistemSesijeDto> findAll() {
        return repository.findByIzbrisanFalseOrderByIdDesc()
                .stream()
                .map(mapper::toDto)
                .toList();
    }

    /**
     * Враћа све сесије за датог корисника.
     */
    @Transactional(readOnly = true)
    public List<DySistemSesijeDto> findAllForKorisnik(Long korisnikId) {
        return repository.findByKorisnik_IdAndIzbrisanFalseOrderByIdDesc(korisnikId)
                .stream()
                .map(mapper::toDto)
                .toList();
    }

    /**
     * Враћа све сесије за датог претплатника.
     */
    @Transactional(readOnly = true)
    public List<DySistemSesijeDto> findAllForPretplatnik(Long pretplatnikId) {
        return repository.findByPretplatnik_IdAndIzbrisanFalseOrderByIdDesc(pretplatnikId)
                .stream()
                .map(mapper::toDto)
                .toList();
    }
}
