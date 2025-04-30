package rs.prati.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import rs.prati.core.model.AeSistemGoriva;
import rs.prati.service.common.AbstractCrudService;
import rs.prati.service.dto.AeSistemGorivaDto;
import rs.prati.service.mapper.AeSistemGorivaMapper;
import rs.prati.service.repository.AeSistemGorivaRepository;

/**
 * Сервис класа за управљање ентитетом AeSistemGoriva.
 * Наслеђује основне CRUD методе из AbstractCrudService.
 */
@Service
@Transactional
public class AeSistemGorivaService extends AbstractCrudService<AeSistemGoriva, AeSistemGorivaDto> {

    /** Репозиторијум за приступ ентитету AeSistemGoriva. */
    private final AeSistemGorivaRepository repository;

    /** MapStruct мапер за конверзију између ентитета и DTO-а. */
    private final AeSistemGorivaMapper mapper;

    /**
     * Конструктор који иницијализује репозиторијум и мапер.
     *
     * @param repository репозиторијум за AeSistemGoriva
     * @param mapper мапер за AeSistemGoriva
     */
    public AeSistemGorivaService(AeSistemGorivaRepository repository, AeSistemGorivaMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    /**
     * Враћа репозиторијум за AeSistemGoriva.
     *
     * @return репозиторијум
     */
    @Override
    protected AeSistemGorivaRepository getRepository() {
        return repository;
    }

    /**
     * Враћа мапер за AeSistemGoriva.
     *
     * @return мапер
     */
    @Override
    protected AeSistemGorivaMapper getMapper() {
        return mapper;
    }
}
