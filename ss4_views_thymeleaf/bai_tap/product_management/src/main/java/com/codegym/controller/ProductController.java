package com.codegym.controller;

import com.codegym.model.Product;
import com.codegym.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    IProductService productService;

    @GetMapping("/list")
    public String showList(Model model){
        model.addAttribute("productList",productService.findAll());
        return "list";
    }

    @GetMapping("/create")
    public String showFormCreate(Model model){
        model.addAttribute("product",new Product());
        return "create";
    }

    @PostMapping("/create")
    public String save(@ModelAttribute Product product, RedirectAttributes attributes){
        if (productService.save(product)){
            attributes.addFlashAttribute("mess","Thêm mới thành công");
        }else {
            attributes.addFlashAttribute("mess","Thêm mới thất bại");
        }
        return "redirect:/product/list";
    }

    @GetMapping("/update")
    public String showFormUpdate(@RequestParam int id , Model model){
        model.addAttribute("product",new Product());
        Product productUpdate = new Product();
        List<Product> productList = productService.findAll();
        for(Product product: productList){
            if (product.getId()==id){
                productUpdate=product;
            }
        }
        model.addAttribute("product", productUpdate);
        return "update";
    }
    @PostMapping("/update")
    public String update(@ModelAttribute Product product,RedirectAttributes attributes){
        if (productService.update(product)){
            attributes.addFlashAttribute("mess","Chỉnh sửa thành công");
        }else {
            attributes.addFlashAttribute("mess","Chỉnh sửa thất bại");
        }
        return "redirect:/product/list";
    }
    @GetMapping("/delete")
    public String delete(@RequestParam int id, RedirectAttributes attributes){
        if (productService.delete(id)){
            attributes.addFlashAttribute("mess","Xoá thành công");
        }else {
            attributes.addFlashAttribute("mess","Xoá thất bại");
        }
        return "redirect:/product/list";
    }
    @GetMapping("/search")
    public String searchProduct(@RequestParam String search, Model model){
        model.addAttribute("productList",productService.searchByName(search));
        return "list";
    }

}
