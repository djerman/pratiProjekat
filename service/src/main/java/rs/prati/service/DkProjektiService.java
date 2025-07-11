package rs.prati.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import rs.prati.core.model.DkProjekti;
import rs.prati.service.common.AbstractCrudService;
import rs.prati.service.dto.DkProjektiDto;
import rs.prati.service.mapper.DkProjektiMapper;
import rs.prati.service.mapper.EntityMapper;
import rs.prati.service.repository.DkProjektiRepository;

import java.util.List;
import java.util.Optional;

/**
 * Сервис за обраду ентитета DkProjekti (пројекат).
 */
@Service
public class DkProjektiService extends AbstractCrudService<DkProjekti, DkProjektiDto> {

    private final DkProjektiRepository repository;
    private final DkProjektiMapper mapper;

    public DkProjektiService(DkProjektiRepository repository, DkProjektiMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    protected JpaRepository<DkProjekti, Long> getRepository() {
        return repository;
    }

    @Override
    protected EntityMapper<DkProjekti, DkProjektiDto> getMapper() {
        return mapper;
    }

    /**
     * Чување или ажурирање пројекта.
     */
    @Transactional
    public DkProjektiDto save(DkProjektiDto dto) {
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
    public Optional<DkProjektiDto> findById(Long id) {
        return super.findById(id);
    }

    /**
     * Враћа све не-обрисане пројекте.
     */
    @Transactional(readOnly = true)
    public List<DkProjektiDto> findAll() {
        return repository.findByIzbrisanFalseOrderByIdDesc()
                .stream()
                .map(mapper::toDto)
                .toList();
    }

    /**
     * Враћа све пројекте за датог претплатника.
     */
    @Transactional(readOnly = true)
    public List<DkProjektiDto> findAllForPretplatnik(Long pretplatnikId) {
        return repository.findByPretplatnikIdAndIzbrisanFalseOrderByIdDesc(pretplatnikId)
                .stream()
                .map(mapper::toDto)
                .toList();
    }

    /**
     * Враћа све пројекте за датог партнера.
     */
    @Transactional(readOnly = true)
    public List<DkProjektiDto> findAllForPartner(Long partnerId) {
        return repository.findByPartnerIdAndIzbrisanFalseOrderByIdDesc(partnerId)
                .stream()
                .map(mapper::toDto)
                .toList();
    }
}
