package com.codegym.blog_app.service;

import com.codegym.blog_app.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IBlogService {
    List<Blog> findAll();
    void save(Blog blog);
    void delete(Blog blog);
    void update(Blog blog);
    Blog findById(int id);
    Page<Blog> searchByTitle(String title, Pageable pageable);
    Page<Blog> searchByTitleAndCategory(String title,int idCategory, Pageable pageable);

}
