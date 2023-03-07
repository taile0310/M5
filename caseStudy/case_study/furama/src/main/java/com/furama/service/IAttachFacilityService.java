package com.furama.service;

import com.furama.model.contract.AttachFacility;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface IAttachFacilityService {
    List<AttachFacility> getListAttachFacility();

    double getTotalMoneyAdd(int quantity,int attachFacility, int facility);
    double getCostFacility( int facilityId);

    AttachFacility  findById(int id );
}
