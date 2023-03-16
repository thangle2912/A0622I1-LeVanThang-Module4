package com.codegym.furama.controller;

import com.codegym.furama.DTO.employee.EmployeeDTO;
import com.codegym.furama.model.employee.Employee;
import com.codegym.furama.service.employee.IDivisionService;
import com.codegym.furama.service.employee.IEducationDegreeService;
import com.codegym.furama.service.employee.IEmployeeService;
import com.codegym.furama.service.employee.IPositionService;
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
import java.util.Optional;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    IEmployeeService employeeService;
    @Autowired
    IDivisionService divisionService;
    @Autowired
    IPositionService positionService;
    @Autowired
    IEducationDegreeService educationDegreeService;

    @GetMapping("/list")
    public String showList(Model model,
                           @RequestParam(required = false, defaultValue = "") String searchName,
                           @RequestParam Optional<Integer> page) {
        int pageBegin = 0;
        if (page.isPresent()) {
            pageBegin = page.get();
        }
        Pageable pageable = PageRequest.of(pageBegin, 4, Sort.by("name").descending());
        Page<Employee> employeePage = employeeService.searchByName(searchName,pageable);
        model.addAttribute("employeePage",employeePage);
        model.addAttribute("searchName",searchName);

        return "employee/list";
    }
    @GetMapping("/create")
    public String showFormCreate(Model model) {
        model.addAttribute("employeeDTO", new EmployeeDTO());

        model.addAttribute("divisionList",divisionService.findAll());
        model.addAttribute("positionList",positionService.findAll());
        model.addAttribute("educationDegreeList",educationDegreeService.findAll());
        return "employee/create";
    }

    @PostMapping("/create")
    public String save(@Validated @ModelAttribute EmployeeDTO employeeDTO,@RequestParam String date, BindingResult bindingResult) {
        new EmployeeDTO().validate(employeeDTO,bindingResult);
        employeeDTO.setBirthday(date);

        if (bindingResult.hasErrors()){
            return "employee/create";
        }
        Employee employee = new Employee();
        BeanUtils.copyProperties(employeeDTO,employee);
        employeeService.save(employee);
        return "redirect:/employee/list";
    }

    @GetMapping("/update")
    public String showFormUpdate(@RequestParam int id, Model model, RedirectAttributes redirectAttributes) {
        model.addAttribute("employee", employeeService.findById(id));


        model.addAttribute("divisionList",divisionService.findAll());
        model.addAttribute("positionList",positionService.findAll());
        model.addAttribute("educationDegreeList",educationDegreeService.findAll());

        return "employee/update";
    }

    @PostMapping("/update")
    public String update(@Validated @ModelAttribute EmployeeDTO employeeDTO,@RequestParam String date, BindingResult bindingResult) {
        employeeDTO.setBirthday(date);

        if (bindingResult.hasErrors()){
            return "employee/create";
        }
        Employee employee = new Employee();
        BeanUtils.copyProperties(employeeDTO,employee);
        employeeService.save(employee);
        return "redirect:/employee/list";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam int id, RedirectAttributes attributes) {
        Employee employee = employeeService.findById(id);
        employeeService.delete(employee);
        return "redirect:/employee/list";
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
            Employee employee = new Employee();
            employee =  employeeService.findById(i);
            employeeService.delete(employee);
        }
        return "redirect:/employee/list";
    }


    public static String removeCharAt(String s, int pos) {
        return s.substring(0, pos) + s.substring(pos + 1);
    }

}
