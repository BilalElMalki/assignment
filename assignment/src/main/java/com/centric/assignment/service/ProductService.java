package com.centric.assignment.service;


import com.centric.assignment.controller.model.command.CreateProductCommand;
import com.centric.assignment.controller.model.view.ProductView;
import com.centric.assignment.entity.Product;
import com.centric.assignment.entity.Tag;
import com.centric.assignment.repository.ProductRepository;
import com.centric.assignment.response.BadRequestException;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class ProductService implements IProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    @Override
    public Product insertProduct(CreateProductCommand productCommand) {

        if(productCommand == null){
            throw new BadRequestException("You need to fill the product form correctly");
        }


        Product product = new Product(
                UUID.randomUUID().toString(),
                productCommand.getName(),
                productCommand.getDescription(),
                productCommand.getBrand(),
                productCommand.getTags().stream().map(t -> new Tag(t, null)).collect(Collectors.toList()),
                productCommand.getCategory()
                , LocalDateTime.now()
        );

        product.getTags().forEach(t -> t.setProduct(product));

        return this.productRepository.save(product);
    }

    @Override
    public List<Product> findAllPagedByDateCreated(String category, Pageable pageable) {

        if(category == null || category.equals("")) {
            throw new BadRequestException("You need a category to filter the pages");
        }

        return this.productRepository.findAllPagesByCategory(category, pageable);
    }
}
