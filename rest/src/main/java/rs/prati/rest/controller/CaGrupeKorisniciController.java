package rs.prati.rest.controller;

import io.swagger.v3.oas.annotations.Hidden;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import rs.prati.service.CaGrupeKorisniciService;
import rs.prati.service.common.CrudService;
import rs.prati.service.dto.CaGrupeKorisniciDto;

import java.util.List;

/**
 * REST контролер за CaGrupeKorisnici – повезивање корисника са групама.
 */
@RestController
@RequestMapping("/api/ca-grupe-korisnici")
@Hidden
public class CaGrupeKorisniciController extends AbstractCrudController<CaGrupeKorisniciDto> {

    private final CaGrupeKorisniciService service;

    public CaGrupeKorisniciController(CaGrupeKorisniciService service) {
        this.service = service;
    }

    /**
     * Враћа све везе за датог претплатника.
     */
    @GetMapping("/pretplatnik/{id}")
    @Operation(summary = "Све везе корисника и група за претплатника")
    @PreAuthorize("hasRole('ROLE_SISTEM') or hasRole('ROLE_ADMIN')")
    public List<CaGrupeKorisniciDto> findAllForPretplatnik(@PathVariable Long id) {
        return service.findAllForPretplatnik(id);
    }

    /**
     * Чување нове или постојеће везе.
     */
    @PostMapping
    @Operation(summary = "Чување везе корисника и групе")
    @PreAuthorize("hasRole('ROLE_SISTEM') or hasRole('ROLE_ADMIN')")
    public ResponseEntity<CaGrupeKorisniciDto> save(@RequestBody CaGrupeKorisniciDto dto) {
        return ResponseEntity.ok(service.save(dto));
    }

    /**
     * Тврдо брисање по ID-у.
     */
    @DeleteMapping("/{id}")
    @Operation(summary = "Тврдо брисање везе")
    @PreAuthorize("hasRole('ROLE_SISTEM')")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.hardDelete(id);
        return ResponseEntity.noContent().build();
    }

    /**
     * Меко брисање (означава као обрисану).
     */
    @PatchMapping("/{id}/mark-deleted")
    @Operation(summary = "Меко брисање везе")
    @PreAuthorize("hasRole('ROLE_SISTEM') or hasRole('ROLE_ADMIN')")
    public ResponseEntity<Void> markDeleted(@PathVariable Long id) {
        service.oznaciIzbrisan(id);
        return ResponseEntity.noContent().build();
    }

    /**
     * Проналажење по ID-у.
     */
    @GetMapping("/{id}")
    @Operation(summary = "Проналажење везе по ID-у")
    @PreAuthorize("hasRole('ROLE_SISTEM') or hasRole('ROLE_ADMIN')")
    public ResponseEntity<CaGrupeKorisniciDto> findById(@PathVariable Long id) {
        return service.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    /**
     * Враћа све везе.
     */
    @GetMapping
    @Operation(summary = "Све везе корисника и група")
    @PreAuthorize("hasRole('ROLE_SISTEM') or hasRole('ROLE_ADMIN')")
    public ResponseEntity<List<CaGrupeKorisniciDto>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    /**
     * Повезивање са сервис слојем.
     */
    @Override
    protected CrudService<?, CaGrupeKorisniciDto> getService() {
        return service;
    }
}
