package com.centric.assignment.service;

import com.centric.assignment.repository.ProductRepository;
import com.centric.assignment.response.BadRequestException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.data.domain.Pageable;



import static org.junit.jupiter.api.Assertions.assertThrows;

class ProductServiceTest {

    private IProductService iProductService;
    private ProductRepository productRepository;


    @BeforeEach
    public void init(){

        productRepository = Mockito.mock(ProductRepository.class);
        iProductService = new ProductService(productRepository);
    }

    @Test
    void shouldThrowBadRequestExceptionIsNullWhenInsertProduct(){


        assertThrows(BadRequestException.class,  () -> iProductService.insertProduct(null));
    }

    @Test
    void shouldThrowBadRequestExceptionIsNullWhenFindAllProducts(){

        assertThrows(BadRequestException.class, () -> iProductService.findAllPagedByDateCreated("", Pageable.unpaged()));

        assertThrows(BadRequestException.class, () -> iProductService.findAllPagedByDateCreated(null, Pageable.unpaged()));
    }
}