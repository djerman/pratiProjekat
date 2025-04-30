package rs.prati.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import rs.prati.core.model.BbObjekti;
import rs.prati.service.common.MessageService;
import rs.prati.service.dto.BbObjektiDto;
import rs.prati.service.mapper.BbObjektiMapper;
import rs.prati.service.repository.BbObjektiRepository;


import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

/**
 * Тест класа за BbObjektiService.
 */
class BbObjektiServiceTest {

    @Mock
    private BbObjektiRepository repository;

    @Mock
    private BbObjektiMapper mapper;

    @Mock
    private MessageService messageService;

    @InjectMocks
    private BbObjektiService service;

    private BbObjektiDto dto;
    private BbObjekti entity;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        dto = new BbObjektiDto();
        dto.setPretplatnikId(1L);
        dto.setOznaka("TEST");

        entity = new BbObjekti();
        entity.setPretplatnikId(1L);
        entity.setOznaka("TEST");
        entity.setId(10L);
    }

    @Test
    void save_shouldSaveObject_WhenNoDuplicateExists() {
        // Нема постојећег дупликата
        when(repository.findByPretplatnikIdAndOznakaAndIzbrisanFalse(1L, "TEST"))
                .thenReturn(Optional.empty());

        when(mapper.toEntity(dto)).thenReturn(entity);
        when(repository.save(entity)).thenReturn(entity);
        when(mapper.toDto(entity)).thenReturn(dto);

        BbObjektiDto saved = service.save(dto);

        // Очекујемо да се објекат успешно сачува
        assertNotNull(saved);
        verify(repository).save(entity);
    }

    @Test
    void save_shouldThrowException_WhenDuplicateExists() {
        // Већ постоји објекат са истом ознаком и претплатником
        when(repository.findByPretplatnikIdAndOznakaAndIzbrisanFalse(1L, "TEST"))
                .thenReturn(Optional.of(entity));

        when(messageService.getMessage("error.objekat.exists"))
                .thenReturn("Објекат већ постоји!");

        // Очекујемо да баци IllegalStateException
        IllegalStateException ex = assertThrows(IllegalStateException.class, () -> service.save(dto));
        assertEquals("Објекат већ постоји!", ex.getMessage());

        // Проверавамо да save није позван
        verify(repository, never()).save(any());
    }
}
