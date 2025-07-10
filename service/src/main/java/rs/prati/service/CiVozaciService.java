package rs.prati.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import rs.prati.core.model.CiVozaci;
import rs.prati.service.common.AbstractCrudService;
import rs.prati.service.dto.CiVozaciDto;
import rs.prati.service.mapper.CiVozaciMapper;
import rs.prati.service.mapper.EntityMapper;
import rs.prati.service.repository.CiVozaciRepository;

import java.util.List;
import java.util.Optional;

/**
 * Сервис за ентитет CiVozaci – возачи у систему.
 */
@Service
public class CiVozaciService extends AbstractCrudService<CiVozaci, CiVozaciDto> {

    private final CiVozaciRepository repository;
    private final CiVozaciMapper mapper;

    public CiVozaciService(CiVozaciRepository repository, CiVozaciMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    protected JpaRepository<CiVozaci, Long> getRepository() {
        return repository;
    }

    @Override
    protected EntityMapper<CiVozaci, CiVozaciDto> getMapper() {
        return mapper;
    }

    /**
     * Чување или ажурирање података о возачу.
     */
    @Transactional
    public CiVozaciDto save(CiVozaciDto dto) {
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
    public Optional<CiVozaciDto> findById(Long id) {
        return super.findById(id);
    }

    /**
     * Враћа све возаче.
     */
    @Transactional(readOnly = true)
    public List<CiVozaciDto> findAll() {
        return super.findAll();
    }
}
