package com.codegym.blog_app.repository;

import com.codegym.blog_app.model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBlogRepository extends JpaRepository<Blog,Integer> {


}