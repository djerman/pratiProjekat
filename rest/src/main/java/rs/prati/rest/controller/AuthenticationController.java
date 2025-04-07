package rs.prati.rest.controller;

import rs.prati.rest.security.JwtTokenProvider;
import rs.prati.service.auth.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
public class AuthenticationController {

    @Autowired
    private AuthenticationService authenticationService;

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    /**
     * Обрађује POST захтев на /login и враћа JWT токен ако су подаци валидни.
     */
    @PostMapping
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest request) {
        Authentication auth = authenticationService.authenticate(request.getEmail(), request.getPassword());
        String token = jwtTokenProvider.generateToken(auth);

        LoginResponse response = new LoginResponse();
        response.setToken(token);
        response.setUsername(request.getEmail());

        return ResponseEntity.ok(response);
    }
}
