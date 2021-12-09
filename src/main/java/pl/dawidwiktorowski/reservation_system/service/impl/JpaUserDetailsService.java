package pl.dawidwiktorowski.reservation_system.service.impl;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pl.dawidwiktorowski.reservation_system.model.User;
import pl.dawidwiktorowski.reservation_system.repository.UserRepository;

import java.util.Optional;

@Service
public class JpaUserDetailsService implements UserDetailsService {


    private UserRepository userRepository;

    public JpaUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<User> userNameOptional = userRepository.findByEmail(email);
        if (userNameOptional.isEmpty()) {
            throw new UsernameNotFoundException("No user found with email: " + email);
        }
        return userNameOptional.get();
    }
}
