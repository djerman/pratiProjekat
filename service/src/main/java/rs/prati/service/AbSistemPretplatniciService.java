package rs.prati.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import rs.prati.core.model.AbSistemPretplatnici;
import rs.prati.service.dto.AbSistemPretplatniciDto;
import rs.prati.service.mapper.AbSistemPretplatniciMapper;
import rs.prati.service.repository.AbSistemPretplatniciRepository;
import rs.prati.service.delete.PretplatnikCascadeDeleter;

import java.util.List;
import java.util.Optional;

/**
 * Сервисна класа за рад са системским претплатницима.
 * Подржава каскадно брисање свих ентитета повезаних са претплатником.
 */
@Service
public class AbSistemPretplatniciService {

    @Autowired
    private AbSistemPretplatniciRepository repository;

    @Autowired
    private AbSistemPretplatniciMapper mapper;

    @Autowired
    private List<PretplatnikCascadeDeleter> deleters;

    public List<AbSistemPretplatniciDto> findAll() {
        return repository.findAll().stream().map(mapper::toDto).toList();
    }

    public Optional<AbSistemPretplatniciDto> findById(Long id) {
        return repository.findById(id).map(mapper::toDto);
    }

    @Transactional
    public AbSistemPretplatniciDto save(AbSistemPretplatniciDto dto) {
        AbSistemPretplatnici entity = mapper.toEntity(dto);
        return mapper.toDto(repository.save(entity));
    }

    @Transactional
    public void oznaciIzbrisan(Long id) {
        repository.findById(id).ifPresent(entity -> {
            entity.oznaciIzbrisan();
            repository.save(entity);
        });
    }

    /**
     * Брише претплатника и све ентитете повезане са њим директно или индиректно.
     */
    @Transactional
    public void deleteById(Long id) {
        // 1. Покрени све сервисе који чисте податке по pretplatnikId
        for (PretplatnikCascadeDeleter deleter : deleters) {
            deleter.deleteAllByPretplatnikId(id);
        }

        // 2. Обриши самог претплатника
        repository.deleteById(id);
    }
}


