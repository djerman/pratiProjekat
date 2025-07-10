package rs.prati.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import rs.prati.core.model.CeJavljanjaMirovanja;
import rs.prati.service.common.AbstractCrudService;
import rs.prati.service.dto.CeJavljanjaMirovanjaDto;
import rs.prati.service.mapper.CeJavljanjaMirovanjaMapper;
import rs.prati.service.mapper.EntityMapper;
import rs.prati.service.repository.CeJavljanjaMirovanjaRepository;

import java.util.List;
import java.util.Optional;

/**
 * Сервис за обраду ентитета CeJavljanjaMirovanja.
 */
@Service
public class CeJavljanjaMirovanjaService extends AbstractCrudService<CeJavljanjaMirovanja, CeJavljanjaMirovanjaDto> {

    private final CeJavljanjaMirovanjaRepository repository;
    private final CeJavljanjaMirovanjaMapper mapper;

    public CeJavljanjaMirovanjaService(CeJavljanjaMirovanjaRepository repository,
                                       CeJavljanjaMirovanjaMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    protected JpaRepository<CeJavljanjaMirovanja, Long> getRepository() {
        return repository;
    }

    @Override
    protected EntityMapper<CeJavljanjaMirovanja, CeJavljanjaMirovanjaDto> getMapper() {
        return mapper;
    }

    /**
     * Чување јављања мировања.
     */
    @Transactional
    public CeJavljanjaMirovanjaDto save(CeJavljanjaMirovanjaDto dto) {
        return super.save(dto);
    }

    /**
     * Тврдо брисање по ID-у.
     */
    @Transactional
    public void hardDelete(Long id) {
        repository.deleteById(id);
    }

    /**
     * Проналажење по ID-у.
     */
    @Transactional(readOnly = true)
    public Optional<CeJavljanjaMirovanjaDto> findById(Long id) {
        return super.findById(id);
    }

    /**
     * Враћа сва јављања мировања.
     */
    @Transactional(readOnly = true)
    public List<CeJavljanjaMirovanjaDto> findAll() {
        return super.findAll();
    }

    /**
     * Враћа сва јављања мировања за одређени објекат.
     */
    @Transactional(readOnly = true)
    public List<CeJavljanjaMirovanjaDto> findAllForObjekat(Long objekatId) {
        return repository.findByObjekat_IdOrderByDatumVremeDesc().stream()
                .map(mapper::toDto)
                .toList();
    }

    /**
     * Враћа само валидна јављања мировања.
     */
    @Transactional(readOnly = true)
    public List<CeJavljanjaMirovanjaDto> findAllValid() {
        return repository.findByValidTrueOrderByDatumVremeDesc().stream()
                .map(mapper::toDto)
                .toList();
    }
}
