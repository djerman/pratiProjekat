package rs.prati.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import rs.prati.core.model.BcUredjaji;
import rs.prati.service.common.AbstractCrudService;
import rs.prati.service.dto.BcUredjajiDto;
import rs.prati.service.mapper.BcUredjajiMapper;
import rs.prati.service.repository.BcUredjajiRepository;

import java.util.List;

/**
 * Сервис за управљање уређајима (BcUredjaji).
 */
@Service
@Transactional
public class BcUredjajiService extends AbstractCrudService<BcUredjaji, BcUredjajiDto> {

    private final BcUredjajiRepository repository;
    private final BcUredjajiMapper mapper;

    public BcUredjajiService(BcUredjajiRepository repository, BcUredjajiMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    protected BcUredjajiRepository getRepository() {
        return repository;
    }

    @Override
    protected BcUredjajiMapper getMapper() {
        return mapper;
    }
    
    /**
     * Враћа све уређаје који нису означени као избрисани.
     * Овај метод је намењен само системским корисницима.
     */
    @Transactional(readOnly = true)
    public List<BcUredjajiDto> findAllNotDeleted() {
        return repository.findByIzbrisanFalse()
                .stream()
                .map(mapper::toDto)
                .toList();
    }


    /**
     * Проналази све слободне уређаје у систему (само активни).
     * Користи се за системски преглед.
     */
    @Transactional(readOnly = true)
    public List<BcUredjajiDto> findSviSlobodni() {
        return repository.findByObjekatIsNullAndAktivanTrueAndIzbrisanFalse()
                .stream()
                .map(mapper::toDto)
                .toList();
    }

    /**
     * Проналази све слободне уређаје за једног претплатника (само активни).
     * Користи се за администраторски преглед.
     */
    @Transactional(readOnly = true)
    public List<BcUredjajiDto> findSlobodniZaPretplatnika(Long pretplatnikId) {
        return repository.findByPretplatnik_IdAndObjekatIsNullAndAktivanTrueAndIzbrisanFalse(pretplatnikId)
                .stream()
                .map(mapper::toDto)
                .toList();
    }

    /**
     * Аутоматски поставља поље zauzet пре снимања.
     */
    @Override
    protected void beforeSave(BcUredjaji entity, BcUredjajiDto dto) {
        entity.setZauzet(entity.getObjekat() != null);
    }
}
