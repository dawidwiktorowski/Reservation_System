package pl.dawidwiktorowski.reservation_system.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.dawidwiktorowski.reservation_system.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
