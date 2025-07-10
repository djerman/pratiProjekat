package rs.prati.rest.controller;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import rs.prati.service.CgObdPoslednjiService;
import rs.prati.service.common.CrudService;
import rs.prati.service.dto.CgObdPoslednjiDto;

import java.util.List;

/**
 * REST контролер за CgObdPoslednji – последњи OBD подаци по објекту.
 */
@RestController
@RequestMapping("/api/cg-obdPoslednji")
public class CgObdPoslednjiController extends AbstractCrudController<CgObdPoslednjiDto> {

    private final CgObdPoslednjiService service;

    public CgObdPoslednjiController(CgObdPoslednjiService service) {
        this.service = service;
    }

    /**
     * Враћа све последње OBD податке за све објекте.
     */
    @GetMapping
    @Operation(
        summary = "Сви последњи OBD подаци",
        description = "Враћа све унетe последње OBD податке за све објекте из табеле cg_obdPoslednji.",
        tags = {"CgObdPoslednji"},
        operationId = "getAllCgObdPoslednji")
    @PreAuthorize("hasRole('ROLE_SISTEM') or hasRole('ROLE_ADMIN')")
    public ResponseEntity<List<CgObdPoslednjiDto>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    /**
     * Проналажење последњих OBD података по ID-у записа.
     */
    @GetMapping("/{id}")
    @Operation(
        summary = "Проналажење по ID-у",
        description = "Враћа један запис из табеле cg_obdPoslednji по ID-у.",
        tags = {"CgObdPoslednji"},
        operationId = "getCgObdPoslednjiById")
    @PreAuthorize("hasRole('ROLE_SISTEM') or hasRole('ROLE_ADMIN')")
    public ResponseEntity<CgObdPoslednjiDto> findById(@PathVariable Long id) {
        return service.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    /**
     * Чување (креирање/ажурирање) последњег OBD податка.
     */
    @PostMapping
    @Operation(
        summary = "Чување последњег OBD податка",
        description = "Креира или ажурира један запис у табели cg_obdPoslednji.",
        tags = {"CgObdPoslednji"},
        operationId = "saveCgObdPoslednji")
    @PreAuthorize("hasRole('ROLE_SISTEM') or hasRole('ROLE_ADMIN')")
    public ResponseEntity<CgObdPoslednjiDto> save(@RequestBody CgObdPoslednjiDto dto) {
        return ResponseEntity.ok(service.save(dto));
    }

    /**
     * Тврдо брисање последњег OBD податка.
     */
    @DeleteMapping("/{id}")
    @Operation(
        summary = "Тврдо брисање OBD податка",
        description = "Тврдо (перманентно) брише запис из табеле cg_obdPoslednji.",
        tags = {"CgObdPoslednji"},
        operationId = "deleteCgObdPoslednji")
    @PreAuthorize("hasRole('ROLE_SISTEM')")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.hardDelete(id);
        return ResponseEntity.noContent().build();
    }

    /**
     * Повезивање са CrudService-ом.
     */
    @Override
    protected CrudService<?, CgObdPoslednjiDto> getService() {
        return service;
    }
}
