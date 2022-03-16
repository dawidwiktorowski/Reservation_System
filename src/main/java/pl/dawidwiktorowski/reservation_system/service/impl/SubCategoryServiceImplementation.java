package pl.dawidwiktorowski.reservation_system.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.dawidwiktorowski.reservation_system.model.SubCategory;
import pl.dawidwiktorowski.reservation_system.repository.SubCategoryRepository;
import pl.dawidwiktorowski.reservation_system.service.SubCategoryServiceInterface;

import java.util.List;

@Service
@AllArgsConstructor
public class SubCategoryServiceImplementation implements SubCategoryServiceInterface {

    private SubCategoryRepository subCategoryRepository;

    @Override
    public void add(SubCategory subCategory) {
        subCategoryRepository.save(subCategory);
    }

    @Override
    public SubCategory findById(Long id) {
        return subCategoryRepository.findById(id).orElse(null);
    }

    @Override
    public List<SubCategory> findAll() {
        return subCategoryRepository.findAll();
    }

    @Override
    public List<SubCategory> findAllByCategoryId(Long categoryId) {
        return subCategoryRepository.findAllByCategoryId(categoryId);
    }
}
