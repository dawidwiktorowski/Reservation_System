package pl.dawidwiktorowski.reservation_system.service;

import pl.dawidwiktorowski.reservation_system.model.Category;

import java.util.List;

public interface CategoryServiceInterface {
    void add(Category category);
    List<Category> findAll();
    Category getById(Long id);
}
