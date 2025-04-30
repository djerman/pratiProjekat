package rs.prati.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import rs.prati.core.model.AfSistemOperateri;
import rs.prati.service.common.AbstractCrudService;
import rs.prati.service.dto.AfSistemOperateriDto;
import rs.prati.service.mapper.AfSistemOperateriMapper;
import rs.prati.service.repository.AfSistemOperateriRepository;

/**
 * Сервис класа за управљање ентитетом AfSistemOperateri.
 * Наслеђује основне CRUD методе из AbstractCrudService.
 */
@Service
@Transactional
public class AfSistemOperateriService extends AbstractCrudService<AfSistemOperateri, AfSistemOperateriDto> {

    /** Репозиторијум за приступ ентитету AfSistemOperateri. */
    private final AfSistemOperateriRepository repository;

    /** MapStruct мапер за конверзију између ентитета и DTO-а. */
    private final AfSistemOperateriMapper mapper;

    /**
     * Конструктор који иницијализује репозиторијум и мапер.
     *
     * @param repository репозиторијум за AfSistemOperateri
     * @param mapper мапер за AfSistemOperateri
     */
    public AfSistemOperateriService(AfSistemOperateriRepository repository, AfSistemOperateriMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    /**
     * Враћа репозиторијум за AfSistemOperateri.
     *
     * @return репозиторијум
     */
    @Override
    protected AfSistemOperateriRepository getRepository() {
        return repository;
    }

    /**
     * Враћа мапер за AfSistemOperateri.
     *
     * @return мапер
     */
    @Override
    protected AfSistemOperateriMapper getMapper() {
        return mapper;
    }
}
