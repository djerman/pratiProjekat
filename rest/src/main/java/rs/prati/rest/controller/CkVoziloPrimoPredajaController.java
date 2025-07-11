package rs.prati.rest.controller;

import io.swagger.v3.oas.annotations.Hidden;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import rs.prati.service.CkVoziloPrimoPredajaService;
import rs.prati.service.common.CrudService;
import rs.prati.service.dto.CkVoziloPrimoPredajaDto;

import java.util.List;

/**
 * REST контролер за CkVoziloPrimoPredaja – примопредаје возила.
 */
@RestController
@RequestMapping("/api/ck-vozilo-primo-predaja")
@Hidden
public class CkVoziloPrimoPredajaController extends AbstractCrudController<CkVoziloPrimoPredajaDto> {

    private final CkVoziloPrimoPredajaService service;

    public CkVoziloPrimoPredajaController(CkVoziloPrimoPredajaService service) {
        this.service = service;
    }

    /**
     * Враћа све примопредаје за одређеног претплатника.
     */
    @GetMapping("/pretplatnik/{id}")
    @Operation(
        summary = "Све примопредаје за претплатника",
        description = "Враћа све активне (необрисане) примопредаје за дати ID претплатника.",
        tags = {"CkVoziloPrimoPredaja"},
        operationId = "getAllForPretplatnik"
    )
    @PreAuthorize("hasRole('ROLE_SISTEM') or hasRole('ROLE_ADMIN')")
    public List<CkVoziloPrimoPredajaDto> findAllForPretplatnik(@PathVariable Long id) {
        return service.findAllForPretplatnik(id);
    }

    /**
     * Чување нове или постојеће примопредаје.
     */
    @PostMapping
    @Operation(
        summary = "Чување примопредаје возила",
        description = "Чува нову или ажурира постојећу примопредају возила.",
        tags = {"CkVoziloPrimoPredaja"},
        operationId = "saveVoziloPrimoPredaja"
    )
    @PreAuthorize("hasRole('ROLE_SISTEM') or hasRole('ROLE_ADMIN')")
    public ResponseEntity<CkVoziloPrimoPredajaDto> save(@RequestBody CkVoziloPrimoPredajaDto dto) {
        return ResponseEntity.ok(service.save(dto));
    }

    /**
     * Тврдо брисање примопредаје по ID-у.
     */
    @DeleteMapping("/{id}")
    @Operation(
        summary = "Тврдо брисање примопредаје",
        description = "Потпуно брише примопредају по ID-у.",
        tags = {"CkVoziloPrimoPredaja"},
        operationId = "hardDeleteVoziloPrimoPredaja"
    )
    @PreAuthorize("hasRole('ROLE_SISTEM')")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.hardDelete(id);
        return ResponseEntity.noContent().build();
    }

    /**
     * Меко брисање (означава као обрисано).
     */
    @PatchMapping("/{id}/mark-deleted")
    @Operation(
        summary = "Меко брисање примопредаје",
        description = "Означава примопредају као обрисану, не брише је физички из базе.",
        tags = {"CkVoziloPrimoPredaja"},
        operationId = "softDeleteVoziloPrimoPredaja"
    )
    @PreAuthorize("hasRole('ROLE_SISTEM') or hasRole('ROLE_ADMIN')")
    public ResponseEntity<Void> markDeleted(@PathVariable Long id) {
        service.oznaciIzbrisan(id);
        return ResponseEntity.noContent().build();
    }

    /**
     * Проналажење примопредаје по ID-у.
     */
    @GetMapping("/{id}")
    @Operation(
        summary = "Проналажење по ID-у",
        description = "Враћа примопредају по ID-у ако постоји.",
        tags = {"CkVoziloPrimoPredaja"},
        operationId = "findVoziloPrimoPredajaById"
    )
    @PreAuthorize("hasRole('ROLE_SISTEM') or hasRole('ROLE_ADMIN')")
    public ResponseEntity<CkVoziloPrimoPredajaDto> findById(@PathVariable Long id) {
        return service.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    /**
     * Враћа све примопредаје (необрисане).
     */
    @GetMapping
    @Operation(
        summary = "Све примопредаје возила",
        description = "Враћа све необрисане примопредаје возила.",
        tags = {"CkVoziloPrimoPredaja"},
        operationId = "getAllVoziloPrimoPredaja"
    )
    @PreAuthorize("hasRole('ROLE_SISTEM') or hasRole('ROLE_ADMIN')")
    public ResponseEntity<List<CkVoziloPrimoPredajaDto>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    /**
     * Повезивање са CrudService-ом.
     */
    @Override
    protected CrudService<?, CkVoziloPrimoPredajaDto> getService() {
        return service;
    }
}
