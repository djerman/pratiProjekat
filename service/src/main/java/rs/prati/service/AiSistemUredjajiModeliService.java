package rs.prati.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import rs.prati.core.model.AiSistemUredjajiModeli;
import rs.prati.service.common.AbstractCrudService;
import rs.prati.service.dto.AiSistemUredjajiModeliDto;
import rs.prati.service.mapper.AiSistemUredjajiModeliMapper;
import rs.prati.service.repository.AiSistemUredjajiModeliRepository;

/**
 * Сервис класа за управљање ентитетом AiSistemUredjajiModeli.
 * Наслеђује основне CRUD методе из AbstractCrudService.
 */
@Service
@Transactional
public class AiSistemUredjajiModeliService extends AbstractCrudService<AiSistemUredjajiModeli, AiSistemUredjajiModeliDto> {

    /** Репозиторијум за приступ ентитету AiSistemUredjajiModeli. */
    private final AiSistemUredjajiModeliRepository repository;

    /** MapStruct мапер за конверзију између ентитета и DTO-а. */
    private final AiSistemUredjajiModeliMapper mapper;

    /**
     * Конструктор који иницијализује репозиторијум и мапер.
     *
     * @param repository репозиторијум за AiSistemUredjajiModeli
     * @param mapper мапер за AiSistemUredjajiModeli
     */
    public AiSistemUredjajiModeliService(AiSistemUredjajiModeliRepository repository, AiSistemUredjajiModeliMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    /**
     * Враћа репозиторијум за AiSistemUredjajiModeli.
     *
     * @return репозиторијум
     */
    @Override
    protected AiSistemUredjajiModeliRepository getRepository() {
        return repository;
    }

    /**
     * Враћа мапер за AiSistemUredjajiModeli.
     *
     * @return мапер
     */
    @Override
    protected AiSistemUredjajiModeliMapper getMapper() {
        return mapper;
    }
}
