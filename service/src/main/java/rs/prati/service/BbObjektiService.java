package rs.prati.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import rs.prati.core.model.BbObjekti;
import rs.prati.service.common.AbstractCrudService;
import rs.prati.service.common.MessageService;
import rs.prati.service.dto.BbObjektiDto;
import rs.prati.service.mapper.BbObjektiMapper;
import rs.prati.service.repository.BbObjektiRepository;

/**
 * Сервис класа за управљање ентитетом BbObjekti.
 */
@Service
@Transactional
public class BbObjektiService extends AbstractCrudService<BbObjekti, BbObjektiDto> {

    /** Репозиторијум за приступ објектима. */
    private final BbObjektiRepository repository;

    /** MapStruct мапер за конверзију ентитета и DTO. */
    private final BbObjektiMapper mapper;
    
    /** Сервис за интернационализацију порука. */
    private final MessageService messageService;

    /**
     * Конструктор сервиса.
     *
     * @param repository BbObjekti репозиторијум
     * @param mapper BbObjekti мапер
     * @param messageService сервис за поруке
     */
    public BbObjektiService(BbObjektiRepository repository, BbObjektiMapper mapper, MessageService messageService) {
        this.repository = repository;
        this.mapper = mapper;
        this.messageService = messageService;
    }

    /** Враћа BbObjekti репозиторијум. */
    @Override
    protected BbObjektiRepository getRepository() {
        return repository;
    }

    /** Враћа BbObjekti мапер. */
    @Override
    protected BbObjektiMapper getMapper() {
        return mapper;
    }
    
    /**
     * Чува нови или ажурира постојећи објекат.
     * Пре чувања проверава да ли већ постоји објекат за истог претплатника са истом ознаком
     * који није означен као избрисан. У случају да такав објекат постоји и није исти као текући,
     * баца се изузетак и онемогућава чување.
     *
     * @param dto DTO објекта за чување
     * @return DTO сачуваног објекта
     */
    @Override
    @Transactional
    public BbObjektiDto save(BbObjektiDto dto) {
    	getRepository()
        .findByPretplatnik_IdAndOznakaAndIzbrisanFalse(dto.getPretplatnikId(), dto.getOznaka())
            .ifPresent(existing -> {
                if (dto.getId() == null || !existing.getId().equals(dto.getId())) {
                    throw new IllegalStateException(messageService.getMessage("error.objekat.exists"));
                }
            });

        return super.save(dto);
    }

}
