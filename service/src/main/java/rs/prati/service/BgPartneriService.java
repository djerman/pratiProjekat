package rs.prati.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import rs.prati.core.model.BgPartneri;
import rs.prati.service.common.AbstractCrudService;
import rs.prati.service.dto.BgPartneriDto;
import rs.prati.service.mapper.BgPartneriMapper;
import rs.prati.service.mapper.EntityMapper;
import rs.prati.service.repository.BgPartneriRepository;

import java.util.List;
import java.util.Optional;

/**
 * Сервис за обраду ентитета BgPartneri.
 */
@Service
public class BgPartneriService extends AbstractCrudService<BgPartneri, BgPartneriDto> {

    private final BgPartneriRepository repository;
    private final BgPartneriMapper mapper;

    public BgPartneriService(BgPartneriRepository repository, BgPartneriMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    protected JpaRepository<BgPartneri, Long> getRepository() {
        return repository;
    }

    @Override
    protected EntityMapper<BgPartneri, BgPartneriDto> getMapper() {
        return mapper;
    }

    /**
     * Чува партнера (новог или постојећег).
     */
    @Transactional
    public BgPartneriDto save(BgPartneriDto dto) {
        return super.save(dto);
    }

    /**
     * Тврдо брисање партнера.
     */
    @Transactional
    public void hardDelete(Long id) {
        repository.deleteById(id);
    }

    /**
     * Меко брисање – означава партнера као обрисаног.
     */
    @Transactional
    public void oznaciIzbrisan(Long id) {
        repository.findById(id).ifPresent(entity -> {
            entity.setIzbrisan(true);
            repository.save(entity);
        });
    }

    /**
     * Враћа партнера по ID-у.
     */
    @Transactional(readOnly = true)
    public Optional<BgPartneriDto> findById(Long id) {
        return super.findById(id);
    }

    /**
     * Враћа све партнере који нису обрисани.
     */
    @Transactional(readOnly = true)
    public List<BgPartneriDto> findAll() {
        return super.findAll();
    }

    /**
     * Враћа партнере за задатог претплатника.
     */
    @Transactional(readOnly = true)
    public List<BgPartneriDto> findAllForPretplatnik(Long pretplatnikId) {
        return repository.findByPretplatnik_IdAndIzbrisanFalseOrderByIdDesc()
                .stream()
                .map(mapper::toDto)
                .toList();
    }
}
