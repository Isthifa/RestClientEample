package com.example.restclientexample.client;


import com.example.restclientexample.dto.Product;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.List;

@Service
public class ProductService {

    private RestClient restClient;

    public ProductService() {
        restClient = RestClient.builder()
                .baseUrl("http://localhost:9191/v1")
                .build();
    }

    public Product saveProduct(Product product) {
        return restClient.post()
                .uri("/save")
                .contentType(MediaType.APPLICATION_JSON)
                .body(product)
                .retrieve()
                .body(Product.class);
    }

    public Product getProduct(int id) {
        return restClient.get()
                .uri("/get/{id}", id)
                .retrieve()
                .body(Product.class);
    }

    public Product updateProduct(Product product, int id) {
        return restClient.put()
                .uri("/update/{id}", id)
                .contentType(MediaType.APPLICATION_JSON)
                .body(product)
                .retrieve()
                .body(Product.class);
    }

    public String deleteProduct(int id) {
        restClient.delete()
                .uri("/delete/{id}", id)
                .retrieve()
                .toBodilessEntity();
        return "product removed : " + id;
    }

    public Iterable<Product> listProducts() {
        return restClient.get()
                .uri("/list")
                .retrieve()
                .body(new ParameterizedTypeReference<List<Product>>() {});
    }
}
