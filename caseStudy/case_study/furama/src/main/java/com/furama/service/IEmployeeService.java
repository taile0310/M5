package com.furama.service;

import com.furama.model.employee.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IEmployeeService {
    Page<Employee> employeePage(String name, Pageable pageable);
     void  saveEmployee(Employee employee);
     void deleteEmployee(int id);
     List<Employee> listEmployee();
}
