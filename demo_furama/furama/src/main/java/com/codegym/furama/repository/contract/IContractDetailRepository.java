package com.codegym.furama.repository.contract;

import com.codegym.furama.model.contract.ContractDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IContractDetailRepository extends JpaRepository<ContractDetail,Integer> {
    List<ContractDetail> findByContract_Id(int id);
}
