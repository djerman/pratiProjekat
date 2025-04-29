package rs.prati.rest.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rs.prati.service.common.CrudService;
import rs.prati.service.dto.BaseDto;

import java.util.List;

/**
 * Апстрактни контролер за основне CRUD операције над DTO објектима.
 * Параметар D представља тип DTO објекта који наслеђује BaseDto.
 */
public abstract class AbstractCrudController<D extends BaseDto> {

    /** Сервис који управља објектима. */
    protected abstract CrudService<?, D> getService();

    /**
     * Чување или ажурирање објекта.
     *
     * @param dto DTO објекат
     * @return сачувани DTO
     */
    @PostMapping
    public ResponseEntity<D> save(@RequestBody D dto) {
        return ResponseEntity.ok(getService().save(dto));
    }

    /**
     * Проналажење објекта по ID-у.
     *
     * @param id идентификатор објекта
     * @return DTO објекат ако постоји
     */
    @GetMapping("/{id}")
    public ResponseEntity<D> findById(@PathVariable Long id) {
        return getService().findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    /**
     * Проналажење свих објеката.
     *
     * @return листа DTO објеката
     */
    @GetMapping
    public ResponseEntity<List<D>> findAll() {
        return ResponseEntity.ok(getService().findAll());
    }

    /**
     * Логичко брисање објекта.
     *
     * @param id идентификатор објекта
     * @return без садржаја ако је успешно
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> oznaciIzbrisan(@PathVariable Long id) {
        getService().oznaciIzbrisan(id);
        return ResponseEntity.noContent().build();
    }

    /**
     * Потпуно брисање објекта.
     *
     * @param id идентификатор објекта
     * @return без садржаја ако је успешно
     */
    @DeleteMapping("/hard/{id}")
    public ResponseEntity<Void> hardDelete(@PathVariable Long id) {
        getService().hardDelete(id);
        return ResponseEntity.noContent().build();
    }
}

