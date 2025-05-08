package rs.prati.rest.controller;

import io.swagger.v3.oas.annotations.Hidden;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import rs.prati.service.BgPartneriService;
import rs.prati.service.common.CrudService;
import rs.prati.service.dto.BgPartneriDto;

import java.util.List;

/**
 * REST контролер за партнера (BgPartneri) – скривен у Swagger-у.
 */
@RestController
@RequestMapping("/api/bg-partneri")
@Hidden
public class BgPartneriController extends AbstractCrudController<BgPartneriDto> {

    private final BgPartneriService service;

    public BgPartneriController(BgPartneriService service) {
        this.service = service;
    }

    /**
     * Враћа све партнере за датог претплатника који нису обрисани.
     * Приступ имају улоге: систем и администратор.
     */
    @GetMapping("/pretplatnik/{id}")
    @Operation(summary = "Сви партнери за претплатника")
    @PreAuthorize("hasRole('ROLE_SISTEM') or hasRole('ROLE_ADMIN')")
    public List<BgPartneriDto> findAllForPretplatnik(@PathVariable Long id) {
        return service.findAllForPretplatnik(id);
    }

    /**
     * Чување новог или постојећег партнера.
     */
    @PostMapping
    @Operation(summary = "Чување партнера")
    @PreAuthorize("hasRole('ROLE_SISTEM') or hasRole('ROLE_ADMIN')")
    public ResponseEntity<BgPartneriDto> save(@RequestBody BgPartneriDto dto) {
        return ResponseEntity.ok(service.save(dto));
    }

    /**
     * Тврдо брисање партнера по ID-у.
     */
    @DeleteMapping("/{id}")
    @Operation(summary = "Тврдо брисање партнера")
    @PreAuthorize("hasRole('ROLE_SISTEM')")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.hardDelete(id);
        return ResponseEntity.noContent().build();
    }

    /**
     * Меко брисање (означава као обрисаног).
     */
    @PatchMapping("/{id}/mark-deleted")
    @Operation(summary = "Меко брисање партнера")
    @PreAuthorize("hasRole('ROLE_SISTEM') or hasRole('ROLE_ADMIN')")
    public ResponseEntity<Void> markDeleted(@PathVariable Long id) {
        service.oznaciIzbrisan(id);
        return ResponseEntity.noContent().build();
    }

    /**
     * Враћа партнера по ID-у.
     */
    @GetMapping("/{id}")
    @Operation(summary = "Проналажење партнера по ID-у")
    @PreAuthorize("hasRole('ROLE_SISTEM') or hasRole('ROLE_ADMIN')")
    public ResponseEntity<BgPartneriDto> findById(@PathVariable Long id) {
        return service.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    /**
     * Враћа све партнере (сортиране по ID).
     */
    @GetMapping
    @Operation(summary = "Сви партнери")
    @PreAuthorize("hasRole('ROLE_SISTEM') or hasRole('ROLE_ADMIN')")
    public ResponseEntity<List<BgPartneriDto>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    /**
     * Повезивање контролера са CrudService-ом.
     */
    @Override
    protected CrudService<?, BgPartneriDto> getService() {
        return service;
    }
}
