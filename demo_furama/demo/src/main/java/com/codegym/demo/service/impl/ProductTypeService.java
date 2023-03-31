package com.codegym.demo.service.impl;


import com.codegym.demo.model.ProductType;
import com.codegym.demo.repository.IProductTypeRepository;
import com.codegym.demo.service.IProductTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductTypeService implements IProductTypeService {

    @Autowired
    IProductTypeRepository customerTypeRepository;

    @Override
    public List<ProductType> findAll() {
        return customerTypeRepository.findAll();
    }

    @Override
    public void save(ProductType productType) {
        customerTypeRepository.save(productType);
    }

    @Override
    public void delete(ProductType productType) {
        customerTypeRepository.delete(productType);
    }

    @Override
    public void update(ProductType productType) {
        customerTypeRepository.save(productType);
    }
}
