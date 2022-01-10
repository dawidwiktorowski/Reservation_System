package pl.dawidwiktorowski.reservation_system.service.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import pl.dawidwiktorowski.reservation_system.model.SubCategory;
import pl.dawidwiktorowski.reservation_system.repository.SubCategoryRepository;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class SubCategoryServiceImplementationTest {

    @Mock
    private SubCategoryRepository subCategoryRepository;
    private SubCategoryServiceImplementation subCategoryServiceImplementation;
    private SubCategory subCategory;

    @BeforeEach
    void setUp() {
        subCategoryRepository = Mockito.mock(SubCategoryRepository.class);
        subCategoryServiceImplementation = new SubCategoryServiceImplementation(subCategoryRepository);
        subCategory = Mockito.mock(SubCategory.class);
    }

    @Test
    void findAll() {
        // when
        subCategoryServiceImplementation.findAll();

        //then
        verify(subCategoryRepository).findAll();
    }

    @Test
    void shouldGetIdEquals1L() {
        // given
        Mockito.when(subCategory.getId()).thenReturn(1L);

        // when
        subCategoryServiceImplementation.add(subCategory);

        // then
        ArgumentCaptor<SubCategory> captor = ArgumentCaptor.forClass(SubCategory.class);
        Mockito.verify(subCategoryRepository).save(captor.capture());

        SubCategory subCategoryValue = captor.getValue();
        assertThat(subCategoryValue.getId()).isEqualTo(1L);

    }

    @Test
    void shouldGetNameEqualsRzesy() {
        // given
        Mockito.when(subCategory.getName()).thenReturn("Rzęsy");

        // when
        subCategoryServiceImplementation.add(subCategory);

        // then
        ArgumentCaptor<SubCategory> captor = ArgumentCaptor.forClass(SubCategory.class);
        Mockito.verify(subCategoryRepository).save(captor.capture());

        SubCategory subCategoryValue = captor.getValue();
        assertThat(subCategoryValue.getName()).isEqualTo("Rzęsy");

    }

    @Test
    void shouldGetPriceEquals_21_22() {
        // given
        Mockito.when(subCategory.getPrice()).thenReturn(21.22);

        // when
        subCategoryServiceImplementation.add(subCategory);

        // then
        ArgumentCaptor<SubCategory> captor = ArgumentCaptor.forClass(SubCategory.class);
        Mockito.verify(subCategoryRepository).save(captor.capture());

        SubCategory subCategoryValue = captor.getValue();
        assertThat(subCategoryValue.getPrice()).isEqualTo(21.22);

    }
}