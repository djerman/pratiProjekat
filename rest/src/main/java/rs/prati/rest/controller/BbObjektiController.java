package rs.prati.rest.controller;

import io.swagger.v3.oas.annotations.Hidden;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import rs.prati.service.BbObjektiService;
import rs.prati.service.common.CrudService;
import rs.prati.service.dto.BbObjektiDto;

import java.util.List;

/**
 * REST контролер за објекте.
 * Приступ имају систем и администратор.
 */
@RestController
@RequestMapping("/api/objekti")
@Hidden
public class BbObjektiController extends AbstractCrudController<BbObjektiDto> {

    /** Сервис за управљање објектима. */
    private final BbObjektiService service;

    /**
     * Конструктор који прима сервис.
     *
     * @param service сервис за BbObjekti
     */
    public BbObjektiController(BbObjektiService service) {
        this.service = service;
    }

    /**
     * Враћа CrudService за објекте.
     *
     * @return CrudService
     */
    @Override
    protected CrudService<?, BbObjektiDto> getService() {
        return service;
    }

    /**
     * Враћа све објекте.
     *
     * @return листа објеката
     */
    @Override
    @GetMapping
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_SYSTEM')")
    public ResponseEntity<List<BbObjektiDto>> findAll() {
        return ResponseEntity.ok(getService().findAll());
    }

    /**
     * Враћа објекат по ID-у.
     *
     * @param id идентификатор објекта
     * @return објекат ако постоји
     */
    @Override
    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_SYSTEM')")
    public ResponseEntity<BbObjektiDto> findById(@PathVariable Long id) {
        return getService().findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    /**
     * Чува или ажурира објекат.
     *
     * @param dto DTO објекта
     * @return сачувани објекат
     */
    @Override
    @PostMapping
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_SYSTEM')")
    public ResponseEntity<BbObjektiDto> save(@RequestBody BbObjektiDto dto) {
        return ResponseEntity.ok(getService().save(dto));
    }

    /**
     * Логички брише објекат (soft delete).
     *
     * @param id идентификатор објекта
     * @return празан одговор ако је успешно
     */
    @Override
    @DeleteMapping("/soft/{id}")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_SYSTEM')")
    public ResponseEntity<Void> oznaciIzbrisan(@PathVariable Long id) {
        getService().oznaciIzbrisan(id);
        return ResponseEntity.noContent().build();
    }

    /**
     * Потпуно брише објекат (hard delete).
     *
     * @param id идентификатор објекта
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
