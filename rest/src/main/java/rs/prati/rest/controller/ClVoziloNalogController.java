package rs.prati.rest.controller;

import io.swagger.v3.oas.annotations.Hidden;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import rs.prati.service.ClVoziloNalogService;
import rs.prati.service.common.CrudService;
import rs.prati.service.dto.ClVoziloNalogDto;

import java.util.List;

/**
 * REST контролер за ClVoziloNalog – налози за путовања возила.
 */
@RestController
@RequestMapping("/api/cl-vozilo-nalog")
@Hidden
public class ClVoziloNalogController extends AbstractCrudController<ClVoziloNalogDto> {

    private final ClVoziloNalogService service;

    public ClVoziloNalogController(ClVoziloNalogService service) {
        this.service = service;
    }

    /**
     * Враћа све налоге за одређеног претплатника.
     */
    @GetMapping("/pretplatnik/{id}")
    @Operation(
        summary = "Сви налози за одређеног претплатника",
        description = "Враћа све активне налоге (који нису обрисани) за дати ID претплатника.",
        tags = {"ClVoziloNalog"},
        operationId = "getAllForPretplatnik"
    )
    @PreAuthorize("hasRole('ROLE_SISTEM') or hasRole('ROLE_ADMIN')")
    public List<ClVoziloNalogDto> findAllForPretplatnik(@PathVariable Long id) {
        return service.findAllForPretplatnik(id);
    }

    /**
     * Чување новог или постојећег налога.
     */
    @PostMapping
    @Operation(
        summary = "Чување налога за возило",
        description = "Креира или ажурира налог за вожњу/путовање возила."
    )
    @PreAuthorize("hasRole('ROLE_SISTEM') or hasRole('ROLE_ADMIN')")
    public ResponseEntity<ClVoziloNalogDto> save(@RequestBody ClVoziloNalogDto dto) {
        return ResponseEntity.ok(service.save(dto));
    }

    /**
     * Тврдо брисање налога по ID-у.
     */
    @DeleteMapping("/{id}")
    @Operation(
        summary = "Тврдо брисање налога",
        description = "Потпуно уклања налог за возило по задатом ID-у."
    )
    @PreAuthorize("hasRole('ROLE_SISTEM')")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.hardDelete(id);
        return ResponseEntity.noContent().build();
    }

    /**
     * Меко брисање (означава као обрисано).
     */
    @PatchMapping("/{id}/mark-deleted")
    @Operation(
        summary = "Меко брисање налога",
        description = "Означава налог као обрисан (логичко брисање)."
    )
    @PreAuthorize("hasRole('ROLE_SISTEM') or hasRole('ROLE_ADMIN')")
    public ResponseEntity<Void> markDeleted(@PathVariable Long id) {
        service.oznaciIzbrisan(id);
        return ResponseEntity.noContent().build();
    }

    /**
     * Проналажење налога по ID-у.
     */
    @GetMapping("/{id}")
    @Operation(
        summary = "Проналажење налога по ID-у",
        description = "Враћа налог за возило по јединственом ID-у."
    )
    @PreAuthorize("hasRole('ROLE_SISTEM') or hasRole('ROLE_ADMIN')")
    public ResponseEntity<ClVoziloNalogDto> findById(@PathVariable Long id) {
        return service.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    /**
     * Враћа све налоге за сва возила.
     */
    @GetMapping
    @Operation(
        summary = "Сви налози за сва возила",
        description = "Враћа све налоге за сва возила у систему (који нису обрисани).",
        tags = {"ClVoziloNalog"},
        operationId = "getAllVoziloNalogs"
    )
    @PreAuthorize("hasRole('ROLE_SISTEM') or hasRole('ROLE_ADMIN')")
    public ResponseEntity<List<ClVoziloNalogDto>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    /**
     * Повезивање са CrudService-ом.
     */
    @Override
    protected CrudService<?, ClVoziloNalogDto> getService() {
        return service;
    }
}
