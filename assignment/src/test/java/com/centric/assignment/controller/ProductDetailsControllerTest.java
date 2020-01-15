package com.centric.assignment.controller;

import com.centric.assignment.service.IProductService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.data.domain.Sort;

import static org.junit.jupiter.api.Assertions.*;

class ProductDetailsControllerTest {

    private ProductDetailsController productDetailsController;
    private IProductService iProductService;


    @BeforeEach
    public void init(){

        iProductService = Mockito.mock(IProductService.class);
        productDetailsController = new ProductDetailsController(iProductService);
    }


    @Test
    void shouldCallProductServiceWithPageable(){

        productDetailsController.getAllProductsSortedByDateCreated("shoes", 0, 10);

        Mockito.verify(iProductService, Mockito.times(1)).findAllPagedByDateCreated(Mockito.anyString(),Mockito.any());
    }

}