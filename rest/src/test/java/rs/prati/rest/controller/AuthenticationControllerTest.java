// Пакет у ком се налази тест класа
package rs.prati.rest.controller;

// Увоз JSON алата за серијализацију објеката
import com.fasterxml.jackson.databind.ObjectMapper;

// Увоз тест и mock алата
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

// Аннотације за покретање Spring Boot окружења током тестирања
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.test.context.ActiveProfiles;

// Spring безбедносне класе за аутентификацију
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

// MockMvc омогућава симулацију HTTP захтева према REST контролеру
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.http.MediaType;

// Доменски и безбедносни објекти
import rs.prati.core.model.BaKorisnici;
import rs.prati.core.model.AuthRefreshToken;
import rs.prati.service.dto.LoginRequest;
import rs.prati.service.repository.BaKorisniciRepository;
import rs.prati.service.security.JwtTokenProvider;
import rs.prati.service.security.AuthRefreshTokenService;

// Статички увоз метода за симулацију HTTP захтева и валидацију резултата
import java.time.LocalDateTime;
import java.util.Optional;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


// Аннотација која покреће целокупан Spring Boot контекст
@SpringBootTest

// Ова аннотација омогућава коришћење MockMvc без покретања сервера
@AutoConfigureMockMvc

// Активира "test" профил, који користи `application-test.properties`
@ActiveProfiles("test")

public class AuthenticationControllerTest {

    // MockMvc симулира HTTP захтеве према контролерима
    @Autowired
    private MockMvc mockMvc;

    // Mock-овани компоненти који се користе унутар контролера
    @MockBean
    private JwtTokenProvider jwtTokenProvider;

    @MockBean
    private BaKorisniciRepository korisniciRepository;

    @MockBean
    private AuthRefreshTokenService refreshTokenService;

    // Mock-овани authentication manager — обавезан за пролазак Spring Security провере
    @MockBean
    private AuthenticationManager authenticationManager;

    // Серијализација објеката у JSON
    @Autowired
    private ObjectMapper objectMapper;

    // Главни тест — проверава да ли login враћа access и refresh токен
    @Test
    void loginShouldReturnAccessAndRefreshToken() throws Exception {
        // Тест подаци: е-маил и лозинка
        String email = "test@example.com";
        String password = "lozinka123";

        // Очекиване вредности токена
        String accessToken = "ACCESS";
        String refreshToken = "REFRESH";

        // Конструисање mock корисника
        BaKorisnici korisnik = new BaKorisnici();
        korisnik.setEmail(email);

        // Симулирање враћања корисника из базе
        Mockito.when(korisniciRepository.findByEmail(email)).thenReturn(Optional.of(korisnik));

        // Генерисање access токена
        Mockito.when(jwtTokenProvider.generateToken(korisnik)).thenReturn(accessToken);

        // Конструисање refresh токена
        AuthRefreshToken token = new AuthRefreshToken();
        token.setToken(refreshToken);
        token.setKorisnik(korisnik);
        token.setCreatedAt(LocalDateTime.now());
        token.setExpiryDate(LocalDateTime.now().plusDays(7));

        // Симулирање сервисне логике за креирање refresh токена
        Mockito.when(refreshTokenService.createRefreshToken(korisnik)).thenReturn(token);

        // Конструисање логин захтева
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setEmail(email);
        loginRequest.setPassword(password);

        // Симулирање успешне аутентификације преко Spring Security
        Mockito.when(authenticationManager.authenticate(Mockito.any()))
               .thenReturn(new UsernamePasswordAuthenticationToken(email, password));

        // Симулирање POST захтева на /login и провера резултата
        mockMvc.perform(post("/login")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(loginRequest)))
                .andExpect(status().isOk()) // Очекује се HTTP 200 OK
                .andExpect(jsonPath("$.accessToken").value(accessToken)) // accessToken присутан у одговору
                .andExpect(jsonPath("$.refreshToken").value(refreshToken)); // refreshToken присутан у одговору
    }
    
}
