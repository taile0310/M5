package com.furama.service.impl;

import com.furama.model.facility.Facility;
import com.furama.repository.IFacilityRepository;
import com.furama.service.IFacilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FacilityService implements IFacilityService {
    @Autowired
    private IFacilityRepository facilityRepository;

    @Override
    public List<Facility> getListFacility() {
        return facilityRepository.findAll();
    }

    @Override
    public void saveFacility(Facility facility) {
        facilityRepository.save(facility);
    }

    @Override
    public void deleteFacility(int id) {
        facilityRepository.deleteById(id);
    }


    @Override
    public Page<Facility> searchForTwoField(String name, int facilityType,Pageable pageable) {
        return facilityRepository.findByNameContainingAndFacilityType_Id(name, facilityType,pageable);
    }

    @Override
    public Page<Facility> findByNameContaining(String name,Pageable pageable) {
        return facilityRepository.findByNameContaining(name,pageable);
    }


}
