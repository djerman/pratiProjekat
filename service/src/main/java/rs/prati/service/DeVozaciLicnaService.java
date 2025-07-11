package rs.prati.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import rs.prati.core.model.DeVozaciLicna;
import rs.prati.service.common.AbstractCrudService;
import rs.prati.service.dto.DeVozaciLicnaDto;
import rs.prati.service.mapper.DeVozaciLicnaMapper;
import rs.prati.service.mapper.EntityMapper;
import rs.prati.service.repository.DeVozaciLicnaRepository;

import java.util.List;
import java.util.Optional;

/**
 * Сервис за обраду ентитета DeVozaciLicna (лична карта возача).
 */
@Service
public class DeVozaciLicnaService extends AbstractCrudService<DeVozaciLicna, DeVozaciLicnaDto> {

    private final DeVozaciLicnaRepository repository;
    private final DeVozaciLicnaMapper mapper;

    public DeVozaciLicnaService(DeVozaciLicnaRepository repository, DeVozaciLicnaMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    protected JpaRepository<DeVozaciLicna, Long> getRepository() {
        return repository;
    }

    @Override
    protected EntityMapper<DeVozaciLicna, DeVozaciLicnaDto> getMapper() {
        return mapper;
    }

    /**
     * Чување или ажурирање личне карте.
     */
    @Transactional
    public DeVozaciLicnaDto save(DeVozaciLicnaDto dto) {
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
    public Optional<DeVozaciLicnaDto> findById(Long id) {
        return super.findById(id);
    }

    /**
     * Враћа све не-обрисане личне карте.
     */
    @Transactional(readOnly = true)
    public List<DeVozaciLicnaDto> findAll() {
        return repository.findByIzbrisanFalseOrderByIdDesc()
                .stream()
                .map(mapper::toDto)
                .toList();
    }

    /**
     * Враћа све личне карте за датог корисника.
     */
    @Transactional(readOnly = true)
    public List<DeVozaciLicnaDto> findAllForKorisnik(Long korisnikId) {
        return repository.findByKorisnik_IdAndIzbrisanFalseOrderByIdDesc(korisnikId)
                .stream()
                .map(mapper::toDto)
                .toList();
    }

    /**
     * Враћа све личне карте за датог претплатника.
     */
    @Transactional(readOnly = true)
    public List<DeVozaciLicnaDto> findAllForPretplatnik(Long pretplatnikId) {
        return repository.findByPretplatnik_IdAndIzbrisanFalseOrderByIdDesc(pretplatnikId)
                .stream()
                .map(mapper::toDto)
                .toList();
    }
}
