package com.codegym.demo.controller;


import com.codegym.demo.DTO.ProductDTO;
import com.codegym.demo.model.Product;
import com.codegym.demo.service.IProductService;
import com.codegym.demo.service.IProductTypeService;
import com.codegym.demo.util.AdminException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    IProductService productService;
    @Autowired
    IProductTypeService productTypeService;

    @GetMapping("/list")
    public String showList(Model model,
                           @RequestParam(required = false, defaultValue = "") String searchName,
                           @RequestParam(required = false, defaultValue = "0") double searchPrice,
                           @RequestParam(required = false, defaultValue = "0") int idProductType,
                           @RequestParam Optional<Integer> page) {
        int pageBegin = 0;
        if (page.isPresent()) {
            pageBegin = page.get();
        }
        Pageable pageable = PageRequest.of(pageBegin, 5, Sort.by("name").descending());

        Page<Product> productPage = null;
        if (idProductType == 0 && searchPrice == 0) {
            productPage = productService.searchByName(searchName, pageable);
        } else{
            if (idProductType == 0) {
                productPage = productService.searchByNameAndPrice(searchName, searchPrice, pageable);
            }else if (searchPrice == 0){
                productPage = productService.searchByNameAndProductType(searchName, idProductType, pageable);
                model.addAttribute("idCustomerType", idProductType);
            } else {
                productPage = productService.searchByNameAndAndPriceAndProductType(searchName,searchPrice, idProductType, pageable);
            }
        }

        model.addAttribute("productPage", productPage);
        model.addAttribute("searchName", searchName);
        model.addAttribute("searchPrice", searchPrice);
        model.addAttribute("idProductType", idProductType);
        model.addAttribute("customerTypeList", productTypeService.findAll());

        return "product/list";
    }


    @GetMapping("/create")
    public String showFormCreate(Model model) {
        model.addAttribute("productDTO", new ProductDTO());

        model.addAttribute("productTypeList", productTypeService.findAll());
        return "product/create";
    }

    @PostMapping("/create")
    public String save(@Validated @ModelAttribute ProductDTO productDTO, BindingResult bindingResult, Model model,RedirectAttributes attributes) {
        new ProductDTO().validate(productDTO, bindingResult);

        if (bindingResult.hasErrors()) {
            model.addAttribute("productTypeList", productTypeService.findAll());
            return "product/create";
        }
        Product product = new Product();
        BeanUtils.copyProperties(productDTO, product);
        productService.save(product);
        attributes.addFlashAttribute("mess","Thêm mới thành công");
        return "redirect:/product/list";
    }


    @GetMapping("/delete")
    public String delete(@RequestParam int id, RedirectAttributes attributes) {
        Product product = productService.findById(id);
        productService.delete(product);
        return "redirect:/product/list";
    }

    @GetMapping("/deletes")
    public String delete(@RequestParam String idDeleteMore,RedirectAttributes attributes) {
        //Chuỗi lấy qua sẽ có dấu "." ở đầu, dùng hàm để bỏ kí tự "."
        idDeleteMore = removeCharAt(idDeleteMore, 0);

        //Chuyền chuỗi thành mảng id
        String[] idDelete = idDeleteMore.split("\\.");
        int[] arrId = new int[idDelete.length];
        for (int i = 0; i < idDelete.length; i++) {
            arrId[i] = Integer.parseInt(idDelete[i]);
        }
        //dùng vòng lặp để xoá blog
        for (int i : arrId) {
            Product product = new Product();
            product = productService.findById(i);
            productService.delete(product);
        }
        attributes.addFlashAttribute("mess","Xoá thành công");

        return "redirect:/product/list";
    }

    public static String removeCharAt(String s, int pos) {
        return s.substring(0, pos) + s.substring(pos + 1);
    }

    @ExceptionHandler(AdminException.class)
    public String exceptionAdmin() {
        return "error";
    }
}
