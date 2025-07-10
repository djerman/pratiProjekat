package rs.prati.rest.controller;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import rs.prati.service.ChZoneObjektiService;
import rs.prati.service.common.CrudService;
import rs.prati.service.dto.ChZoneObjektiDto;

import java.util.List;

/**
 * REST контролер за ChZoneObjekti – повезаност зона и објеката.
 */
@RestController
@RequestMapping("/api/ch-zone-objekti")
public class ChZoneObjektiController extends AbstractCrudController<ChZoneObjektiDto> {

    private final ChZoneObjektiService service;

    public ChZoneObjektiController(ChZoneObjektiService service) {
        this.service = service;
    }

    /**
     * Враћа све везе зона-објекат.
     */
    @GetMapping
    @Operation(
        summary = "Све повезаности зона и објеката",
        description = "Враћа све везе између зона и објеката из табеле ch_zoneObjekti.",
        tags = {"ChZoneObjekti"},
        operationId = "getAllChZoneObjekti"
    )
    @PreAuthorize("hasRole('ROLE_SISTEM') or hasRole('ROLE_ADMIN')")
    public ResponseEntity<List<ChZoneObjektiDto>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    /**
     * Проналажење везе зона-објекат по ID-у.
     */
    @GetMapping("/{id}")
    @Operation(
        summary = "Проналажење по ID-у",
        description = "Враћа једну везу зона-објекат из табеле ch_zoneObjekti по ID-у.",
        tags = {"ChZoneObjekti"},
        operationId = "getChZoneObjektiById"
    )
    @PreAuthorize("hasRole('ROLE_SISTEM') or hasRole('ROLE_ADMIN')")
    public ResponseEntity<ChZoneObjektiDto> findById(@PathVariable Long id) {
        return service.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    /**
     * Чување (креирање/ажурирање) везе зона-објекат.
     */
    @PostMapping
    @Operation(
        summary = "Чување повезаности зона и објеката",
        description = "Креира или ажурира један запис у табели ch_zoneObjekti.",
        tags = {"ChZoneObjekti"},
        operationId = "saveChZoneObjekti"
    )
    @PreAuthorize("hasRole('ROLE_SISTEM') or hasRole('ROLE_ADMIN')")
    public ResponseEntity<ChZoneObjektiDto> save(@RequestBody ChZoneObjektiDto dto) {
        return ResponseEntity.ok(service.save(dto));
    }

    /**
     * Тврдо брисање везе зона-објекат.
     */
    @DeleteMapping("/{id}")
    @Operation(
        summary = "Тврдо брисање повезаности зона и објеката",
        description = "Тврдо (перманентно) брише запис из табеле ch_zoneObjekti.",
        tags = {"ChZoneObjekti"},
        operationId = "deleteChZoneObjekti"
    )
    @PreAuthorize("hasRole('ROLE_SISTEM')")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.hardDelete(id);
        return ResponseEntity.noContent().build();
    }

    /**
     * Повезивање са CrudService-ом.
     */
    @Override
    protected CrudService<?, ChZoneObjektiDto> getService() {
        return service;
    }
}
