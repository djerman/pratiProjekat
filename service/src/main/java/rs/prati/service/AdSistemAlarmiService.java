package rs.prati.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import rs.prati.core.model.AdSistemAlarmi;
import rs.prati.service.common.AbstractCrudService;
import rs.prati.service.dto.AdSistemAlarmiDto;
import rs.prati.service.mapper.AdSistemAlarmiMapper;
import rs.prati.service.repository.AdSistemAlarmiRepository;

/**
 * Сервис класа за управљање ентитетом AdSistemAlarmi.
 * Наслеђује основне CRUD методе из AbstractCrudService.
 */
@Service
@Transactional
public class AdSistemAlarmiService extends AbstractCrudService<AdSistemAlarmi, AdSistemAlarmiDto> {

    /** Репозиторијум за приступ ентитету AdSistemAlarmi. */
    private final AdSistemAlarmiRepository repository;

    /** MapStruct мапер за конверзију између ентитета и DTO-а. */
    private final AdSistemAlarmiMapper mapper;

    /**
     * Конструктор који иницијализује репозиторијум и мапер.
     *
     * @param repository репозиторијум за AdSistemAlarmi
     * @param mapper мапер за AdSistemAlarmi
     */
    public AdSistemAlarmiService(AdSistemAlarmiRepository repository, AdSistemAlarmiMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    /**
     * Враћа репозиторијум за AdSistemAlarmi.
     *
     * @return репозиторијум
     */
    @Override
    protected AdSistemAlarmiRepository getRepository() {
        return repository;
    }

    /**
     * Враћа мапер за AdSistemAlarmi.
     *
     * @return мапер
     */
    @Override
    protected AdSistemAlarmiMapper getMapper() {
        return mapper;
    }
}
