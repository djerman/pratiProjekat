package rs.prati.rest.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import rs.prati.service.DjRacuniService;
import rs.prati.service.dto.DjRacuniDto;

import java.util.List;
import java.util.Optional;

/**
 * REST контролер за управљање рачунима.
 */
@RestController
@RequestMapping("/api/dj-racuni")
@Tag(name = "DjRacuni", description = "Операције над рачунима")
public class DjRacuniController {

    private final DjRacuniService service;

    public DjRacuniController(DjRacuniService service) {
        this.service = service;
    }

    @GetMapping
    @Operation(
            summary = "Сви небрисани рачуни",
            description = "Враћа све рачуне који нису означени као обрисани, опадајуће по ID."
    )
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_SISTEM')")
    public ResponseEntity<List<DjRacuniDto>> getAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/partner/{partnerId}")
    @Operation(
            summary = "Рачуни по партнеру",
            description = "Враћа све небрисане рачуне за датог партнера."
    )
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_SISTEM')")
    public ResponseEntity<List<DjRacuniDto>> getAllByPartner(@PathVariable Long partnerId) {
        return ResponseEntity.ok(service.findAllForPartner(partnerId));
    }

    @GetMapping("/pretplatnik/{pretplatnikId}")
    @Operation(
            summary = "Рачуни по претплатнику",
            description = "Враћа све небрисане рачуне за датог претплатника."
    )
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_SISTEM')")
    public ResponseEntity<List<DjRacuniDto>> getAllByPretplatnik(@PathVariable Long pretplatnikId) {
        return ResponseEntity.ok(service.findAllForPretplatnik(pretplatnikId));
    }

    @GetMapping("/{id}")
    @Operation(
            summary = "Један рачун по ID-у",
            description = "Враћа податке о рачуну по задатом идентификатору."
    )
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_SISTEM')")
    public ResponseEntity<DjRacuniDto> getById(@PathVariable Long id) {
        Optional<DjRacuniDto> dto = service.findById(id);
        return dto.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    @Operation(
            summary = "Креирај/ажурирај рачун",
            description = "Креира нови или ажурира постојећи рачун."
    )
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_SISTEM')")
    public ResponseEntity<DjRacuniDto> save(@RequestBody DjRacuniDto dto) {
        return ResponseEntity.ok(service.save(dto));
    }

    @PatchMapping("/{id}/mark-deleted")
    @Operation(
            summary = "Меко брисање рачуна",
            description = "Означава рачун као обрисан (логичко брисање)."
    )
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_SISTEM')")
    public ResponseEntity<Void> markAsDeleted(@PathVariable Long id) {
        service.markAsDeleted(id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    @Operation(
            summary = "Тврдо брисање рачуна",
            description = "Брише рачун по идентификатору (тврдо брисање)."
    )
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_SISTEM')")
    public ResponseEntity<Void> hardDelete(@PathVariable Long id) {
        service.hardDelete(id);
        return ResponseEntity.noContent().build();
    }
}
