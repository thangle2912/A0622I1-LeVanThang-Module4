package com.codegym.demo.controller;


import com.codegym.demo.model.Product;
import com.codegym.demo.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@CrossOrigin("*")
@RestController
@RequestMapping("/customer/api")
public class CustomerRestController {
    @Autowired
    IProductService customerService;

    @GetMapping("/detail/{id}")
    public ResponseEntity<Product> getAttachFacility(@PathVariable int id) {

        Product product = customerService.findById(id);
        if (product == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(product, HttpStatus.OK);
    }
}
