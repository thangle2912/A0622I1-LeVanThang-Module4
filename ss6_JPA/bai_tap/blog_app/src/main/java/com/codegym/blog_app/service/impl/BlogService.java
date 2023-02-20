package com.codegym.blog_app.service.impl;

import com.codegym.blog_app.model.Blog;
import com.codegym.blog_app.repository.IBlogRepository;
import com.codegym.blog_app.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogService implements IBlogService {
    @Autowired
    IBlogRepository blogRepository;

    @Override
    public List<Blog> findAll() {
        return blogRepository.findAll();
    }

    @Override
    public void save(Blog blog) {
        blogRepository.save(blog);
    }

    @Override
    public void delete(Blog blog) {
        blogRepository.delete(blog);
    }

    @Override
    public void update(Blog blog) {
        blogRepository.save(blog);
    }

    @Override
    public Blog findById(int id) {
        return blogRepository.findById(id).orElse(null);
    }

    @Override
    public Page<Blog> searchByTitle(String title, Pageable pageable) {
        return blogRepository.findByTitleContaining(title,pageable);
    }

    @Override
    public Page<Blog> searchByTitleAndCategory(String title, int idCategory, Pageable pageable) {
        return blogRepository.findByTitleContainingAndCategory_Id(title,idCategory,pageable);
    }
}
