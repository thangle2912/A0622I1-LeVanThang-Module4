package com.codegym.product.controller;

import com.codegym.product.dto.CartDto;
import com.codegym.product.dto.ProductDto;
import com.codegym.product.model.Product;
import com.codegym.product.service.IProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/cart")
public class CartController {
    @Autowired
    IProductService productService;

    @GetMapping
    public ModelAndView showCart(@SessionAttribute(name = "cart",required = false) CartDto cartDto){
        ModelAndView modelAndView = new ModelAndView("cart","cart",cartDto);
        return modelAndView;
    }
    @GetMapping("delete")
    public String delete(@RequestParam int id, @SessionAttribute(name = "cart", required = false) CartDto cart) {
        Product product = productService.findById(id);
        if (product!=null) {
            ProductDto productDto = new ProductDto();
            BeanUtils.copyProperties(product, productDto);
            cart.removeProductCart(productDto);
        }
        return "redirect:/cart";
    }

    @GetMapping("decrement")
    public String decrement(@RequestParam int id, @SessionAttribute(name = "cart", required = false) CartDto cart) {
        Product product = productService.findById(id);
        if (product!=null) {
            ProductDto productDto = new ProductDto();
            BeanUtils.copyProperties(product, productDto);
            cart.decrementProduct(productDto);
        }
        return "redirect:/cart";
    }
    @GetMapping("increase")
    public String increase(@RequestParam int id, @SessionAttribute(name = "cart", required = false) CartDto cart) {
        Product product = productService.findById(id);
        if (product!=null) {
            ProductDto productDto = new ProductDto();
            BeanUtils.copyProperties(product, productDto);
            cart.increaseProduct(productDto);
        }
        return "redirect:/cart";
    }
}
