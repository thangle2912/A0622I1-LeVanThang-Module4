package com.codegym.blog_app.repository;


import com.codegym.blog_app.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICategoryRepository extends JpaRepository<Category,Integer> {
}
