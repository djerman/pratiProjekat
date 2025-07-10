package rs.prati.rest.controller;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import rs.prati.service.CjVoziloService;
import rs.prati.service.common.CrudService;
import rs.prati.service.dto.CjVoziloDto;

import java.util.List;

/**
 * REST контролер за CjVozilo – возила у систему.
 */
@RestController
@RequestMapping("/api/cj-vozila")
public class CjVoziloController extends AbstractCrudController<CjVoziloDto> {

    private final CjVoziloService service;

    public CjVoziloController(CjVoziloService service) {
        this.service = service;
    }

    /**
     * Враћа сва возила у систему.
     */
    @GetMapping
    @Operation(
        summary = "Сва возила",
        description = "Враћа све уносе из табеле cj_vozilo.",
        tags = {"CjVozilo"},
        operationId = "getAllCjVozilo"
    )
    @PreAuthorize("hasRole('ROLE_SISTEM') or hasRole('ROLE_ADMIN')")
    public ResponseEntity<List<CjVoziloDto>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    /**
     * Проналажење возила по ID-у.
     */
    @GetMapping("/{id}")
    @Operation(
        summary = "Возило по ID-у",
        description = "Враћа једно возило из табеле cj_vozilo по задатом ID-у.",
        tags = {"CjVozilo"},
        operationId = "getCjVoziloById"
    )
    @PreAuthorize("hasRole('ROLE_SISTEM') or hasRole('ROLE_ADMIN')")
    public ResponseEntity<CjVoziloDto> findById(@PathVariable Long id) {
        return service.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    /**
     * Чување (креирање/ажурирање) возила.
     */
    @PostMapping
    @Operation(
        summary = "Чување возила",
        description = "Креира или ажурира једно возило у табели cj_vozilo.",
        tags = {"CjVozilo"},
        operationId = "saveCjVozilo"
    )
    @PreAuthorize("hasRole('ROLE_SISTEM') or hasRole('ROLE_ADMIN')")
    public ResponseEntity<CjVoziloDto> save(@RequestBody CjVoziloDto dto) {
        return ResponseEntity.ok(service.save(dto));
    }

    /**
     * Тврдо брисање возила по ID-у.
     */
    @DeleteMapping("/{id}")
    @Operation(
        summary = "Тврдо брисање возила",
        description = "Тврдо (перманентно) брише возило из табеле cj_vozilo по ID-у.",
        tags = {"CjVozilo"},
        operationId = "deleteCjVozilo"
    )
    @PreAuthorize("hasRole('ROLE_SISTEM')")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.hardDelete(id);
        return ResponseEntity.noContent().build();
    }

    /**
     * Повезивање са CrudService-ом.
     */
    @Override
    protected CrudService<?, CjVoziloDto> getService() {
        return service;
    }
}
