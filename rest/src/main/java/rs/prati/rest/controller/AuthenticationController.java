package rs.prati.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import rs.prati.core.model.BaKorisnici;
import rs.prati.core.model.AuthRefreshToken;
import rs.prati.service.dto.LoginRequest;
import rs.prati.service.dto.LoginResponse;
import rs.prati.service.dto.UserDto;
import rs.prati.service.repository.BaKorisniciRepository;
import rs.prati.service.security.AuthRefreshTokenService;
import rs.prati.service.security.JwtTokenProvider;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private BaKorisniciRepository korisniciRepository;

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @Autowired
    private AuthRefreshTokenService refreshTokenService;

    // Компонента за учитавање порука на основу језика корисника
    @Autowired
    private MessageSource messageSource;

    /**
     * Контролер за пријаву корисника.
     * Прима е-адресу и лозинку и враћа access и refresh токен ако је пријава успешна.
     */
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        try {
        	// Позив аутентификације преко Spring Security-а.
        	// Ова линија проверава да ли је е-адреса и лозинка валидна,
        	// активира UserDetailsService и баца изузетак ако је пријава неуспешна.
        	// Иако се објекат `authentication` не користи даље у коду,
        	// овај позив је неопходан за покретање механизма пријаве.
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword())
            );

            // Проналажење корисника у бази по е-адреси
            Optional<BaKorisnici> korisnikOpt = korisniciRepository.findByEmail(loginRequest.getEmail());

            if (korisnikOpt.isEmpty()) {
                // Ако корисник није пронађен, враћа се грешка
                String poruka = messageSource.getMessage("login.error", null, LocaleContextHolder.getLocale());
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(poruka);
            }

            BaKorisnici korisnik = korisnikOpt.get();

            // Генерисање access и refresh токена
            String accessToken = jwtTokenProvider.generateToken(korisnik);
            AuthRefreshToken refreshToken = refreshTokenService.createRefreshToken(korisnik);

            // Формирање листе улога
            List<String> uloge = new ArrayList<>();
            if (korisnik.getSistem() != null && korisnik.getSistem()) uloge.add("SYSTEM");
            if (korisnik.getAdmin() != null && korisnik.getAdmin()) uloge.add("ADMIN");
            if (korisnik.getKorisnik() != null && korisnik.getKorisnik()) uloge.add("KORISNIK");

            // Креирање DTO објекта за корисника
            UserDto userDto = new UserDto(
                    korisnik.getId(),
                    korisnik.getEmail(),
                    korisnik.getIme(),
                    uloge,
                    korisnik.getPretplatnikId()
            );

            // Креирање login одговора
            LoginResponse loginResponse = new LoginResponse(accessToken, refreshToken.getToken(), userDto);

            // Враћање login одговора
            return ResponseEntity.ok(loginResponse);


        } catch (Exception ex) {
            // У случају било какве грешке (невалидна лозинка, изузетак итд)
            String poruka = messageSource.getMessage("login.error", null, LocaleContextHolder.getLocale());
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(poruka);
        }
    }

}
