package rs.prati.rest.controller;

import io.swagger.v3.oas.annotations.Hidden;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import rs.prati.service.BdSimService;
import rs.prati.service.common.CrudService;
import rs.prati.service.dto.BdSimDto;

import java.util.List;

/**
 * REST контролер за СИМ картице.
 * Приступ имају систем и администратор.
 */
@RestController
@RequestMapping("/api/bd-sim")
@Hidden
public class BdSimController extends AbstractCrudController<BdSimDto> {

    // У сервису се мора додати метода findAllForPretplatnik(Long pretplatnikId)
    // која враћа све активне и неизбрисане сим картице за дати претплатник ID.

    private final BdSimService service;

    public BdSimController(BdSimService service) {
        this.service = service;
    }

    @Override
    protected CrudService<?, BdSimDto> getService() {
        return service;
    }

    @Override
    @GetMapping
    @PreAuthorize("hasRole('ROLE_SYSTEM')")
    public ResponseEntity<List<BdSimDto>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    /**
     * Све СИМ картице за претплатника (само за администратора).
     */
    @GetMapping("/pretplatnik/{pretplatnikId}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<List<BdSimDto>> findAllForPretplatnik(@PathVariable Long pretplatnikId) {
        return ResponseEntity.ok(service.findAllForPretplatnik(pretplatnikId));
    }

    @Override
    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_SYSTEM')")
    public ResponseEntity<BdSimDto> findById(@PathVariable Long id) {
        return getService().findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @Override
    @PostMapping
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_SYSTEM')")
    public ResponseEntity<BdSimDto> save(@RequestBody BdSimDto dto) {
        return ResponseEntity.ok(getService().save(dto));
    }

    @Override
    @DeleteMapping("/soft/{id}")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_SYSTEM')")
    public ResponseEntity<Void> oznaciIzbrisan(@PathVariable Long id) {
        getService().oznaciIzbrisan(id);
        return ResponseEntity.noContent().build();
    }

    @Override
    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_SYSTEM')")
    public ResponseEntity<Void> hardDelete(@PathVariable Long id) {
        getService().hardDelete(id);
        return ResponseEntity.noContent().build();
    }

    /**
     * Сви слободни СИМ-ови у систему (само системски корисници).
     */
    @GetMapping("/slobodni")
    @PreAuthorize("hasRole('ROLE_SYSTEM')")
    public List<BdSimDto> findAllSlobodni() {
        return service.findSviSlobodni();
    }

    /**
     * Слободни СИМ-ови за датог претплатника (само администратори).
     */
    @GetMapping("/slobodni/pretplatnik/{pretplatnikId}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public List<BdSimDto> findSlobodniZaPretplatnika(@PathVariable Long pretplatnikId) {
        return service.findSlobodniZaPretplatnika(pretplatnikId);
    }
}
