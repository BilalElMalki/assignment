package com.centric.assignment.repository;

import com.centric.assignment.entity.Product;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductRepository extends CrudRepository<Product, String> {

    public List<Product> findAllPagesByCategory(String category, Pageable pageable);

}
