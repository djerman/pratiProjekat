package rs.prati.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import rs.prati.core.model.CkVoziloPrimoPredaja;
import rs.prati.service.common.AbstractCrudService;
import rs.prati.service.dto.CkVoziloPrimoPredajaDto;
import rs.prati.service.mapper.CkVoziloPrimoPredajaMapper;
import rs.prati.service.mapper.EntityMapper;
import rs.prati.service.repository.CkVoziloPrimoPredajaRepository;

import java.util.List;
import java.util.Optional;

/**
 * Сервис за обраду ентитета CkVoziloPrimoPredaja.
 */
@Service
public class CkVoziloPrimoPredajaService extends AbstractCrudService<CkVoziloPrimoPredaja, CkVoziloPrimoPredajaDto> {

    private final CkVoziloPrimoPredajaRepository repository;
    private final CkVoziloPrimoPredajaMapper mapper;

    public CkVoziloPrimoPredajaService(
            CkVoziloPrimoPredajaRepository repository,
            CkVoziloPrimoPredajaMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    protected JpaRepository<CkVoziloPrimoPredaja, Long> getRepository() {
        return repository;
    }

    @Override
    protected EntityMapper<CkVoziloPrimoPredaja, CkVoziloPrimoPredajaDto> getMapper() {
        return mapper;
    }

    /**
     * Чување нове или постојеће примопредаје.
     */
    @Transactional
    public CkVoziloPrimoPredajaDto save(CkVoziloPrimoPredajaDto dto) {
        return super.save(dto);
    }

    /**
     * Тврдо брисање по ID-у.
     */
    @Transactional
    public void hardDelete(Long id) {
        repository.deleteById(id);
    }

    /**
     * Меко брисање — означава запис као обрисан.
     */
    @Transactional
    public void oznaciIzbrisan(Long id) {
        repository.findById(id).ifPresent(entity -> {
            entity.setIzbrisan(true);
            repository.save(entity);
        });
    }

    /**
     * Проналажење по ID-у.
     */
    @Transactional(readOnly = true)
    public Optional<CkVoziloPrimoPredajaDto> findById(Long id) {
        return super.findById(id);
    }

    /**
     * Враћа све необрисане примопредаје.
     */
    @Transactional(readOnly = true)
    public List<CkVoziloPrimoPredajaDto> findAll() {
        return super.findAll();
    }

    /**
     * Враћа све примопредаје за задатог претплатника.
     */
    @Transactional(readOnly = true)
    public List<CkVoziloPrimoPredajaDto> findAllForPretplatnik(Long pretplatnikId) {
        return repository.findByPretplatnikIdAndIzbrisanFalseOrderByIdDesc(pretplatnikId).stream()
                .map(mapper::toDto)
                .toList();
    }
}
