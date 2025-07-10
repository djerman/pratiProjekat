package rs.prati.rest.controller;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import rs.prati.service.CiVozaciService;
import rs.prati.service.common.CrudService;
import rs.prati.service.dto.CiVozaciDto;

import java.util.List;

/**
 * REST контролер за CiVozaci – возачи у систему.
 */
@RestController
@RequestMapping("/api/ci-vozaci")
public class CiVozaciController extends AbstractCrudController<CiVozaciDto> {

    private final CiVozaciService service;

    public CiVozaciController(CiVozaciService service) {
        this.service = service;
    }

    /**
     * Враћа све возаче у систему.
     */
    @GetMapping
    @Operation(
        summary = "Сви возачи",
        description = "Враћа све возаче из табеле ci_vozaci.",
        tags = {"CiVozaci"},
        operationId = "getAllCiVozaci"
    )
    @PreAuthorize("hasRole('ROLE_SISTEM') or hasRole('ROLE_ADMIN')")
    public ResponseEntity<List<CiVozaciDto>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    /**
     * Проналажење возача по ID-у.
     */
    @GetMapping("/{id}")
    @Operation(
        summary = "Проналажење возача по ID-у",
        description = "Враћа једног возача из табеле ci_vozaci по задатом ID-у.",
        tags = {"CiVozaci"},
        operationId = "getCiVozacById"
    )
    @PreAuthorize("hasRole('ROLE_SISTEM') or hasRole('ROLE_ADMIN')")
    public ResponseEntity<CiVozaciDto> findById(@PathVariable Long id) {
        return service.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    /**
     * Чување (креирање/ажурирање) возача.
     */
    @PostMapping
    @Operation(
        summary = "Чување возача",
        description = "Креира или ажурира једног возача у табели ci_vozaci.",
        tags = {"CiVozaci"},
        operationId = "saveCiVozac"
    )
    @PreAuthorize("hasRole('ROLE_SISTEM') or hasRole('ROLE_ADMIN')")
    public ResponseEntity<CiVozaciDto> save(@RequestBody CiVozaciDto dto) {
        return ResponseEntity.ok(service.save(dto));
    }

    /**
     * Тврдо брисање возача по ID-у.
     */
    @DeleteMapping("/{id}")
    @Operation(
        summary = "Тврдо брисање возача",
        description = "Тврдо (перманентно) брише возача из табеле ci_vozaci по ID-у.",
        tags = {"CiVozaci"},
        operationId = "deleteCiVozac"
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
    protected CrudService<?, CiVozaciDto> getService() {
        return service;
    }
}
