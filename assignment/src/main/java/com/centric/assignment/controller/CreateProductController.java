package com.centric.assignment.controller;


import com.centric.assignment.controller.model.command.CreateProductCommand;
import com.centric.assignment.controller.model.view.ProductView;
import com.centric.assignment.service.IProductService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/products")
public class CreateProductController {

    private final IProductService iProductService;

    public CreateProductController(IProductService iProductService) {
        this.iProductService = iProductService;
    }

    @PostMapping
    public ProductView insertProduct(@RequestBody CreateProductCommand createProductCommand){

        return new ProductView(this.iProductService.insertProduct(createProductCommand));
    }
}
