package com.furama.service;

import com.furama.model.employee.Division;
import org.springframework.stereotype.Service;

import java.util.List;


public interface IDivisionService {
    List<Division> listDivision();
}
