package com.codegym.furama.controller;

import com.codegym.furama.DTO.contract.ContractDTO;
import com.codegym.furama.model.contract.AttachFacility;
import com.codegym.furama.model.contract.Contract;
import com.codegym.furama.model.contract.ContractDetail;
import com.codegym.furama.service.contract.IAttachFacilityService;
import com.codegym.furama.service.contract.IContractDetailService;
import com.codegym.furama.service.contract.IContractService;
import com.fasterxml.jackson.databind.util.BeanUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequestMapping("/contract")
@Controller
public class ContractController {

    @Autowired
    IContractService contractService;
    @Autowired
    IAttachFacilityService attachFacilityService;

    @Autowired
    IContractDetailService contractDetailService;

    @GetMapping("/list")
    public String showList(Model model,
                           @RequestParam(required = false, defaultValue = "") String searchName,
                           @RequestParam Optional<Integer> page) {
        int pageBegin = 0;
        if (page.isPresent()) {
            pageBegin = page.get();
        }

        Pageable pageable = PageRequest.of(pageBegin, 6, Sort.by("id").descending());
//        Page<Contract> contractPage = contractService.searchByFacilityName(searchName, pageable);
        Page<Contract> contractPage = contractService.findAll(pageable);



        List<AttachFacility> attachFacilities = new ArrayList<>();
        model.addAttribute("attachFacilities", attachFacilities);
        model.addAttribute("contractPage", contractPage);
        model.addAttribute("contractDetail", new ContractDetail());
        model.addAttribute("contractDetailList", contractDetailService.findAll());
        model.addAttribute("attachFacilityList", attachFacilityService.findAll());
        model.addAttribute("searchName", searchName);

        return "contract/list";
    }

    @PostMapping("/addAttachFacility")
    public String addAttachFacility(@ModelAttribute ContractDetail contractDetail) {
        contractDetailService.save(contractDetail);
        return "redirect:/contract/list";
    }
}
