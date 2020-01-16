package com.centric.assignment.integration;

import com.centric.assignment.controller.model.command.CreateProductCommand;
import com.centric.assignment.controller.model.view.ProductView;
import com.centric.assignment.entity.Product;
import com.centric.assignment.entity.Tag;
import com.centric.assignment.service.IProductService;
import com.centric.assignment.service.ProductService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class IntegrationTest {

    @Autowired
    WebTestClient webTestClient;

    private IProductService iProductService;

    private final List<Product> products = Arrays.asList(new Product(
            UUID.randomUUID().toString(),
            "name",
            "description",
            "brand",
            Collections.emptyList(),
            "apparel"
            , LocalDateTime.now()
    ), new Product(
            UUID.randomUUID().toString(),
            "name2",
            "description2",
            "brand2",
            Collections.emptyList(),
            "apparel"
            , LocalDateTime.now()
    ), new Product(
            UUID.randomUUID().toString(),
            "name3",
            "description2",
            "brand2",
            Collections.emptyList(),
            "apparel"
            , LocalDateTime.now()
    ));

    @BeforeEach
    public void init(){

        iProductService = Mockito.mock(ProductService.class);

    }


    @Test
    void shouldGetAllProduct(){

        /*
        This test should work fine if the database wasn't in memory
         */

        webTestClient
                .get()
                .uri("/v1/products?category=apparel&page=0&limit=10")
                .exchange()
                .expectStatus()
                .isOk()
                .expectBodyList(Product.class)
                .hasSize(0);
    }


    @Test
    void shouldInsertProduct(){


        /*
        This test should work fine if the database wasn't in memory
         */

        webTestClient
                .post()
                .uri("/v1/products")
                .bodyValue(new Product(
                        UUID.randomUUID().toString(),
                        "name",
                        "description",
                        "brand",
                        Collections.emptyList(),
                        "category"
                        , LocalDateTime.now()
                ))
                .exchange()
                .expectStatus()
                .isOk();
    }
}
