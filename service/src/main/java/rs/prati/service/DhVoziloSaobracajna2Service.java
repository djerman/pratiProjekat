package rs.prati.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import rs.prati.core.model.DhVoziloSaobracajna2;
import rs.prati.service.common.AbstractCrudService;
import rs.prati.service.dto.DhVoziloSaobracajna2Dto;
import rs.prati.service.mapper.DhVoziloSaobracajna2Mapper;
import rs.prati.service.mapper.EntityMapper;
import rs.prati.service.repository.DhVoziloSaobracajna2Repository;

import java.util.List;
import java.util.Optional;

/**
 * Сервис за обраду ентитета DhVoziloSaobracajna2 (додатни подаци саобраћајне дозволе).
 */
@Service
public class DhVoziloSaobracajna2Service extends AbstractCrudService<DhVoziloSaobracajna2, DhVoziloSaobracajna2Dto> {

    private final DhVoziloSaobracajna2Repository repository;
    private final DhVoziloSaobracajna2Mapper mapper;

    public DhVoziloSaobracajna2Service(
            DhVoziloSaobracajna2Repository repository,
            DhVoziloSaobracajna2Mapper mapper
    ) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    protected JpaRepository<DhVoziloSaobracajna2, Long> getRepository() {
        return repository;
    }

    @Override
    protected EntityMapper<DhVoziloSaobracajna2, DhVoziloSaobracajna2Dto> getMapper() {
        return mapper;
    }

    /**
     * Чување или ажурирање података.
     */
    @Transactional
    public DhVoziloSaobracajna2Dto save(DhVoziloSaobracajna2Dto dto) {
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
    public Optional<DhVoziloSaobracajna2Dto> findById(Long id) {
        return super.findById(id);
    }

    /**
     * Враћа све не-обрисане записе, сортиране по ID-у опадајуће.
     */
    @Transactional(readOnly = true)
    public List<DhVoziloSaobracajna2Dto> findAll() {
        return repository.findByIzbrisanFalseOrderByIdDesc()
                .stream()
                .map(mapper::toDto)
                .toList();
    }

    /**
     * Враћа све записе за дату саобраћајну дозволу.
     */
    @Transactional(readOnly = true)
    public List<DhVoziloSaobracajna2Dto> findAllForSaobracajna(Long saobracajnaId) {
        return repository.findBySaobracajnaIdAndIzbrisanFalseOrderByIdDesc(saobracajnaId)
                .stream()
                .map(mapper::toDto)
                .toList();
    }

    /**
     * Враћа све записе за датог претплатника.
     */
    @Transactional(readOnly = true)
    public List<DhVoziloSaobracajna2Dto> findAllForPretplatnik(Long pretplatnikId) {
        return repository.findByPretplatnikIdAndIzbrisanFalseOrderByIdDesc(pretplatnikId)
                .stream()
                .map(mapper::toDto)
                .toList();
    }
}
