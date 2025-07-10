package rs.prati.rest.controller;

import io.swagger.v3.oas.annotations.Hidden;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import rs.prati.service.CeJavljanjaMirovanjaService;
import rs.prati.service.common.CrudService;
import rs.prati.service.dto.CeJavljanjaMirovanjaDto;

import java.util.List;

/**
 * REST контролер за CeJavljanjaMirovanja – јављања у стању мировања.
 */
@RestController
@RequestMapping("/api/ce-javljanja-mirovanja")
@Hidden
public class CeJavljanjaMirovanjaController extends AbstractCrudController<CeJavljanjaMirovanjaDto> {

    private final CeJavljanjaMirovanjaService service;

    public CeJavljanjaMirovanjaController(CeJavljanjaMirovanjaService service) {
        this.service = service;
    }

    /**
     * Враћа сва јављања мировања за задати објекат.
     */
    @GetMapping("/objekat/{id}")
    @Operation(summary = "Сва јављања мировања за објекат",
               description = "Враћа сва јављања мировања за дати ID објекта.",
               tags = {"CeJavljanjaMirovanja"},
               operationId = "getAllForObjekat")
    @PreAuthorize("hasRole('ROLE_SISTEM') or hasRole('ROLE_ADMIN')")
    public List<CeJavljanjaMirovanjaDto> findAllForObjekat(@PathVariable Long id) {
        return service.findAllForObjekat(id);
    }

    /**
     * Враћа сва валидна јављања мировања.
     */
    @GetMapping("/valid")
    @Operation(summary = "Сва валидна јављања мировања",
               description = "Враћа сва јављања која имају статус valid=true.",
               tags = {"CeJavljanjaMirovanja"},
               operationId = "getAllValid")
    @PreAuthorize("hasRole('ROLE_SISTEM') or hasRole('ROLE_ADMIN')")
    public List<CeJavljanjaMirovanjaDto> findAllValid() {
        return service.findAllValid();
    }

    /**
     * Чување новог или постојећег јављања мировања.
     */
    @PostMapping
    @Operation(summary = "Чување јављања мировања")
    @PreAuthorize("hasRole('ROLE_SISTEM') or hasRole('ROLE_ADMIN')")
    public ResponseEntity<CeJavljanjaMirovanjaDto> save(@RequestBody CeJavljanjaMirovanjaDto dto) {
        return ResponseEntity.ok(service.save(dto));
    }

    /**
     * Тврдо брисање по ID-у.
     */
    @DeleteMapping("/{id}")
    @Operation(summary = "Тврдо брисање јављања мировања")
    @PreAuthorize("hasRole('ROLE_SISTEM')")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.hardDelete(id);
        return ResponseEntity.noContent().build();
    }

    /**
     * Проналажење јављања мировања по ID-у.
     */
    @GetMapping("/{id}")
    @Operation(summary = "Проналажење јављања мировања по ID-у")
    @PreAuthorize("hasRole('ROLE_SISTEM') or hasRole('ROLE_ADMIN')")
    public ResponseEntity<CeJavljanjaMirovanjaDto> findById(@PathVariable Long id) {
        return service.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    /**
     * Враћа сва јављања мировања.
     */
    @GetMapping
    @Operation(summary = "Сва јављања мировања",
               description = "Враћа сва јављања у стању мировања.",
               tags = {"CeJavljanjaMirovanja"},
               operationId = "getAllJavljanjaMirovanja")
    @PreAuthorize("hasRole('ROLE_SISTEM') or hasRole('ROLE_ADMIN')")
    public ResponseEntity<List<CeJavljanjaMirovanjaDto>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    /**
     * Повезивање са CrudService-ом.
     */
    @Override
    protected CrudService<?, CeJavljanjaMirovanjaDto> getService() {
        return service;
    }
}
