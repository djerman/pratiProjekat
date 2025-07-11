package rs.prati.rest.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import rs.prati.service.DmEvidencijaVoznjiService;
import rs.prati.service.dto.DmEvidencijaVoznjiDto;

import java.util.List;
import java.util.Optional;

/**
 * REST контролер за евиденцију вожњи.
 */
@RestController
@RequestMapping("/api/dm-evidencija-voznji")
@Tag(name = "DmEvidencijaVoznji", description = "Операције над евиденцијом вожњи")
public class DmEvidencijaVoznjiController {

    private final DmEvidencijaVoznjiService service;

    public DmEvidencijaVoznjiController(DmEvidencijaVoznjiService service) {
        this.service = service;
    }

    @GetMapping("/pretplatnik/{pretplatnikId}")
    @Operation(
            summary = "Све евиденције по претплатнику",
            description = "Враћа све евиденције за датог претплатника."
    )
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_SISTEM')")
    public ResponseEntity<List<DmEvidencijaVoznjiDto>> getAllByPretplatnik(@PathVariable Long pretplatnikId) {
        return ResponseEntity.ok(service.findAllForPretplatnik(pretplatnikId));
    }

    @GetMapping("/organizacija/{organizacijaId}")
    @Operation(
            summary = "Све евиденције по организацији",
            description = "Враћа све евиденције за дату организацију."
    )
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_SISTEM')")
    public ResponseEntity<List<DmEvidencijaVoznjiDto>> getAllByOrganizacija(@PathVariable Long organizacijaId) {
        return ResponseEntity.ok(service.findAllForOrganizacija(organizacijaId));
    }

    @GetMapping("/{id}")
    @Operation(
            summary = "Једна евиденција по ID-у",
            description = "Враћа податке о евиденцији по задатом идентификатору."
    )
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_SISTEM')")
    public ResponseEntity<DmEvidencijaVoznjiDto> getById(@PathVariable Long id) {
        Optional<DmEvidencijaVoznjiDto> dto = service.findById(id);
        return dto.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    @Operation(
            summary = "Креирај/ажурирај евиденцију",
            description = "Креира нову или ажурира постојећу евиденцију."
    )
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_SISTEM')")
    public ResponseEntity<DmEvidencijaVoznjiDto> save(@RequestBody DmEvidencijaVoznjiDto dto) {
        return ResponseEntity.ok(service.save(dto));
    }

    @DeleteMapping("/{id}")
    @Operation(
            summary = "Тврдо брисање евиденције",
            description = "Брише евиденцију по идентификатору (тврдо брисање)."
    )
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_SISTEM')")
    public ResponseEntity<Void> hardDelete(@PathVariable Long id) {
        service.hardDelete(id);
        return ResponseEntity.noContent().build();
    }
}
