package rs.prati.rest.controller;

import io.swagger.v3.oas.annotations.Hidden;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import rs.prati.service.AaSistemService;
import rs.prati.service.dto.AaSistemDto;

/**
 * REST контролер за системске параметре (AaSistem).
 */
@RestController
@RequestMapping("/api/sistem")
@Hidden
public class AaSistemController {

    /** Сервис за системске параметре. */
    private final AaSistemService service;

    /**
     * Конструктор који прима сервис.
     *
     * @param service сервис за AaSistem
     */
    public AaSistemController(AaSistemService service) {
        this.service = service;
    }

    /**
     * Враћа тренутне системске параметре.
     *
     * @return системски параметри
     */
    @GetMapping
    @PreAuthorize("hasRole('ROLE_SYSTEM')")
    public ResponseEntity<AaSistemDto> get() {
        return ResponseEntity.ok(service.get());
    }

    /**
     * Ажурира системске параметре.
     *
     * @param dto нови подаци за системске параметре
     * @return ажурирани системски параметри
     */
    @PutMapping
    @PreAuthorize("hasRole('ROLE_SYSTEM')")
    public ResponseEntity<AaSistemDto> update(@RequestBody AaSistemDto dto) {
        return ResponseEntity.ok(service.update(dto));
    }
}
