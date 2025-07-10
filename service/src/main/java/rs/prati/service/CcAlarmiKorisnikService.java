package rs.prati.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import rs.prati.core.model.CcAlarmiKorisnik;
import rs.prati.service.common.AbstractCrudService;
import rs.prati.service.dto.CcAlarmiKorisnikDto;
import rs.prati.service.mapper.CcAlarmiKorisnikMapper;
import rs.prati.service.mapper.EntityMapper;
import rs.prati.service.repository.CcAlarmiKorisnikRepository;

import java.util.List;
import java.util.Optional;

/**
 * Сервис за обраду ентитета CcAlarmiKorisnik.
 */
@Service
public class CcAlarmiKorisnikService extends AbstractCrudService<CcAlarmiKorisnik, CcAlarmiKorisnikDto> {

    private final CcAlarmiKorisnikRepository repository;
    private final CcAlarmiKorisnikMapper mapper;

    public CcAlarmiKorisnikService(CcAlarmiKorisnikRepository repository, CcAlarmiKorisnikMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    protected JpaRepository<CcAlarmiKorisnik, Long> getRepository() {
        return repository;
    }

    @Override
    protected EntityMapper<CcAlarmiKorisnik, CcAlarmiKorisnikDto> getMapper() {
        return mapper;
    }

    /**
     * Чување нове или постојеће везе корисника и аларма.
     */
    @Transactional
    public CcAlarmiKorisnikDto save(CcAlarmiKorisnikDto dto) {
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
     * Меко брисање – означава као обрисано.
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
    public Optional<CcAlarmiKorisnikDto> findById(Long id) {
        return super.findById(id);
    }

    /**
     * Враћа све активне записе.
     */
    @Transactional(readOnly = true)
    public List<CcAlarmiKorisnikDto> findAll() {
        return super.findAll();
    }

    /**
     * Враћа све везе за одређеног претплатника.
     */
    @Transactional(readOnly = true)
    public List<CcAlarmiKorisnikDto> findAllForPretplatnik(Long pretplatnikId) {
        return repository.findByPretplatnik_IdAndIzbrisanFalseOrderByIdDesc().stream()
                .map(mapper::toDto)
                .toList();
    }
}
