package rs.prati.rest.controller;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.MessageSource;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import rs.prati.core.model.AuthRefreshToken;
import rs.prati.core.model.BaKorisnici;
import rs.prati.rest.exception.RefreshTokenExpiredException;
import rs.prati.rest.exception.RefreshTokenInvalidException;
import rs.prati.service.dto.RefreshTokenRequest;
import rs.prati.service.security.AuthRefreshTokenService;
import rs.prati.service.security.JwtTokenProvider;

import java.time.LocalDateTime;
import java.util.Locale;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Јединични тестови за контролер освежавања access токена.
 */
@SpringBootTest
@AutoConfigureMockMvc
public class RefreshTokenControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AuthRefreshTokenService refreshTokenService;

    @MockBean
    private JwtTokenProvider jwtTokenProvider;

    @Autowired
    private ObjectMapper objectMapper;
    
    @Autowired
    private MessageSource messageSource;

    /**
     * Тестира случај када је refresh токен валидан и успешно се враћа нови access и refresh токен.
     */
    @WithMockUser // Додаје "лажног" корисника у безбедносни контекст
    @Test
    @DisplayName("Треба вратити нови access и refresh токен ако је све у реду")
    void refreshTokenShouldReturnNewTokens() throws Exception {
        // ➤ Тест вредности за refresh токене и access токен
        String oldRefreshToken = "valid-refresh-token";
        String newAccessToken = "new-access-token";
        String newRefreshToken = "new-refresh-token";

        // ➤ Фиктиван корисник (објекат се мора попунити јер се прослеђује сервисима)
        BaKorisnici korisnik = new BaKorisnici();
        korisnik.setId(1L);
        korisnik.setEmail("korisnik@example.com");

        // ➤ Стари refresh токен који се шаље у захтеву
        AuthRefreshToken oldToken = new AuthRefreshToken();
        oldToken.setExpiryDate(LocalDateTime.now().plusDays(1));
        oldToken.setToken(oldRefreshToken);
        oldToken.setKorisnik(korisnik); // ВАЖНО: без овога долази до NPE

        // ➤ Нови refresh токен који сервис враћа као резултат
        AuthRefreshToken newToken = new AuthRefreshToken();
        newToken.setToken(newRefreshToken);
        newToken.setKorisnik(korisnik);

        // ➤ Мокање сервиса
        when(refreshTokenService.findByToken(oldRefreshToken)).thenReturn(Optional.of(oldToken));
        when(refreshTokenService.verifyExpiration(oldToken)).thenReturn(oldToken);
        when(refreshTokenService.createRefreshToken(korisnik)).thenReturn(newToken);
        when(jwtTokenProvider.generateToken(any(BaKorisnici.class))).thenReturn(newAccessToken);

        // ➤ Захтев
        RefreshTokenRequest request = new RefreshTokenRequest(oldRefreshToken);

        // ➤ Извршење и верификација
        mockMvc.perform(post("/refresh-token")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.accessToken").value(newAccessToken))
                .andExpect(jsonPath("$.refreshToken").value(oldRefreshToken));
    }

    
    /**
     * Тестира случај када refresh токен не постоји у бази.
     * Очекује се статус 404 и порука о грешци.
     */
    @WithMockUser
    @Test
    void refreshTokenShouldReturnNotFoundIfTokenDoesNotExist() throws Exception {
    	// Учитавање локализоване поруке
        String expectedMessage = messageSource.getMessage("refresh.notfound", null, Locale.getDefault());
        
        // Тест вредност која не постоји
        String nonExistingToken = "non-existing-refresh-token";

        // Мокање – сервис не враћа ништа
        when(refreshTokenService.findByToken(nonExistingToken)).thenReturn(Optional.empty());

        RefreshTokenRequest request = new RefreshTokenRequest(nonExistingToken);

        mockMvc.perform(post("/refresh-token")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.message").value(expectedMessage)); // Ово зависи од поруке у твом контролеру
    }
    
    @Test
    @DisplayName("Треба бацити грешку ако је refresh токен ревокиран")
    @WithMockUser
    void refreshTokenShouldFailIfTokenIsRevoked() throws Exception {
        RefreshTokenRequest request = new RefreshTokenRequest("revoked-token");

        when(refreshTokenService.findByToken("revoked-token"))
                .thenReturn(Optional.empty());

        mockMvc.perform(post("/refresh-token")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(request)))
            .andExpect(status().isNotFound())
            .andExpect(jsonPath("$.message").value(messageSource.getMessage("refresh.notfound", null, Locale.getDefault())));
    }

    @Test
    @DisplayName("Треба бацити грешку ако је refresh токен истекао")
    @WithMockUser
    void refreshTokenShouldFailIfTokenIsExpired() throws Exception {
        RefreshTokenRequest request = new RefreshTokenRequest("expired-token");

        AuthRefreshToken token = new AuthRefreshToken();
        token.setToken("expired-token");
        token.setExpiryDate(LocalDateTime.now().minusDays(1));
        token.setKorisnik(new BaKorisnici());

        when(refreshTokenService.findByToken("expired-token"))
            .thenReturn(Optional.of(token));
        when(refreshTokenService.verifyExpiration(token))
            .thenThrow(new RefreshTokenExpiredException(messageSource.getMessage("refresh.expired", null, Locale.getDefault())));

        mockMvc.perform(post("/refresh-token")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(request)))
            .andExpect(status().isBadRequest())
            .andExpect(jsonPath("$.message").value(messageSource.getMessage("refresh.expired", null, Locale.getDefault())));
    }

    @Test
    @DisplayName("Треба бацити грешку ако је refresh токен модификован или неважећи")
    @WithMockUser
    void refreshTokenShouldFailIfTokenIsInvalid() throws Exception {
        RefreshTokenRequest request = new RefreshTokenRequest("invalid-token");

        AuthRefreshToken token = new AuthRefreshToken();
        token.setToken("invalid-token");
        token.setExpiryDate(LocalDateTime.now().plusDays(1));
        token.setKorisnik(new BaKorisnici());

        when(refreshTokenService.findByToken("invalid-token"))
            .thenReturn(Optional.of(token));
        when(refreshTokenService.verifyExpiration(token))
            .thenReturn(token);
        when(jwtTokenProvider.generateToken(any(BaKorisnici.class)))
            .thenThrow(new RefreshTokenInvalidException(messageSource.getMessage("refresh.invalid", null, Locale.getDefault())));

        mockMvc.perform(post("/refresh-token")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(request)))
            .andExpect(status().isBadRequest())
            .andExpect(jsonPath("$.message").value(messageSource.getMessage("refresh.invalid", null, Locale.getDefault())));
    }


}
