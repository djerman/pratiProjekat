package rs.prati.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import rs.prati.core.model.AcOrganizacije;
import rs.prati.service.common.AbstractCrudService;
import rs.prati.service.dto.AcOrganizacijeDto;
import rs.prati.service.mapper.AcOrganizacijeMapper;
import rs.prati.service.repository.AcOrganizacijeRepository;

/**
 * Сервис класа за управљање ентитетом AcOrganizacije.
 * Наслеђује основне CRUD методе из AbstractCrudService.
 */
@Service
@Transactional
public class AcOrganizacijeService extends AbstractCrudService<AcOrganizacije, AcOrganizacijeDto> {

    /** Репозиторијум за приступ ентитету AcOrganizacije. */
    private final AcOrganizacijeRepository repository;

    /** MapStruct мапер за конверзију између ентитета и DTO-а. */
    private final AcOrganizacijeMapper mapper;

    /**
     * Конструктор који иницијализује репозиторијум и мапер.
     *
     * @param repository репозиторијум за AcOrganizacije
     * @param mapper мапер за AcOrganizacije
     */
    public AcOrganizacijeService(AcOrganizacijeRepository repository, AcOrganizacijeMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    /**
     * Враћа репозиторијум за AcOrganizacije.
     *
     * @return репозиторијум
     */
    @Override
    protected AcOrganizacijeRepository getRepository() {
        return repository;
    }

    /**
     * Враћа мапер за AcOrganizacije.
     *
     * @return мапер
     */
    @Override
    protected AcOrganizacijeMapper getMapper() {
        return mapper;
    }
}