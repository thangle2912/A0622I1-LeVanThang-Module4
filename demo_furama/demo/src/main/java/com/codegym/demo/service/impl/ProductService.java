package com.codegym.demo.service.impl;

import com.codegym.demo.model.Product;
import com.codegym.demo.repository.IProductRepository;
import com.codegym.demo.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements IProductService {

    @Autowired
    IProductRepository productRepository;

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public void save(Product product) {
        productRepository.save(product);
    }

    @Override
    public void delete(Product product) {
        productRepository.delete(product);
    }

    @Override
    public void update(Product product) {
        productRepository.save(product);
    }

    @Override
    public Product findById(int i) {
        return productRepository.findById(i).orElse(null);
    }

    @Override
    public Page<Product> searchByName(String name, Pageable pageable) {
        return productRepository.findProductByNameContaining(name,pageable);
    }

    @Override
    public Page<Product> searchByNameAndPrice(String name,double price, Pageable pageable) {
        return productRepository.findProductsByNameContainingAndPrice(name,price, pageable);
    }

    @Override
    public Page<Product> searchByNameAndProductType(String name, int idProductType, Pageable pageable) {
        return productRepository.findProductsByNameContainingAndProductType_Id(name, idProductType, pageable);
    }

    @Override
    public Page<Product> searchByNameAndAndPriceAndProductType(String name,double price, int idCustomerType, Pageable pageable) {
        return productRepository.findByNameContainingAndPriceAndProductType_Id(name,price, idCustomerType, pageable);
    }
}
