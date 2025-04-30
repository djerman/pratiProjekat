package rs.prati.rest.controller;

import io.swagger.v3.oas.annotations.Hidden;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import rs.prati.service.AeSistemGorivaService;
import rs.prati.service.common.CrudService;
import rs.prati.service.dto.AeSistemGorivaDto;

import java.util.List;

/**
 * REST контролер за систем горива.
 * Приступ имају систем и администратор.
 */
@RestController
@RequestMapping("/api/sistem-goriva")
@Hidden
public class AeSistemGorivaController extends AbstractCrudController<AeSistemGorivaDto> {

    /** Сервис за управљање системима горива. */
    private final AeSistemGorivaService service;

    /**
     * Конструктор који прима сервис.
     *
     * @param service сервис за AeSistemGoriva
     */
    public AeSistemGorivaController(AeSistemGorivaService service) {
        this.service = service;
    }

    /**
     * Враћа CrudService за систем горива.
     *
     * @return CrudService
     */
    @Override
    protected CrudService<?, AeSistemGorivaDto> getService() {
        return service;
    }

    /**
     * Враћа све системе горива.
     *
     * @return листа система горива
     */
    @Override
    @GetMapping
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_SYSTEM')")
    public ResponseEntity<List<AeSistemGorivaDto>> findAll() {
        return ResponseEntity.ok(getService().findAll());
    }

    /**
     * Враћа систем горива по ID-у.
     *
     * @param id идентификатор система горива
     * @return систем горива ако постоји
     */
    @Override
    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_SYSTEM')")
    public ResponseEntity<AeSistemGorivaDto> findById(@PathVariable Long id) {
        return getService().findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    /**
     * Чува или ажурира систем горива.
     *
     * @param dto DTO система горива
     * @return сачувани систем горива
     */
    @Override
    @PostMapping
    @PreAuthorize("hasRole('ROLE_SYSTEM')")
    public ResponseEntity<AeSistemGorivaDto> save(@RequestBody AeSistemGorivaDto dto) {
        return ResponseEntity.ok(getService().save(dto));
    }

    /**
     * Логички брише систем горива (soft delete).
     *
     * @param id идентификатор система горива
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
     * Потпуно брише систем горива (hard delete).
     *
     * @param id идентификатор система горива
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
