package rs.prati.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import rs.prati.core.model.AcOrganizacije;
import rs.prati.service.common.AbstractCrudService;
import rs.prati.service.dto.AcOrganizacijeDto;
import rs.prati.service.mapper.AcOrganizacijeMapper;
import rs.prati.service.repository.AcOrganizacijeRepository;

/**
 * Сервис класа за рад са ентитетом AcOrganizacije.
 * Наслеђује апстрактни CRUD сервис и обезбеђује приступ подацима организација.
 */
@Service
public class AcOrganizacijeService extends AbstractCrudService<AcOrganizacije, AcOrganizacijeDto> {

    private final AcOrganizacijeRepository repository;
    private final AcOrganizacijeMapper mapper;

    /**
     * Конструктор са зависностима.
     *
     * @param repository репозиторијум за организације
     * @param mapper     MapStruct мапер за конверзију
     */
    public AcOrganizacijeService(
            AcOrganizacijeRepository repository,
            AcOrganizacijeMapper mapper
    ) {
        this.repository = repository;
        this.mapper = mapper;
    }

    /** Враћа JPA репозиторијум. */
    @Override
    protected JpaRepository<AcOrganizacije, Long> getRepository() {
        return repository;
    }

    /** Враћа MapStruct мапер. */
    @Override
    protected AcOrganizacijeMapper getMapper() {
        return mapper;
    }
}
