package pl.dawidwiktorowski.reservation_system.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pl.dawidwiktorowski.reservation_system.model.Role;
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
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setActive(true);
        Role role = roleRepository.findByRoleType("ROLE_USER");
        user.setRole(role);
        userRepository.save(user);
    }

    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public User findById(Long userId) {
        return userRepository.findById(userId).orElse(null);
    }

    @Override
    public void update(User user) {
        userRepository.findById(user.getId()).ifPresent(updateUser ->{
            updateUser.setFirstname(user.getFirstname());
            updateUser.setLastname(user.getLastname());
            updateUser.setEmail(user.getEmail());
            updateUser.setPhoneNumber(user.getPhoneNumber());
            userRepository.save(updateUser);
        });
    }

    @Override
    public void forgottenPassword(User user, Map<String, String> requestParam) {
        userRepository.findById(user.getId()).ifPresent(updateUserPassword ->{
            updateUserPassword.setPassword(passwordEncoder.encode(requestParam.get("password")));
            userRepository.save(updateUserPassword);
        });

    }
}
