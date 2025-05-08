package rs.prati.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import rs.prati.core.model.BeGrupe;
import rs.prati.service.dto.BeGrupeDto;
import rs.prati.service.mapper.BeGrupeMapper;
import rs.prati.service.mapper.EntityMapper;
import rs.prati.service.repository.BeGrupeRepository;
import rs.prati.service.common.AbstractCrudService;

@Service
@Transactional
public class BeGrupeService extends AbstractCrudService<BeGrupe, BeGrupeDto> {

    public BeGrupeService(BeGrupeRepository repository, BeGrupeMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    protected BeGrupeRepository getRepository() {
        return repository;
    }
    
	@Override
	protected EntityMapper<BeGrupe, BeGrupeDto> getMapper() {
		return mapper;
	}
	
    /**
     * Чува или ажурира групу.
     */
    @Transactional
    public BeGrupeDto save(BeGrupeDto dto) {
        BeGrupe entity = mapper.toEntity(dto);
        beforeSave(entity, dto);
        return mapper.toDto(repository.save(entity));
    }

    /**
     * Меко брише групу (означава је као избрисану).
     */
    @Transactional
    public void oznaciIzbrisan(Long id) {
        repository.findById(id).ifPresent(entity -> {
            entity.setIzbrisan(true);
            repository.save(entity);
        });
    }

    /**
     * Трајно брише групу из базе.
     */
    @Transactional
    public void hardDelete(Long id) {
        repository.deleteById(id);
    }

    private final BeGrupeRepository repository;
    private final BeGrupeMapper mapper;

    /**
     * Враћа све групе за датог претплатника које нису обрисане.
     * Приступ имају улоге: систем и администратор претплатника.
     */
    public List<BeGrupeDto> findAllForPretplatnik(Long pretplatnikId) {
        return repository.findByPretplatnik_IdAndIzbrisanFalse(pretplatnikId)
                .stream()
                .map(mapper::toDto)
                .toList();
    }
    
}
