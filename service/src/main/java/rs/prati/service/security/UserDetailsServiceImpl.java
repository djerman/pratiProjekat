package rs.prati.service.security;

import rs.prati.core.model.BaKorisnici;
import rs.prati.service.repository.BaKorisniciRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
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
    
    // Компонента за учитавање порука на основу језика корисника
    @Autowired
    private MessageSource messageSource;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        BaKorisnici korisnik = korisniciRepository.findValidUserByEmail(email)
            .orElseThrow(() -> new UsernameNotFoundException(messageSource.getMessage("login.notfound", null, LocaleContextHolder.getLocale()) + " " + email));

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
    
    /**
     * за случај да требад аима више улога по кориснику
     */
    /*private Collection<? extends GrantedAuthority> getAuthorities(BaKorisnici korisnik) {
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        if (korisnik.getSistem()) authorities.add(new SimpleGrantedAuthority("ROLE_SYSTEM"));
        if (korisnik.getAdmin())  authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
        if (korisnik.getKorisnik()) authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
        return authorities;
    }*/
}
