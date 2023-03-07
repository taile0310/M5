package com.furama.service;

import com.furama.model.contract.Contract;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IContractService {
    Page<Contract> findAll(Pageable pageable);

    void saveContract(Contract contract);
    void deleteContract(int id);
    Contract findById(int id);
}
