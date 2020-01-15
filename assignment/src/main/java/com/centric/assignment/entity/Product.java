package com.centric.assignment.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Product implements Serializable {

    @Id
    private String id;
    private String name;
    private String description;
    private String brand;
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "product", cascade=CascadeType.ALL)
    private List<Tag> tags;
    private String category;
    private LocalDateTime createdAt;

    public Product() {
    }

    public Product(String id, String name, String description, String brand, List<Tag> tags, String category, LocalDateTime createdAt) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.brand = brand;
        this.tags = tags;
        this.category = category;
        this.createdAt = createdAt;
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

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
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
