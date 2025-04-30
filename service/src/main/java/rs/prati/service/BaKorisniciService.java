package rs.prati.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import rs.prati.core.model.BaKorisnici;
import rs.prati.service.common.AbstractCrudService;
import rs.prati.service.dto.BaKorisniciDto;
import rs.prati.service.mapper.BaKorisniciMapper;
import rs.prati.service.repository.BaKorisniciRepository;

import java.util.Optional;

/**
 * Сервис класа за управљање ентитетом BaKorisnici.
 * Наслеђује основне CRUD методе из AbstractCrudService.
 */
@Service
@Transactional
public class BaKorisniciService extends AbstractCrudService<BaKorisnici, BaKorisniciDto> {

    /** Репозиторијум за приступ ентитету BaKorisnici. */
    private final BaKorisniciRepository repository;

    /** MapStruct мапер за конверзију између ентитета и DTO-а. */
    private final BaKorisniciMapper mapper;

    /**
     * Конструктор који иницијализује репозиторијум и мапер.
     *
     * @param repository репозиторијум за BaKorisnici
     * @param mapper мапер за BaKorisnici
     */
    public BaKorisniciService(BaKorisniciRepository repository, BaKorisniciMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    /**
     * Враћа репозиторијум за BaKorisnici.
     *
     * @return репозиторијум
     */
    @Override
    protected BaKorisniciRepository getRepository() {
        return repository;
    }

    /**
     * Враћа мапер за BaKorisnici.
     *
     * @return мапер
     */
    @Override
    protected BaKorisniciMapper getMapper() {
        return mapper;
    }

    /**
     * Проналази корисника на основу емаил адресе.
     *
     * @param email емаил адреса корисника
     * @return опциони DTO корисника ако постоји
     */
    @Transactional(readOnly = true)
    public Optional<BaKorisniciDto> findByEmail(String email) {
        return repository.findByEmail(email)
                .map(mapper::toDto);
    }
}
