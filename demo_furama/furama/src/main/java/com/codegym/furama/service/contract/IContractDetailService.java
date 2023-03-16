package com.codegym.furama.service.contract;


import com.codegym.furama.model.contract.ContractDetail;

import java.util.List;

public interface IContractDetailService {
    List<ContractDetail> findAll();

    void save(ContractDetail contractDetail);

    void delete(ContractDetail contractDetail);

    void update(ContractDetail contractDetail);

    ContractDetail findById(int id);

    List<ContractDetail> findByContactId(int id);
}
