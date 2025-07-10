package rs.prati.rest.controller;

import io.swagger.v3.oas.annotations.Hidden;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import rs.prati.service.CcAlarmiKorisnikService;
import rs.prati.service.common.CrudService;
import rs.prati.service.dto.CcAlarmiKorisnikDto;

import java.util.List;

/**
 * REST контролер за CcAlarmiKorisnik – повезивање корисника са алармима.
 */
@RestController
@RequestMapping("/api/cc-alarmi-korisnik")
@Hidden
public class CcAlarmiKorisnikController extends AbstractCrudController<CcAlarmiKorisnikDto> {

    private final CcAlarmiKorisnikService service;

    public CcAlarmiKorisnikController(CcAlarmiKorisnikService service) {
        this.service = service;
    }

    /**
     * Враћа све везе за одређеног претплатника.
     */
    @GetMapping("/pretplatnik/{id}")
    @Operation(summary = "Све везе за претплатника", description = "Враћа све активне везе између корисника и аларма за дати ID претплатника.")
    @PreAuthorize("hasRole('ROLE_SISTEM') or hasRole('ROLE_ADMIN')")
    public List<CcAlarmiKorisnikDto> findAllForPretplatnik(@PathVariable Long id) {
        return service.findAllForPretplatnik(id);
    }

    /**
     * Чување нове или постојеће везе.
     */
    @PostMapping
    @Operation(summary = "Чување везе", description = "Креирање или измена повезаности корисника са алармом.")
    @PreAuthorize("hasRole('ROLE_SISTEM') or hasRole('ROLE_ADMIN')")
    public ResponseEntity<CcAlarmiKorisnikDto> save(@RequestBody CcAlarmiKorisnikDto dto) {
        return ResponseEntity.ok(service.save(dto));
    }

    /**
     * Тврдо брисање везе по ID-у.
     */
    @DeleteMapping("/{id}")
    @Operation(summary = "Тврдо брисање", description = "Трајно уклањање везе по задатом ID-у.")
    @PreAuthorize("hasRole('ROLE_SISTEM')")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.hardDelete(id);
        return ResponseEntity.noContent().build();
    }

    /**
     * Меко брисање (означава као обрисано).
     */
    @PatchMapping("/{id}/mark-deleted")
    @Operation(summary = "Меко брисање", description = "Означава везу као обрисану без физичког брисања из базе.")
    @PreAuthorize("hasRole('ROLE_SISTEM') or hasRole('ROLE_ADMIN')")
    public ResponseEntity<Void> markDeleted(@PathVariable Long id) {
        service.oznaciIzbrisan(id);
        return ResponseEntity.noContent().build();
    }

    /**
     * Проналажење везе по ID-у.
     */
    @GetMapping("/{id}")
    @Operation(summary = "Проналажење по ID-у", description = "Враћа податке о вези на основу њеног јединственог ID-а.")
    @PreAuthorize("hasRole('ROLE_SISTEM') or hasRole('ROLE_ADMIN')")
    public ResponseEntity<CcAlarmiKorisnikDto> findById(@PathVariable Long id) {
        return service.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    /**
     * Враћа све активне везе.
     */
    @GetMapping
    @Operation(summary = "Све везе", description = "Враћа све активне везе између корисника и аларма.", tags = {"CcAlarmiKorisnik"}, operationId = "getAllLinks")
    @PreAuthorize("hasRole('ROLE_SISTEM') or hasRole('ROLE_ADMIN')")
    public ResponseEntity<List<CcAlarmiKorisnikDto>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    /**
     * Повезивање са CrudService-ом.
     */
    @Override
    protected CrudService<?, CcAlarmiKorisnikDto> getService() {
        return service;
    }
}
