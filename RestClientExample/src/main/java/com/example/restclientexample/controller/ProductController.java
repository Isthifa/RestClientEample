package com.example.restclientexample.controller;

import com.example.restclientexample.client.ProductService;
import com.example.restclientexample.dto.Product;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/products")
@Slf4j
public class ProductController {

    private final ProductService productService;


    @PostMapping("/save")
    public Product saveProduct(@RequestBody Product product) {
        log.info("saveProduct method of ProductController called");
        return productService.saveProduct(product);
    }

    @PutMapping("/update/{id}")
    public Product updateProduct(@RequestBody Product product, @PathVariable int id) {
        log.info("updateProduct method of ProductController called");
        return productService.updateProduct(product, id);
    }

    @GetMapping("/get/{id}")
    public Product getProduct(@PathVariable int id) {
        log.info("getProduct method of ProductController called");
        return productService.getProduct(id);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteProduct(@PathVariable int id) {
        log.info("deleteProduct method of ProductController called");
        return productService.deleteProduct(id);
    }

    @GetMapping("/list")
    public Iterable<Product> listProducts() {
        log.info("listProducts method of ProductController called");
        return productService.listProducts();
    }

}
