package rs.prati.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import rs.prati.core.model.BfZone;
import rs.prati.service.common.AbstractCrudService;
import rs.prati.service.dto.BfZoneDto;
import rs.prati.service.mapper.BfZoneMapper;
import rs.prati.service.mapper.EntityMapper;
import rs.prati.service.repository.BfZoneRepository;

import java.util.List;
import java.util.Optional;

/**
 * Сервис за обраду ентитета BfZone.
 */
@Service
public class BfZoneService extends AbstractCrudService<BfZone, BfZoneDto> {

    private final BfZoneRepository repository;
    private final BfZoneMapper mapper;

    public BfZoneService(BfZoneRepository repository, BfZoneMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

	@Override
	protected JpaRepository<BfZone, Long> getRepository() {
		return repository;
	}

	@Override
	protected EntityMapper<BfZone, BfZoneDto> getMapper() {
		return mapper;
	}
	
    /**
     * Чува нову зону или ажурира постојећу (ако DTO има ID).
     */
    @Transactional
    public BfZoneDto save(BfZoneDto dto) {
        return super.save(dto);
    }

    /**
     * Брише зону по ID-у (тврдо брисање).
     */
    @Transactional
    public void hardDelete(Long id) {
    	repository.deleteById(id);
    }

    /**
     * Означава зону као обрисану (меко брисање).
     */
    @Transactional
    public void oznaciIzbrisan(Long id) {
        repository.findById(id).ifPresent(entity -> {
            entity.setIzbrisan(true);
            repository.save(entity);
        });
    }

    /**
     * Враћа зону по ID-у.
     */
    @Transactional
    public Optional<BfZoneDto> findById(Long id) {
        return super.findById(id);
    }

    /**
     * Враћа све зоне (сортиране по ID опадајуће).
     */
    @Transactional
    public List<BfZoneDto> findAll() {
        return super.findAll();
    }

    /**
     * Враћа све зоне за одређеног претплатника које нису обрисане.
     */
    @Transactional
    public List<BfZoneDto> findAllForPretplatnik(Long pretplatnikId) {
        return repository.findByPretplatnik_IdAndIzbrisanFalse(pretplatnikId)
                .stream()
                .map(mapper::toDto)
                .toList();
    }


}
