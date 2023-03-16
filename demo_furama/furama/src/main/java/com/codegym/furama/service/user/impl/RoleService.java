package com.codegym.furama.service.user.impl;

import com.codegym.furama.model.user.Role;
import com.codegym.furama.repository.user.IRoleRepository;
import com.codegym.furama.service.user.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService implements IRoleService {
    @Autowired
    IRoleRepository roleRepository;
    @Override
    public List<Role> findAll() {
        return roleRepository.findAll();
    }

    @Override
    public void save(Role role) {
        roleRepository.save(role);
    }

    @Override
    public void delete(Role role) {
        roleRepository.delete(role);
    }

    @Override
    public void update(Role role) {
        roleRepository.save(role);
    }
}
