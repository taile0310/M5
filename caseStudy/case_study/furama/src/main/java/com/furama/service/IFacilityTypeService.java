package com.furama.service;

import com.furama.model.facility.FacilityType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IFacilityTypeService {
    List<FacilityType> getListFacilityType();
    void saveFacilityType(FacilityType facilityType);
    void deleteFacilityType(int id);


}
