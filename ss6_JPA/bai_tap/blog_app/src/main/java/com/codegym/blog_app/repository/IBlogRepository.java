package com.codegym.blog_app.repository;

import com.codegym.blog_app.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IBlogRepository extends JpaRepository<Blog, Integer> {

    @Query(value = "select * from blog where title like :title", nativeQuery = true)
    Page<Blog> searchPage(@Param("title") String title, Pageable pageable);

    Page<Blog> findByTitleContainingAndCategory_Id(String title,int idCategory, Pageable pageable);
    Page<Blog> findByTitleContaining(String title, Pageable pageable);

}
