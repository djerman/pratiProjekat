package rs.prati.rest.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import rs.prati.service.DfVozaciPasosiService;
import rs.prati.service.dto.DfVozaciPasosiDto;

import java.util.List;
import java.util.Optional;

/**
 * REST контролер за управљање пасошима возача.
 */
@RestController
@RequestMapping("/api/df-vozaci-pasosi")
@Tag(name = "DfVozaciPasosi", description = "Операције над пасошима возача")
public class DfVozaciPasosiController {

    private final DfVozaciPasosiService service;

    public DfVozaciPasosiController(DfVozaciPasosiService service) {
        this.service = service;
    }

    @GetMapping
    @Operation(
            summary = "Сви небрисани пасоши возача",
            description = "Враћа све пасоше који нису означени као обрисани, опадајуће по ID."
    )
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_SISTEM')")
    public ResponseEntity<List<DfVozaciPasosiDto>> getAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/korisnik/{korisnikId}")
    @Operation(
            summary = "Пасоши по кориснику",
            description = "Враћа све небрисане пасоше за датог корисника."
    )
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_SISTEM')")
    public ResponseEntity<List<DfVozaciPasosiDto>> getAllByKorisnik(@PathVariable Long korisnikId) {
        return ResponseEntity.ok(service.findAllForKorisnik(korisnikId));
    }

    @GetMapping("/pretplatnik/{pretplatnikId}")
    @Operation(
            summary = "Пасоши по претплатнику",
            description = "Враћа све небрисане пасоше за датог претплатника."
    )
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_SISTEM')")
    public ResponseEntity<List<DfVozaciPasosiDto>> getAllByPretplatnik(@PathVariable Long pretplatnikId) {
        return ResponseEntity.ok(service.findAllForPretplatnik(pretplatnikId));
    }

    @GetMapping("/{id}")
    @Operation(
            summary = "Један пасош по ID-у",
            description = "Враћа податке о пасошу по задатом идентификатору."
    )
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_SISTEM')")
    public ResponseEntity<DfVozaciPasosiDto> getById(@PathVariable Long id) {
        Optional<DfVozaciPasosiDto> dto = service.findById(id);
        return dto.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    @Operation(
            summary = "Креирај/ажурирај пасош возача",
            description = "Креира нови или ажурира постојећи пасош возача."
    )
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_SISTEM')")
    public ResponseEntity<DfVozaciPasosiDto> save(@RequestBody DfVozaciPasosiDto dto) {
        return ResponseEntity.ok(service.save(dto));
    }

    @PatchMapping("/{id}/mark-deleted")
    @Operation(
            summary = "Меко брисање пасоша",
            description = "Означава пасош као обрисан (логичко брисање)."
    )
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_SISTEM')")
    public ResponseEntity<Void> markAsDeleted(@PathVariable Long id) {
        service.markAsDeleted(id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    @Operation(
            summary = "Тврдо брисање пасоша",
            description = "Брише пасош по идентификатору (тврдо брисање)."
    )
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_SISTEM')")
    public ResponseEntity<Void> hardDelete(@PathVariable Long id) {
        service.hardDelete(id);
        return ResponseEntity.noContent().build();
    }
}
