package com.codegym.furama.controller;

import com.codegym.furama.DTO.customer.CustomerDTO;
import com.codegym.furama.model.customer.Customer;
import com.codegym.furama.model.facility.Facility;
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

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
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
                           @RequestParam(required = false, defaultValue = "0") int idFacilityType,
                           @RequestParam Optional<Integer> page) {
        int pageBegin = 0;
        if (page.isPresent()) {
            pageBegin = page.get();
        }

        Pageable pageable = PageRequest.of(pageBegin, 6, Sort.by("name").descending());
        Page<Facility> facilityPage;

        if (idFacilityType == 0) {
            facilityPage = facilityService.searchByName(searchName, pageable);
        } else {
            facilityPage = facilityService.searchByNameAndFacilityType(searchName, idFacilityType, pageable);
            model.addAttribute("idFacilityType", idFacilityType);
        }
        model.addAttribute("facilityPage", facilityPage);
        model.addAttribute("searchName", searchName);

        model.addAttribute("facilityTypeList", facilityTypeService.findAll());
        return "facility/list";
    }

    @GetMapping("/create")
    public String showFormCreate(Model model) {
        model.addAttribute("facility", new Facility());


        model.addAttribute("facilityTypeList", facilityTypeService.findAll());
        model.addAttribute("rentTypeList", rentTypeService.findAll());
        return "facility/create";
    }

    @PostMapping("/create")
    public String save(@ModelAttribute Facility facility, Model model, RedirectAttributes redirectAttributes) {

        facilityService.save(facility);
        return "redirect:/facility/list";
    }

    @GetMapping("/update")
    public String showFormUpdate(@RequestParam int id, Model model, RedirectAttributes redirectAttributes) {
        Facility facility = facilityService.findById(id);
        String rentTypeName = facility.getFacilityType().getName();
        model.addAttribute("facility", facility);
        model.addAttribute("rentTypeName", rentTypeName);
        model.addAttribute("rentTypeList", rentTypeService.findAll());
        return "facility/update";
    }
//
//    @PostMapping("/update")
//    public String update(@ModelAttribute Blog blog, RedirectAttributes attributes) {
//        blogService.update(blog);
//        return "redirect:/blog/list";
//    }
//
//    @GetMapping("/delete")
//    public String delete(@RequestParam int id, RedirectAttributes attributes) {
//        Blog blog = blogService.findById(id);
//        blogService.delete(blog);
//        return "redirect:/blog/list";
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
//            Blog blog = new Blog();
//            blog =  blogService.findById(i);
//            blogService.delete(blog);
//        }
//        return "redirect:/blog/list";
//    }
//
//    public String dateCreate() {
//        Date date = new Date();
//        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
//        String dateCreate = format.format(date);
//        return dateCreate;
//    }
//    public static String removeCharAt(String s, int pos) {
//        return s.substring(0, pos) + s.substring(pos + 1);
//    }

}
