package com.furama.service.impl;

import com.furama.model.facility.FacilityType;
import com.furama.repository.IFacilityTypeRepository;
import com.furama.service.IFacilityTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FacilityTypeService implements IFacilityTypeService {
    @Autowired
    private IFacilityTypeRepository facilityTypeRepository;

    @Override
    public List<FacilityType> getListFacilityType() {
        return facilityTypeRepository.findAll();
    }

    @Override
    public void saveFacilityType(FacilityType facilityType) {
        facilityTypeRepository.save(facilityType);
    }

    @Override
    public void deleteFacilityType(int id) {
        facilityTypeRepository.deleteById(id);
    }


}
