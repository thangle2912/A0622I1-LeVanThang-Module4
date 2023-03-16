package com.codegym.furama.service.user;


import com.codegym.furama.model.customer.Customer;
import com.codegym.furama.model.user.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IUserService {

    List<User> findAll();
    void save(User user);
    void delete(User user);
    void update(User user);
    User findById(String s);
    Page<User> searchByName(String name, Pageable pageable);
}
