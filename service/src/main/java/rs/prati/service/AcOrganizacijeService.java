package rs.prati.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import rs.prati.core.model.AcOrganizacije;
import rs.prati.service.delete.PretplatnikCascadeDeleter;
import rs.prati.service.dto.AcOrganizacijeDto;
import rs.prati.service.mapper.AcOrganizacijeMapper;
import rs.prati.service.repository.AcOrganizacijeRepository;

import java.util.List;
import java.util.Optional;

/**
 * Сервисна логика за ентитет AcOrganizacije. Обрађује захтеве из контролера и сарађује са репозиторијумом.
 */
@Service
public class AcOrganizacijeService implements PretplatnikCascadeDeleter {

    @Autowired
    private AcOrganizacijeRepository repository;

    @Autowired
    private AcOrganizacijeMapper mapper;

    /**
     * Враћа све организације, сортиране по ID у опадајућем редоследу.
     */
    public List<AcOrganizacijeDto> findAll() {
        return repository.findAll(Sort.by(Sort.Direction.DESC, "id"))
                .stream()
                .map(mapper::toDto)
                .toList();
    }

    /**
     * Проналази организацију по ID.
     * @param id
     * @return
     */
    public Optional<AcOrganizacijeDto> findById(Long id) {
        return repository.findById(id).map(mapper::toDto);
    }

	/**
	 * Чува организацију у бази података или ажурира постојећу.
	 * @param id
	 * @return
	 */
    @Transactional
    public AcOrganizacijeDto save(AcOrganizacijeDto dto) {
        AcOrganizacije entity = mapper.toEntity(dto);
        return mapper.toDto(repository.save(entity));
    }

	/**
	 * Обележава организацију као обрисану у бази података.
	 * @param id
	 * @return
	 */
    @Transactional
    public void oznaciIzbrisan(Long id) {
        repository.findById(id).ifPresent(entity -> {
            entity.oznaciIzbrisan();
            repository.save(entity);
        });
    }

	/**
	 * Брише организацију из базе података.
	 * @param id
	 * @return
	 */
    @Transactional
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
    
    @Override
    @Transactional
    public void deleteAllByPretplatnikId(Long pretplatnikId) {
        List<AcOrganizacije> lista = repository.findByPretplatnikId(pretplatnikId);
        for (AcOrganizacije org : lista) {
            deleteById(org.getId());
        }
    }
}
