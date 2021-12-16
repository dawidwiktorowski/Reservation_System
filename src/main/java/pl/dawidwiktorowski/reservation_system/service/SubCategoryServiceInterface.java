package pl.dawidwiktorowski.reservation_system.service;

import pl.dawidwiktorowski.reservation_system.model.SubCategory;

import java.util.List;

public interface SubCategoryServiceInterface {
    void add(SubCategory subCategory);
    SubCategory findById(Long id);
    List<SubCategory> findAll();
    List<SubCategory> findAllByCategoryId(Long categoryId);
}
