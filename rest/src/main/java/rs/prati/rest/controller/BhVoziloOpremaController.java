package rs.prati.rest.controller;

import io.swagger.v3.oas.annotations.Hidden;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import rs.prati.service.BhVoziloOpremaService;
import rs.prati.service.common.CrudService;
import rs.prati.service.dto.BhVoziloOpremaDto;

import java.util.List;

/**
 * REST контролер за BhVoziloOprema – опрема возила, скривен у Swagger-у.
 */
@RestController
@RequestMapping("/api/bh-vozilo-oprema")
@Hidden
public class BhVoziloOpremaController extends AbstractCrudController<BhVoziloOpremaDto> {

    private final BhVoziloOpremaService service;

    public BhVoziloOpremaController(BhVoziloOpremaService service) {
        this.service = service;
    }

    /**
     * Враћа сву опрему за датог претплатника.
     */
    @GetMapping("/pretplatnik/{id}")
    @Operation(summary = "Сва опрема за претплатника")
    @PreAuthorize("hasRole('ROLE_SISTEM') or hasRole('ROLE_ADMIN')")
    public List<BhVoziloOpremaDto> findAllForPretplatnik(@PathVariable Long id) {
        return service.findAllForPretplatnik(id);
    }

    /**
     * Чување нове или постојеће опреме.
     */
    @PostMapping
    @Operation(summary = "Чување опреме")
    @PreAuthorize("hasRole('ROLE_SISTEM') or hasRole('ROLE_ADMIN')")
    public ResponseEntity<BhVoziloOpremaDto> save(@RequestBody BhVoziloOpremaDto dto) {
        return ResponseEntity.ok(service.save(dto));
    }

    /**
     * Тврдо брисање опреме по ID-у.
     */
    @DeleteMapping("/{id}")
    @Operation(summary = "Тврдо брисање опреме")
    @PreAuthorize("hasRole('ROLE_SISTEM')")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.hardDelete(id);
        return ResponseEntity.noContent().build();
    }

    /**
     * Меко брисање (означава као обрисану).
     */
    @PatchMapping("/{id}/mark-deleted")
    @Operation(summary = "Меко брисање опреме")
    @PreAuthorize("hasRole('ROLE_SISTEM') or hasRole('ROLE_ADMIN')")
    public ResponseEntity<Void> markDeleted(@PathVariable Long id) {
        service.oznaciIzbrisan(id);
        return ResponseEntity.noContent().build();
    }

    /**
     * Проналажење опреме по ID-у.
     */
    @GetMapping("/{id}")
    @Operation(summary = "Проналажење опреме по ID-у")
    @PreAuthorize("hasRole('ROLE_SISTEM') or hasRole('ROLE_ADMIN')")
    public ResponseEntity<BhVoziloOpremaDto> findById(@PathVariable Long id) {
        return service.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    /**
     * Враћа сву опрему (сортирану).
     */
    @GetMapping
    @Operation(summary = "Сва опрема")
    @PreAuthorize("hasRole('ROLE_SISTEM') or hasRole('ROLE_ADMIN')")
    public ResponseEntity<List<BhVoziloOpremaDto>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    /**
     * Повезивање контролера са сервисом.
     */
    @Override
    protected CrudService<?, BhVoziloOpremaDto> getService() {
        return service;
    }
}
