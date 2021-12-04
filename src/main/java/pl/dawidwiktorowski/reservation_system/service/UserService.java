package pl.dawidwiktorowski.reservation_system.service;

import pl.dawidwiktorowski.reservation_system.model.User;

import java.util.Map;

public interface UserService {

    void saveUser(User user);

    User findByEmail(String email);

    User findById(Long userId);

    void update (User user);

    void forgottenPassword(User user, Map<String,String> requestParam);
}
