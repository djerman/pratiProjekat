package rs.prati.rest.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import rs.prati.service.DgVoziloSaobracajnaService;
import rs.prati.service.dto.DgVoziloSaobracajnaDto;

import java.util.List;
import java.util.Optional;

/**
 * REST контролер за управљање саобраћајним дозволама возила.
 */
@RestController
@RequestMapping("/api/dg-vozilo-saobracajna")
@Tag(name = "DgVoziloSaobracajna", description = "Операције над саобраћајним дозволама возила")
public class DgVoziloSaobracajnaController {

    private final DgVoziloSaobracajnaService service;

    public DgVoziloSaobracajnaController(DgVoziloSaobracajnaService service) {
        this.service = service;
    }

    @GetMapping
    @Operation(
            summary = "Све небрисане саобраћајне дозволе",
            description = "Враћа све саобраћајне дозволе које нису означене као обрисане, опадајуће по ID."
    )
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_SISTEM')")
    public ResponseEntity<List<DgVoziloSaobracajnaDto>> getAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/vozilo/{voziloId}")
    @Operation(
            summary = "Саобраћајне дозволе по возилу",
            description = "Враћа све небрисане саобраћајне дозволе за дато возило."
    )
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_SISTEM')")
    public ResponseEntity<List<DgVoziloSaobracajnaDto>> getAllByVozilo(@PathVariable Long voziloId) {
        return ResponseEntity.ok(service.findAllForVozilo(voziloId));
    }

    @GetMapping("/pretplatnik/{pretplatnikId}")
    @Operation(
            summary = "Саобраћајне дозволе по претплатнику",
            description = "Враћа све небрисане саобраћајне дозволе за датог претплатника."
    )
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_SISTEM')")
    public ResponseEntity<List<DgVoziloSaobracajnaDto>> getAllByPretplatnik(@PathVariable Long pretplatnikId) {
        return ResponseEntity.ok(service.findAllForPretplatnik(pretplatnikId));
    }

    @GetMapping("/{id}")
    @Operation(
            summary = "Једна саобраћајна дозвола по ID-у",
            description = "Враћа податке о саобраћајној дозволи по задатом идентификатору."
    )
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_SISTEM')")
    public ResponseEntity<DgVoziloSaobracajnaDto> getById(@PathVariable Long id) {
        Optional<DgVoziloSaobracajnaDto> dto = service.findById(id);
        return dto.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    @Operation(
            summary = "Креирај/ажурирај саобраћајну дозволу",
            description = "Креира нову или ажурира постојећу саобраћајну дозволу возила."
    )
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_SISTEM')")
    public ResponseEntity<DgVoziloSaobracajnaDto> save(@RequestBody DgVoziloSaobracajnaDto dto) {
        return ResponseEntity.ok(service.save(dto));
    }

    @PatchMapping("/{id}/mark-deleted")
    @Operation(
            summary = "Меко брисање саобраћајне дозволе",
            description = "Означава саобраћајну дозволу као обрисану (логичко брисање)."
    )
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_SISTEM')")
    public ResponseEntity<Void> markAsDeleted(@PathVariable Long id) {
        service.markAsDeleted(id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    @Operation(
            summary = "Тврдо брисање саобраћајне дозволе",
            description = "Брише саобраћајну дозволу по идентификатору (тврдо брисање)."
    )
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_SISTEM')")
    public ResponseEntity<Void> hardDelete(@PathVariable Long id) {
        service.hardDelete(id);
        return ResponseEntity.noContent().build();
    }
}
