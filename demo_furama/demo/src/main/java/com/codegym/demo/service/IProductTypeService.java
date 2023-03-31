package com.codegym.demo.service;


import com.codegym.demo.model.ProductType;

import java.util.List;

public interface IProductTypeService {
    List<ProductType> findAll();
    void save(ProductType productType);
    void delete(ProductType productType);
    void update(ProductType productType);
}
