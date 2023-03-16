package com.codegym.furama.service.customer.impl;

import com.codegym.furama.model.customer.Customer;
import com.codegym.furama.repository.customer.ICustomerRepository;
import com.codegym.furama.service.customer.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService implements ICustomerService {

    @Autowired
    ICustomerRepository customerRepository;
    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public void save(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public void delete(Customer customer) {
        customerRepository.delete(customer);
    }

    @Override
    public void update(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public Customer findById(int i) {
        return customerRepository.findById(i).orElse(null);
    }

    @Override
    public Page<Customer> searchByName(String name, Pageable pageable) {
        return customerRepository.findCustomerByNameContaining(name, pageable);
    }
}
