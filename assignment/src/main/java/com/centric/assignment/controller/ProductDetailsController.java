package com.centric.assignment.controller;

import com.centric.assignment.controller.model.view.ProductView;
import com.centric.assignment.service.IProductService;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/v1/products")
public class ProductDetailsController {

    private final IProductService iProductService;


    public ProductDetailsController(IProductService iProductService) {
        this.iProductService = iProductService;
    }

    @GetMapping
    public List<ProductView> getAllProductsSortedByDateCreated(@RequestParam String category,
                                                               @RequestParam(value = "page", defaultValue = "0") int page,
                                                               @RequestParam(value = "limit", defaultValue = "10") int limit) {
            return this.iProductService.findAllPagedByDateCreated(category, PageRequest.of(page, limit, Sort.by(Sort.Direction.DESC,"createdAt")))
                    .stream()
                    .map(ProductView::new)
                    .collect(Collectors.toList());
    }
}
