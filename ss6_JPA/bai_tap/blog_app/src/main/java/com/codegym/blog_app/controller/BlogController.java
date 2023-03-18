package com.codegym.blog_app.controller;

import com.codegym.blog_app.model.Blog;
import com.codegym.blog_app.service.IBlogService;
import com.codegym.blog_app.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

@Controller
@RequestMapping("/blog")
public class BlogController {

    @Autowired
    IBlogService blogService;
    @Autowired
    ICategoryService categoryService;

    @GetMapping("/list")
    public String showList(Model model,
                           @RequestParam(required = false, defaultValue = "") String searchTitle,
                           @RequestParam(required = false, defaultValue = "0") int idCategory,
                           @RequestParam Optional<Integer> page) {
        int pageBegin = 0;
        if (page.isPresent()) {
            pageBegin = page.get();
        }
        Pageable pageable = PageRequest.of(pageBegin, 7, Sort.by("date").descending());
        Page<Blog> blogPage;

        if (idCategory == 0) {
            blogPage = blogService.searchByTitle(searchTitle, pageable);
        } else {
            blogPage = blogService.searchByTitleAndCategory(searchTitle, idCategory, pageable);
            model.addAttribute("idCategory", idCategory);
        }
        model.addAttribute("blogPage", blogPage);
        model.addAttribute("searchTitle", searchTitle);

        model.addAttribute("categoryList", categoryService.findAll());
        return "blog/ajax";
    }

    @GetMapping("/create")
    public String showFormCreate(Model model) {
        model.addAttribute("blog", new Blog());

        model.addAttribute("dateCreate", dateCreate());
        model.addAttribute("categoryList", categoryService.findAll());
        return "blog/create";
    }

    @PostMapping("/create")
    public String save(@ModelAttribute Blog blog, Model model, RedirectAttributes redirectAttributes) {

        blog.setDate(dateCreate());
        blogService.save(blog);
        model.addAttribute("blogList", blogService.findAll());
        return "redirect:/blog/list";
    }

    @GetMapping("/update")
    public String showFormUpdate(@RequestParam int id, Model model, RedirectAttributes redirectAttributes) {
        model.addAttribute("blog", blogService.findById(id));
        model.addAttribute("categoryList", categoryService.findAll());
        return "blog/update";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute Blog blog, RedirectAttributes attributes) {
        blogService.update(blog);
        return "redirect:/blog/list";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam int id, RedirectAttributes attributes) {
        Blog blog = blogService.findById(id);
        blogService.delete(blog);
        return "redirect:/blog/list";
    }

    @GetMapping("/deletes")
    public String delete(@RequestParam String idDeleteMore) {
        //Chuỗi lấy qua sẽ có dấu "." ở đầu, dùng hàm để bỏ kí tự "."
        idDeleteMore= removeCharAt(idDeleteMore, 0);

        //Chuyền chuỗi thành mảng id
        String[] idDelete = idDeleteMore.split("\\.");
        int[] arrId = new int[idDelete.length];
        for (int i = 0; i < idDelete.length; i++) {
            arrId[i] = Integer.parseInt(idDelete[i]);
        }
        //dùng vòng lặp để xoá blog
        for (int i:arrId) {
            Blog blog = new Blog();
            blog =  blogService.findById(i);
            blogService.delete(blog);
        }
        return "redirect:/blog/list";
    }

    public String dateCreate() {
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String dateCreate = format.format(date);
        return dateCreate;
    }
    public static String removeCharAt(String s, int pos) {
        return s.substring(0, pos) + s.substring(pos + 1);
    }

}
