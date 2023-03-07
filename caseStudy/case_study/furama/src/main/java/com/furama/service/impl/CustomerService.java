package com.furama.service.impl;

import com.furama.model.customer.Customer;

import com.furama.repository.ICustomerRepository;
import com.furama.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService implements ICustomerService {
    @Autowired
    private ICustomerRepository customerRepository;


    @Override
    public void saveCustomer(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public void deleteCustomer(int id) {
        customerRepository.deleteById(id);
    }

    @Override
    public Page<Customer> searchForThreeField(String name, String email, int customerType, Pageable pageable) {
        return customerRepository.findByNameContainingAndEmailContainingAndCustomerType_Id(name, email, customerType, pageable);
    }

    @Override
    public Page<Customer> customerPage(String name, String email, Pageable pageable) {
        return customerRepository.findByNameContainingAndEmailContaining(name, email, pageable);
    }

    @Override
    public List<Customer> customerList() {
        return customerRepository.findAll();
    }
}
