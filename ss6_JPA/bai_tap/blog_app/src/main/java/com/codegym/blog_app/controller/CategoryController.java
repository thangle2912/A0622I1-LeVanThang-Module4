package com.codegym.blog_app.controller;


import com.codegym.blog_app.model.Blog;
import com.codegym.blog_app.model.Category;
import com.codegym.blog_app.service.IBlogService;
import com.codegym.blog_app.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/category")
public class CategoryController {


    @Autowired
    ICategoryService categoryService;

    @Autowired
    IBlogService blogService;

    @GetMapping("/list")
    public String showList(Model model){
        List<Category> categoryList =categoryService.findAll();
        List<Blog> blogList =blogService.findAll();

        for (Category category:categoryList) {
            for (Blog blog: blogList) {
                if (blog.getCategory().getId()==category.getId()){
                    category.getBlogSet().add(blog);
                }
            }
        }
        model.addAttribute("categoryList", categoryList);
        return "category/list";
    }

    @GetMapping("/create")
    public String showFormCreate(Model model){
        model.addAttribute("category", new Category());
        return "category/create";
    }

    @PostMapping("/create")
    public String save(@ModelAttribute Category category, Model model, RedirectAttributes redirectAttributes){
        categoryService.save(category);
        model.addAttribute("categoryList", categoryService.findAll());
        return "redirect:/category/list";
    }

    @GetMapping("/update")
    public String showFormUpdate(@RequestParam int id, Model model, RedirectAttributes redirectAttributes){
        model.addAttribute("category", categoryService.findById(id));
        return "category/update";
    }
    @PostMapping("/update")
    public String update(@ModelAttribute Category category,RedirectAttributes attributes){
        categoryService.update(category);
        return "redirect:/category/list";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam int id,RedirectAttributes attributes){
        Category category = categoryService.findById(id);
        categoryService.delete(category);
        return "redirect:/category/list";
    }
}
