package rs.prati.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import rs.prati.core.model.CdObjektiAlarmi;
import rs.prati.service.common.AbstractCrudService;
import rs.prati.service.dto.CdObjektiAlarmiDto;
import rs.prati.service.mapper.CdObjektiAlarmiMapper;
import rs.prati.service.mapper.EntityMapper;
import rs.prati.service.repository.CdObjektiAlarmiRepository;

import java.util.List;
import java.util.Optional;

/**
 * Сервис за обраду ентитета CdObjektiAlarmi.
 */
@Service
public class CdObjektiAlarmiService extends AbstractCrudService<CdObjektiAlarmi, CdObjektiAlarmiDto> {

    private final CdObjektiAlarmiRepository repository;
    private final CdObjektiAlarmiMapper mapper;

    public CdObjektiAlarmiService(CdObjektiAlarmiRepository repository, CdObjektiAlarmiMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    protected JpaRepository<CdObjektiAlarmi, Long> getRepository() {
        return repository;
    }

    @Override
    protected EntityMapper<CdObjektiAlarmi, CdObjektiAlarmiDto> getMapper() {
        return mapper;
    }

    /**
     * Чување нове или постојеће конфигурације аларма.
     */
    @Transactional
    public CdObjektiAlarmiDto save(CdObjektiAlarmiDto dto) {
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
     * Меко брисање — означава запис као обрисан.
     */
    @Transactional
    public void oznaciIzbrisan(Long id) {
        repository.findById(id).ifPresent(entity -> {
            entity.setIzbrisan(true);
            repository.save(entity);
        });
    }

    /**
     * Проналажење по ID-у.
     */
    @Transactional(readOnly = true)
    public Optional<CdObjektiAlarmiDto> findById(Long id) {
        return super.findById(id);
    }

    /**
     * Враћа све необрисане конфигурације аларма.
     */
    @Transactional(readOnly = true)
    public List<CdObjektiAlarmiDto> findAll() {
        return super.findAll();
    }

    /**
     * Враћа све конфигурације аларма за задатог претплатника.
     */
    @Transactional(readOnly = true)
    public List<CdObjektiAlarmiDto> findAllForPretplatnik(Long pretplatnikId) {
        return repository.findByPretplatnik_IdAndIzbrisanFalseOrderByIdDesc().stream()
                .map(mapper::toDto)
                .toList();
    }
}
