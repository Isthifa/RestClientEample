package com.example.productsdata.service.impl;

import com.example.productsdata.entity.Product;
import com.example.productsdata.service.ProductService;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    List<Product> value=new ArrayList<>();

    @PostConstruct
    public void listOfValue() {

        value.add(new Product(1,"Mobile",10000));
        value.add(new Product(2,"Laptop",50000));
        value.add(new Product(3,"TV",20000));
        value.add(new Product(4,"AC",30000));
        value.add(new Product(5,"Fridge",40000));
    }

    public Product getProductById(int id) {
        return value.stream().filter(product -> product.getId()==id).findFirst().get();
    }

    public Product saveProduct(Product product) {
        value.add(product);
        return product;
    }

    public Product updateProduct(Product product, int id) {
        value.stream().filter(product1 -> product1.getId()==id).forEach(product1 -> {
            product1.setName(product.getName());
            product1.setPrice(product.getPrice());
        });
        return product;
    }

    public String deleteProduct(int id) {
        value.removeIf(product -> product.getId()==id);
        return "product removed : " + id;
    }

    public Iterable<Product> listProducts() {
        return value;
    }


}
