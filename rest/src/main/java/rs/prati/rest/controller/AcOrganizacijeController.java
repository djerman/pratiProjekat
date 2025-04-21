package rs.prati.rest.controller;

import io.swagger.v3.oas.annotations.Hidden;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import rs.prati.service.AcOrganizacijeService;
import rs.prati.service.dto.AcOrganizacijeDto;

import java.util.List;

/**
 * REST контролер за организације.
 * Приступ имају:
 * - системски корисници,
 * - администратори (само ако припадају истом претплатнику као организација).
 */
@RestController
@RequestMapping("/api/organizacije")
@Hidden // Сакривен из Swagger-а
public class AcOrganizacijeController {

    @Autowired
    private AcOrganizacijeService service;

    /**
     * Враћа листу свих организација. Приступ имају систем и администратор.
     * Администратор може видети само организације из свог претплатничког домена (филтрација се обавља у сервису).
     */
    @GetMapping
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_SYSTEM')")
    public ResponseEntity<List<AcOrganizacijeDto>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    /**
     * Враћа једну организацију по ID-у. Приступ имају систем и администратор.
     * Администратор може видети само организацију у оквиру свог претплатничког домена.
     */
    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_SYSTEM')")
    public ResponseEntity<AcOrganizacijeDto> findById(@PathVariable Long id) {
        return service.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    /**
     * Снима нову или ажурира постојећу организацију.
     * Ово може радити само системски корисник.
     */
    @PostMapping
    @PreAuthorize("hasRole('ROLE_SYSTEM')")
    public ResponseEntity<AcOrganizacijeDto> save(@Valid @RequestBody AcOrganizacijeDto dto) {
        return ResponseEntity.ok(service.save(dto));
    }

    /**
     * Меки delete (логичко брисање) организације — поставља поље 'izbrisan' на true.
     * Само за системског корисника.
     */
    @DeleteMapping("/soft/{id}")
    @PreAuthorize("hasRole('ROLE_SYSTEM')")
    public ResponseEntity<Void> oznaciIzbrisan(@PathVariable Long id) {
        service.oznaciIzbrisan(id);
        return ResponseEntity.noContent().build();
    }

    /**
     * Тврдо брисање организације из базе (само за системског корисника).
     */
    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_SYSTEM')")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}

