package rs.prati.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import rs.prati.core.model.CaGrupeKorisnici;
import rs.prati.service.common.AbstractCrudService;
import rs.prati.service.dto.CaGrupeKorisniciDto;
import rs.prati.service.mapper.CaGrupeKorisniciMapper;
import rs.prati.service.mapper.EntityMapper;
import rs.prati.service.repository.CaGrupeKorisniciRepository;

import java.util.List;
import java.util.Optional;

/**
 * Сервис за обраду ентитета CaGrupeKorisnici.
 */
@Service
public class CaGrupeKorisniciService extends AbstractCrudService<CaGrupeKorisnici, CaGrupeKorisniciDto> {

    private final CaGrupeKorisniciRepository repository;
    private final CaGrupeKorisniciMapper mapper;

    public CaGrupeKorisniciService(CaGrupeKorisniciRepository repository, CaGrupeKorisniciMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    protected JpaRepository<CaGrupeKorisnici, Long> getRepository() {
        return repository;
    }

    @Override
    protected EntityMapper<CaGrupeKorisnici, CaGrupeKorisniciDto> getMapper() {
        return mapper;
    }

    /**
     * Чува нову или постојећу везу групе и корисника.
     */
    @Transactional
    public CaGrupeKorisniciDto save(CaGrupeKorisniciDto dto) {
        return super.save(dto);
    }

    /**
     * Тврдо брисање записа по ID-у.
     */
    @Transactional
    public void hardDelete(Long id) {
        repository.deleteById(id);
    }

    /**
     * Меко брисање (означава као обрисано).
     */
    @Transactional
    public void oznaciIzbrisan(Long id) {
        repository.findById(id).ifPresent(entity -> {
            entity.setIzbrisan(true);
            repository.save(entity);
        });
    }

    /**
     * Проналажење записа по ID-у.
     */
    @Transactional(readOnly = true)
    public Optional<CaGrupeKorisniciDto> findById(Long id) {
        return super.findById(id);
    }

    /**
     * Враћа све активне везе.
     */
    @Transactional(readOnly = true)
    public List<CaGrupeKorisniciDto> findAll() {
        return super.findAll();
    }

    /**
     * Враћа све активне везе за одређеног претплатника.
     */
    @Transactional(readOnly = true)
    public List<CaGrupeKorisniciDto> findAllForPretplatnik(Long pretplatnikId) {
        return repository.findByPretplatnik_IdAndIzbrisanFalseOrderByIdDesc().stream()
                .map(mapper::toDto)
                .toList();
    }
}
