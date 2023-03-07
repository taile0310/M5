package com.furama.service.impl;

import com.furama.model.employee.Division;
import com.furama.repository.IDivisionRepository;
import com.furama.service.IDivisionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DivisionService implements IDivisionService {
    @Autowired
    private IDivisionRepository divisionRepository;
    @Override
    public List<Division> listDivision() {
        return divisionRepository.findAll();
    }
}
