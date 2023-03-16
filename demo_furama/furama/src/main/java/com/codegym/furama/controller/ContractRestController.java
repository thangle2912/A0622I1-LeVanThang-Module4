package com.codegym.furama.controller;

import com.codegym.furama.model.contract.AttachFacility;
import com.codegym.furama.model.contract.ContractDetail;
import com.codegym.furama.service.contract.IAttachFacilityService;
import com.codegym.furama.service.contract.IContractDetailService;
import com.codegym.furama.service.contract.IContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/contract_api")
public class ContractRestController {

    @Autowired
    IContractService contractService;
    @Autowired
    IAttachFacilityService attachFacilityService;
    @Autowired
    IContractDetailService contractDetailService;

    @GetMapping("/detail/{id}")
    public ResponseEntity<List<ContractDetail>> getAttachFacility(@PathVariable int id){
        List<ContractDetail> contractDetailList = contractDetailService.findByContactId(id);
//        for (ContractDetail contractDetail: contractDetailList) {
//            for (AttachFacility attachFacility: attachFacilityService.findAll()) {
//                if (contractDetail.getAttachFacility().getId() == attachFacility.getId()){
//
//                }
//            }
//        }
        if (contractDetailList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(contractDetailList,HttpStatus.OK);
    }
//    @GetMapping("/attach/{id}")
//    public ResponseEntity<AttachFacility> getAttachFacility(@PathVariable int id){
//        List<ContractDetail> contractDetailList = contractDetailService.findByContactId(id);
//        AttachFacility attachFacility = attachFacilityService.findById(id);
//        if (attachFacility == null){
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//        return new ResponseEntity<>(attachFacility,HttpStatus.OK);
//    }

}
