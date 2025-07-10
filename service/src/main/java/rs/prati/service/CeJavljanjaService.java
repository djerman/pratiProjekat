package rs.prati.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import rs.prati.core.model.CeJavljanja;
import rs.prati.service.common.AbstractCrudService;
import rs.prati.service.dto.CeJavljanjaDto;
import rs.prati.service.mapper.CeJavljanjaMapper;
import rs.prati.service.mapper.EntityMapper;
import rs.prati.service.repository.CeJavljanjaRepository;

import java.util.List;
import java.util.Optional;

/**
 * Сервис за обраду ентитета CeJavljanja.
 */
@Service
public class CeJavljanjaService extends AbstractCrudService<CeJavljanja, CeJavljanjaDto> {

    private final CeJavljanjaRepository repository;
    private final CeJavljanjaMapper mapper;

    public CeJavljanjaService(CeJavljanjaRepository repository, CeJavljanjaMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    protected JpaRepository<CeJavljanja, Long> getRepository() {
        return repository;
    }

    @Override
    protected EntityMapper<CeJavljanja, CeJavljanjaDto> getMapper() {
        return mapper;
    }

    /**
     * Чување јављања (новог или постојећег).
     */
    @Transactional
    public CeJavljanjaDto save(CeJavljanjaDto dto) {
        return super.save(dto);
    }

    /**
     * Тврдо брисање јављања по ID-у.
     */
    @Transactional
    public void hardDelete(Long id) {
        repository.deleteById(id);
    }

    /**
     * Проналажење јављања по ID-у.
     */
    @Transactional(readOnly = true)
    public Optional<CeJavljanjaDto> findById(Long id) {
        return super.findById(id);
    }

    /**
     * Враћа сва јављања.
     */
    @Transactional(readOnly = true)
    public List<CeJavljanjaDto> findAll() {
        return super.findAll();
    }

    /**
     * Враћа сва јављања за задати објекат.
     */
    @Transactional(readOnly = true)
    public List<CeJavljanjaDto> findAllForObjekat(Long objekatId) {
        return repository.findByObjekat_IdOrderByDatumVremeDesc().stream()
                .map(mapper::toDto)
                .toList();
    }

    /**
     * Враћа само валидна јављања.
     */
    @Transactional(readOnly = true)
    public List<CeJavljanjaDto> findAllValid() {
        return repository.findByValidTrueOrderByDatumVremeDesc().stream()
                .map(mapper::toDto)
                .toList();
    }
}
