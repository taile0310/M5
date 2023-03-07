package com.furama.service;

import com.furama.model.customer.Customer;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ICustomerService {
    void saveCustomer(Customer customer);

    void deleteCustomer(int id);

    Page<Customer> searchForThreeField(String name, String email, int customerType, Pageable pageable);

    Page<Customer> customerPage(String name, String email, Pageable pageable);
    List<Customer> customerList();

}
