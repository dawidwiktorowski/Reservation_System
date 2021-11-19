package pl.dawidwiktorowski.reservation_system.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.dawidwiktorowski.reservation_system.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
