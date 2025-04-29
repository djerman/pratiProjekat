package rs.prati.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import rs.prati.core.model.AaSistem;
import rs.prati.service.dto.AaSistemDto;
import rs.prati.service.mapper.AaSistemMapper;
import rs.prati.service.repository.AaSistemRepository;
import rs.prati.service.common.MessageService;

/**
 * Сервис за управљање системским подешавањима (AaSistem).
 */
@Service
@Transactional
public class AaSistemService {

    /** Репозиторијум за приступ подацима. */
    private final AaSistemRepository repository;

    /** MapStruct мапер за конверзију између ентитета и DTO-а. */
    private final AaSistemMapper mapper;

    /** Сервис за интернационализацију порука. */
    private final MessageService messageService;

    /**
     * Конструктор који прима зависности.
     *
     * @param repository репозиторијум за AaSistem
     * @param mapper мапер за AaSistem
     * @param messageService сервис за интернационализацију порука
     */
    public AaSistemService(AaSistemRepository repository, AaSistemMapper mapper, MessageService messageService) {
        this.repository = repository;
        this.mapper = mapper;
        this.messageService = messageService;
    }

    /**
     * Враћа системске параметре.
     *
     * @return системски параметри као DTO
     */
    @Transactional(readOnly = true)
    public AaSistemDto get() {
        return repository.findAll().stream()
                .findFirst()
                .map(mapper::toDto)
                .orElseThrow(() -> new IllegalStateException(messageService.getMessage("error.sistem.notfound")));
    }

    /**
     * Ажурира системске параметре.
     *
     * @param dto нови подаци
     * @return ажурирани системски параметри као DTO
     */
    public AaSistemDto update(AaSistemDto dto) {
        AaSistem entity = repository.findAll().stream()
                .findFirst()
                .orElseThrow(() -> new IllegalStateException(messageService.getMessage("error.sistem.notfound")));

        mapper.updateEntityFromDto(dto, entity);

        return mapper.toDto(repository.save(entity));
    }
}