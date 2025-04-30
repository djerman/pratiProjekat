package rs.prati.rest.controller;

import io.swagger.v3.oas.annotations.Hidden;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import rs.prati.service.AfSistemOperateriService;
import rs.prati.service.common.CrudService;
import rs.prati.service.dto.AfSistemOperateriDto;

import java.util.List;

/**
 * REST контролер за системске оператере.
 * Приступ имају систем и администратор.
 */
@RestController
@RequestMapping("/api/sistem-operateri")
@Hidden
public class AfSistemOperateriController extends AbstractCrudController<AfSistemOperateriDto> {

    /** Сервис за управљање системским оператерима. */
    private final AfSistemOperateriService service;

    /**
     * Конструктор који прима сервис.
     *
     * @param service сервис за AfSistemOperateri
     */
    public AfSistemOperateriController(AfSistemOperateriService service) {
        this.service = service;
    }

    /**
     * Враћа CrudService за системске оператере.
     *
     * @return CrudService
     */
    @Override
    protected CrudService<?, AfSistemOperateriDto> getService() {
        return service;
    }

    /**
     * Враћа све системске оператере.
     *
     * @return листа оператера
     */
    @Override
    @GetMapping
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_SYSTEM')")
    public ResponseEntity<List<AfSistemOperateriDto>> findAll() {
        return ResponseEntity.ok(getService().findAll());
    }

    /**
     * Враћа системског оператера по ID-у.
     *
     * @param id идентификатор оператера
     * @return оператер ако постоји
     */
    @Override
    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_SYSTEM')")
    public ResponseEntity<AfSistemOperateriDto> findById(@PathVariable Long id) {
        return getService().findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    /**
     * Чува или ажурира системског оператера.
     *
     * @param dto DTO оператера
     * @return сачувани оператер
     */
    @Override
    @PostMapping
    @PreAuthorize("hasRole('ROLE_SYSTEM')")
    public ResponseEntity<AfSistemOperateriDto> save(@RequestBody AfSistemOperateriDto dto) {
        return ResponseEntity.ok(getService().save(dto));
    }

    /**
     * Логички брише системског оператера (soft delete).
     *
     * @param id идентификатор оператера
     * @return празан одговор ако је успешно
     */
    @Override
    @DeleteMapping("/soft/{id}")
    @PreAuthorize("hasRole('ROLE_SYSTEM')")
    public ResponseEntity<Void> oznaciIzbrisan(@PathVariable Long id) {
        getService().oznaciIzbrisan(id);
        return ResponseEntity.noContent().build();
    }

    /**
     * Потпуно брише системског оператера (hard delete).
     *
     * @param id идентификатор оператера
     * @return празан одговор ако је успешно
     */
    @Override
    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_SYSTEM')")
    public ResponseEntity<Void> hardDelete(@PathVariable Long id) {
        getService().hardDelete(id);
        return ResponseEntity.noContent().build();
    }
}
