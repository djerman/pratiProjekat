package rs.prati.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import rs.prati.core.model.DlSifre;
import rs.prati.service.common.AbstractCrudService;
import rs.prati.service.dto.DlSifreDto;
import rs.prati.service.mapper.DlSifreMapper;
import rs.prati.service.mapper.EntityMapper;
import rs.prati.service.repository.DlSifreRepository;

import java.util.List;
import java.util.Optional;

/**
 * Сервис за обраду ентитета DlSifre (шифре партнера).
 */
@Service
public class DlSifreService extends AbstractCrudService<DlSifre, DlSifreDto> {

    private final DlSifreRepository repository;
    private final DlSifreMapper mapper;

    public DlSifreService(DlSifreRepository repository, DlSifreMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    protected JpaRepository<DlSifre, Long> getRepository() {
        return repository;
    }

    @Override
    protected EntityMapper<DlSifre, DlSifreDto> getMapper() {
        return mapper;
    }

    /**
     * Чување или ажурирање шифре.
     */
    @Transactional
    public DlSifreDto save(DlSifreDto dto) {
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
    public Optional<DlSifreDto> findById(Long id) {
        return super.findById(id);
    }

    /**
     * Враћа све не-обрисане шифре.
     */
    @Transactional(readOnly = true)
    public List<DlSifreDto> findAll() {
        return repository.findByIzbrisanFalseOrderByIdDesc()
                .stream()
                .map(mapper::toDto)
                .toList();
    }

    /**
     * Враћа све шифре за датог претплатника.
     */
    @Transactional(readOnly = true)
    public List<DlSifreDto> findAllForPretplatnik(Long pretplatnikId) {
        return repository.findByPretplatnikIdAndIzbrisanFalseOrderByIdDesc(pretplatnikId)
                .stream()
                .map(mapper::toDto)
                .toList();
    }

    /**
     * Враћа све шифре за датог партнера.
     */
    @Transactional(readOnly = true)
    public List<DlSifreDto> findAllForPartner(Long partnerId) {
        return repository.findByPartnerIdAndIzbrisanFalseOrderByIdDesc(partnerId)
                .stream()
                .map(mapper::toDto)
                .toList();
    }
}
