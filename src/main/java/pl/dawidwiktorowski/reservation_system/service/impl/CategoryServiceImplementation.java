package pl.dawidwiktorowski.reservation_system.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.dawidwiktorowski.reservation_system.model.Category;
import pl.dawidwiktorowski.reservation_system.repository.CategoryRepository;
import pl.dawidwiktorowski.reservation_system.service.CategoryServiceInterface;

import java.util.List;

@Service
@AllArgsConstructor
public class CategoryServiceImplementation  implements CategoryServiceInterface {

    private CategoryRepository categoryRepository;

    @Override
    public void add(Category category) {
        categoryRepository.save(category);
    }

    @Override
    public List<Category> findAll() {
        return null;
    }

    @Override
    public Category getById(Long id) {
        return categoryRepository.findById(id).orElse(null);
    }
}
