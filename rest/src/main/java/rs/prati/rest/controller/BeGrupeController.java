package rs.prati.rest.controller;

import io.swagger.v3.oas.annotations.Hidden;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import rs.prati.service.BeGrupeService;
import rs.prati.service.common.CrudService;
import rs.prati.service.dto.BeGrupeDto;

import java.util.List;

@RestController
@RequestMapping("/api/grupe")
@Hidden
public class BeGrupeController extends AbstractCrudController<BeGrupeDto> {

    private final BeGrupeService service;

    public BeGrupeController(BeGrupeService service) {
        this.service = service;
    }

    @Override
    protected CrudService<?, BeGrupeDto> getService() {
        return service;
    }
    
    /**
     * Враћа све групе (само за системског корисника).
     */
    @Override
    @GetMapping
    @PreAuthorize("hasRole('ROLE_SYSTEM')")
    public ResponseEntity<List<BeGrupeDto>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    /**
     * Враћа групу по ID-у (систем и администратор).
     */
    @Override
    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('ROLE_SYSTEM', 'ROLE_ADMIN')")
    public ResponseEntity<BeGrupeDto> findById(@PathVariable Long id) {
        return getService().findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    /**
     * Чува или ажурира групу (систем и администратор).
     */
    @Override
    @PostMapping
    @PreAuthorize("hasAnyRole('ROLE_SYSTEM', 'ROLE_ADMIN')")
    public ResponseEntity<BeGrupeDto> save(@RequestBody BeGrupeDto dto) {
        return ResponseEntity.ok(getService().save(dto));
    }

    /**
     * Софт брисање групе (означава као избрисану).
     */
    @Override
    @DeleteMapping("/soft/{id}")
    @PreAuthorize("hasAnyRole('ROLE_SYSTEM', 'ROLE_ADMIN')")
    public ResponseEntity<Void> oznaciIzbrisan(@PathVariable Long id) {
        getService().oznaciIzbrisan(id);
        return ResponseEntity.noContent().build();
    }

    /**
     * Тврдо брисање групе (трајно уклањање).
     */
    @Override
    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_SYSTEM')")
    public ResponseEntity<Void> hardDelete(@PathVariable Long id) {
        getService().hardDelete(id);
        return ResponseEntity.noContent().build();
    }

    /**
     * Враћа све групе за датог претплатника (систем и администратор).
     */
    @GetMapping("/pretplatnik/{pretplatnikId}")
    @PreAuthorize("hasAnyRole('ROLE_SYSTEM', 'ROLE_ADMIN')")
    public ResponseEntity<List<BeGrupeDto>> findAllForPretplatnik(@PathVariable Long pretplatnikId) {
        return ResponseEntity.ok(service.findAllForPretplatnik(pretplatnikId));
    }

}
