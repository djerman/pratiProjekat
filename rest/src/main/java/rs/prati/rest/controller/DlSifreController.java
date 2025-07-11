package rs.prati.rest.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import rs.prati.service.DlSifreService;
import rs.prati.service.dto.DlSifreDto;

import java.util.List;
import java.util.Optional;

/**
 * REST контролер за управљање шифрама партнера.
 */
@RestController
@RequestMapping("/api/dl-sifre")
@Tag(name = "DlSifre", description = "Операције над шифрама партнера")
public class DlSifreController {

    private final DlSifreService service;

    public DlSifreController(DlSifreService service) {
        this.service = service;
    }

    @GetMapping
    @Operation(
            summary = "Све небрисане шифре",
            description = "Враћа све шифре које нису означене као обрисане, опадајуће по ID."
    )
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_SISTEM')")
    public ResponseEntity<List<DlSifreDto>> getAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/pretplatnik/{pretplatnikId}")
    @Operation(
            summary = "Шифре по претплатнику",
            description = "Враћа све небрисане шифре за датог претплатника."
    )
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_SISTEM')")
    public ResponseEntity<List<DlSifreDto>> getAllByPretplatnik(@PathVariable Long pretplatnikId) {
        return ResponseEntity.ok(service.findAllForPretplatnik(pretplatnikId));
    }

    @GetMapping("/partner/{partnerId}")
    @Operation(
            summary = "Шифре по партнеру",
            description = "Враћа све небрисане шифре за датог партнера."
    )
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_SISTEM')")
    public ResponseEntity<List<DlSifreDto>> getAllByPartner(@PathVariable Long partnerId) {
        return ResponseEntity.ok(service.findAllForPartner(partnerId));
    }

    @GetMapping("/{id}")
    @Operation(
            summary = "Једна шифра по ID-у",
            description = "Враћа податке о шифри по задатом идентификатору."
    )
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_SISTEM')")
    public ResponseEntity<DlSifreDto> getById(@PathVariable Long id) {
        Optional<DlSifreDto> dto = service.findById(id);
        return dto.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    @Operation(
            summary = "Креирај/ажурирај шифру",
            description = "Креира нову или ажурира постојећу шифру партнера."
    )
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_SISTEM')")
    public ResponseEntity<DlSifreDto> save(@RequestBody DlSifreDto dto) {
        return ResponseEntity.ok(service.save(dto));
    }

    @PatchMapping("/{id}/mark-deleted")
    @Operation(
            summary = "Меко брисање шифре",
            description = "Означава шифру као обрисану (логичко брисање)."
    )
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_SISTEM')")
    public ResponseEntity<Void> markAsDeleted(@PathVariable Long id) {
        service.markAsDeleted(id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    @Operation(
            summary = "Тврдо брисање шифре",
            description = "Брише шифру по идентификатору (тврдо брисање)."
    )
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_SISTEM')")
    public ResponseEntity<Void> hardDelete(@PathVariable Long id) {
        service.hardDelete(id);
        return ResponseEntity.noContent().build();
    }
}
