package rs.prati.rest.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import rs.prati.service.DkProjektiService;
import rs.prati.service.dto.DkProjektiDto;

import java.util.List;
import java.util.Optional;

/**
 * REST контролер за управљање пројектима.
 */
@RestController
@RequestMapping("/api/dk-projekti")
@Tag(name = "DkProjekti", description = "Операције над пројектима")
public class DkProjektiController {

    private final DkProjektiService service;

    public DkProjektiController(DkProjektiService service) {
        this.service = service;
    }

    @GetMapping
    @Operation(
            summary = "Сви небрисани пројекти",
            description = "Враћа све пројекте који нису означени као обрисани, опадајуће по ID."
    )
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_SISTEM')")
    public ResponseEntity<List<DkProjektiDto>> getAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/pretplatnik/{pretplatnikId}")
    @Operation(
            summary = "Пројекти по претплатнику",
            description = "Враћа све небрисане пројекте за датог претплатника."
    )
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_SISTEM')")
    public ResponseEntity<List<DkProjektiDto>> getAllByPretplatnik(@PathVariable Long pretplatnikId) {
        return ResponseEntity.ok(service.findAllForPretplatnik(pretplatnikId));
    }

    @GetMapping("/partner/{partnerId}")
    @Operation(
            summary = "Пројекти по партнеру",
            description = "Враћа све небрисане пројекте за датог партнера."
    )
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_SISTEM')")
    public ResponseEntity<List<DkProjektiDto>> getAllByPartner(@PathVariable Long partnerId) {
        return ResponseEntity.ok(service.findAllForPartner(partnerId));
    }

    @GetMapping("/{id}")
    @Operation(
            summary = "Један пројекат по ID-у",
            description = "Враћа податке о пројекту по задатом идентификатору."
    )
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_SISTEM')")
    public ResponseEntity<DkProjektiDto> getById(@PathVariable Long id) {
        Optional<DkProjektiDto> dto = service.findById(id);
        return dto.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    @Operation(
            summary = "Креирај/ажурирај пројекат",
            description = "Креира нови или ажурира постојећи пројекат."
    )
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_SISTEM')")
    public ResponseEntity<DkProjektiDto> save(@RequestBody DkProjektiDto dto) {
        return ResponseEntity.ok(service.save(dto));
    }

    @PatchMapping("/{id}/mark-deleted")
    @Operation(
            summary = "Меко брисање пројекта",
            description = "Означава пројекат као обрисан (логичко брисање)."
    )
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_SISTEM')")
    public ResponseEntity<Void> markAsDeleted(@PathVariable Long id) {
        service.markAsDeleted(id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    @Operation(
            summary = "Тврдо брисање пројекта",
            description = "Брише пројекат по идентификатору (тврдо брисање)."
    )
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_SISTEM')")
    public ResponseEntity<Void> hardDelete(@PathVariable Long id) {
        service.hardDelete(id);
        return ResponseEntity.noContent().build();
    }
}
