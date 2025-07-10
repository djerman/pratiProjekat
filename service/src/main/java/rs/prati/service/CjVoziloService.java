package rs.prati.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import rs.prati.core.model.CjVozilo;
import rs.prati.service.common.AbstractCrudService;
import rs.prati.service.dto.CjVoziloDto;
import rs.prati.service.mapper.CjVoziloMapper;
import rs.prati.service.mapper.EntityMapper;
import rs.prati.service.repository.CjVoziloRepository;

import java.util.List;
import java.util.Optional;

/**
 * Сервис за ентитет CjVozilo – возила у систему.
 */
@Service
public class CjVoziloService extends AbstractCrudService<CjVozilo, CjVoziloDto> {

    private final CjVoziloRepository repository;
    private final CjVoziloMapper mapper;

    public CjVoziloService(CjVoziloRepository repository, CjVoziloMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    protected JpaRepository<CjVozilo, Long> getRepository() {
        return repository;
    }

    @Override
    protected EntityMapper<CjVozilo, CjVoziloDto> getMapper() {
        return mapper;
    }

    /**
     * Чување или ажурирање возила.
     */
    @Transactional
    public CjVoziloDto save(CjVoziloDto dto) {
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
    public Optional<CjVoziloDto> findById(Long id) {
        return super.findById(id);
    }

    /**
     * Враћа сва возила.
     */
    @Transactional(readOnly = true)
    public List<CjVoziloDto> findAll() {
        return super.findAll();
    }
}
