package rs.prati.rest.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import rs.prati.service.DySistemSesijeService;
import rs.prati.service.dto.DySistemSesijeDto;

import java.util.List;
import java.util.Optional;

/**
 * REST контролер за управљање системским сесијама корисника.
 */
@RestController
@RequestMapping("/api/dy-sistem-sesije")
@Tag(name = "DySistemSesije", description = "Операције над системским сесијама корисника")
public class DySistemSesijeController {

    private final DySistemSesijeService service;

    public DySistemSesijeController(DySistemSesijeService service) {
        this.service = service;
    }

    @GetMapping
    @Operation(
            summary = "Све небрисане системске сесије",
            description = "Враћа све системске сесије које нису означене као обрисане, опадајуће по ID."
    )
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_SISTEM')")
    public ResponseEntity<List<DySistemSesijeDto>> getAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/korisnik/{korisnikId}")
    @Operation(
            summary = "Сесије по кориснику",
            description = "Враћа све небрисане сесије за датог корисника."
    )
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_SISTEM')")
    public ResponseEntity<List<DySistemSesijeDto>> getAllByKorisnik(@PathVariable Long korisnikId) {
        return ResponseEntity.ok(service.findAllForKorisnik(korisnikId));
    }

    @GetMapping("/pretplatnik/{pretplatnikId}")
    @Operation(
            summary = "Сесије по претплатнику",
            description = "Враћа све небрисане сесије за датог претплатника."
    )
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_SISTEM')")
    public ResponseEntity<List<DySistemSesijeDto>> getAllByPretplatnik(@PathVariable Long pretplatnikId) {
        return ResponseEntity.ok(service.findAllForPretplatnik(pretplatnikId));
    }

    @GetMapping("/{id}")
    @Operation(
            summary = "Једна сесија по ID-у",
            description = "Враћа податке о системској сесији по задатом идентификатору."
    )
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_SISTEM')")
    public ResponseEntity<DySistemSesijeDto> getById(@PathVariable Long id) {
        Optional<DySistemSesijeDto> dto = service.findById(id);
        return dto.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    @Operation(
            summary = "Креирај/ажурирај системску сесију",
            description = "Креира нову или ажурира постојећу системску сесију."
    )
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_SISTEM')")
    public ResponseEntity<DySistemSesijeDto> save(@RequestBody DySistemSesijeDto dto) {
        return ResponseEntity.ok(service.save(dto));
    }

    @PatchMapping("/{id}/mark-deleted")
    @Operation(
            summary = "Меко брисање системске сесије",
            description = "Означава системску сесију као обрисану (логичко брисање)."
    )
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_SISTEM')")
    public ResponseEntity<Void> markAsDeleted(@PathVariable Long id) {
        service.markAsDeleted(id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    @Operation(
            summary = "Тврдо брисање системске сесије",
            description = "Брише системску сесију по идентификатору (тврдо брисање)."
    )
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_SISTEM')")
    public ResponseEntity<Void> hardDelete(@PathVariable Long id) {
        service.hardDelete(id);
        return ResponseEntity.noContent().build();
    }
}
