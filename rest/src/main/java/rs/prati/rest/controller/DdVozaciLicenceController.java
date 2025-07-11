package rs.prati.rest.controller;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import rs.prati.service.DdVozaciLicenceService;
import rs.prati.service.common.CrudService;
import rs.prati.service.dto.DdVozaciLicenceDto;

import java.util.List;

/**
 * REST контролер за лиценце возача.
 */
@RestController
@RequestMapping("/api/dd-vozaci-licence")
public class DdVozaciLicenceController extends AbstractCrudController<DdVozaciLicenceDto> {

    private final DdVozaciLicenceService service;

    public DdVozaciLicenceController(DdVozaciLicenceService service) {
        this.service = service;
    }

    /**
     * Враћа све лиценце за датог корисника.
     */
    @GetMapping("/korisnik/{id}")
    @Operation(
        summary = "Све лиценце за корисника",
        description = "Враћа све необрисане лиценце за датог корисника по ID-у.",
        tags = {"DdVozaciLicence"},
        operationId = "getAllForKorisnik"
    )
    @PreAuthorize("hasRole('ROLE_SISTEM') or hasRole('ROLE_ADMIN')")
    public List<DdVozaciLicenceDto> findAllForKorisnik(@PathVariable Long id) {
        return service.findAllForKorisnik(id);
    }

    /**
     * Враћа све лиценце за датог претплатника.
     */
    @GetMapping("/pretplatnik/{id}")
    @Operation(
        summary = "Све лиценце за претплатника",
        description = "Враћа све необрисане лиценце за датог претплатника по ID-у.",
        tags = {"DdVozaciLicence"},
        operationId = "getAllForPretplatnik"
    )
    @PreAuthorize("hasRole('ROLE_SISTEM') or hasRole('ROLE_ADMIN')")
    public List<DdVozaciLicenceDto> findAllForPretplatnik(@PathVariable Long id) {
        return service.findAllForPretplatnik(id);
    }

    /**
     * Повезивање са CrudService-ом (апстрактни контролер).
     */
    @Override
    protected CrudService<?, DdVozaciLicenceDto> getService() {
        return service;
    }
}
