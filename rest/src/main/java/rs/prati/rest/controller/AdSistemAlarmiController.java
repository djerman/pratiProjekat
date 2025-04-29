package rs.prati.rest.controller;

import io.swagger.v3.oas.annotations.Hidden;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import rs.prati.service.AdSistemAlarmiService;
import rs.prati.service.common.CrudService;
import rs.prati.service.dto.AdSistemAlarmiDto;

import java.util.List;

/**
 * REST контролер за системске аларме.
 * Приступ имају само систем корисници.
 */
@RestController
@RequestMapping("/api/alarms")
@Hidden
public class AdSistemAlarmiController extends AbstractCrudController<AdSistemAlarmiDto> {

    /** Сервис за управљање алармима. */
    private final AdSistemAlarmiService service;

    /**
     * Конструктор који прима сервис.
     *
     * @param service сервис за аларме
     */
    public AdSistemAlarmiController(AdSistemAlarmiService service) {
        this.service = service;
    }

    /**
     * Враћа CrudService за рад са алармима.
     *
     * @return CrudService
     */
    @Override
    protected CrudService<?, AdSistemAlarmiDto> getService() {
        return service;
    }

    /**
     * Враћа све аларме.
     *
     * @return листа аларма
     */
    @Override
    @GetMapping
    @PreAuthorize("hasRole('ROLE_SYSTEM')")
    public ResponseEntity<List<AdSistemAlarmiDto>> findAll() {
        return ResponseEntity.ok(getService().findAll());
    }

    /**
     * Враћа аларм по ID-у.
     *
     * @param id идентификатор аларма
     * @return аларм ако постоји
     */
    @Override
    @GetMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_SYSTEM')")
    public ResponseEntity<AdSistemAlarmiDto> findById(@PathVariable Long id) {
        return getService().findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    /**
     * Чува или ажурира аларм.
     *
     * @param dto DTO аларма
     * @return сачуван аларм
     */
    @Override
    @PostMapping
    @PreAuthorize("hasRole('ROLE_SYSTEM')")
    public ResponseEntity<AdSistemAlarmiDto> save(@RequestBody AdSistemAlarmiDto dto) {
        return ResponseEntity.ok(getService().save(dto));
    }

    /**
     * Логички брише аларм (soft delete).
     *
     * @param id идентификатор аларма
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
     * Потпуно брише аларм (hard delete).
     *
     * @param id идентификатор аларма
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
