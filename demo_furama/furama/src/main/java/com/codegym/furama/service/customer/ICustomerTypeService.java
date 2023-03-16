package com.codegym.furama.service.customer;

import com.codegym.furama.model.customer.CustomerType;


import java.util.List;

public interface ICustomerTypeService {
    List<CustomerType> findAll();
    void save(CustomerType customerType);
    void delete(CustomerType customerType);
    void update(CustomerType customerType);
}
