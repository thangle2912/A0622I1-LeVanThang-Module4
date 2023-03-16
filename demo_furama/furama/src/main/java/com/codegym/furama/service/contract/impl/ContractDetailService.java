package com.codegym.furama.service.contract.impl;

import com.codegym.furama.model.contract.ContractDetail;
import com.codegym.furama.repository.contract.IContractDetailRepository;
import com.codegym.furama.service.contract.IContractDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContractDetailService implements IContractDetailService {

    @Autowired
    IContractDetailRepository contractDetailRepository;
    @Override
    public List<ContractDetail> findAll() {
        return contractDetailRepository.findAll();
    }

    @Override
    public void save(ContractDetail contractDetail) {
        contractDetailRepository.save(contractDetail);
    }

    @Override
    public void delete(ContractDetail contractDetail) {
        contractDetailRepository.delete(contractDetail);
    }

    @Override
    public void update(ContractDetail contractDetail) {
        contractDetailRepository.save(contractDetail);
    }

    @Override
    public ContractDetail findById(int id) {
        return contractDetailRepository.findById(id).orElse(null);
    }

    @Override
    public List<ContractDetail> findByContactId(int id) {
        return contractDetailRepository.findByContract_Id(id);
    }
}
