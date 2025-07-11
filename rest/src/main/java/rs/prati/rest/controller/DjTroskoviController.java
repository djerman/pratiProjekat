package rs.prati.rest.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import rs.prati.service.DjTroskoviService;
import rs.prati.service.dto.DjTroskoviDto;

import java.util.List;
import java.util.Optional;

/**
 * REST контролер за управљање трошковима.
 */
@RestController
@RequestMapping("/api/dj-troskovi")
@Tag(name = "DjTroskovi", description = "Операције над трошковима")
public class DjTroskoviController {

    private final DjTroskoviService service;

    public DjTroskoviController(DjTroskoviService service) {
        this.service = service;
    }

    @GetMapping
    @Operation(
            summary = "Сви небрисани трошкови",
            description = "Враћа све трошкове који нису означени као обрисани, опадајуће по ID."
    )
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_SISTEM')")
    public ResponseEntity<List<DjTroskoviDto>> getAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/objekat/{objekatId}")
    @Operation(
            summary = "Трошкови по објекту",
            description = "Враћа све небрисане трошкове за дати објекат."
    )
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_SISTEM')")
    public ResponseEntity<List<DjTroskoviDto>> getAllByObjekat(@PathVariable Long objekatId) {
        return ResponseEntity.ok(service.findAllForObjekat(objekatId));
    }

    @GetMapping("/partner/{partnerId}")
    @Operation(
            summary = "Трошкови по партнеру",
            description = "Враћа све небрисане трошкове за датог партнера."
    )
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_SISTEM')")
    public ResponseEntity<List<DjTroskoviDto>> getAllByPartner(@PathVariable Long partnerId) {
        return ResponseEntity.ok(service.findAllForPartner(partnerId));
    }

    @GetMapping("/pretplatnik/{pretplatnikId}")
    @Operation(
            summary = "Трошкови по претплатнику",
            description = "Враћа све небрисане трошкове за датог претплатника."
    )
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_SISTEM')")
    public ResponseEntity<List<DjTroskoviDto>> getAllByPretplatnik(@PathVariable Long pretplatnikId) {
        return ResponseEntity.ok(service.findAllForPretplatnik(pretplatnikId));
    }

    @GetMapping("/{id}")
    @Operation(
            summary = "Један трошак по ID-у",
            description = "Враћа податке о трошку по задатом идентификатору."
    )
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_SISTEM')")
    public ResponseEntity<DjTroskoviDto> getById(@PathVariable Long id) {
        Optional<DjTroskoviDto> dto = service.findById(id);
        return dto.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    @Operation(
            summary = "Креирај/ажурирај трошак",
            description = "Креира нови или ажурира постојећи трошак."
    )
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_SISTEM')")
    public ResponseEntity<DjTroskoviDto> save(@RequestBody DjTroskoviDto dto) {
        return ResponseEntity.ok(service.save(dto));
    }

    @PatchMapping("/{id}/mark-deleted")
    @Operation(
            summary = "Меко брисање трошка",
            description = "Означава трошак као обрисан (логичко брисање)."
    )
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_SISTEM')")
    public ResponseEntity<Void> markAsDeleted(@PathVariable Long id) {
        service.markAsDeleted(id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    @Operation(
            summary = "Тврдо брисање трошка",
            description = "Брише трошак по идентификатору (тврдо брисање)."
    )
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_SISTEM')")
    public ResponseEntity<Void> hardDelete(@PathVariable Long id) {
        service.hardDelete(id);
        return ResponseEntity.noContent().build();
    }
}
