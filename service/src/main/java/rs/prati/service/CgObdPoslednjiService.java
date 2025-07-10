package rs.prati.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import rs.prati.core.model.CgObdPoslednji;
import rs.prati.service.common.AbstractCrudService;
import rs.prati.service.dto.CgObdPoslednjiDto;
import rs.prati.service.mapper.CgObdPoslednjiMapper;
import rs.prati.service.mapper.EntityMapper;
import rs.prati.service.repository.CgObdPoslednjiRepository;

import java.util.List;
import java.util.Optional;

/**
 * Сервис за ентитет CgObdPoslednji – последњи OBD подаци по објекту.
 */
@Service
public class CgObdPoslednjiService extends AbstractCrudService<CgObdPoslednji, CgObdPoslednjiDto> {

    private final CgObdPoslednjiRepository repository;
    private final CgObdPoslednjiMapper mapper;

    public CgObdPoslednjiService(CgObdPoslednjiRepository repository, CgObdPoslednjiMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    protected JpaRepository<CgObdPoslednji, Long> getRepository() {
        return repository;
    }

    @Override
    protected EntityMapper<CgObdPoslednji, CgObdPoslednjiDto> getMapper() {
        return mapper;
    }

    /**
     * Чување нових или ажурираних OBD података.
     */
    @Transactional
    public CgObdPoslednjiDto save(CgObdPoslednjiDto dto) {
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
    public Optional<CgObdPoslednjiDto> findById(Long id) {
        return super.findById(id);
    }

    /**
     * Враћа све OBD податке.
     */
    @Transactional(readOnly = true)
    public List<CgObdPoslednjiDto> findAll() {
        return super.findAll();
    }
}
