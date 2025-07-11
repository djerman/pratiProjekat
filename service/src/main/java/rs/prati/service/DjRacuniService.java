package rs.prati.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import rs.prati.core.model.DjRacuni;
import rs.prati.service.common.AbstractCrudService;
import rs.prati.service.dto.DjRacuniDto;
import rs.prati.service.mapper.DjRacuniMapper;
import rs.prati.service.mapper.EntityMapper;
import rs.prati.service.repository.DjRacuniRepository;

import java.util.List;
import java.util.Optional;

/**
 * Сервис за обраду ентитета DjRacuni (рачун).
 */
@Service
public class DjRacuniService extends AbstractCrudService<DjRacuni, DjRacuniDto> {

    private final DjRacuniRepository repository;
    private final DjRacuniMapper mapper;

    public DjRacuniService(DjRacuniRepository repository, DjRacuniMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    protected JpaRepository<DjRacuni, Long> getRepository() {
        return repository;
    }

    @Override
    protected EntityMapper<DjRacuni, DjRacuniDto> getMapper() {
        return mapper;
    }

    /**
     * Чување или ажурирање рачуна.
     */
    @Transactional
    public DjRacuniDto save(DjRacuniDto dto) {
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
    public Optional<DjRacuniDto> findById(Long id) {
        return super.findById(id);
    }

    /**
     * Враћа све не-обрисане рачуне.
     */
    @Transactional(readOnly = true)
    public List<DjRacuniDto> findAll() {
        return repository.findByIzbrisanFalseOrderByIdDesc()
                .stream()
                .map(mapper::toDto)
                .toList();
    }

    /**
     * Враћа све рачуне за датог партнера.
     */
    @Transactional(readOnly = true)
    public List<DjRacuniDto> findAllForPartner(Long partnerId) {
        return repository.findByPartnerIdAndIzbrisanFalseOrderByIdDesc(partnerId)
                .stream()
                .map(mapper::toDto)
                .toList();
    }

    /**
     * Враћа све рачуне за датог претплатника.
     */
    @Transactional(readOnly = true)
    public List<DjRacuniDto> findAllForPretplatnik(Long pretplatnikId) {
        return repository.findByPretplatnikIdAndIzbrisanFalseOrderByIdDesc(pretplatnikId)
                .stream()
                .map(mapper::toDto)
                .toList();
    }
}
