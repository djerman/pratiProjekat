package rs.prati.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import rs.prati.core.model.DzSistemObracuni;
import rs.prati.service.common.AbstractCrudService;
import rs.prati.service.dto.DzSistemObracuniDto;
import rs.prati.service.mapper.DzSistemObracuniMapper;
import rs.prati.service.mapper.EntityMapper;
import rs.prati.service.repository.DzSistemObracuniRepository;

import java.util.List;
import java.util.Optional;

/**
 * Сервис за обраду ентитета DzSistemObracuni (системски обрачуни за објекте).
 */
@Service
public class DzSistemObracuniService extends AbstractCrudService<DzSistemObracuni, DzSistemObracuniDto> {

    private final DzSistemObracuniRepository repository;
    private final DzSistemObracuniMapper mapper;

    public DzSistemObracuniService(DzSistemObracuniRepository repository, DzSistemObracuniMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    protected JpaRepository<DzSistemObracuni, Long> getRepository() {
        return repository;
    }

    @Override
    protected EntityMapper<DzSistemObracuni, DzSistemObracuniDto> getMapper() {
        return mapper;
    }

    /**
     * Чување или ажурирање обрачуна.
     */
    @Transactional
    public DzSistemObracuniDto save(DzSistemObracuniDto dto) {
        return super.save(dto);
    }

    /**
     * Проналажење по ID.
     */
    @Transactional(readOnly = true)
    public Optional<DzSistemObracuniDto> findById(Long id) {
        return super.findById(id);
    }

    /**
     * Враћа све обрачуне за дати објекат (сортирано по датуму опадајуће).
     */
    @Transactional(readOnly = true)
    public List<DzSistemObracuniDto> findAllForObjekat(Long objekatId) {
        return repository.findByObjekat_IdOrderByDatumDesc(objekatId)
                .stream()
                .map(mapper::toDto)
                .toList();
    }

    /**
     * Враћа све обрачуне за дати датум (сортирано по објекту).
     */
    @Transactional(readOnly = true)
    public List<DzSistemObracuniDto> findAllForDatum(Long datum) {
        return repository.findByDatumOrderByObjekat_Id(datum)
                .stream()
                .map(mapper::toDto)
                .toList();
    }
}
