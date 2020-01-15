package com.centric.assignment.controller;

import com.centric.assignment.controller.model.command.CreateProductCommand;
import com.centric.assignment.service.IProductService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

class CreateProductControllerTest {

    private CreateProductController createProductController;
    private IProductService iProductService;


    @BeforeEach
    public void init(){

        iProductService = Mockito.mock(IProductService.class);
        createProductController = new CreateProductController(iProductService);
    }

    @Test
    void shouldCallProductServiceWithProduct() {

        CreateProductCommand createProductCommand = new CreateProductCommand();


        createProductCommand.setName("UltraBoost");
        createProductCommand.setDescription("Confortable shoes");
        createProductCommand.setBrand("Adidas");
        createProductCommand.setTags(createProductCommand.getTags());
        createProductCommand.setCategory("Shoes");

        createProductController.insertProduct(createProductCommand);

        Mockito.verify(iProductService, Mockito.times(1)).insertProduct(Mockito.any());
    }

}