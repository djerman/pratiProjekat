package rs.prati.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import rs.prati.core.model.ChZoneObjekti;
import rs.prati.service.common.AbstractCrudService;
import rs.prati.service.dto.ChZoneObjektiDto;
import rs.prati.service.mapper.ChZoneObjektiMapper;
import rs.prati.service.mapper.EntityMapper;
import rs.prati.service.repository.ChZoneObjektiRepository;

import java.util.List;
import java.util.Optional;

/**
 * Сервис за ентитет ChZoneObjekti – повезаност зона и објеката.
 */
@Service
public class ChZoneObjektiService extends AbstractCrudService<ChZoneObjekti, ChZoneObjektiDto> {

    private final ChZoneObjektiRepository repository;
    private final ChZoneObjektiMapper mapper;

    public ChZoneObjektiService(ChZoneObjektiRepository repository, ChZoneObjektiMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    protected JpaRepository<ChZoneObjekti, Long> getRepository() {
        return repository;
    }

    @Override
    protected EntityMapper<ChZoneObjekti, ChZoneObjektiDto> getMapper() {
        return mapper;
    }

    /**
     * Чување или ажурирање везе зона-објекат.
     */
    @Transactional
    public ChZoneObjektiDto save(ChZoneObjektiDto dto) {
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
    public Optional<ChZoneObjektiDto> findById(Long id) {
        return super.findById(id);
    }

    /**
     * Враћа све везе зона-објекат.
     */
    @Transactional(readOnly = true)
    public List<ChZoneObjektiDto> findAll() {
        return super.findAll();
    }
}
