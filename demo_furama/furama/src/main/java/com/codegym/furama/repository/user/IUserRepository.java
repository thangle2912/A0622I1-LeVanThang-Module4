package com.codegym.furama.repository.user;


import com.codegym.furama.model.user.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<User,String> {
    Page<User> findUserByUsernameContaining(String username, Pageable pageable);
}
