package rs.prati.rest.controller;

import io.swagger.v3.oas.annotations.Hidden;
import io.swagger.v3.oas.annotations.Operation;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import rs.prati.service.BfZoneService;
import rs.prati.service.common.CrudService;
import rs.prati.service.dto.BfZoneDto;

import java.util.List;

/**
 * REST контролер за рад са гео-зонама (BfZone).
 */
@RestController
@RequestMapping("/api/bf-zone")
@Hidden
public class BfZoneController extends AbstractCrudController<BfZoneDto> {

    private final BfZoneService service;

    public BfZoneController(BfZoneService service) {
        this.service = service;
    }

    /**
     * Враћа све зоне за датог претплатника које нису обрисане.
     * Приступ имају систем и администратор.
     */
    @GetMapping("/pretplatnik/{id}")
    @Operation(summary = "Све зоне за претплатника")
    @PreAuthorize("hasRole('ROLE_SISTEM') or hasRole('ROLE_ADMIN')")
    public List<BfZoneDto> findAllForPretplatnik(@PathVariable Long id) {
        return service.findAllForPretplatnik(id);
    }

    /**
     * Чува нову или постојећу зону.
     */
    @PostMapping
    @Operation(summary = "Чување зоне")
    @PreAuthorize("hasRole('ROLE_SISTEM') or hasRole('ROLE_ADMIN')")
    public ResponseEntity<BfZoneDto> save(@RequestBody BfZoneDto dto) {
        return ResponseEntity.ok(service.save(dto));
    }

    /**
     * Брише зону по ID-у.
     */
    @DeleteMapping("/{id}")
    @Operation(summary = "Тврдо брисање зоне")
    @PreAuthorize("hasRole('ROLE_SISTEM')")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.hardDelete(id);
        return ResponseEntity.noContent().build();
    }

    /**
     * Означава зону као обрисану.
     */
    @PatchMapping("/{id}/mark-deleted")
    @Operation(summary = "Меко брисање зоне")
    @PreAuthorize("hasRole('ROLE_SISTEM') or hasRole('ROLE_ADMIN')")
    public ResponseEntity<Void> markDeleted(@PathVariable Long id) {
        service.oznaciIzbrisan(id);
        return ResponseEntity.noContent().build();
    }

    /**
     * Враћа зону по ID-у.
     */
    @GetMapping("/{id}")
    @Operation(summary = "Проналажење зоне по ID-у")
    @PreAuthorize("hasRole('ROLE_SISTEM') or hasRole('ROLE_ADMIN')")
    public ResponseEntity<BfZoneDto> findById(@PathVariable Long id) {
        return service.findById(id)
        		.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    /**
     * Враћа све зоне (сортиране по ID).
     */
    @GetMapping
    @Operation(summary = "Све зоне")
    @PreAuthorize("hasRole('ROLE_SISTEM') or hasRole('ROLE_ADMIN')")
    public ResponseEntity<List<BfZoneDto>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

	@Override
	protected CrudService<?, BfZoneDto> getService() {
		return service;
	}
}
