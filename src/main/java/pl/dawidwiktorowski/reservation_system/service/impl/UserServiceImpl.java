package pl.dawidwiktorowski.reservation_system.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pl.dawidwiktorowski.reservation_system.model.User;
import pl.dawidwiktorowski.reservation_system.repository.RoleRepository;
import pl.dawidwiktorowski.reservation_system.repository.UserRepository;
import pl.dawidwiktorowski.reservation_system.service.UserService;

import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;



    @Override
    public void saveUser(User user) {

    }

    @Override
    public User findByEmail(String email) {
        return null;
    }

    @Override
    public User findById(Long userId) {
        return null;
    }

    @Override
    public void update(User user) {

    }

    @Override
    public void forgottenPassword(User user, Map<String, String> requestParam) {

    }
}
