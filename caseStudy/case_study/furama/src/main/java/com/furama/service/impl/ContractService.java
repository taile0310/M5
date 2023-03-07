package com.furama.service.impl;

import com.furama.model.contract.Contract;
import com.furama.repository.IContractRepository;
import com.furama.service.IContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ContractService implements IContractService {
    @Autowired
    private IContractRepository contractRepository;

    @Override
    public Page<Contract> findAll(Pageable pageable) {
        return contractRepository.findAll(pageable);
    }

    @Override
    public void saveContract(Contract contract) {
        contractRepository.save(contract);
    }

    @Override

    public void deleteContract(int id) {

        contractRepository.deleteById(id);

    }

    @Override
    public Contract findById(int id) {
        return contractRepository.findById(id).orElse(null);
    }
}
