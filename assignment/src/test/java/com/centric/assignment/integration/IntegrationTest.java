package com.centric.assignment.integration;

import com.centric.assignment.entity.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class IntegrationTest {

    @Autowired
    WebTestClient webTestClient;




    @Test
    void shouldGetAllProduct(){



        this.webTestClient
                .get()
                .uri("/v1/products")
                .exchange()
                .expectStatus()
                .isOk()
                .expectBodyList(Product.class)
                .hasSize(0);
    }


    @Test
    void shouldInsertProduct(){

        this.webTestClient
                .post()
                .uri("/v1/products")
                .body(new Product(), Product.class)
                .exchange()
                .expectStatus()
                .isOk();
    }
}
