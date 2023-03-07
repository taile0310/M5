package com.furama.repository;

import com.furama.model.contract.ContractDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IContractDetailRepository extends JpaRepository<ContractDetail,Integer> {
}
