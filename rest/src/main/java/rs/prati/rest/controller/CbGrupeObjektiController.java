package rs.prati.rest.controller;

import io.swagger.v3.oas.annotations.Hidden;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import rs.prati.service.CbGrupeObjektiService;
import rs.prati.service.common.CrudService;
import rs.prati.service.dto.CbGrupeObjektiDto;

import java.util.List;

/**
 * REST контролер за CbGrupeObjekti – повезивање објеката и група.
 */
@RestController
@RequestMapping("/api/cb-grupe-objekti")
@Hidden
public class CbGrupeObjektiController extends AbstractCrudController<CbGrupeObjektiDto> {

    private final CbGrupeObjektiService service;

    public CbGrupeObjektiController(CbGrupeObjektiService service) {
        this.service = service;
    }

    /**
     * Враћа све везе за одређеног претплатника.
     */
    @GetMapping("/pretplatnik/{id}")
    @Operation(summary = "Све везе за претплатника")
    @PreAuthorize("hasRole('ROLE_SISTEM') or hasRole('ROLE_ADMIN')")
    public List<CbGrupeObjektiDto> findAllForPretplatnik(@PathVariable Long id) {
        return service.findAllForPretplatnik(id);
    }

    /**
     * Чување нове или постојеће везе.
     */
    @PostMapping
    @Operation(summary = "Чување везе")
    @PreAuthorize("hasRole('ROLE_SISTEM') or hasRole('ROLE_ADMIN')")
    public ResponseEntity<CbGrupeObjektiDto> save(@RequestBody CbGrupeObjektiDto dto) {
        return ResponseEntity.ok(service.save(dto));
    }

    /**
     * Тврдо брисање везе по ID-у.
     */
    @DeleteMapping("/{id}")
    @Operation(summary = "Тврдо брисање")
    @PreAuthorize("hasRole('ROLE_SISTEM')")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.hardDelete(id);
        return ResponseEntity.noContent().build();
    }

    /**
     * Меко брисање (означава као обрисано).
     */
    @PatchMapping("/{id}/mark-deleted")
    @Operation(summary = "Меко брисање")
    @PreAuthorize("hasRole('ROLE_SISTEM') or hasRole('ROLE_ADMIN')")
    public ResponseEntity<Void> markDeleted(@PathVariable Long id) {
        service.oznaciIzbrisan(id);
        return ResponseEntity.noContent().build();
    }

    /**
     * Проналажење везе по ID-у.
     */
    @GetMapping("/{id}")
    @Operation(summary = "Проналажење по ID-у")
    @PreAuthorize("hasRole('ROLE_SISTEM') or hasRole('ROLE_ADMIN')")
    public ResponseEntity<CbGrupeObjektiDto> findById(@PathVariable Long id) {
        return service.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    /**
     * Враћа све везе.
     */
    @GetMapping
    @Operation(summary = "Све везе")
    @PreAuthorize("hasRole('ROLE_SISTEM') or hasRole('ROLE_ADMIN')")
    public ResponseEntity<List<CbGrupeObjektiDto>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    /**
     * Повезивање са CrudService-ом.
     */
    @Override
    protected CrudService<?, CbGrupeObjektiDto> getService() {
        return service;
    }
}
