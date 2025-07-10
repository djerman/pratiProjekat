package rs.prati.rest.controller;

import io.swagger.v3.oas.annotations.Hidden;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import rs.prati.service.CdObjektiAlarmiService;
import rs.prati.service.common.CrudService;
import rs.prati.service.dto.CdObjektiAlarmiDto;

import java.util.List;

/**
 * REST контролер за CdObjektiAlarmi – конфигурације аларма по објектима.
 */
@RestController
@RequestMapping("/api/cd-objekti-alarmi")
@Hidden
public class CdObjektiAlarmiController extends AbstractCrudController<CdObjektiAlarmiDto> {

    private final CdObjektiAlarmiService service;

    public CdObjektiAlarmiController(CdObjektiAlarmiService service) {
        this.service = service;
    }

    /**
     * Враћа све конфигурације аларма за одређеног претплатника.
     */
    @GetMapping("/pretplatnik/{id}")
    @Operation(summary = "Све конфигурације аларма за претплатника",
               description = "Враћа све активне конфигурације аларма за дати ID претплатника.",
               tags = {"CdObjektiAlarmi"},
               operationId = "getAllForPretplatnik")
    @PreAuthorize("hasRole('ROLE_SISTEM') or hasRole('ROLE_ADMIN')")
    public List<CdObjektiAlarmiDto> findAllForPretplatnik(@PathVariable Long id) {
        return service.findAllForPretplatnik(id);
    }

    /**
     * Чување нове или постојеће конфигурације аларма.
     */
    @PostMapping
    @Operation(summary = "Чување конфигурације аларма")
    @PreAuthorize("hasRole('ROLE_SISTEM') or hasRole('ROLE_ADMIN')")
    public ResponseEntity<CdObjektiAlarmiDto> save(@RequestBody CdObjektiAlarmiDto dto) {
        return ResponseEntity.ok(service.save(dto));
    }

    /**
     * Тврдо брисање конфигурације по ID-у.
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
     * Проналажење конфигурације по ID-у.
     */
    @GetMapping("/{id}")
    @Operation(summary = "Проналажење по ID-у")
    @PreAuthorize("hasRole('ROLE_SISTEM') or hasRole('ROLE_ADMIN')")
    public ResponseEntity<CdObjektiAlarmiDto> findById(@PathVariable Long id) {
        return service.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    /**
     * Враћа све конфигурације аларма.
     */
    @GetMapping
    @Operation(summary = "Све конфигурације аларма",
               description = "Враћа све конфигурације аларма за све објекте.",
               tags = {"CdObjektiAlarmi"},
               operationId = "getAllAlarmConfigs")
    @PreAuthorize("hasRole('ROLE_SISTEM') or hasRole('ROLE_ADMIN')")
    public ResponseEntity<List<CdObjektiAlarmiDto>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    /**
     * Повезивање са CrudService-ом.
     */
    @Override
    protected CrudService<?, CdObjektiAlarmiDto> getService() {
        return service;
    }
}
