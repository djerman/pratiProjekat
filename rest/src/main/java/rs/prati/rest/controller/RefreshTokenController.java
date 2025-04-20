package rs.prati.rest.controller;

import org.springframework.context.MessageSource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rs.prati.service.dto.RefreshTokenRequest;
import rs.prati.service.dto.TokenResponse;
import rs.prati.service.security.AuthRefreshTokenService;
import rs.prati.service.security.JwtTokenProvider;
import rs.prati.core.model.AuthRefreshToken;
import rs.prati.rest.exception.RefreshTokenExpiredException;
import rs.prati.rest.exception.RefreshTokenInvalidException;
import rs.prati.rest.exception.RefreshTokenNotFoundException;

import java.time.LocalDateTime;
import java.util.Locale;

@RestController // Означава да је ово REST контролер (враћа JSON/HTTP одговоре)
@RequestMapping("/refresh-token") // Основна путања за све методе у контролеру
public class RefreshTokenController {

    private final AuthRefreshTokenService refreshTokenService;
    private final JwtTokenProvider jwtTokenProvider;
    private final MessageSource messageSource;

    /**
     * Конструкторска инјекција зависности.
     */
    public RefreshTokenController(AuthRefreshTokenService refreshTokenService,
                                  JwtTokenProvider jwtTokenProvider,
                                  MessageSource messageSource) {
        this.refreshTokenService = refreshTokenService;
        this.jwtTokenProvider = jwtTokenProvider;
        this.messageSource = messageSource;
    }

    /**
     * Обрађује POST захтев за освежавање access токена.
     * @param request објекат који садржи refresh токен
     * @return одговор са новим access токеном и старим refresh токеном
     */
    @PostMapping
    public ResponseEntity<TokenResponse> refreshToken(@RequestBody RefreshTokenRequest request) {
        String requestToken = request.getRefreshToken();

        // Пронађи refresh токен у бази
        AuthRefreshToken refreshToken = refreshTokenService.findByToken(requestToken)
                .orElseThrow(() ->
                        new RefreshTokenNotFoundException(
                                messageSource.getMessage("refresh.notfound", null, Locale.getDefault())
                        )
                );

        // Провера истека рока важности
        if (refreshToken.getExpiryDate().isBefore(LocalDateTime.now())) {
            throw new RefreshTokenExpiredException(
                    messageSource.getMessage("refresh.expired", null, Locale.getDefault())
            );
        }

        try {
            // Генериши нови access токен
            String newAccessToken = jwtTokenProvider.generateToken(refreshToken.getKorisnik());

            // Врати response DTO са access и refresh токеном
            TokenResponse response = new TokenResponse(newAccessToken, refreshToken.getToken());
            return ResponseEntity.ok(response);

        } catch (Exception e) {
            // Ако дође до грешке у генерисању токена, баци прилагођени изузетак
            throw new RefreshTokenInvalidException(
                    messageSource.getMessage("refresh.invalid", null, Locale.getDefault())
            );
        }
    }
}
