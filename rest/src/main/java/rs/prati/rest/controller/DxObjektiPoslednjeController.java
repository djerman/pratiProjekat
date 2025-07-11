package rs.prati.rest.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import rs.prati.service.DxObjektiPoslednjeService;
import rs.prati.service.dto.DxObjektiPoslednjeDto;

import java.util.List;
import java.util.Optional;

/**
 * REST контролер за управљање подацима о последњим сервисима, регистрацији и километражи објеката.
 */
@RestController
@RequestMapping("/api/dx-objekti-poslednje")
@Tag(name = "DxObjektiPoslednje", description = "Операције над подацима о последњим сервисима, регистрацији и километражи објеката")
public class DxObjektiPoslednjeController {

    private final DxObjektiPoslednjeService service;

    public DxObjektiPoslednjeController(DxObjektiPoslednjeService service) {
        this.service = service;
    }

    @GetMapping("/objekat/{objekatId}")
    @Operation(
            summary = "Сви подаци за објекат",
            description = "Враћа све записе о последњим сервисима, регистрацији и километражи за дати објекат (опадајуће по ID)."
    )
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_SISTEM')")
    public ResponseEntity<List<DxObjektiPoslednjeDto>> getAllForObjekat(@PathVariable Long objekatId) {
        return ResponseEntity.ok(service.findAllForObjekat(objekatId));
    }

    @GetMapping("/{id}")
    @Operation(
            summary = "Један запис по ID-у",
            description = "Враћа податке о сервису, регистрацији или километражи по задатом идентификатору."
    )
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_SISTEM')")
    public ResponseEntity<DxObjektiPoslednjeDto> getById(@PathVariable Long id) {
        Optional<DxObjektiPoslednjeDto> dto = service.findById(id);
        return dto.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    @Operation(
            summary = "Креирај/ажурирај запис",
            description = "Креира нови или ажурира постојећи запис о сервису, регистрацији или километражи објекта."
    )
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_SISTEM')")
    public ResponseEntity<DxObjektiPoslednjeDto> save(@RequestBody DxObjektiPoslednjeDto dto) {
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
