package rs.prati.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import rs.prati.core.model.CgObd;
import rs.prati.service.common.AbstractCrudService;
import rs.prati.service.dto.CgObdDto;
import rs.prati.service.mapper.CgObdMapper;
import rs.prati.service.mapper.EntityMapper;
import rs.prati.service.repository.CgObdRepository;

import java.util.List;
import java.util.Optional;

/**
 * Сервис за обраду ентитета CgObd – OBD подаци возила.
 */
@Service
public class CgObdService extends AbstractCrudService<CgObd, CgObdDto> {

    private final CgObdRepository repository;
    private final CgObdMapper mapper;

    public CgObdService(CgObdRepository repository, CgObdMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    protected JpaRepository<CgObd, Long> getRepository() {
        return repository;
    }

    @Override
    protected EntityMapper<CgObd, CgObdDto> getMapper() {
        return mapper;
    }

    @Transactional
    public CgObdDto save(CgObdDto dto) {
        return super.save(dto);
    }

    @Transactional
    public void hardDelete(Long id) {
        repository.deleteById(id);
    }

    @Transactional(readOnly = true)
    public Optional<CgObdDto> findById(Long id) {
        return super.findById(id);
    }

    @Transactional(readOnly = true)
    public List<CgObdDto> findAll() {
        return super.findAll();
    }
}
