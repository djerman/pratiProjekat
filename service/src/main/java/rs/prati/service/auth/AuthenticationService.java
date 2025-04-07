package rs.prati.service.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    @Autowired
    private AuthenticationManager authenticationManager;

    public Authentication authenticate(String email, String lozinka) {
        UsernamePasswordAuthenticationToken token =
                new UsernamePasswordAuthenticationToken(email, lozinka);

        return authenticationManager.authenticate(token);
    }
}
