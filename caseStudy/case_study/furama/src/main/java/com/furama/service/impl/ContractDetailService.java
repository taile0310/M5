package com.furama.service.impl;

import com.furama.model.contract.ContractDetail;
import com.furama.repository.IContractDetailRepository;
import com.furama.service.IContractDetailService;
import com.furama.service.IContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContractDetailService implements IContractDetailService {
    @Autowired
    private IContractDetailRepository contractDetailRepository;
    @Override
    public boolean addContractDetail(ContractDetail contractDetail) {
        try {
            contractDetailRepository.save(contractDetail);
            return true;
        } catch (Exception e){
            return false;
        }
    }
}
