package com.codegym.furama.controller;

import com.codegym.furama.DTO.customer.CustomerDTO;
import com.codegym.furama.model.customer.Customer;
import com.codegym.furama.service.facility.IFacilityService;
import com.codegym.furama.service.facility.IFacilityTypeService;
import com.codegym.furama.service.facility.IRentTypeService;
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
@RequestMapping("/facility")
public class FacilityController {
    @Autowired
    IFacilityService facilityService;
    @Autowired
    IFacilityTypeService facilityTypeService;
    @Autowired
    IRentTypeService rentTypeService;

    @GetMapping("/list")
    public String showList(Model model,
                           @RequestParam(required = false, defaultValue = "") String searchName,
                           @RequestParam Optional<Integer> page) {
        int pageBegin = 0;
        if (page.isPresent()) {
            pageBegin = page.get();
        }
        Pageable pageable = PageRequest.of(pageBegin, 4, Sort.by("name").descending());
        Page<Customer> customerPage = facilityService.searchByName(searchName,pageable);
        model.addAttribute("customerPage",customerPage);
        model.addAttribute("searchName",searchName);

        return "customer/list";
    }
//    @GetMapping("/create")
//    public String showFormCreate(Model model) {
//        model.addAttribute("customerDTO", new CustomerDTO());
//
//        model.addAttribute("customerTypeList",customerTypeService.findAll());
//        return "customer/create";
//    }
//
//    @PostMapping("/create")
//    public String save(@Validated @ModelAttribute CustomerDTO customerDTO, @RequestParam String date, BindingResult bindingResult) {
//        new CustomerDTO().validate(customerDTO,bindingResult);
//        customerDTO.setBirthday(date);
//
//        if (bindingResult.hasErrors()){
//            return "customer/create";
//        }
//        Customer customer = new Customer();
//        BeanUtils.copyProperties(customerDTO,customer);
//        customerService.save(customer);
//        return "redirect:/customer/list";
//    }
//
//    @GetMapping("/update")
//    public String showFormUpdate(@RequestParam int id, Model model, RedirectAttributes redirectAttributes) {
//        model.addAttribute("customer", customerService.findById(id));
//        model.addAttribute("customerTypeList",customerTypeService.findAll());
//        return "customer/update";
//    }
//
//    @PostMapping("/update")
//    public String update(@Validated @ModelAttribute CustomerDTO customerDTO,@RequestParam String date, BindingResult bindingResult) {
//        customerDTO.setBirthday(date);
//
//        if (bindingResult.hasErrors()){
//            return "employee/create";
//        }
//        Customer customer = new Customer();
//        BeanUtils.copyProperties(customerDTO,customer);
//        customerService.save(customer);
//        return "redirect:/customer/list";
//    }
//
//    @GetMapping("/delete")
//    public String delete(@RequestParam int id, RedirectAttributes attributes) {
//        Customer customer = customerService.findById(id);
//        customerService.delete(customer);
//        return "redirect:/customer/list";
//    }
//
//    @GetMapping("/deletes")
//    public String delete(@RequestParam String idDeleteMore) {
//        //Chuỗi lấy qua sẽ có dấu "." ở đầu, dùng hàm để bỏ kí tự "."
//        idDeleteMore= removeCharAt(idDeleteMore, 0);
//
//        //Chuyền chuỗi thành mảng id
//        String[] idDelete = idDeleteMore.split("\\.");
//        int[] arrId = new int[idDelete.length];
//        for (int i = 0; i < idDelete.length; i++) {
//            arrId[i] = Integer.parseInt(idDelete[i]);
//        }
//        //dùng vòng lặp để xoá blog
//        for (int i:arrId) {
//            Customer customer = new Customer();
//            customer =  customerService.findById(i);
//            customerService.delete(customer);
//        }
//        return "redirect:/customer/list";
//    }
//    public static String removeCharAt(String s, int pos) {
//        return s.substring(0, pos) + s.substring(pos + 1);
//    }

}
