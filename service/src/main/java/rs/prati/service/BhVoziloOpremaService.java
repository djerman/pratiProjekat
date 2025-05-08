package rs.prati.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import rs.prati.core.model.BhVoziloOprema;
import rs.prati.service.common.AbstractCrudService;
import rs.prati.service.dto.BhVoziloOpremaDto;
import rs.prati.service.mapper.BhVoziloOpremaMapper;
import rs.prati.service.mapper.EntityMapper;
import rs.prati.service.repository.BhVoziloOpremaRepository;

import java.util.List;
import java.util.Optional;

/**
 * Сервис за обраду ентитета BhVoziloOprema.
 */
@Service
public class BhVoziloOpremaService extends AbstractCrudService<BhVoziloOprema, BhVoziloOpremaDto> {

    private final BhVoziloOpremaRepository repository;
    private final BhVoziloOpremaMapper mapper;

    public BhVoziloOpremaService(BhVoziloOpremaRepository repository, BhVoziloOpremaMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    protected JpaRepository<BhVoziloOprema, Long> getRepository() {
        return repository;
    }

    @Override
    protected EntityMapper<BhVoziloOprema, BhVoziloOpremaDto> getMapper() {
        return mapper;
    }

    /**
     * Чува опрему (нову или постојећу).
     */
    @Transactional
    public BhVoziloOpremaDto save(BhVoziloOpremaDto dto) {
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
     * Меко брисање – означава као обрисану.
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
    public Optional<BhVoziloOpremaDto> findById(Long id) {
        return super.findById(id);
    }

    /**
     * Враћа све елементе опреме.
     */
    @Transactional(readOnly = true)
    public List<BhVoziloOpremaDto> findAll() {
        return super.findAll();
    }

    /**
     * Враћа сву опрему за задатог претплатника.
     */
    @Transactional(readOnly = true)
    public List<BhVoziloOpremaDto> findAllForPretplatnik(Long pretplatnikId) {
        return repository.findByPretplatnik_IdAndIzbrisanFalseOrderByIdDesc()
                .stream()
                .map(mapper::toDto)
                .toList();
    }
}
