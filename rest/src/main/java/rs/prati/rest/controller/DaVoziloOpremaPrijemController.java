package rs.prati.rest.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import rs.prati.service.DaVoziloOpremaPrijemService;
import rs.prati.service.common.CrudService;
import rs.prati.service.dto.DaVoziloOpremaPrijemDto;

import java.util.List;

/**
 * REST контролер за DaVoziloOpremaPrijem – пријем опреме приликом примопредаје возила.
 */
@RestController
@RequestMapping("/api/da-vozilo-oprema-prijem")
@Tag(name = "DaVoziloOpremaPrijem", description = "Операције над пријемом опреме приликом примопредаје возила")
public class DaVoziloOpremaPrijemController extends AbstractCrudController<DaVoziloOpremaPrijemDto> {

    private final DaVoziloOpremaPrijemService service;

    public DaVoziloOpremaPrijemController(DaVoziloOpremaPrijemService service) {
        this.service = service;
    }

    /**
     * Враћа све пријеме опреме за одређену примопредају.
     */
    @GetMapping("/primo-predaja/{primoPredajaId}")
    @Operation(
        summary = "Све примљене опреме за задату примопредају",
        description = "Враћа све евидентиране пријеме опреме за дати ID примопредаје.",
        tags = {"DaVoziloOpremaPrijem"},
        operationId = "getAllByPrimoPredaja"
    )
    @PreAuthorize("hasRole('ROLE_SISTEM') or hasRole('ROLE_ADMIN')")
    public ResponseEntity<List<DaVoziloOpremaPrijemDto>> findByPrimoPredaja(@PathVariable Long primoPredajaId) {
        return ResponseEntity.ok(service.findByPrimoPredaja(primoPredajaId));
    }

    /**
     * Враћа све пријеме опреме за одређеног претплатника.
     */
    @GetMapping("/pretplatnik/{pretplatnikId}")
    @Operation(
        summary = "Све примљене опреме за претплатника",
        description = "Враћа све евидентиране пријеме опреме за дати ID претплатника.",
        tags = {"DaVoziloOpremaPrijem"},
        operationId = "getAllByPretplatnik"
    )
    @PreAuthorize("hasRole('ROLE_SISTEM') or hasRole('ROLE_ADMIN')")
    public ResponseEntity<List<DaVoziloOpremaPrijemDto>> findByPretplatnik(@PathVariable Long pretplatnikId) {
        return ResponseEntity.ok(service.findByPretplatnik(pretplatnikId));
    }

    /**
     * Чување новог или постојећег пријема опреме.
     */
    @PostMapping
    @Operation(
        summary = "Чување податка о пријему опреме",
        description = "Креира или ажурира податак о пријему опреме.",
        tags = {"DaVoziloOpremaPrijem"},
        operationId = "saveOpremaPrijem"
    )
    @PreAuthorize("hasRole('ROLE_SISTEM') or hasRole('ROLE_ADMIN')")
    public ResponseEntity<DaVoziloOpremaPrijemDto> save(@RequestBody DaVoziloOpremaPrijemDto dto) {
        return ResponseEntity.ok(service.save(dto));
    }

    /**
     * Проналажење по ID-у.
     */
    @GetMapping("/{id}")
    @Operation(
        summary = "Проналажење по ID-у",
        description = "Враћа податак о пријему опреме по задатом ID-у.",
        tags = {"DaVoziloOpremaPrijem"},
        operationId = "findOpremaPrijemById"
    )
    @PreAuthorize("hasRole('ROLE_SISTEM') or hasRole('ROLE_ADMIN')")
    public ResponseEntity<DaVoziloOpremaPrijemDto> findById(@PathVariable Long id) {
        return service.findById(id)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    /**
     * Повезивање са CrudService-ом.
     */
    @Override
    protected CrudService<?, DaVoziloOpremaPrijemDto> getService() {
        return service;
    }
}
