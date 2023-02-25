package com.codegym.registration_form.repository;

import com.codegym.registration_form.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<User,Integer> {

    // trả một Page<Student
    Page<User> findAll(Pageable pageable);
}
