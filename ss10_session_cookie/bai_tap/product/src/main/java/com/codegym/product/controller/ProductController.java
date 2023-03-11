package com.codegym.product.controller;

import com.codegym.product.dto.CartDto;
import com.codegym.product.dto.ProductDto;
import com.codegym.product.model.Product;
import com.codegym.product.service.IProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/product")
@SessionAttributes("cart")
public class ProductController {
    @Autowired
    IProductService productService;

    @ModelAttribute("cart")
    public CartDto cart(){
        return new CartDto();
    }

    @GetMapping("/list")
    public String showList(Model model, @CookieValue(value = "idProduct",defaultValue = "-1")int idProduct){
       model.addAttribute("historyProduct",productService.findById(idProduct));
       model.addAttribute("productList",productService.findAll());
        return "list";
    }

    @GetMapping("/detail")
    public ModelAndView showDetail(@RequestParam int id, HttpServletResponse response){
        Cookie cookie = new Cookie("idProduct",id+"");
        cookie.setMaxAge(1*24*60*60);
        cookie.setPath("/");
        response.addCookie(cookie);
        ModelAndView modelAndView = new ModelAndView("detail","product",productService.findById(id));
        return modelAndView;
    }
    @GetMapping("/add")
    public String addToCard(@RequestParam int id,
                            @ModelAttribute("cart") CartDto cart) {
        Product productDetail = productService.findById(id);
        if (productDetail!=null) {
            ProductDto productDto = new ProductDto();
            BeanUtils.copyProperties(productDetail, productDto);
            cart.addProduct(productDto);
        }
        return "redirect:/cart";
    }

}
