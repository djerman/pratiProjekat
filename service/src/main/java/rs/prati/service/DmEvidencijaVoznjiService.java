package rs.prati.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import rs.prati.core.model.DmEvidencijaVoznji;
import rs.prati.service.common.AbstractCrudService;
import rs.prati.service.dto.DmEvidencijaVoznjiDto;
import rs.prati.service.mapper.DmEvidencijaVoznjiMapper;
import rs.prati.service.mapper.EntityMapper;
import rs.prati.service.repository.DmEvidencijaVoznjiRepository;

import java.util.List;
import java.util.Optional;

/**
 * Сервис за евиденцију вожњи.
 */
@Service
public class DmEvidencijaVoznjiService extends AbstractCrudService<DmEvidencijaVoznji, DmEvidencijaVoznjiDto> {

    private final DmEvidencijaVoznjiRepository repository;
    private final DmEvidencijaVoznjiMapper mapper;

    public DmEvidencijaVoznjiService(DmEvidencijaVoznjiRepository repository, DmEvidencijaVoznjiMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    protected JpaRepository<DmEvidencijaVoznji, Long> getRepository() {
        return repository;
    }

    @Override
    protected EntityMapper<DmEvidencijaVoznji, DmEvidencijaVoznjiDto> getMapper() {
        return mapper;
    }

    /**
     * Чување или ажурирање евиденције вожње.
     */
    @Transactional
    public DmEvidencijaVoznjiDto save(DmEvidencijaVoznjiDto dto) {
        return super.save(dto);
    }

    /**
     * Тврдо брисање по ID.
     */
    @Transactional
    public void hardDelete(Long id) {
        repository.deleteById(id);
    }

    /**
     * Проналажење по ID.
     */
    @Transactional(readOnly = true)
    public Optional<DmEvidencijaVoznjiDto> findById(Long id) {
        return super.findById(id);
    }

    /**
     * Враћа све евиденције за датог претплатника.
     */
    @Transactional(readOnly = true)
    public List<DmEvidencijaVoznjiDto> findAllForPretplatnik(Long pretplatnikId) {
        return repository.findByPretplatnikIdAndZakljucanFalseOrderByIdDesc(pretplatnikId)
                .stream()
                .map(mapper::toDto)
                .toList();
    }

    /**
     * Враћа све евиденције за дату организацију.
     */
    @Transactional(readOnly = true)
    public List<DmEvidencijaVoznjiDto> findAllForOrganizacija(Long organizacijaId) {
        return repository.findByOrganizacijaIdAndZakljucanFalseOrderByIdDesc(organizacijaId)
                .stream()
                .map(mapper::toDto)
                .toList();
    }
}
