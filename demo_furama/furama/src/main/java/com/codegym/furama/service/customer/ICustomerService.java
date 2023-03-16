package com.codegym.furama.service.customer;

import com.codegym.furama.model.customer.Customer;
import com.codegym.furama.model.employee.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ICustomerService {
    List<Customer> findAll();
    void save(Customer customer);
    void delete(Customer customer);
    void update(Customer customer);
    Customer findById(int i);
    Page<Customer> searchByName(String name, Pageable pageable);
}
