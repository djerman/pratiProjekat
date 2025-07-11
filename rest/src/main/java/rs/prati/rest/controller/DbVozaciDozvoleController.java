package rs.prati.rest.controller;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import rs.prati.service.DbVozaciDozvoleService;
import rs.prati.service.common.CrudService;
import rs.prati.service.dto.DbVozaciDozvoleDto;

import java.util.List;

/**
 * REST контролер за DbVozaciDozvole – возачке дозволе корисника.
 */
@RestController
@RequestMapping("/api/db-vozaci-dozvole")
public class DbVozaciDozvoleController extends AbstractCrudController<DbVozaciDozvoleDto> {

    private final DbVozaciDozvoleService service;

    public DbVozaciDozvoleController(DbVozaciDozvoleService service) {
        this.service = service;
    }

    /**
     * Враћа све дозволе за конкретног корисника (возача).
     */
    @GetMapping("/korisnik/{korisnikId}")
    @Operation(
        summary = "Све дозволе за корисника",
        description = "Враћа све валидне (необрисане) возачке дозволе за датог корисника (возача) по ID-у.",
        tags = {"DbVozaciDozvole"},
        operationId = "getAllByKorisnik"
    )
    @PreAuthorize("hasRole('ROLE_SISTEM') or hasRole('ROLE_ADMIN')")
    public List<DbVozaciDozvoleDto> findByKorisnik(@PathVariable Long korisnikId) {
        return service.findByKorisnik(korisnikId);
    }

    /**
     * Враћа све дозволе за претплатника.
     */
    @GetMapping("/pretplatnik/{pretplatnikId}")
    @Operation(
        summary = "Све дозволе за претплатника",
        description = "Враћа све валидне (необрисане) возачке дозволе за датог претплатника по ID-у.",
        tags = {"DbVozaciDozvole"},
        operationId = "getAllByPretplatnik"
    )
    @PreAuthorize("hasRole('ROLE_SISTEM') or hasRole('ROLE_ADMIN')")
    public List<DbVozaciDozvoleDto> findByPretplatnik(@PathVariable Long pretplatnikId) {
        return service.findByPretplatnik(pretplatnikId);
    }

    /**
     * Чување нове или постојеће дозволе.
     */
    @PostMapping
    @Operation(
        summary = "Чување возачке дозволе",
        description = "Чува нову или ажурира постојећу возачку дозволу.",
        tags = {"DbVozaciDozvole"},
        operationId = "saveDbVozaciDozvole"
    )
    @PreAuthorize("hasRole('ROLE_SISTEM') or hasRole('ROLE_ADMIN')")
    public ResponseEntity<DbVozaciDozvoleDto> save(@RequestBody DbVozaciDozvoleDto dto) {
        return ResponseEntity.ok(service.save(dto));
    }

    /**
     * Проналажење дозволе по ID-у.
     */
    @GetMapping("/{id}")
    @Operation(
        summary = "Проналажење по ID-у",
        description = "Враћа податке о возачкој дозволи по ID-у.",
        tags = {"DbVozaciDozvole"},
        operationId = "findDbVozaciDozvoleById"
    )
    @PreAuthorize("hasRole('ROLE_SISTEM') or hasRole('ROLE_ADMIN')")
    public ResponseEntity<DbVozaciDozvoleDto> findById(@PathVariable Long id) {
        return service.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    /**
     * Враћа све возачке дозволе.
     */
    @GetMapping
    @Operation(
        summary = "Све возачке дозволе",
        description = "Враћа све валидне (необрисане) возачке дозволе.",
        tags = {"DbVozaciDozvole"},
        operationId = "getAllDbVozaciDozvole"
    )
    @PreAuthorize("hasRole('ROLE_SISTEM') or hasRole('ROLE_ADMIN')")
    public ResponseEntity<List<DbVozaciDozvoleDto>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    /**
     * Повезивање са CrudService-ом.
     */
    @Override
    protected CrudService<?, DbVozaciDozvoleDto> getService() {
        return service;
    }
}
