package com.example.productsdata.controller;


import com.example.productsdata.entity.Product;
import com.example.productsdata.service.ProductService;
import com.example.productsdata.service.impl.ProductServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1")
@RequiredArgsConstructor
public class ProductController {

        private final ProductService productService;


        @GetMapping("/list")
        public Iterable listProducts() {
                return productService.listProducts();
        }

        @PostMapping("/save")
        public Product saveProduct(@RequestBody Product product) {
                return productService.saveProduct(product);
        }

        @PutMapping("/update/{id}")
        public Product updateProduct(@RequestBody Product product,@PathVariable int id) {
                return productService.updateProduct(product, id);
        }

        @DeleteMapping("/delete/{id}")
        public String deleteProduct(@PathVariable int id) {
                return productService.deleteProduct(id);
        }

        @GetMapping("/get/{id}")
        public Product getProduct(@PathVariable int id) {
                return productService.getProductById(id);
        }

}
