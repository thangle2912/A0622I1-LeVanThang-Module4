package com.codegym.blog_app.controller;

import com.codegym.blog_app.model.Blog;
import com.codegym.blog_app.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/blog")
public class BlogController {

    @Autowired

    IBlogService blogService;
    @GetMapping("/list")
    public String showList(Model model){
        model.addAttribute("blogList",blogService.findAll());
        return "list";
    }

    @GetMapping("/create")
    public String showFormCreate(Model model){
        model.addAttribute("blog", new Blog());
        return "create";
    }

    @PostMapping("/create")
    public String save(@ModelAttribute Blog blog, Model model, RedirectAttributes redirectAttributes){
        blogService.save(blog);
        model.addAttribute("blogList",blogService.findAll());
        return "redirect:/blog/list";
    }

    @GetMapping("/update")
    public String showFormUpdate(@RequestParam int id, Model model, RedirectAttributes redirectAttributes){
        model.addAttribute("blog",blogService.findById(id));
        return "update";
    }
    @PostMapping("/update")
    public String update(@ModelAttribute Blog blog,RedirectAttributes attributes){
        blogService.update(blog);
        return "redirect:/blog/list";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam int id,RedirectAttributes attributes){
        Blog blog = blogService.findById(id);
        blogService.delete(blog);
        return "redirect:/blog/list";
    }
}
