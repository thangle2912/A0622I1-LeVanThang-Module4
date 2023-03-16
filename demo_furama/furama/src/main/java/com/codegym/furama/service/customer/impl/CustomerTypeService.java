package com.codegym.furama.service.customer.impl;

import com.codegym.furama.model.customer.CustomerType;
import com.codegym.furama.repository.customer.ICustomerTypeRepository;
import com.codegym.furama.service.customer.ICustomerTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CustomerTypeService implements ICustomerTypeService {

    @Autowired
    ICustomerTypeRepository customerTypeRepository;

    @Override
    public List<CustomerType> findAll() {
        return customerTypeRepository.findAll();
    }

    @Override
    public void save(CustomerType customerType) {
        customerTypeRepository.save(customerType);
    }

    @Override
    public void delete(CustomerType customerType) {
        customerTypeRepository.delete(customerType);
    }

    @Override
    public void update(CustomerType customerType) {
        customerTypeRepository.save(customerType);
    }
}
