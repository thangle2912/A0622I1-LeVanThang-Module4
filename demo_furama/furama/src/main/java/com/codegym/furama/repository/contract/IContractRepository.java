package com.codegym.furama.repository.contract;

import com.codegym.furama.model.contract.Contract;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IContractRepository extends JpaRepository<Contract,Integer> {

    Page<Contract> findContractByFacility_Name(String name, Pageable pageable);

}
