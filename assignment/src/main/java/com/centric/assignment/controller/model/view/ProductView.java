package com.centric.assignment.controller.model.view;

import com.centric.assignment.entity.Product;
import com.centric.assignment.entity.Tag;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class ProductView {


    private String id;
    private String name;
    private String description;
    private String brand;
    private List<String> tags;
    private String category;
    private LocalDateTime createdAt;

    public ProductView() {
    }

    public ProductView(Product product){

        this.id = product.getId();
        this.name = product.getName();
        this.description = product.getDescription();
        this.brand = product.getBrand();
        this.tags = product.getTags().stream()
                .map(Tag::getName)
                .collect(Collectors.toList());
        this.category = product.getCategory();
        this.createdAt = product.getCreatedAt();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
