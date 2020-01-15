package com.centric.assignment.service;

import com.centric.assignment.controller.model.command.CreateProductCommand;
import com.centric.assignment.entity.Product;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IProductService {

    Product insertProduct(CreateProductCommand productCommand);
    List<Product> findAllPagedByDateCreated(String category,Pageable pageable);
}
