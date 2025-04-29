package rs.prati.rest.controller;

import io.swagger.v3.oas.annotations.Hidden;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import rs.prati.service.AcOrganizacijeService;
import rs.prati.service.common.CrudService;
import rs.prati.service.dto.AcOrganizacijeDto;

import java.util.List;

/**
 * REST контролер за организације.
 * Приступ имају систем и администратор.
 */
@RestController
@RequestMapping("/api/organizacije")
@Hidden
public class AcOrganizacijeController extends AbstractCrudController<AcOrganizacijeDto> {

    /** Сервис за управљање организацијама. */
    private final AcOrganizacijeService service;

    /**
     * Конструктор који прима сервис.
     *
     * @param service сервис за организације
     */
    public AcOrganizacijeController(AcOrganizacijeService service) {
        this.service = service;
    }

    /**
     * Враћа CrudService за рад са организацијама.
     *
     * @return CrudService
     */
    @Override
    protected CrudService<?, AcOrganizacijeDto> getService() {
        return service;
    }

    /**
     * Враћа све организације.
     *
     * @return листа организација
     */
    @Override
    @GetMapping
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_SYSTEM')")
    public ResponseEntity<List<AcOrganizacijeDto>> findAll() {
        return ResponseEntity.ok(getService().findAll());
    }

    /**
     * Враћа организацију по ID-у.
     *
     * @param id идентификатор организације
     * @return организација ако постоји
     */
    @Override
    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_SYSTEM')")
    public ResponseEntity<AcOrganizacijeDto> findById(@PathVariable Long id) {
        return getService().findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    /**
     * Чува или ажурира организацију.
     *
     * @param dto DTO организације
     * @return сачувана организација
     */
    @Override
    @PostMapping
    @PreAuthorize("hasRole('ROLE_SYSTEM')")
    public ResponseEntity<AcOrganizacijeDto> save(@RequestBody AcOrganizacijeDto dto) {
        return ResponseEntity.ok(getService().save(dto));
    }

    /**
     * Логички брише организацију (soft delete).
     *
     * @param id идентификатор организације
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
     * Потпуно брише организацију (hard delete).
     *
     * @param id идентификатор организације
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
