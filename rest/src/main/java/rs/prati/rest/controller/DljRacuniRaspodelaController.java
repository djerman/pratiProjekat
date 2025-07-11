package rs.prati.rest.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import rs.prati.service.DljRacuniRaspodelaService;
import rs.prati.service.dto.DljRacuniRaspodelaDto;

import java.util.List;
import java.util.Optional;

/**
 * REST контролер за управљање расподелом износа по рачунима.
 */
@RestController
@RequestMapping("/api/dlj-racuni-raspodela")
@Tag(name = "DljRacuniRaspodela", description = "Операције над расподелом износа по рачунима")
public class DljRacuniRaspodelaController {

    private final DljRacuniRaspodelaService service;

    public DljRacuniRaspodelaController(DljRacuniRaspodelaService service) {
        this.service = service;
    }

    @GetMapping("/partner/{partnerId}")
    @Operation(
            summary = "Расподела по партнеру",
            description = "Враћа све расподеле за датог партнера."
    )
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_SISTEM')")
    public ResponseEntity<List<DljRacuniRaspodelaDto>> getAllByPartner(@PathVariable Long partnerId) {
        return ResponseEntity.ok(service.findAllForPartner(partnerId));
    }

    @GetMapping("/racun/{racunId}")
    @Operation(
            summary = "Расподела по рачуну",
            description = "Враћа све расподеле за дати рачун."
    )
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_SISTEM')")
    public ResponseEntity<List<DljRacuniRaspodelaDto>> getAllByRacun(@PathVariable Long racunId) {
        return ResponseEntity.ok(service.findAllForRacun(racunId));
    }

    @GetMapping("/pretplatnik/{pretplatnikId}")
    @Operation(
            summary = "Расподела по претплатнику",
            description = "Враћа све расподеле за датог претплатника."
    )
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_SISTEM')")
    public ResponseEntity<List<DljRacuniRaspodelaDto>> getAllByPretplatnik(@PathVariable Long pretplatnikId) {
        return ResponseEntity.ok(service.findAllForPretplatnik(pretplatnikId));
    }

    @GetMapping("/{id}")
    @Operation(
            summary = "Једна расподела по ID-у",
            description = "Враћа податке о расподели по задатом идентификатору."
    )
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_SISTEM')")
    public ResponseEntity<DljRacuniRaspodelaDto> getById(@PathVariable Long id) {
        Optional<DljRacuniRaspodelaDto> dto = service.findById(id);
        return dto.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    @Operation(
            summary = "Креирај/ажурирај расподелу",
            description = "Креира нову или ажурира постојећу расподелу."
    )
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_SISTEM')")
    public ResponseEntity<DljRacuniRaspodelaDto> save(@RequestBody DljRacuniRaspodelaDto dto) {
        return ResponseEntity.ok(service.save(dto));
    }

    @DeleteMapping("/{id}")
    @Operation(
            summary = "Тврдо брисање расподеле",
            description = "Брише расподелу по идентификатору (тврдо брисање)."
    )
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_SISTEM')")
    public ResponseEntity<Void> hardDelete(@PathVariable Long id) {
        service.hardDelete(id);
        return ResponseEntity.noContent().build();
    }
}
