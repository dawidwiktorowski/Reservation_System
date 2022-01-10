package pl.dawidwiktorowski.reservation_system.service.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import pl.dawidwiktorowski.reservation_system.model.SubCategory;
import pl.dawidwiktorowski.reservation_system.repository.SubCategoryRepository;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


class SubCategoryServiceImplementationTest {

    @Mock
    private SubCategoryRepository subCategoryRepository;

    @Mock
    private SubCategory subCategory;

    @Captor
    private ArgumentCaptor<SubCategory> captor;

    private SubCategoryServiceImplementation subCategoryServiceImplementation;


    @BeforeEach
    void setUp() {

        MockitoAnnotations.openMocks(this);
        subCategoryServiceImplementation = new SubCategoryServiceImplementation(subCategoryRepository);
    }

    @Test
    void shouldFindAll() {
        // when
        subCategoryServiceImplementation.findAll();

        //then
        verify(subCategoryRepository).findAll();
    }

    @Test
    void shouldGetIdEquals1L() {
        // given
        when(subCategory.getId()).thenReturn(1L);

        // when
        subCategoryServiceImplementation.add(subCategory);

        // then
        verify(subCategoryRepository).save(captor.capture());

        SubCategory subCategoryValue = captor.getValue();
        assertThat(subCategoryValue.getId()).isEqualTo(1L);

    }

    @Test
    void shouldGetNameEqualsRzesy() {
        // given
        when(subCategory.getName()).thenReturn("Rzęsy");

        // when
        subCategoryServiceImplementation.add(subCategory);

        // then
        verify(subCategoryRepository).save(captor.capture());

        SubCategory subCategoryValue = captor.getValue();
        assertThat(subCategoryValue.getName()).isEqualTo("Rzęsy");

    }

    @Test
    void shouldGetPriceEquals_21_22() {
        // given
        when(subCategory.getPrice()).thenReturn(21.22);

        // when
        subCategoryServiceImplementation.add(subCategory);

        // then
        verify(subCategoryRepository).save(captor.capture());

        SubCategory subCategoryValue = captor.getValue();
        assertThat(subCategoryValue.getPrice()).isEqualTo(21.22);

    }
}