package rs.prati.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import rs.prati.core.model.ClVoziloNalog;
import rs.prati.service.common.AbstractCrudService;
import rs.prati.service.dto.ClVoziloNalogDto;
import rs.prati.service.mapper.ClVoziloNalogMapper;
import rs.prati.service.mapper.EntityMapper;
import rs.prati.service.repository.ClVoziloNalogRepository;

import java.util.List;
import java.util.Optional;

/**
 * Сервис за обраду ентитета ClVoziloNalog.
 */
@Service
public class ClVoziloNalogService extends AbstractCrudService<ClVoziloNalog, ClVoziloNalogDto> {

    private final ClVoziloNalogRepository repository;
    private final ClVoziloNalogMapper mapper;

    public ClVoziloNalogService(ClVoziloNalogRepository repository, ClVoziloNalogMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    protected JpaRepository<ClVoziloNalog, Long> getRepository() {
        return repository;
    }

    @Override
    protected EntityMapper<ClVoziloNalog, ClVoziloNalogDto> getMapper() {
        return mapper;
    }

    /**
     * Чување новог или постојећег налога за возило.
     */
    @Transactional
    public ClVoziloNalogDto save(ClVoziloNalogDto dto) {
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
     * Меко брисање — означава запис као обрисан.
     */
    @Transactional
    public void oznaciIzbrisan(Long id) {
        repository.findById(id).ifPresent(entity -> {
            entity.setIzbrisan(true);
            repository.save(entity);
        });
    }

    /**
     * Проналажење по ID-у.
     */
    @Transactional(readOnly = true)
    public Optional<ClVoziloNalogDto> findById(Long id) {
        return super.findById(id);
    }

    /**
     * Враћа све налоге који нису обрисани.
     */
    @Transactional(readOnly = true)
    public List<ClVoziloNalogDto> findAll() {
        return repository.findByIzbrisanFalseOrderByIdDesc()
                .stream()
                .map(mapper::toDto)
                .toList();
    }

    /**
     * Враћа све налоге за одређеног претплатника.
     */
    @Transactional(readOnly = true)
    public List<ClVoziloNalogDto> findAllForPretplatnik(Long pretplatnikId) {
        return repository.findByPretplatnikIdAndIzbrisanFalseOrderByIdDesc(pretplatnikId)
                .stream()
                .map(mapper::toDto)
                .toList();
    }
}
