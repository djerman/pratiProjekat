package rs.prati.rest.controller;

import io.swagger.v3.oas.annotations.Hidden;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import rs.prati.service.AhSistemUredjajiProizvodjacService;
import rs.prati.service.common.CrudService;
import rs.prati.service.dto.AhSistemUredjajiProizvodjacDto;

import java.util.List;

/**
 * REST контролер за произвођаче уређаја.
 * Приступ имају систем и администратор.
 */
@RestController
@RequestMapping("/api/sistem-uredjaji-proizvodjaci")
@Hidden
public class AhSistemUredjajiProizvodjacController extends AbstractCrudController<AhSistemUredjajiProizvodjacDto> {

    /** Сервис за управљање произвођачима уређаја. */
    private final AhSistemUredjajiProizvodjacService service;

    /**
     * Конструктор који прима сервис.
     *
     * @param service сервис за AhSistemUredjajiProizvodjac
     */
    public AhSistemUredjajiProizvodjacController(AhSistemUredjajiProizvodjacService service) {
        this.service = service;
    }

    /**
     * Враћа CrudService за произвођаче уређаја.
     *
     * @return CrudService
     */
    @Override
    protected CrudService<?, AhSistemUredjajiProizvodjacDto> getService() {
        return service;
    }

    /**
     * Враћа све произвођаче уређаја.
     *
     * @return листа произвођача
     */
    @Override
    @GetMapping
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_SYSTEM')")
    public ResponseEntity<List<AhSistemUredjajiProizvodjacDto>> findAll() {
        return ResponseEntity.ok(getService().findAll());
    }

    /**
     * Враћа произвођача уређаја по ID-у.
     *
     * @param id идентификатор произвођача
     * @return произвођач ако постоји
     */
    @Override
    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_SYSTEM')")
    public ResponseEntity<AhSistemUredjajiProizvodjacDto> findById(@PathVariable Long id) {
        return getService().findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    /**
     * Чува или ажурира произвођача уређаја.
     *
     * @param dto DTO произвођача
     * @return сачувани произвођач
     */
    @Override
    @PostMapping
    @PreAuthorize("hasRole('ROLE_SYSTEM')")
    public ResponseEntity<AhSistemUredjajiProizvodjacDto> save(@RequestBody AhSistemUredjajiProizvodjacDto dto) {
        return ResponseEntity.ok(getService().save(dto));
    }

    /**
     * Логички брише произвођача уређаја (soft delete).
     *
     * @param id идентификатор произвођача
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
     * Потпуно брише произвођача уређаја (hard delete).
     *
     * @param id идентификатор произвођача
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