package com.furama.repository;

import com.furama.model.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;



public interface ICustomerRepository extends JpaRepository<Customer, Integer> {

    //    phân trang list và search
Page<Customer> findByNameContainingAndEmailContainingAndCustomerType_Id(String name, String email, int customerType, Pageable pageable);
Page<Customer> findByNameContainingAndEmailContaining(String name, String email , Pageable pageable);
}
