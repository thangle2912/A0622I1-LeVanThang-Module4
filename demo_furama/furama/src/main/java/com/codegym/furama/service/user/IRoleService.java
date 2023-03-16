package com.codegym.furama.service.user;

import com.codegym.furama.model.user.Role;


import java.util.List;

public interface IRoleService {
    List<Role> findAll();
    void save(Role role);
    void delete(Role role);
    void update(Role role);
}
