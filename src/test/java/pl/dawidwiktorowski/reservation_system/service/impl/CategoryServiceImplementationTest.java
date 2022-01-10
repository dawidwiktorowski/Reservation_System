package pl.dawidwiktorowski.reservation_system.service.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import pl.dawidwiktorowski.reservation_system.model.Category;
import pl.dawidwiktorowski.reservation_system.repository.CategoryRepository;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


class CategoryServiceImplementationTest {

    @Mock
    private CategoryRepository categoryRepository;

    @Mock
    private Category category;

    @Captor
    ArgumentCaptor<Category> categoryArgumentCaptor;

    private CategoryServiceImplementation underTest;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        underTest = new CategoryServiceImplementation(categoryRepository);
    }

    @Test
    void shouldGetNameIsFacelift() {
        // given
        when(category.getName()).thenReturn("facelift");

        // when
        underTest.add(category);

        // then

        verify(categoryRepository).save(categoryArgumentCaptor.capture());

        Category captureCategory = categoryArgumentCaptor.getValue();
        assertThat(captureCategory.getName()).isEqualTo("facelift");
    }


    @Test
    void shouldGetFindAllCategories() {

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