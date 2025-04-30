package rs.prati.rest.controller;

import io.swagger.v3.oas.annotations.Hidden;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import rs.prati.service.BaKorisniciService;
import rs.prati.service.common.CrudService;
import rs.prati.service.dto.BaKorisniciDto;

import java.util.List;

/**
 * REST контролер за кориснике.
 * Приступ имају систем и администратор.
 */
@RestController
@RequestMapping("/api/korisnici")
@Hidden
public class BaKorisniciController extends AbstractCrudController<BaKorisniciDto> {

    /** Сервис за управљање корисницима. */
    private final BaKorisniciService service;

    /**
     * Конструктор који прима сервис.
     *
     * @param service сервис за BaKorisnici
     */
    public BaKorisniciController(BaKorisniciService service) {
        this.service = service;
    }

    /**
     * Враћа CrudService за кориснике.
     *
     * @return CrudService
     */
    @Override
    protected CrudService<?, BaKorisniciDto> getService() {
        return service;
    }

    /**
     * Враћа све кориснике.
     *
     * @return листа корисника
     */
    @Override
    @GetMapping
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_SYSTEM')")
    public ResponseEntity<List<BaKorisniciDto>> findAll() {
        return ResponseEntity.ok(getService().findAll());
    }

    /**
     * Враћа корисника по ID-у.
     *
     * @param id идентификатор корисника
     * @return корисник ако постоји
     */
    @Override
    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_SYSTEM')")
    public ResponseEntity<BaKorisniciDto> findById(@PathVariable Long id) {
        return getService().findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    /**
     * Чува или ажурира корисника.
     *
     * @param dto DTO корисника
     * @return сачувани корисник
     */
    @Override
    @PostMapping
    @PreAuthorize("hasRole('ROLE_SYSTEM')")
    public ResponseEntity<BaKorisniciDto> save(@RequestBody BaKorisniciDto dto) {
        return ResponseEntity.ok(getService().save(dto));
    }

    /**
     * Логички брише корисника (soft delete).
     *
     * @param id идентификатор корисника
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
     * Потпуно брише корисника (hard delete).
     *
     * @param id идентификатор корисника
     * @return празан одговор ако је успешно
     */
    @Override
    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_SYSTEM')")
    public ResponseEntity<Void> hardDelete(@PathVariable Long id) {
        getService().hardDelete(id);
        return ResponseEntity.noContent().build();
    }

    /**
     * Проналази корисника на основу емаил адресе.
     *
     * @param email емаил адреса
     * @return корисник ако постоји
     */
    @GetMapping("/find-by-email")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_SYSTEM')")
    public ResponseEntity<BaKorisniciDto> findByEmail(@RequestParam String email) {
        return service.findByEmail(email)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
