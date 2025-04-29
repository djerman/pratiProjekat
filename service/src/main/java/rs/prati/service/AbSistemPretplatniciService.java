package rs.prati.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import rs.prati.core.model.AbSistemPretplatnici;
import rs.prati.service.common.AbstractCrudService;
import rs.prati.service.dto.AbSistemPretplatniciDto;
import rs.prati.service.mapper.AbSistemPretplatniciMapper;
import rs.prati.service.repository.AbSistemPretplatniciRepository;

/**
 * Сервис класа за управљање ентитетом AbSistemPretplatnici.
 * Наслеђује основне CRUD методе из AbstractCrudService.
 */
@Service
@Transactional
public class AbSistemPretplatniciService extends AbstractCrudService<AbSistemPretplatnici, AbSistemPretplatniciDto> {

    /** Репозиторијум за приступ ентитету AbSistemPretplatnici. */
    private final AbSistemPretplatniciRepository repository;

    /** MapStruct мапер за конверзију између ентитета и DTO-а. */
    private final AbSistemPretplatniciMapper mapper;

    /**
     * Конструктор који иницијализује репозиторијум и мапер.
     *
     * @param repository репозиторијум за AbSistemPretplatnici
     * @param mapper мапер за AbSistemPretplatnici
     */
    public AbSistemPretplatniciService(AbSistemPretplatniciRepository repository, AbSistemPretplatniciMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    /**
     * Враћа репозиторијум за AbSistemPretplatnici.
     *
     * @return репозиторијум
     */
    @Override
    protected AbSistemPretplatniciRepository getRepository() {
        return repository;
    }

    /**
     * Враћа мапер за AbSistemPretplatnici.
     *
     * @return мапер
     */
    @Override
    protected AbSistemPretplatniciMapper getMapper() {
        return mapper;
    }
}
