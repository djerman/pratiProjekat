package rs.prati.rest.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import rs.prati.service.DhVoziloSaobracajna2Service;
import rs.prati.service.dto.DhVoziloSaobracajna2Dto;

import java.util.List;
import java.util.Optional;

/**
 * REST контролер за управљање додатним подацима саобраћајне дозволе.
 */
@RestController
@RequestMapping("/api/dh-vozilo-saobracajna2")
@Tag(name = "DhVoziloSaobracajna2", description = "Операције над додатним подацима саобраћајних дозвола")
public class DhVoziloSaobracajna2Controller {

    private final DhVoziloSaobracajna2Service service;

    public DhVoziloSaobracajna2Controller(DhVoziloSaobracajna2Service service) {
        this.service = service;
    }

    @GetMapping
    @Operation(
            summary = "Сви небрисани записи",
            description = "Враћа све записе који нису означени као обрисани, опадајуће по ID."
    )
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_SISTEM')")
    public ResponseEntity<List<DhVoziloSaobracajna2Dto>> getAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/saobracajna/{saobracajnaId}")
    @Operation(
            summary = "Записи по саобраћајној дозволи",
            description = "Враћа све небрисане записе за дату саобраћајну дозволу."
    )
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_SISTEM')")
    public ResponseEntity<List<DhVoziloSaobracajna2Dto>> getAllBySaobracajna(@PathVariable Long saobracajnaId) {
        return ResponseEntity.ok(service.findAllForSaobracajna(saobracajnaId));
    }

    @GetMapping("/pretplatnik/{pretplatnikId}")
    @Operation(
            summary = "Записи по претплатнику",
            description = "Враћа све небрисане записе за датог претплатника."
    )
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_SISTEM')")
    public ResponseEntity<List<DhVoziloSaobracajna2Dto>> getAllByPretplatnik(@PathVariable Long pretplatnikId) {
        return ResponseEntity.ok(service.findAllForPretplatnik(pretplatnikId));
    }

    @GetMapping("/{id}")
    @Operation(
            summary = "Један запис по ID-у",
            description = "Враћа податке о запису по задатом идентификатору."
    )
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_SISTEM')")
    public ResponseEntity<DhVoziloSaobracajna2Dto> getById(@PathVariable Long id) {
        Optional<DhVoziloSaobracajna2Dto> dto = service.findById(id);
        return dto.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    @Operation(
            summary = "Креирај/ажурирај запис",
            description = "Креира нови или ажурира постојећи запис."
    )
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_SISTEM')")
    public ResponseEntity<DhVoziloSaobracajna2Dto> save(@RequestBody DhVoziloSaobracajna2Dto dto) {
        return ResponseEntity.ok(service.save(dto));
    }

    @PatchMapping("/{id}/mark-deleted")
    @Operation(
            summary = "Меко брисање записа",
            description = "Означава запис као обрисан (логичко брисање)."
    )
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_SISTEM')")
    public ResponseEntity<Void> markAsDeleted(@PathVariable Long id) {
        service.markAsDeleted(id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    @Operation(
            summary = "Тврдо брисање записа",
            description = "Брише запис по идентификатору (тврдо брисање)."
    )
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_SISTEM')")
    public ResponseEntity<Void> hardDelete(@PathVariable Long id) {
        service.hardDelete(id);
        return ResponseEntity.noContent().build();
    }
}
