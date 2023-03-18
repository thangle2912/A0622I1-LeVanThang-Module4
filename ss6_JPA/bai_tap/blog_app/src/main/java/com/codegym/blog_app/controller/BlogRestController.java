package com.codegym.blog_app.controller;

import com.codegym.blog_app.model.Blog;
import com.codegym.blog_app.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin("*")//Cho phép domain khác truy vấn tới
@RestController
@RequestMapping("/blog/api")
public class BlogRestController {

    private int quantity = 2;

    @Autowired
    IBlogService blogService;


    @GetMapping()
    public ResponseEntity<List<Blog>> getAll() {
//        List<Blog> blogList = blogService.findAll();
        List<Blog> blogList = blogService.loadMore(quantity);
        if (blogList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogList, HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<?> save(@RequestBody Blog blog) {
        blogService.save(blog);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PatchMapping("/edit")
    public ResponseEntity<?> editBlog(@RequestBody Blog blog) {
        Blog blogEdit = blogService.findById(blog.getId());
        if (blogEdit == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        blogService.save(blog);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Blog> showBlog(@PathVariable int id) {
        Blog blog = blogService.findById(id);
        if (blog == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(blog, HttpStatus.OK);
    }

    @GetMapping("/category/{categoryId}")
    public ResponseEntity<List<Blog>> showBlogByCategoryId(@PathVariable int categoryId) {
        List<Blog> blogList = blogService.searchByCategory(categoryId);
        if (blogList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(blogList, HttpStatus.OK);
    }

    @GetMapping("/search/{title}")
    public ResponseEntity<List<Blog>> searchBlog(@PathVariable String title) {
        List<Blog> blogList = blogService.searchByTitle(title);
        if (blogList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogList, HttpStatus.OK);
    }

    @GetMapping("/loadMore")
    public ResponseEntity<List<Blog>> showLimit() {
        List<Blog> blogAllList = blogService.findAll();
        List<Blog> blogList = new ArrayList<>();
        if (blogAllList.size() < quantity) {
            blogList = blogService.loadMore(quantity);
        } else {
            quantity += 2;
            blogList = blogService.loadMore(quantity);
        }
        if (blogList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogList, HttpStatus.OK);
    }
}
