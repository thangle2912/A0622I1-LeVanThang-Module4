package com.codegym.registration_form.controller;

import com.codegym.registration_form.dto.UserDTO;
import com.codegym.registration_form.model.User;
import com.codegym.registration_form.service.IUserService;
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

import java.util.Optional;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    IUserService userService;

    @GetMapping("/list")
    public String showList(Model model,@RequestParam Optional<Integer> page) {
        int pageBegin = 0;
        if (page.isPresent()) {
            pageBegin = page.get();
        }
        Pageable pageable = PageRequest.of(pageBegin, 3, Sort.by("firstName").descending());

        Page<User> userPage = userService.findAll(pageable);
        model.addAttribute("userPage", userPage);
        model.addAttribute("userList",userPage);
        return "list";
    }

    @GetMapping("/create")
    public String showFormCreate(Model model) {
        model.addAttribute("userDTO", new UserDTO());
        model.addAttribute("userList", userService.findAll(Pageable.unpaged()));
        return "create";
    }

    @PostMapping("/create")
    public String createUser(@Validated @ModelAttribute UserDTO userDto, BindingResult bindingResult){
        new UserDTO().validate(userDto,bindingResult);
        if(bindingResult.hasErrors()){
            return "create";
        }
        User user= new User();
        BeanUtils.copyProperties(userDto,user);
        userService.save(user);
        return "redirect:/user/list";
    }

}
