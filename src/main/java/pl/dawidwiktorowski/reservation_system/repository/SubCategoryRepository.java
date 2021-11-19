package pl.dawidwiktorowski.reservation_system.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.dawidwiktorowski.reservation_system.model.SubCategory;

public interface SubCategoryRepository extends JpaRepository<SubCategory, Long> {
}
