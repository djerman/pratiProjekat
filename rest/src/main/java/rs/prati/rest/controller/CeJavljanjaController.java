package rs.prati.rest.controller;

import io.swagger.v3.oas.annotations.Hidden;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import rs.prati.service.CeJavljanjaService;
import rs.prati.service.common.CrudService;
import rs.prati.service.dto.CeJavljanjaDto;

import java.util.List;

/**
 * REST контролер за CeJavljanja – јављања у реалном времену са возила/уређаја.
 */
@RestController
@RequestMapping("/api/ce-javljanja")
@Hidden
public class CeJavljanjaController extends AbstractCrudController<CeJavljanjaDto> {

    private final CeJavljanjaService service;

    public CeJavljanjaController(CeJavljanjaService service) {
        this.service = service;
    }

    /**
     * Враћа сва јављања за задати објекат.
     */
    @GetMapping("/objekat/{id}")
    @Operation(summary = "Сва јављања за објекат",
               description = "Враћа сва јављања за дати ID објекта, сортирано по датуму силазно.",
               tags = {"CeJavljanja"},
               operationId = "getAllForObjekat")
    @PreAuthorize("hasRole('ROLE_SISTEM') or hasRole('ROLE_ADMIN')")
    public List<CeJavljanjaDto> findAllForObjekat(@PathVariable Long id) {
        return service.findAllForObjekat(id);
    }

    /**
     * Враћа сва валидна јављања.
     */
    @GetMapping("/valid")
    @Operation(summary = "Сва валидна јављања",
               description = "Враћа само јављања која имају статус 'valid=true'.",
               tags = {"CeJavljanja"},
               operationId = "getAllValidJavljanja")
    @PreAuthorize("hasRole('ROLE_SISTEM') or hasRole('ROLE_ADMIN')")
    public List<CeJavljanjaDto> findAllValid() {
        return service.findAllValid();
    }

    /**
     * Чување новог или постојећег јављања.
     */
    @PostMapping
    @Operation(summary = "Чување јављања")
    @PreAuthorize("hasRole('ROLE_SISTEM') or hasRole('ROLE_ADMIN')")
    public ResponseEntity<CeJavljanjaDto> save(@RequestBody CeJavljanjaDto dto) {
        return ResponseEntity.ok(service.save(dto));
    }

    /**
     * Тврдо брисање јављања по ID-у.
     */
    @DeleteMapping("/{id}")
    @Operation(summary = "Тврдо брисање јављања")
    @PreAuthorize("hasRole('ROLE_SISTEM')")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.hardDelete(id);
        return ResponseEntity.noContent().build();
    }

    /**
     * Проналажење јављања по ID-у.
     */
    @GetMapping("/{id}")
    @Operation(summary = "Проналажење јављања по ID-у")
    @PreAuthorize("hasRole('ROLE_SISTEM') or hasRole('ROLE_ADMIN')")
    public ResponseEntity<CeJavljanjaDto> findById(@PathVariable Long id) {
        return service.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    /**
     * Враћа сва јављања.
     */
    @GetMapping
    @Operation(summary = "Сва јављања",
               description = "Враћа сва јављања у систему, без филтера.",
               tags = {"CeJavljanja"},
               operationId = "getAllJavljanja")
    @PreAuthorize("hasRole('ROLE_SISTEM') or hasRole('ROLE_ADMIN')")
    public ResponseEntity<List<CeJavljanjaDto>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    /**
     * Повезивање са CrudService-ом.
     */
    @Override
    protected CrudService<?, CeJavljanjaDto> getService() {
        return service;
    }
}
