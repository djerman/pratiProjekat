package rs.prati.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import rs.prati.core.model.BdSim;
import rs.prati.service.common.AbstractCrudService;
import rs.prati.service.dto.BdSimDto;
import rs.prati.service.mapper.BdSimMapper;
import rs.prati.service.repository.BdSimRepository;

import java.util.List;

@Service
@Transactional
public class BdSimService extends AbstractCrudService<BdSim, BdSimDto> {

    private final BdSimRepository repository;
    private final BdSimMapper mapper;

    public BdSimService(BdSimRepository repository, BdSimMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    protected BdSimRepository getRepository() {
        return repository;
    }

    @Override
    protected BdSimMapper getMapper() {
        return mapper;
    }

    @Transactional(readOnly = true)
    public List<BdSimDto> findSviSlobodni() {
        return repository.findByUredjajIsNullAndAktivanTrueAndIzbrisanFalse()
                .stream()
                .map(mapper::toDto)
                .toList();
    }

    @Transactional(readOnly = true)
    public List<BdSimDto> findSlobodniZaPretplatnika(Long pretplatnikId) {
        return repository.findByPretplatnik_IdAndUredjajIsNullAndAktivanTrueAndIzbrisanFalse(pretplatnikId)
                .stream()
                .map(mapper::toDto)
                .toList();
    }

    @Transactional(readOnly = true)
    public List<BdSimDto> findAllForPretplatnik(Long pretplatnikId) {
        return repository.findByPretplatnik_IdAndIzbrisanFalse(pretplatnikId)
                .stream()
                .map(mapper::toDto)
                .toList();
    }

    @Override
    protected void beforeSave(BdSim entity, BdSimDto dto) {
        entity.setZauzet(entity.getUredjaj() != null);
    }
}