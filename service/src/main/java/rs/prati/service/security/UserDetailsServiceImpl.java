package rs.prati.service.security;

import rs.prati.core.model.BaKorisnici;
import rs.prati.service.repository.BaKorisniciRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private BaKorisniciRepository korisniciRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        BaKorisnici korisnik = korisniciRepository.findByEmail(email)
            .orElseThrow(() -> new UsernameNotFoundException("Корисник није пронађен: " + email));

        // Постављање основних улога
        String role = korisnik.getSistem() ? "ROLE_SISTEM" :
                      korisnik.getAdmin() ? "ROLE_ADMIN" :
                      "ROLE_USER";

        return User.builder()
                .username(korisnik.getEmail())
                .password(korisnik.getLozinka())
                .authorities(Collections.singletonList(() -> role))
                .build();
    }
}
