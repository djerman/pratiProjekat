package rs.prati.rest.controller;

import io.swagger.v3.oas.annotations.Hidden;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import rs.prati.service.CfJavljanjaPoslednjaService;
import rs.prati.service.common.CrudService;
import rs.prati.service.dto.CfJavljanjaPoslednjaDto;

import java.util.List;

/**
 * REST контролер за CfJavljanjaPoslednja – последња јављања објеката.
 */
@RestController
@RequestMapping("/api/cf-javljanja-poslednja")
@Hidden
public class CfJavljanjaPoslednjaController extends AbstractCrudController<CfJavljanjaPoslednjaDto> {

    private final CfJavljanjaPoslednjaService service;

    public CfJavljanjaPoslednjaController(CfJavljanjaPoslednjaService service) {
        this.service = service;
    }

    /**
     * Све последње пријаве за све објекте (valid=true).
     */
    @GetMapping("/valid")
    @Operation(summary = "Све последње валидне пријаве",
               description = "Враћа све последње пријаве објеката где је valid=true.",
               tags = {"CfJavljanjaPoslednja"},
               operationId = "getAllValid")
    @PreAuthorize("hasRole('ROLE_SISTEM') or hasRole('ROLE_ADMIN')")
    public ResponseEntity<List<CfJavljanjaPoslednjaDto>> findAllValid() {
        return ResponseEntity.ok(service.findAllValid());
    }

    /**
     * Враћа сва јављања за конкретан објекат.
     */
    @GetMapping("/objekat/{id}")
    @Operation(summary = "Све последње пријаве за објекат",
               description = "Враћа последња јављања за дати ID објекта.",
               tags = {"CfJavljanjaPoslednja"},
               operationId = "getAllForObjekat")
    @PreAuthorize("hasRole('ROLE_SISTEM') or hasRole('ROLE_ADMIN')")
    public ResponseEntity<List<CfJavljanjaPoslednjaDto>> findAllForObjekat(@PathVariable Long id) {
        return ResponseEntity.ok(service.findAllForObjekat(id));
    }

    /**
     * Чување новог или постојећег јављања.
     */
    @PostMapping
    @Operation(summary = "Чување последњег јављања")
    @PreAuthorize("hasRole('ROLE_SISTEM') or hasRole('ROLE_ADMIN')")
    public ResponseEntity<CfJavljanjaPoslednjaDto> save(@RequestBody CfJavljanjaPoslednjaDto dto) {
        return ResponseEntity.ok(service.save(dto));
    }

    /**
     * Брисање јављања по ID-у.
     */
    @DeleteMapping("/{id}")
    @Operation(summary = "Брисање јављања")
    @PreAuthorize("hasRole('ROLE_SISTEM')")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.hardDelete(id);
        return ResponseEntity.noContent().build();
    }

    /**
     * Проналажење по ID-у.
     */
    @GetMapping("/{id}")
    @Operation(summary = "Проналажење јављања по ID-у")
    @PreAuthorize("hasRole('ROLE_SISTEM') or hasRole('ROLE_ADMIN')")
    public ResponseEntity<CfJavljanjaPoslednjaDto> findById(@PathVariable Long id) {
        return service.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    /**
     * Све последње пријаве свих објеката.
     */
    @GetMapping
    @Operation(summary = "Све последње пријаве", tags = {"CfJavljanjaPoslednja"})
    @PreAuthorize("hasRole('ROLE_SISTEM') or hasRole('ROLE_ADMIN')")
    public ResponseEntity<List<CfJavljanjaPoslednjaDto>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    /**
     * Враћа CrudService.
     */
    @Override
    protected CrudService<?, CfJavljanjaPoslednjaDto> getService() {
        return service;
    }
}
