package com.furama.service.impl;

import com.furama.model.employee.EducationDegree;
import com.furama.repository.IEducationRepository;
import com.furama.service.IEducationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EducationService implements IEducationService {

    @Autowired
    private IEducationRepository educationRepository;
    @Override
    public List<EducationDegree> educationList() {
        return educationRepository.findAll();
    }
}
