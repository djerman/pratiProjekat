package rs.prati.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import rs.prati.core.model.DgVoziloSaobracajna;
import rs.prati.service.common.AbstractCrudService;
import rs.prati.service.dto.DgVoziloSaobracajnaDto;
import rs.prati.service.mapper.DgVoziloSaobracajnaMapper;
import rs.prati.service.mapper.EntityMapper;
import rs.prati.service.repository.DgVoziloSaobracajnaRepository;

import java.util.List;
import java.util.Optional;

/**
 * Сервис за обраду ентитета DgVoziloSaobracajna (саобраћајна дозвола возила).
 */
@Service
public class DgVoziloSaobracajnaService extends AbstractCrudService<DgVoziloSaobracajna, DgVoziloSaobracajnaDto> {

    private final DgVoziloSaobracajnaRepository repository;
    private final DgVoziloSaobracajnaMapper mapper;

    public DgVoziloSaobracajnaService(DgVoziloSaobracajnaRepository repository, DgVoziloSaobracajnaMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    protected JpaRepository<DgVoziloSaobracajna, Long> getRepository() {
        return repository;
    }

    @Override
    protected EntityMapper<DgVoziloSaobracajna, DgVoziloSaobracajnaDto> getMapper() {
        return mapper;
    }

    /**
     * Чување или ажурирање саобраћајне дозволе.
     */
    @Transactional
    public DgVoziloSaobracajnaDto save(DgVoziloSaobracajnaDto dto) {
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
    public Optional<DgVoziloSaobracajnaDto> findById(Long id) {
        return super.findById(id);
    }

    /**
     * Враћа све не-обрисане саобраћајне дозволе.
     */
    @Transactional(readOnly = true)
    public List<DgVoziloSaobracajnaDto> findAll() {
        return repository.findByIzbrisanFalseOrderByIdDesc()
                .stream()
                .map(mapper::toDto)
                .toList();
    }

    /**
     * Враћа све саобраћајне дозволе за дато возило.
     */
    @Transactional(readOnly = true)
    public List<DgVoziloSaobracajnaDto> findAllForVozilo(Long voziloId) {
        return repository.findByVoziloIdAndIzbrisanFalseOrderByIdDesc(voziloId)
                .stream()
                .map(mapper::toDto)
                .toList();
    }

    /**
     * Враћа све саобраћајне дозволе за датог претплатника.
     */
    @Transactional(readOnly = true)
    public List<DgVoziloSaobracajnaDto> findAllForPretplatnik(Long pretplatnikId) {
        return repository.findByPretplatnikIdAndIzbrisanFalseOrderByIdDesc(pretplatnikId)
                .stream()
                .map(mapper::toDto)
                .toList();
    }
}
