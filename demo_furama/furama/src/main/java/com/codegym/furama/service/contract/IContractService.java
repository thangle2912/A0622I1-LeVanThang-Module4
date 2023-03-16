package com.codegym.furama.service.contract;

import com.codegym.furama.model.contract.Contract;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface IContractService {
    Page<Contract> findAll(Pageable pageable);

    void save(Contract contract);

    void delete(Contract contract);

    void update(Contract contract);

    Contract findById(int id);

    Page<Contract> searchByFacilityName(String name, Pageable pageable);
}
