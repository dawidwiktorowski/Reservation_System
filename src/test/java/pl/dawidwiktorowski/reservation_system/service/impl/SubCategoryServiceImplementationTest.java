package pl.dawidwiktorowski.reservation_system.service.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pl.dawidwiktorowski.reservation_system.repository.SubCategoryRepository;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class SubCategoryServiceImplementationTest {

    @Mock
    private SubCategoryRepository subCategoryRepository;
    private SubCategoryServiceImplementation underTest;

    @BeforeEach
    void setUp() {
        underTest = new SubCategoryServiceImplementation(subCategoryRepository);
    }

    @Test
    void findAll() {
        // when
        underTest.findAll();

        //then
        verify(subCategoryRepository).findAll();
    }
}