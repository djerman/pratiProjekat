package rs.prati.rest.controller;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import rs.prati.service.DeVozaciLicnaService;
import rs.prati.service.common.CrudService;
import rs.prati.service.dto.DeVozaciLicnaDto;

import java.util.List;
import java.util.Optional;

/**
 * REST контролер за ентитет DeVozaciLicna (лична карта возача).
 */
@RestController
@RequestMapping("/api/de-vozaci-licna")
public class DeVozaciLicnaController extends AbstractCrudController<DeVozaciLicnaDto> {

    private final DeVozaciLicnaService service;

    public DeVozaciLicnaController(DeVozaciLicnaService service) {
        this.service = service;
    }

    /**
     * Враћа све личне карте за датог корисника.
     */
    @GetMapping("/korisnik/{korisnikId}")
    @Operation(
            summary = "Све личне карте за корисника",
            description = "Враћа све личне карте (које нису обрисане) за датог корисника."
    )
    @PreAuthorize("hasRole('ROLE_SISTEM') or hasRole('ROLE_ADMIN')")
    public ResponseEntity<List<DeVozaciLicnaDto>> getAllForKorisnik(@PathVariable Long korisnikId) {
        return ResponseEntity.ok(service.findAllForKorisnik(korisnikId));
    }

    /**
     * Враћа све личне карте за датог претплатника.
     */
    @GetMapping("/pretplatnik/{pretplatnikId}")
    @Operation(
            summary = "Све личне карте за претплатника",
            description = "Враћа све личне карте (које нису обрисане) за датог претплатника."
    )
    @PreAuthorize("hasRole('ROLE_SISTEM') or hasRole('ROLE_ADMIN')")
    public ResponseEntity<List<DeVozaciLicnaDto>> getAllForPretplatnik(@PathVariable Long pretplatnikId) {
        return ResponseEntity.ok(service.findAllForPretplatnik(pretplatnikId));
    }

    /**
     * Враћа све не-обрисане личне карте.
     */
    @GetMapping
    @Operation(
            summary = "Све личне карте",
            description = "Враћа све не-обрисане личне карте возача."
    )
    @PreAuthorize("hasRole('ROLE_SISTEM') or hasRole('ROLE_ADMIN')")
    public ResponseEntity<List<DeVozaciLicnaDto>> getAll() {
        return ResponseEntity.ok(service.findAll());
    }

    /**
     * Чување нове или постојеће личне карте.
     */
    @PostMapping
    @Operation(
            summary = "Чување личне карте",
            description = "Чува или ажурира личну карту возача."
    )
    @PreAuthorize("hasRole('ROLE_SISTEM') or hasRole('ROLE_ADMIN')")
    public ResponseEntity<DeVozaciLicnaDto> save(@RequestBody DeVozaciLicnaDto dto) {
        return ResponseEntity.ok(service.save(dto));
    }

    /**
     * Тврдо брисање по ID.
     */
    @DeleteMapping("/{id}")
    @Operation(
            summary = "Тврдо брисање личне карте",
            description = "Тврдо брише личну карту возача по ID-у."
    )
    @PreAuthorize("hasRole('ROLE_SISTEM')")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.hardDelete(id);
        return ResponseEntity.noContent().build();
    }

    /**
     * Меко брисање (означава као обрисано).
     */
    @PatchMapping("/{id}/mark-deleted")
    @Operation(
            summary = "Меко брисање личне карте",
            description = "Меко брише личну карту возача (означава као обрисано)."
    )
    @PreAuthorize("hasRole('ROLE_SISTEM') or hasRole('ROLE_ADMIN')")
    public ResponseEntity<Void> markAsDeleted(@PathVariable Long id) {
        service.markAsDeleted(id);
        return ResponseEntity.noContent().build();
    }

    /**
     * Проналажење по ID.
     */
    @GetMapping("/{id}")
    @Operation(
            summary = "Детаљи личне карте по ID-у",
            description = "Враћа личну карту возача по ID-у."
    )
    @PreAuthorize("hasRole('ROLE_SISTEM') or hasRole('ROLE_ADMIN')")
    public ResponseEntity<DeVozaciLicnaDto> findById(@PathVariable Long id) {
        Optional<DeVozaciLicnaDto> dto = service.findById(id);
        return dto.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    /**
     * Поставља сервис за базни CRUD контролер.
     */
    @Override
    protected CrudService<?, DeVozaciLicnaDto> getService() {
        return service;
    }
}
