package com.centric.assignment.initialization;

import com.centric.assignment.entity.Product;
import com.centric.assignment.entity.Tag;
import com.centric.assignment.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Component
public class DatabaseInitializer implements CommandLineRunner {

    private final ProductRepository productRepository;

    public DatabaseInitializer(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        List<Tag> tags = new ArrayList<Tag>();

        Product p = new Product(UUID.randomUUID().toString(),"desk","description gyu","myBrand",
                tags, "myCategory", LocalDateTime.now());

        tags.add(new Tag("111", p));
        tags.add(new Tag("222", p));
        tags.add(new Tag("333", p));
        this.productRepository.save(p);

        Product r = this.productRepository.findAll().iterator().next();
        System.out.println(r.getTags().get(0).getName());
        System.out.println(r.getName());
        System.out.println(r.getTags().get(1).getName());
        System.out.println(r.getTags().get(2).getName());

    }
}
