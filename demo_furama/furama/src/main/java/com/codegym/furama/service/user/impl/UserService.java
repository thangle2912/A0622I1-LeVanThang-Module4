package com.codegym.furama.service.user.impl;

import com.codegym.furama.model.customer.Customer;
import com.codegym.furama.model.user.User;
import com.codegym.furama.repository.user.IUserRepository;
import com.codegym.furama.service.user.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUserService {

    @Autowired
    IUserRepository userRepository;

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    public void delete(User user) {
        userRepository.delete(user);
    }

    @Override
    public void update(User user) {
        userRepository.save(user);
    }

    @Override
    public User findById(String s) {
        return null;
    }

    @Override
    public Page<User> searchByName(String username, Pageable pageable) {
        return userRepository.findUserByUsernameContaining(username,pageable);
    }
}
