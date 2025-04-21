package rs.prati.rest.controller;

import io.swagger.v3.oas.annotations.Hidden;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import rs.prati.service.AbSistemPretplatniciService;
import rs.prati.service.dto.AbSistemPretplatniciDto;

import java.util.List;

/**
 * REST контролер за рад са системским претплатницима. Приступ имају систем и администратор.
 */
@RestController
@RequestMapping("/api/pretplatnici")
@Hidden //@Tag(name = "Pretplatnici", description = "Управљање системским претплатницима")
public class AbSistemPretplatniciController {

    @Autowired
    private AbSistemPretplatniciService service;

    @GetMapping
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_SYSTEM')")
    public ResponseEntity<List<AbSistemPretplatniciDto>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_SYSTEM')")
    public ResponseEntity<AbSistemPretplatniciDto> findById(@PathVariable Long id) {
        return service.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @PreAuthorize("hasRole('ROLE_SYSTEM')")
    public ResponseEntity<AbSistemPretplatniciDto> save(@Valid @RequestBody AbSistemPretplatniciDto dto) {
        return ResponseEntity.ok(service.save(dto));
    }

    @DeleteMapping("/soft/{id}")
    @PreAuthorize("hasRole('ROLE_SYSTEM')")
    public ResponseEntity<Void> oznaciIzbrisan(@PathVariable Long id) {
        service.oznaciIzbrisan(id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_SYSTEM')")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
