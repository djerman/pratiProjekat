package rs.prati.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import rs.prati.core.model.CbGrupeObjekti;
import rs.prati.service.common.AbstractCrudService;
import rs.prati.service.dto.CbGrupeObjektiDto;
import rs.prati.service.mapper.CbGrupeObjektiMapper;
import rs.prati.service.mapper.EntityMapper;
import rs.prati.service.repository.CbGrupeObjektiRepository;

import java.util.List;
import java.util.Optional;

/**
 * Сервис за обраду ентитета CbGrupeObjekti.
 */
@Service
public class CbGrupeObjektiService extends AbstractCrudService<CbGrupeObjekti, CbGrupeObjektiDto> {

    private final CbGrupeObjektiRepository repository;
    private final CbGrupeObjektiMapper mapper;

    public CbGrupeObjektiService(CbGrupeObjektiRepository repository, CbGrupeObjektiMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    protected JpaRepository<CbGrupeObjekti, Long> getRepository() {
        return repository;
    }

    @Override
    protected EntityMapper<CbGrupeObjekti, CbGrupeObjektiDto> getMapper() {
        return mapper;
    }

    /**
     * Чување нове или постојеће везе.
     */
    @Transactional
    public CbGrupeObjektiDto save(CbGrupeObjektiDto dto) {
        return super.save(dto);
    }

    /**
     * Тврдо брисање записа по ID-у.
     */
    @Transactional
    public void hardDelete(Long id) {
        repository.deleteById(id);
    }

    /**
     * Меко брисање – означава као обрисано.
     */
    @Transactional
    public void oznaciIzbrisan(Long id) {
        repository.findById(id).ifPresent(entity -> {
            entity.setIzbrisan(true);
            repository.save(entity);
        });
    }

    /**
     * Проналажење записа по ID-у.
     */
    @Transactional(readOnly = true)
    public Optional<CbGrupeObjektiDto> findById(Long id) {
        return super.findById(id);
    }

    /**
     * Враћа све активне записе.
     */
    @Transactional(readOnly = true)
    public List<CbGrupeObjektiDto> findAll() {
        return super.findAll();
    }

    /**
     * Враћа све везе за одређеног претплатника.
     */
    @Transactional(readOnly = true)
    public List<CbGrupeObjektiDto> findAllForPretplatnik(Long pretplatnikId) {
        return repository.findByPretplatnik_IdAndIzbrisanFalseOrderByIdDesc().stream()
                .map(mapper::toDto)
                .toList();
    }
}
