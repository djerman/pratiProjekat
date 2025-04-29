package rs.prati.service.mapper;

/**
 * Заједнички интерфејс који сваки MapStruct мапер треба да имплементира.
 * Омогућава конзистентан рад са ентитетима и DTO објектима.
 *
 * @param <T> тип ентитета
 * @param <D> тип DTO објекта
 */
public interface EntityMapper<T, D> {

    /**
     * Конвертује ентитет у DTO објекат.
     *
     * @param entity ентитет
     * @return DTO
     */
    D toDto(T entity);

    /**
     * Конвертује DTO у ентитет.
     *
     * @param dto DTO објекат
     * @return ентитет
     */
    T toEntity(D dto);
}
