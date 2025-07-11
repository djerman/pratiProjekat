package rs.prati.rest.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import rs.prati.service.DzSistemObracuniService;
import rs.prati.service.dto.DzSistemObracuniDto;

import java.util.List;
import java.util.Optional;

/**
 * REST контролер за управљање системским обрачунима (DzSistemObracuni).
 */
@RestController
@RequestMapping("/api/dz-sistem-obracuni")
@Tag(name = "DzSistemObracuni", description = "Операције над системским обрачунима")
public class DzSistemObracuniController {

    private final DzSistemObracuniService service;

    public DzSistemObracuniController(DzSistemObracuniService service) {
        this.service = service;
    }

    @GetMapping("/objekat/{objekatId}")
    @Operation(
            summary = "Сви обрачуни за објекат",
            description = "Враћа све системске обрачуне за дати објекат, сортирано по датуму опадајуће."
    )
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_SISTEM')")
    public ResponseEntity<List<DzSistemObracuniDto>> getAllByObjekat(@PathVariable Long objekatId) {
        return ResponseEntity.ok(service.findAllForObjekat(objekatId));
    }

    @GetMapping("/datum/{datum}")
    @Operation(
            summary = "Сви обрачуни за датум",
            description = "Враћа све системске обрачуне за дати датум, сортирано по објекту."
    )
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_SISTEM')")
    public ResponseEntity<List<DzSistemObracuniDto>> getAllByDatum(@PathVariable Long datum) {
        return ResponseEntity.ok(service.findAllForDatum(datum));
    }

    @GetMapping("/{id}")
    @Operation(
            summary = "Један обрачун по ID-у",
            description = "Враћа системски обрачун по задатом идентификатору."
    )
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_SISTEM')")
    public ResponseEntity<DzSistemObracuniDto> getById(@PathVariable Long id) {
        Optional<DzSistemObracuniDto> dto = service.findById(id);
        return dto.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    @Operation(
            summary = "Креирај/ажурирај системски обрачун",
            description = "Креира нови или ажурира постојећи системски обрачун."
    )
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_SISTEM')")
    public ResponseEntity<DzSistemObracuniDto> save(@RequestBody DzSistemObracuniDto dto) {
        return ResponseEntity.ok(service.save(dto));
    }
}
