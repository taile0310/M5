package com.furama.service.impl;

import com.furama.model.contract.AttachFacility;
import com.furama.repository.IAttachFacilityRepository;
import com.furama.service.IAttachFacilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AttachFacilityService implements IAttachFacilityService {
    @Autowired
        private IAttachFacilityRepository attachFacilityRepository;

    @Override
    public List<AttachFacility> getListAttachFacility() {
        return attachFacilityRepository.findAll();
    }

    @Override
    public double getTotalMoneyAdd(int quality, int attachFacilityId, int facilityId) {
        return attachFacilityRepository.getTotalMoneyAdd(quality, attachFacilityId, facilityId);
    }

    @Override
    public double getCostFacility(int facilityId) {
        return attachFacilityRepository.getCostFacility(facilityId);
    }

    @Override
    public AttachFacility findById(int id) {
       return attachFacilityRepository.findById(id).orElse(null);
    }
}
