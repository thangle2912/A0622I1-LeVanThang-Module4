package com.codegym.product.service;

import com.codegym.product.model.Product;

import java.util.List;

public interface IProductService {
    List<Product> findAll();
    void save(Product product);
    void deleteById(int id);
    void update(Product product);
    Product findById(int id);
}
