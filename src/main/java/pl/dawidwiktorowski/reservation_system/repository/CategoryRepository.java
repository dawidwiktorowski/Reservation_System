package pl.dawidwiktorowski.reservation_system.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.dawidwiktorowski.reservation_system.model.Category;

public interface CategoryRepository extends JpaRepository<Category,Long> {
}
