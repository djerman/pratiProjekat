package rs.prati.rest.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import rs.prati.service.DiPredjeniPutService;
import rs.prati.service.dto.DiPredjeniPutDto;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

/**
 * REST контролер за пређене путеве и потрошњу.
 */
@RestController
@RequestMapping("/api/di-predjeni-put")
@Tag(name = "DiPredjeniPut", description = "Операције над пређеним путевима и потрошњом")
public class DiPredjeniPutController {

    private final DiPredjeniPutService service;

    public DiPredjeniPutController(DiPredjeniPutService service) {
        this.service = service;
    }

    @GetMapping("/objekat/{objekatId}")
    @Operation(
            summary = "Сви записи за објекат",
            description = "Враћа све записе за дати објекат, опадајуће по ID."
    )
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_SISTEM')")
    public ResponseEntity<List<DiPredjeniPutDto>> getAllByObjekat(@PathVariable Long objekatId) {
        return ResponseEntity.ok(service.findAllForObjekat(objekatId));
    }

    @GetMapping("/datum/{datum}")
    @Operation(
            summary = "Сви записи за датум",
            description = "Враћа све записе за дати датум."
    )
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_SISTEM')")
    public ResponseEntity<List<DiPredjeniPutDto>> getAllByDatum(@PathVariable LocalDate datum) {
        return ResponseEntity.ok(service.findAllForDatum(datum));
    }

    @GetMapping("/{id}")
    @Operation(
            summary = "Један запис по ID-у",
            description = "Враћа податке по задатом идентификатору."
    )
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_SISTEM')")
    public ResponseEntity<DiPredjeniPutDto> getById(@PathVariable Long id) {
        Optional<DiPredjeniPutDto> dto = service.findById(id);
        return dto.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    @Operation(
            summary = "Креирај/ажурирај запис",
            description = "Креира нови или ажурира постојећи запис."
    )
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_SISTEM')")
    public ResponseEntity<DiPredjeniPutDto> save(@RequestBody DiPredjeniPutDto dto) {
        return ResponseEntity.ok(service.save(dto));
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
