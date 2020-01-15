package com.centric.assignment.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Tag implements Serializable {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;


    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Product product;
    private String name;

    public Tag() {
    }

    public Tag(String name, Product product) {
        this.name = name;
        this.product = product;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
