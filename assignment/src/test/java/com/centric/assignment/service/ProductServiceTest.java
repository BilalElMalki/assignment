package com.centric.assignment.service;

import com.centric.assignment.controller.model.command.CreateProductCommand;
import com.centric.assignment.entity.Product;
import com.centric.assignment.repository.ProductRepository;
import com.centric.assignment.response.BadRequestException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;


import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ProductServiceTest {

    private IProductService iProductService;
    private ProductRepository productRepository;
    private final List<Product> products = Arrays.asList(new Product(
            UUID.randomUUID().toString(),
            "name",
            "description",
            "brand",
            Collections.emptyList(),
            "apparel"
            , LocalDateTime.now()
    ), new Product(
            UUID.randomUUID().toString(),
            "name2",
            "description2",
            "brand2",
            Collections.emptyList(),
            "apparel"
            , LocalDateTime.now()
    ), new Product(
            UUID.randomUUID().toString(),
            "name3",
            "description2",
            "brand2",
            Collections.emptyList(),
            "apparel"
            , LocalDateTime.now()
    ));


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

    @Test
    void shouldGetAllProducts() {

        iProductService.findAllPagedByDateCreated("category", Pageable.unpaged());

        //Verify that repository receives a findAllpagedByDateCreated request
        Mockito.verify(productRepository, Mockito.times(1)).findAllPagesByCategory(Mockito.anyString(), Mockito.any());

        //Database in memory so there's no data expected
        assertEquals(0, iProductService.findAllPagedByDateCreated("apparel", PageRequest.of(0, 5, Sort.by(Sort.Direction.DESC,"createdAt"))).size());
    }

    @Test
    void shouldInsertProduct(){

        /*
        Creating a createProductCommand to verify if the repository receives and saves a product
         */
        CreateProductCommand createProductCommand = new CreateProductCommand();
        createProductCommand.setName("name");
        createProductCommand.setBrand("brand");
        createProductCommand.setCategory("category");
        createProductCommand.setDescription("description");
        createProductCommand.setTags(Collections.emptyList());

        iProductService.insertProduct(createProductCommand);
        Mockito.verify(productRepository, Mockito.times(1)).save(Mockito.any());

    }


}