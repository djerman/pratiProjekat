package rs.prati.rest.controller;

import io.swagger.v3.oas.annotations.Hidden;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import rs.prati.service.AiSistemUredjajiModeliService;
import rs.prati.service.common.CrudService;
import rs.prati.service.dto.AiSistemUredjajiModeliDto;

import java.util.List;

/**
 * REST контролер за моделе уређаја.
 * Приступ имају систем и администратор.
 */
@RestController
@RequestMapping("/api/sistem-uredjaji-modeli")
@Hidden
public class AiSistemUredjajiModeliController extends AbstractCrudController<AiSistemUredjajiModeliDto> {

    /** Сервис за управљање моделима уређаја. */
    private final AiSistemUredjajiModeliService service;

    /**
     * Конструктор који прима сервис.
     *
     * @param service сервис за AiSistemUredjajiModeli
     */
    public AiSistemUredjajiModeliController(AiSistemUredjajiModeliService service) {
        this.service = service;
    }

    /**
     * Враћа CrudService за моделе уређаја.
     *
     * @return CrudService
     */
    @Override
    protected CrudService<?, AiSistemUredjajiModeliDto> getService() {
        return service;
    }

    /**
     * Враћа све моделе уређаја.
     *
     * @return листа модела
     */
    @Override
    @GetMapping
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_SYSTEM')")
    public ResponseEntity<List<AiSistemUredjajiModeliDto>> findAll() {
        return ResponseEntity.ok(getService().findAll());
    }

    /**
     * Враћа модел уређаја по ID-у.
     *
     * @param id идентификатор модела
     * @return модел ако постоји
     */
    @Override
    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_SYSTEM')")
    public ResponseEntity<AiSistemUredjajiModeliDto> findById(@PathVariable Long id) {
        return getService().findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    /**
     * Чува или ажурира модел уређаја.
     *
     * @param dto DTO модела
     * @return сачувани модел
     */
    @Override
    @PostMapping
    @PreAuthorize("hasRole('ROLE_SYSTEM')")
    public ResponseEntity<AiSistemUredjajiModeliDto> save(@RequestBody AiSistemUredjajiModeliDto dto) {
        return ResponseEntity.ok(getService().save(dto));
    }

    /**
     * Логички брише модел уређаја (soft delete).
     *
     * @param id идентификатор модела
     * @return празан одговор ако је успешно
     */
    @Override
    @DeleteMapping("/soft/{id}")
    @PreAuthorize("hasRole('ROLE_SYSTEM')")
    public ResponseEntity<Void> oznaciIzbrisan(@PathVariable Long id) {
        getService().oznaciIzbrisan(id);
        return ResponseEntity.noContent().build();
    }

    /**
     * Потпуно брише модел уређаја (hard delete).
     *
     * @param id идентификатор модела
     * @return празан одговор ако је успешно
     */
    @Override
    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_SYSTEM')")
    public ResponseEntity<Void> hardDelete(@PathVariable Long id) {
        getService().hardDelete(id);
        return ResponseEntity.noContent().build();
    }
}
