package pl.dawidwiktorowski.reservation_system.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.dawidwiktorowski.reservation_system.model.Category;
import pl.dawidwiktorowski.reservation_system.repository.CategoryRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class CategoryServiceImplementation {

    private CategoryRepository categoryRepository;


    public void add(Category category) {
        categoryRepository.save(category);
    }

    public List<Category> findByAll() {
        return categoryRepository.findAll();
    }

    public Category getById(Long id) {
        return categoryRepository.findById(id).orElse(null);
    }
}
