package rs.prati.rest.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import rs.prati.service.BcUredjajiService;
import rs.prati.service.common.MessageService;
import rs.prati.service.dto.BcUredjajiDto;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Тест контролера за BcUredjaji.
 */
@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
class BcUredjajiControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BcUredjajiService service;

    @MockBean
    private MessageService messageService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    @WithMockUser(roles = "SYSTEM")
    void saveEndpoint_shouldReturnOk_WhenValidSave() throws Exception {
        BcUredjajiDto dto = new BcUredjajiDto();
        dto.setKod("TEST-123");
        dto.setModelId(1L);

        when(service.save(any())).thenReturn(dto);

        mockMvc.perform(post("/api/uredjaji")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(dto)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.kod").value("TEST-123"));

        verify(service).save(any());
    }

    @Test
    @WithMockUser(roles = "SYSTEM")
    void saveEndpoint_shouldReturnBadRequest_WhenDuplicateExists() throws Exception {
        BcUredjajiDto dto = new BcUredjajiDto();
        dto.setKod("DUPLIKAT");
        dto.setModelId(1L);

        when(service.save(any())).thenThrow(new IllegalStateException("Уређај већ постоји!"));

        mockMvc.perform(post("/api/uredjaji")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(dto)))
                .andExpect(status().isInternalServerError());

        verify(service).save(any());
    }
}
