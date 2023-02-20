package com.codegym.blog_app.service;

import com.codegym.blog_app.model.Category;

import java.util.List;

public interface ICategoryService {
    List<Category> findAll();
    void save(Category category);
    void delete(Category category);
    void update(Category category);
    Category findById(int id);
}
