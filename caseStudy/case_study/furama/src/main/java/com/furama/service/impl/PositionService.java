package com.furama.service.impl;

import com.furama.model.employee.Position;
import com.furama.repository.IPositionRepository;
import com.furama.service.IPositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PositionService implements IPositionService {
    @Autowired
     private IPositionRepository positionRepository;

    @Override
    public List<Position> positionList() {
        return positionRepository.findAll();
    }
}
