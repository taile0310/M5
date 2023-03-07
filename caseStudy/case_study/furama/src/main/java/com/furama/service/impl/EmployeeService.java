package com.furama.service.impl;

import com.furama.model.employee.Employee;
import com.furama.repository.IEmployeeRepository;
import com.furama.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService implements IEmployeeService {
    @Autowired
    private IEmployeeRepository employeeRepository;

    @Override
    public Page<Employee> employeePage(String name, Pageable pageable) {
        return employeeRepository.findByNameContaining(name, pageable);
    }

    @Override
    public void saveEmployee(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public void deleteEmployee(int id) {
        employeeRepository.deleteById(id);
    }

    @Override
    public List<Employee> listEmployee() {
        return employeeRepository.findAll();
    }
}
