package rs.prati.rest.controller;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import rs.prati.service.CgObdService;
import rs.prati.service.common.CrudService;
import rs.prati.service.dto.CgObdDto;

import java.util.List;

/**
 * REST контролер за CgObd – OBD подаци возила.
 */
@RestController
@RequestMapping("/api/cg-obd")
public class CgObdController extends AbstractCrudController<CgObdDto> {

    private final CgObdService service;

    public CgObdController(CgObdService service) {
        this.service = service;
    }

    /**
     * Враћа све OBD податке.
     */
    @GetMapping
    @Operation(
        summary = "Сви OBD подаци",
        description = "Враћа све унетe OBD податке из табеле cg_obd.",
        tags = {"CgObd"},
        operationId = "getAllCgObd")
    @PreAuthorize("hasRole('ROLE_SISTEM') or hasRole('ROLE_ADMIN')")
    public ResponseEntity<List<CgObdDto>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    /**
     * Проналажење по ID-у.
     */
    @GetMapping("/{id}")
    @Operation(
        summary = "Проналажење по ID-у",
        description = "Проналази један запис из табеле cg_obd на основу ID вредности.",
        tags = {"CgObd"},
        operationId = "getCgObdById")
    @PreAuthorize("hasRole('ROLE_SISTEM') or hasRole('ROLE_ADMIN')")
    public ResponseEntity<CgObdDto> findById(@PathVariable Long id) {
        return service.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    /**
     * Чување OBD податка.
     */
    @PostMapping
    @Operation(
        summary = "Чување OBD податка",
        description = "Креира или ажурира један запис у табели cg_obd.",
        tags = {"CgObd"},
        operationId = "saveCgObd")
    @PreAuthorize("hasRole('ROLE_SISTEM') or hasRole('ROLE_ADMIN')")
    public ResponseEntity<CgObdDto> save(@RequestBody CgObdDto dto) {
        return ResponseEntity.ok(service.save(dto));
    }

    /**
     * Меко брисање – означава као неважечи.
     */
    @PatchMapping("/{id}/mark-deleted")
    @Operation(
        summary = "Меко брисање",
        description = "Означава запис као избрисан (set valid=false) у табели cg_obd.",
        tags = {"CgObd"},
        operationId = "markCgObdDeleted")
    @PreAuthorize("hasRole('ROLE_SISTEM') or hasRole('ROLE_ADMIN')")
    public ResponseEntity<Void> markDeleted(@PathVariable Long id) {
        service.oznaciIzbrisan(id);
        return ResponseEntity.noContent().build();
    }

    /**
     * Тврдо брисање.
     */
    @DeleteMapping("/{id}")
    @Operation(
        summary = "Тврдо брисање",
        description = "Перманентно брише запис из табеле cg_obd.",
        tags = {"CgObd"},
        operationId = "deleteCgObd")
    @PreAuthorize("hasRole('ROLE_SISTEM')")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.hardDelete(id);
        return ResponseEntity.noContent().build();
    }

    /**
     * Повезивање контролера са CrudService-ом.
     */
    @Override
    protected CrudService<?, CgObdDto> getService() {
        return service;
    }
}
