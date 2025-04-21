package rs.prati.rest.controller;

import io.swagger.v3.oas.annotations.Hidden;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import rs.prati.service.AaSistemService;
import rs.prati.service.dto.AaSistemDto;

/**
 * Контролер за приступ системским параметрима – доступан искључиво системским корисницима
 */
@RestController
@RequestMapping("/api/sistem")
@Hidden
public class AaSistemController {

    @Autowired
    private AaSistemService service;

    /**
     *  Враћа тренутно сачуване системске параметре из базе
     * @return
     */
    @GetMapping
    @PreAuthorize("hasRole('ROLE_SYSTEM')")
    public ResponseEntity<AaSistemDto> get() {
        AaSistemDto dto = service.get();
        return dto != null ? ResponseEntity.ok(dto) : ResponseEntity.notFound().build();
    }

    /**
     *  Ажурира постојеће системске параметре – не дозвољава креирање нових записа
     * @param dto
     * @return
     */
    @PutMapping
    @PreAuthorize("hasRole('ROLE_SYSTEM')")
    public ResponseEntity<AaSistemDto> update(@Valid @RequestBody AaSistemDto dto) {
        return ResponseEntity.ok(service.update(dto));
    }
}
