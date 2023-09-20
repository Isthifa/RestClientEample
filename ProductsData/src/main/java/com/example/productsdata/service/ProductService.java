package com.example.productsdata.service;

import com.example.productsdata.entity.Product;

public interface ProductService {

    Product saveProduct(Product product);

    Product getProductById(int id);

    Product updateProduct(Product product, int id);

    String deleteProduct(int id);

    Iterable<Product> listProducts();
}
