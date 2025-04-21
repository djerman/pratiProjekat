package rs.prati.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import rs.prati.core.model.AaSistem;
import rs.prati.service.dto.AaSistemDto;
import rs.prati.service.mapper.AaSistemMapper;
import rs.prati.service.repository.AaSistemRepository;

@Service
public class AaSistemService {

    @Autowired
    private AaSistemRepository repository;

    @Autowired
    private AaSistemMapper mapper;

    public AaSistemDto get() {
        AaSistem entity = repository.findAll().stream().findFirst().orElse(null);
        return entity != null ? mapper.toDto(entity) : null;
    }

    @Transactional
    public AaSistemDto update(AaSistemDto dto) {
        AaSistem entity = repository.findAll().stream().findFirst().orElse(null);
        if (entity == null) {
            throw new IllegalStateException("Системски параметри нису иницијализовани у бази");
        }

        entity.setVlasnik(dto.getVlasnik());
        entity.setAdresaVlasnika(dto.getAdresaVlasnika());
        entity.setSajtVlasnika(dto.getSajtVlasnika());
        entity.setTelVlasnika(dto.getTelVlasnika());
        entity.setEmailVlasnika(dto.getEmailVlasnika());
        entity.setApi(dto.getApi());
        entity.setServerMape(dto.getServerMape());
        entity.setAdresaServeraMape(dto.getAdresaServeraMape());
        entity.setNominatimAdresa(dto.getNominatimAdresa());
        entity.setEmailServer(dto.getEmailServer());
        entity.setEmailServerPort(dto.getEmailServerPort());
        entity.setEmailKorisnik(dto.getEmailKorisnik());
        entity.setEmailLozinka(dto.getEmailLozinka());

        return mapper.toDto(repository.save(entity));
    }
}