package com.furama.service.impl;

import com.furama.model.customer.CustomerType;
import com.furama.repository.ICustomerTypeRepository;
import com.furama.service.ICustomerTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CustomerTypeService implements ICustomerTypeService {
    @Autowired
    private ICustomerTypeRepository customerTypeRepository;

    @Override
    public List<CustomerType> getListCustomerType() {
        return customerTypeRepository.findAll();
    }

    @Override
    public void saveCustomerType(CustomerType customerType) {
        customerTypeRepository.save(customerType);
    }

    @Override
    public void updateCustomerType(CustomerType customerType) {
        customerTypeRepository.save(customerType);

    }

    @Override
    public void deleteCustomerType(int id) {
        customerTypeRepository.deleteById(id);

    }


}
