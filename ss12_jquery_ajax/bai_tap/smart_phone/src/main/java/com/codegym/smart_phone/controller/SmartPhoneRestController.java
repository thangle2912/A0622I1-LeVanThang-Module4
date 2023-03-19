package com.codegym.smart_phone.controller;

import com.codegym.smart_phone.model.SmartPhone;
import com.codegym.smart_phone.service.ISmartPhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/smartphone/api")
public class SmartPhoneRestController {
    @Autowired
    ISmartPhoneService smartPhoneService;

    @GetMapping("")
    public ResponseEntity<List<SmartPhone>> getAll() {
        List<SmartPhone> smartPhoneList = smartPhoneService.findAll();
        if (smartPhoneList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(smartPhoneList, HttpStatus.OK);
    }
    @PostMapping("")
    public ResponseEntity<?> save(@RequestBody SmartPhone smartPhone) {
        smartPhoneService.save(smartPhone);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PatchMapping("/edit")
    public ResponseEntity<?> editSmartPhone(@RequestBody SmartPhone smartPhone) {
        SmartPhone smartPhoneEdit = smartPhoneService.findById(smartPhone.getId());
        if (smartPhoneEdit == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        smartPhoneService.save(smartPhone);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
