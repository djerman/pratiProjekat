package rs.prati.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import rs.prati.core.model.AhSistemUredjajiProizvodjac;
import rs.prati.service.common.AbstractCrudService;
import rs.prati.service.dto.AhSistemUredjajiProizvodjacDto;
import rs.prati.service.mapper.AhSistemUredjajiProizvodjacMapper;
import rs.prati.service.repository.AhSistemUredjajiProizvodjacRepository;

/**
 * Сервис класа за управљање ентитетом AhSistemUredjajiProizvodjac.
 * Наслеђује основне CRUD методе из AbstractCrudService.
 */
@Service
@Transactional
public class AhSistemUredjajiProizvodjacService extends AbstractCrudService<AhSistemUredjajiProizvodjac, AhSistemUredjajiProizvodjacDto> {

    /** Репозиторијум за приступ ентитету AhSistemUredjajiProizvodjac. */
    private final AhSistemUredjajiProizvodjacRepository repository;

    /** MapStruct мапер за конверзију између ентитета и DTO-а. */
    private final AhSistemUredjajiProizvodjacMapper mapper;

    /**
     * Конструктор који иницијализује репозиторијум и мапер.
     *
     * @param repository репозиторијум за AhSistemUredjajiProizvodjac
     * @param mapper мапер за AhSistemUredjajiProizvodjac
     */
    public AhSistemUredjajiProizvodjacService(AhSistemUredjajiProizvodjacRepository repository, AhSistemUredjajiProizvodjacMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    /**
     * Враћа репозиторијум за AhSistemUredjajiProizvodjac.
     *
     * @return репозиторијум
     */
    @Override
    protected AhSistemUredjajiProizvodjacRepository getRepository() {
        return repository;
    }

    /**
     * Враћа мапер за AhSistemUredjajiProizvodjac.
     *
     * @return мапер
     */
    @Override
    protected AhSistemUredjajiProizvodjacMapper getMapper() {
        return mapper;
    }
}
