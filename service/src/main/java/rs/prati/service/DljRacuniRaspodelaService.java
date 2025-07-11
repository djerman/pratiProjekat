package rs.prati.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import rs.prati.core.model.DljRacuniRaspodela;
import rs.prati.service.common.AbstractCrudService;
import rs.prati.service.dto.DljRacuniRaspodelaDto;
import rs.prati.service.mapper.DljRacuniRaspodelaMapper;
import rs.prati.service.mapper.EntityMapper;
import rs.prati.service.repository.DljRacuniRaspodelaRepository;

import java.util.List;
import java.util.Optional;

/**
 * Сервис за обраду ентитета DljRacuniRaspodela (расподела износа по рачунима).
 */
@Service
public class DljRacuniRaspodelaService extends AbstractCrudService<DljRacuniRaspodela, DljRacuniRaspodelaDto> {

    private final DljRacuniRaspodelaRepository repository;
    private final DljRacuniRaspodelaMapper mapper;

    public DljRacuniRaspodelaService(DljRacuniRaspodelaRepository repository, DljRacuniRaspodelaMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    protected JpaRepository<DljRacuniRaspodela, Long> getRepository() {
        return repository;
    }

    @Override
    protected EntityMapper<DljRacuniRaspodela, DljRacuniRaspodelaDto> getMapper() {
        return mapper;
    }

    /**
     * Чување или ажурирање расподеле.
     */
    @Transactional
    public DljRacuniRaspodelaDto save(DljRacuniRaspodelaDto dto) {
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
    public Optional<DljRacuniRaspodelaDto> findById(Long id) {
        return super.findById(id);
    }

    /**
     * Враћа све расподеле за датог партнера.
     */
    @Transactional(readOnly = true)
    public List<DljRacuniRaspodelaDto> findAllForPartner(Long partnerId) {
        return repository.findByPartnerIdOrderByIdDesc(partnerId)
                .stream()
                .map(mapper::toDto)
                .toList();
    }

    /**
     * Враћа све расподеле за дати рачун.
     */
    @Transactional(readOnly = true)
    public List<DljRacuniRaspodelaDto> findAllForRacun(Long racunId) {
        return repository.findByRacunIdOrderByIdDesc(racunId)
                .stream()
                .map(mapper::toDto)
                .toList();
    }

    /**
     * Враћа све расподеле за датог претплатника.
     */
    @Transactional(readOnly = true)
    public List<DljRacuniRaspodelaDto> findAllForPretplatnik(Long pretplatnikId) {
        return repository.findByPretplatnikIdOrderByIdDesc(pretplatnikId)
                .stream()
                .map(mapper::toDto)
                .toList();
    }
}
