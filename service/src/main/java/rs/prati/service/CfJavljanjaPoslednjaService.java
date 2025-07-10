package rs.prati.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import rs.prati.core.model.CfJavljanjaPoslednja;
import rs.prati.service.common.AbstractCrudService;
import rs.prati.service.dto.CfJavljanjaPoslednjaDto;
import rs.prati.service.mapper.CfJavljanjaPoslednjaMapper;
import rs.prati.service.mapper.EntityMapper;
import rs.prati.service.repository.CfJavljanjaPoslednjaRepository;

import java.util.List;
import java.util.Optional;

/**
 * Сервис за обраду ентитета CfJavljanjaPoslednja.
 */
@Service
public class CfJavljanjaPoslednjaService extends AbstractCrudService<CfJavljanjaPoslednja, CfJavljanjaPoslednjaDto> {

    private final CfJavljanjaPoslednjaRepository repository;
    private final CfJavljanjaPoslednjaMapper mapper;

    public CfJavljanjaPoslednjaService(CfJavljanjaPoslednjaRepository repository, CfJavljanjaPoslednjaMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    protected JpaRepository<CfJavljanjaPoslednja, Long> getRepository() {
        return repository;
    }

    @Override
    protected EntityMapper<CfJavljanjaPoslednja, CfJavljanjaPoslednjaDto> getMapper() {
        return mapper;
    }

    @Transactional
    public CfJavljanjaPoslednjaDto save(CfJavljanjaPoslednjaDto dto) {
        return super.save(dto);
    }

    @Transactional
    public void hardDelete(Long id) {
        repository.deleteById(id);
    }

    @Transactional(readOnly = true)
    public Optional<CfJavljanjaPoslednjaDto> findById(Long id) {
        return super.findById(id);
    }

    @Transactional(readOnly = true)
    public List<CfJavljanjaPoslednjaDto> findAll() {
        return super.findAll();
    }

    @Transactional(readOnly = true)
    public List<CfJavljanjaPoslednjaDto> findAllValid() {
        return repository.findByValidTrueOrderByIdDesc().stream()
                .map(mapper::toDto)
                .toList();
    }

    @Transactional(readOnly = true)
    public List<CfJavljanjaPoslednjaDto> findAllForObjekat(Long objekatId) {
        return repository.findByObjekat_IdOrderByIdDesc(objekatId).stream()
                .map(mapper::toDto)
                .toList();
    }
}
