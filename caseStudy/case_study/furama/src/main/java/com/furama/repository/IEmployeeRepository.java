package com.furama.repository;

import com.furama.model.employee.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;



public interface IEmployeeRepository extends JpaRepository<Employee,Integer> {
    Page<Employee> findByNameContaining(String name, Pageable pageable);

}
