package rs.prati.rest.controller;

import io.swagger.v3.oas.annotations.Hidden;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import rs.prati.service.AbSistemPretplatniciService;
import rs.prati.service.common.CrudService;
import rs.prati.service.dto.AbSistemPretplatniciDto;

import java.util.List;

/**
 * REST контролер за системске претплатнике.
 * Приступ имају систем и администратор.
 */
@RestController
@RequestMapping("/api/pretplatnici")
@Hidden
public class AbSistemPretplatniciController extends AbstractCrudController<AbSistemPretplatniciDto> {

    private final AbSistemPretplatniciService service;

    public AbSistemPretplatniciController(AbSistemPretplatniciService service) {
        this.service = service;
    }

    @Override
    protected CrudService<?, AbSistemPretplatniciDto> getService() {
        return service;
    }

    @Override
    @GetMapping
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_SYSTEM')")
    public ResponseEntity<List<AbSistemPretplatniciDto>> findAll() {
        return ResponseEntity.ok(getService().findAll());
    }

    @Override
    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_SYSTEM')")
    public ResponseEntity<AbSistemPretplatniciDto> findById(@PathVariable Long id) {
        return getService().findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @Override
    @PostMapping
    @PreAuthorize("hasRole('ROLE_SYSTEM')")
    public ResponseEntity<AbSistemPretplatniciDto> save(@RequestBody AbSistemPretplatniciDto dto) {
        return ResponseEntity.ok(getService().save(dto));
    }

    @Override
    @DeleteMapping("/soft/{id}")
    @PreAuthorize("hasRole('ROLE_SYSTEM')")
    public ResponseEntity<Void> oznaciIzbrisan(@PathVariable Long id) {
        getService().oznaciIzbrisan(id);
        return ResponseEntity.noContent().build();
    }

    @Override
    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_SYSTEM')")
    public ResponseEntity<Void> hardDelete(@PathVariable Long id) {
        getService().hardDelete(id);
        return ResponseEntity.noContent().build();
    }
}
