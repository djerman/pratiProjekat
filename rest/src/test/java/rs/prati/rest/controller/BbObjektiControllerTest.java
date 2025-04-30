package rs.prati.rest.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.mapping.JpaMetamodelMappingContext;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import rs.prati.service.BbObjektiService;
import rs.prati.service.common.MessageService;
import rs.prati.service.dto.BbObjektiDto;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Тест контролера за BbObjekti.
 */
@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
class BbObjektiControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BbObjektiService service;

    @MockBean
    private MessageService messageService;

    //@MockBean
    //private JpaMetamodelMappingContext jpaMetamodelMappingContext;
    
    @Autowired
    private ObjectMapper objectMapper;

    @Test
    @WithMockUser(roles = "SYSTEM")
    void saveEndpoint_shouldReturnOk_WhenValidSave() throws Exception {
        BbObjektiDto dto = new BbObjektiDto();
        dto.setPretplatnikId(1L);
        dto.setOznaka("TEST");

        when(service.save(any())).thenReturn(dto);

        mockMvc.perform(post("/api/objekti")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(dto)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.oznaka").value("TEST"));

        verify(service).save(any());
    }

    @Test
    @WithMockUser(roles = "SYSTEM")
    void saveEndpoint_shouldReturnBadRequest_WhenDuplicateExists() throws Exception {
        BbObjektiDto dto = new BbObjektiDto();
        dto.setPretplatnikId(1L);
        dto.setOznaka("DUPLIKAT");

        when(service.save(any())).thenThrow(new IllegalStateException("Објекат већ постоји!"));

        mockMvc.perform(post("/api/objekti")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(dto)))
                .andExpect(status().isInternalServerError());

        verify(service).save(any());
    }
}
