package com.codegym.demo.service;

import com.codegym.demo.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IProductService {
    List<Product> findAll();
    void save(Product product);
    void delete(Product product);
    void update(Product product);
    Product findById(int i);
    Page<Product> searchByName(String name, Pageable pageable);
    Page<Product> searchByNameAndPrice(String name,double price, Pageable pageable);
    Page<Product> searchByNameAndProductType(String name,int idProductType, Pageable pageable);
    Page<Product> searchByNameAndAndPriceAndProductType(String name,double price, int idProductType, Pageable pageable);
}
