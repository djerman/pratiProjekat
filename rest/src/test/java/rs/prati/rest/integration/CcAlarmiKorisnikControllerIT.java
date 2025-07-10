package rs.prati.rest.integration;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import rs.prati.rest.controller.CcAlarmiKorisnikController;
import rs.prati.service.CcAlarmiKorisnikService;
import rs.prati.service.dto.CcAlarmiKorisnikDto;

import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Интеграциони тестови за CcAlarmiKorisnikController.
 */
@WebMvcTest(CcAlarmiKorisnikController.class)
class CcAlarmiKorisnikControllerIT {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CcAlarmiKorisnikService service;

    private CcAlarmiKorisnikDto dto;

    @BeforeEach
    void setUp() {
        dto = new CcAlarmiKorisnikDto();
        dto.setId(1L);
        dto.setEmail(true);
        dto.setObavestenje(true);
        dto.setAktivan(true);
    }

    @Test
    @WithMockUser(roles = {"SISTEM", "ADMIN"})
    void testFindById() throws Exception {
        when(service.findById(1L)).thenReturn(Optional.of(dto));

        mockMvc.perform(get("/api/cc-alarmi-korisnik/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1));
    }

    @Test
    @WithMockUser(roles = {"SISTEM", "ADMIN"})
    void testFindAll() throws Exception {
        when(service.findAll()).thenReturn(List.of(dto));

        mockMvc.perform(get("/api/cc-alarmi-korisnik"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value(1));
    }

    @Test
    @WithMockUser(roles = {"SISTEM", "ADMIN"})
    void testSave() throws Exception {
        when(service.save(any())).thenReturn(dto);

        mockMvc.perform(post("/api/cc-alarmi-korisnik")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"id\":1,\"email\":true,\"obavestenje\":true,\"aktivan\":true}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1));
    }

    @Test
    @WithMockUser(roles = {"SISTEM"})
    void testDelete() throws Exception {
        mockMvc.perform(delete("/api/cc-alarmi-korisnik/1"))
                .andExpect(status().isNoContent());
    }

    @Test
    @WithMockUser(roles = {"SISTEM", "ADMIN"})
    void testMarkDeleted() throws Exception {
        mockMvc.perform(patch("/api/cc-alarmi-korisnik/1/mark-deleted"))
                .andExpect(status().isNoContent());
    }
}
