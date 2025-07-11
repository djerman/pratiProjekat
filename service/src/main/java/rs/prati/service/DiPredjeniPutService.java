package rs.prati.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import rs.prati.core.model.DiPredjeniPut;
import rs.prati.service.common.AbstractCrudService;
import rs.prati.service.dto.DiPredjeniPutDto;
import rs.prati.service.mapper.DiPredjeniPutMapper;
import rs.prati.service.mapper.EntityMapper;
import rs.prati.service.repository.DiPredjeniPutRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

/**
 * Сервис за обраду ентитета DiPredjeniPut (пређени пут и потрошња).
 */
@Service
public class DiPredjeniPutService extends AbstractCrudService<DiPredjeniPut, DiPredjeniPutDto> {

    private final DiPredjeniPutRepository repository;
    private final DiPredjeniPutMapper mapper;

    public DiPredjeniPutService(DiPredjeniPutRepository repository, DiPredjeniPutMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    protected JpaRepository<DiPredjeniPut, Long> getRepository() {
        return repository;
    }

    @Override
    protected EntityMapper<DiPredjeniPut, DiPredjeniPutDto> getMapper() {
        return mapper;
    }

    /**
     * Чување или ажурирање података.
     */
    @Transactional
    public DiPredjeniPutDto save(DiPredjeniPutDto dto) {
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
     * Проналажење по ID.
     */
    @Transactional(readOnly = true)
    public Optional<DiPredjeniPutDto> findById(Long id) {
        return super.findById(id);
    }

    /**
     * Враћа све записе за дати објекат.
     */
    @Transactional(readOnly = true)
    public List<DiPredjeniPutDto> findAllForObjekat(Long objekatId) {
        return repository.findByObjekatIdOrderByIdDesc(objekatId)
                .stream()
                .map(mapper::toDto)
                .toList();
    }

    /**
     * Враћа све записе за дати датум.
     */
    @Transactional(readOnly = true)
    public List<DiPredjeniPutDto> findAllForDatum(LocalDate datum) {
        return repository.findByDatum(datum)
                .stream()
                .map(mapper::toDto)
                .toList();
    }
}
