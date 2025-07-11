package rs.prati.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import rs.prati.core.model.DxObjektiPoslednje;
import rs.prati.service.common.AbstractCrudService;
import rs.prati.service.dto.DxObjektiPoslednjeDto;
import rs.prati.service.mapper.DxObjektiPoslednjeMapper;
import rs.prati.service.mapper.EntityMapper;
import rs.prati.service.repository.DxObjektiPoslednjeRepository;

import java.util.List;
import java.util.Optional;

/**
 * Сервис за обраду ентитета DxObjektiPoslednje (подаци о последњим сервисима, регистрацији и километражи објекта).
 */
@Service
public class DxObjektiPoslednjeService extends AbstractCrudService<DxObjektiPoslednje, DxObjektiPoslednjeDto> {

    private final DxObjektiPoslednjeRepository repository;
    private final DxObjektiPoslednjeMapper mapper;

    public DxObjektiPoslednjeService(DxObjektiPoslednjeRepository repository, DxObjektiPoslednjeMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    protected JpaRepository<DxObjektiPoslednje, Long> getRepository() {
        return repository;
    }

    @Override
    protected EntityMapper<DxObjektiPoslednje, DxObjektiPoslednjeDto> getMapper() {
        return mapper;
    }

    /**
     * Чување или ажурирање записа о последњим сервисима.
     */
    @Transactional
    public DxObjektiPoslednjeDto save(DxObjektiPoslednjeDto dto) {
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
     * Проналажење по ID.
     */
    @Transactional(readOnly = true)
    public Optional<DxObjektiPoslednjeDto> findById(Long id) {
        return super.findById(id);
    }

    /**
     * Враћа све записе за дати објекат.
     */
    @Transactional(readOnly = true)
    public List<DxObjektiPoslednjeDto> findAllForObjekat(Long objekatId) {
        return repository.findByObjekat_IdOrderByIdDesc(objekatId)
                .stream()
                .map(mapper::toDto)
                .toList();
    }
}
