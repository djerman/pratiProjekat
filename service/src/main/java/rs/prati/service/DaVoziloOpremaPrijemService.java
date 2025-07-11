package rs.prati.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import rs.prati.core.model.DaVoziloOpremaPrijem;
import rs.prati.service.common.AbstractCrudService;
import rs.prati.service.dto.DaVoziloOpremaPrijemDto;
import rs.prati.service.mapper.DaVoziloOpremaPrijemMapper;
import rs.prati.service.mapper.EntityMapper;
import rs.prati.service.repository.DaVoziloOpremaPrijemRepository;

import java.util.List;
import java.util.Optional;

/**
 * Сервис за ентитет DaVoziloOpremaPrijem.
 */
@Service
public class DaVoziloOpremaPrijemService extends AbstractCrudService<DaVoziloOpremaPrijem, DaVoziloOpremaPrijemDto> {

    private final DaVoziloOpremaPrijemRepository repository;
    private final DaVoziloOpremaPrijemMapper mapper;

    public DaVoziloOpremaPrijemService(DaVoziloOpremaPrijemRepository repository, DaVoziloOpremaPrijemMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    protected JpaRepository<DaVoziloOpremaPrijem, Long> getRepository() {
        return repository;
    }

    @Override
    protected EntityMapper<DaVoziloOpremaPrijem, DaVoziloOpremaPrijemDto> getMapper() {
        return mapper;
    }

    /**
     * Чување новог или постојећег пријема опреме.
     */
    @Transactional
    public DaVoziloOpremaPrijemDto save(DaVoziloOpremaPrijemDto dto) {
        return super.save(dto);
    }

    /**
     * Проналажење по ID-у.
     */
    @Transactional(readOnly = true)
    public Optional<DaVoziloOpremaPrijemDto> findById(Long id) {
        return super.findById(id);
    }

    /**
     * Враћа све пријеме опреме за дату примопредају.
     */
    @Transactional(readOnly = true)
    public List<DaVoziloOpremaPrijemDto> findByPrimoPredaja(Long primoPredajaId) {
        return repository.findByPrimoPredaja_Id(primoPredajaId)
                .stream()
                .map(mapper::toDto)
                .toList();
    }

    /**
     * Враћа све пријеме опреме за задатог претплатника.
     */
    @Transactional(readOnly = true)
    public List<DaVoziloOpremaPrijemDto> findByPretplatnik(Long pretplatnikId) {
        return repository.findByPretplatnik_Id(pretplatnikId)
                .stream()
                .map(mapper::toDto)
                .toList();
    }
}
