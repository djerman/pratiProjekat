package rs.prati.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import rs.prati.core.model.DjTroskovi;
import rs.prati.service.common.AbstractCrudService;
import rs.prati.service.dto.DjTroskoviDto;
import rs.prati.service.mapper.DjTroskoviMapper;
import rs.prati.service.mapper.EntityMapper;
import rs.prati.service.repository.DjTroskoviRepository;

import java.util.List;
import java.util.Optional;

/**
 * Сервис за обраду ентитета DjTroskovi (трошак).
 */
@Service
public class DjTroskoviService extends AbstractCrudService<DjTroskovi, DjTroskoviDto> {

    private final DjTroskoviRepository repository;
    private final DjTroskoviMapper mapper;

    public DjTroskoviService(DjTroskoviRepository repository, DjTroskoviMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    protected JpaRepository<DjTroskovi, Long> getRepository() {
        return repository;
    }

    @Override
    protected EntityMapper<DjTroskovi, DjTroskoviDto> getMapper() {
        return mapper;
    }

    /**
     * Чување или ажурирање трошка.
     */
    @Transactional
    public DjTroskoviDto save(DjTroskoviDto dto) {
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
    public Optional<DjTroskoviDto> findById(Long id) {
        return super.findById(id);
    }

    /**
     * Враћа све не-обрисане трошкове.
     */
    @Transactional(readOnly = true)
    public List<DjTroskoviDto> findAll() {
        return repository.findByIzbrisanFalseOrderByIdDesc()
                .stream()
                .map(mapper::toDto)
                .toList();
    }

    /**
     * Враћа све трошкове за дати објекат.
     */
    @Transactional(readOnly = true)
    public List<DjTroskoviDto> findAllForObjekat(Long objekatId) {
        return repository.findByObjekatIdAndIzbrisanFalseOrderByIdDesc(objekatId)
                .stream()
                .map(mapper::toDto)
                .toList();
    }

    /**
     * Враћа све трошкове за датог партнера.
     */
    @Transactional(readOnly = true)
    public List<DjTroskoviDto> findAllForPartner(Long partnerId) {
        return repository.findByPartnerIdAndIzbrisanFalseOrderByIdDesc(partnerId)
                .stream()
                .map(mapper::toDto)
                .toList();
    }

    /**
     * Враћа све трошкове за датог претплатника.
     */
    @Transactional(readOnly = true)
    public List<DjTroskoviDto> findAllForPretplatnik(Long pretplatnikId) {
        return repository.findByPretplatnikIdAndIzbrisanFalseOrderByIdDesc(pretplatnikId)
                .stream()
                .map(mapper::toDto)
                .toList();
    }
}
