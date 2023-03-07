package com.furama.service;

import com.furama.model.customer.CustomerType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ICustomerTypeService {
    List<CustomerType> getListCustomerType();
    void saveCustomerType(CustomerType customerType);
    void updateCustomerType(CustomerType customerType);
    void deleteCustomerType(int id);


}
