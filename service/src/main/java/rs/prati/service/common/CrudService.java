package rs.prati.service.common;

import java.util.List;
import java.util.Optional;

/**
 * Заједнички CRUD сервис интерфејс за све ентитете и DTO-ове.
 */
public interface CrudService<T, D> {

    /** Чува или ажурира ентитет. */
    D save(D dto);

    /** Проналази ентитет по ID-у. */
    Optional<D> findById(Long id);

    /** Враћа све ентитете сортиране опадајуће по ID-у. */
    List<D> findAll();

    /** Логички брише ентитет (soft delete). */
    void oznaciIzbrisan(Long id);

    /** Потпуно брише ентитет (hard delete). */
    void hardDelete(Long id);
}
