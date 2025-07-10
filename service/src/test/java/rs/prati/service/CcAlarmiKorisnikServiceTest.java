package rs.prati.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import rs.prati.core.model.CcAlarmiKorisnik;
import rs.prati.service.dto.CcAlarmiKorisnikDto;
import rs.prati.service.mapper.CcAlarmiKorisnikMapper;
import rs.prati.service.repository.CcAlarmiKorisnikRepository;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

/**
 * Јединични тестови за CcAlarmiKorisnikService.
 */
class CcAlarmiKorisnikServiceTest {

    @Mock
    private CcAlarmiKorisnikRepository repository;

    @Mock
    private CcAlarmiKorisnikMapper mapper;

    @InjectMocks
    private CcAlarmiKorisnikService service;

    private CcAlarmiKorisnik entity;
    private CcAlarmiKorisnikDto dto;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        entity = new CcAlarmiKorisnik();
        entity.setId(1L);
        dto = new CcAlarmiKorisnikDto();
        dto.setId(1L);
    }

    @Test
    void testSave() {
        when(mapper.toEntity(dto)).thenReturn(entity);
        when(repository.save(entity)).thenReturn(entity);
        when(mapper.toDto(entity)).thenReturn(dto);

        CcAlarmiKorisnikDto result = service.save(dto);

        assertThat(result).isNotNull();
        assertThat(result.getId()).isEqualTo(1L);
    }

    @Test
    void testFindById() {
        when(repository.findById(1L)).thenReturn(Optional.of(entity));
        when(mapper.toDto(entity)).thenReturn(dto);

        Optional<CcAlarmiKorisnikDto> result = service.findById(1L);

        assertThat(result).isPresent();
        assertThat(result.get().getId()).isEqualTo(1L);
    }

    @Test
    void testFindAll() {
        when(repository.findByIzbrisanFalseOrderByIdDesc()).thenReturn(List.of(entity));
        when(mapper.toDto(entity)).thenReturn(dto);

        List<CcAlarmiKorisnikDto> result = service.findAll();

        assertThat(result).hasSize(1);
        assertThat(result.get(0).getId()).isEqualTo(1L);
    }

    @Test
    void testHardDelete() {
        service.hardDelete(1L);
        verify(repository, times(1)).deleteById(1L);
    }

    @Test
    void testOznaciIzbrisan() {
        entity.setIzbrisan(false);
        when(repository.findById(1L)).thenReturn(Optional.of(entity));

        service.oznaciIzbrisan(1L);

        assertThat(entity.getIzbrisan()).isTrue();
        verify(repository, times(1)).save(entity);
    }
}

