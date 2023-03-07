package com.furama.service.impl;

import com.furama.model.facility.RentType;
import com.furama.repository.IRentTypeRepository;
import com.furama.service.IRentTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RentTypeService implements IRentTypeService {
    @Autowired
    private IRentTypeRepository rentTypeRepository;

    @Override
    public List<RentType> getListRentType() {
        return rentTypeRepository.findAll();
    }

    @Override
    public void saveRentType(RentType rentType) {
        rentTypeRepository.save(rentType);
    }

    @Override
    public void deleteRentType(int id) {
        rentTypeRepository.deleteById(id);
    }


}
