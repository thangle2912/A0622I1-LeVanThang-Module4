package com.codegym.blog_app.service;

import com.codegym.blog_app.model.Blog;

import java.util.List;

public interface IBlogService {
    List<Blog> findAll();
    void save(Blog blog);
    void delete(Blog blog);
    void update(Blog blog);
    Blog findById(int id);

}
