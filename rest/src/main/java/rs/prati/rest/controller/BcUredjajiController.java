package rs.prati.rest.controller;

import io.swagger.v3.oas.annotations.Hidden;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import rs.prati.service.BcUredjajiService;
import rs.prati.service.common.CrudService;
import rs.prati.service.dto.BcUredjajiDto;

import java.util.List;

/**
 * REST контролер за уређаје.
 */
@RestController
@RequestMapping("/api/uredjaji")
@Hidden
public class BcUredjajiController extends AbstractCrudController<BcUredjajiDto> {

    private final BcUredjajiService service;

    public BcUredjajiController(BcUredjajiService service) {
        this.service = service;
    }

    @Override
    protected CrudService<?, BcUredjajiDto> getService() {
        return service;
    }

    @Override
    @GetMapping
    @PreAuthorize("hasRole('ROLE_SYSTEM')")
    /**
     * Враћа све уређаје (само системски корисник).
     */
    public ResponseEntity<List<BcUredjajiDto>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/not-deleted")
    @PreAuthorize("hasRole('ROLE_SYSTEM')")
    /**
     * Враћа све уређаје који нису означени као избрисани (само системски корисник).
     */
    public ResponseEntity<List<BcUredjajiDto>> findAllNotDeleted() {
        return ResponseEntity.ok(service.findAllNotDeleted());
    }

    @Override
    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_SYSTEM')")
    /**
     * Враћа уређај по идентификатору (систем и администратор).
     */
    public ResponseEntity<BcUredjajiDto> findById(@PathVariable Long id) {
        return getService().findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @Override
    @PostMapping
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_SYSTEM')")
    /**
     * Чува или ажурира уређај (систем и администратор).
     */
    public ResponseEntity<BcUredjajiDto> save(@RequestBody BcUredjajiDto dto) {
        return ResponseEntity.ok(getService().save(dto));
    }

    @Override
    @DeleteMapping("/soft/{id}")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_SYSTEM')")
    /**
     * Означава уређај као избрисан (софт брисање – систем и администратор).
     */
    public ResponseEntity<Void> oznaciIzbrisan(@PathVariable Long id) {
        getService().oznaciIzbrisan(id);
        return ResponseEntity.noContent().build();
    }

    @Override
    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_SYSTEM')")
    /**
     * Трајно брише уређај (само систем).
     */
    public ResponseEntity<Void> hardDelete(@PathVariable Long id) {
        getService().hardDelete(id);
        return ResponseEntity.noContent().build();
    }

    /**
     * Сви слободни уређаји у систему (само системски корисници).
     */
    @GetMapping("/slobodni")
    @PreAuthorize("hasRole('ROLE_SYSTEM')")
    public List<BcUredjajiDto> findAllSlobodni() {
        return service.findSviSlobodni();
    }

    /**
     * Слободни уређаји за датог претплатника (само администратори).
     */
    @GetMapping("/slobodni/pretplatnik/{pretplatnikId}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public List<BcUredjajiDto> findSlobodniZaPretplatnika(@PathVariable Long pretplatnikId) {
        return service.findSlobodniZaPretplatnika(pretplatnikId);
    }
}
