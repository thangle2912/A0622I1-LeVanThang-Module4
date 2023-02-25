package com.codegym.registration_form.service;

import com.codegym.registration_form.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IUserService {
    Page<User> findAll(Pageable pageable);
    void save(User user);

}
