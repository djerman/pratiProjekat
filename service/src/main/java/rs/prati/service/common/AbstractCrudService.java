package rs.prati.service.common;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import rs.prati.core.model.BaseEntity;

import java.util.List;
import java.util.Optional;

/**
 * Апстрактна имплементација CrudService интерфејса.
 * Обезбеђује основне CRUD операције за ентитете који наслеђују BaseEntity.
 */
@Transactional
public abstract class AbstractCrudService<T extends BaseEntity, D> implements CrudService<T, D> {

    protected abstract JpaRepository<T, Long> getRepository();

    protected abstract rs.prati.service.mapper.EntityMapper<T, D> getMapper();

    @Override
    public D save(D dto) {
        T entity = getMapper().toEntity(dto);
        return getMapper().toDto(getRepository().save(entity));
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<D> findById(Long id) {
        return getRepository().findById(id).map(getMapper()::toDto);
    }

    @Override
    @Transactional(readOnly = true)
    public List<D> findAll() {
        return getRepository().findAll()
                .stream()
                .sorted((a, b) -> b.getId().compareTo(a.getId()))
                .map(getMapper()::toDto)
                .toList();
    }

    @Override
    public void oznaciIzbrisan(Long id) {
        getRepository().findById(id).ifPresent(entity -> {
            entity.oznaciIzbrisan();
            getRepository().save(entity);
        });
    }

    @Override
    public void hardDelete(Long id) {
        getRepository().deleteById(id);
    }
}
