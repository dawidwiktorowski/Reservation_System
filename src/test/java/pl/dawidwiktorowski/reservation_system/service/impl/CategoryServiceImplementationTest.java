package pl.dawidwiktorowski.reservation_system.service.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pl.dawidwiktorowski.reservation_system.model.Category;
import pl.dawidwiktorowski.reservation_system.repository.CategoryRepository;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class CategoryServiceImplementationTest {

    @Mock
    private CategoryRepository categoryRepository;
    private CategoryServiceImplementation underTest;

    @BeforeEach
    void setUp() {
        underTest = new CategoryServiceImplementation(categoryRepository);
    }
    @Test
    void CanAddCategory() {
        // given
        Category category = new Category(
                1L,
                "facelift",
                null
                );
        // when
        underTest.add(category);

        // then

        ArgumentCaptor<Category> categoryArgumentCaptor = ArgumentCaptor.forClass(Category.class);

        verify(categoryRepository).save(categoryArgumentCaptor.capture());

        Category captureCategory = categoryArgumentCaptor.getValue();

        assertThat(captureCategory).isEqualTo(category);
    }


    @Test
    void CanGetFindAllCategories() {

        // when
        underTest.findAll();

        // then
        verify(categoryRepository).findAll();
    }

    @Disabled
    @Test
    void getById() {
    }


}