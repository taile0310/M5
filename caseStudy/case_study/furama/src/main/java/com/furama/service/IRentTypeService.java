package com.furama.service;


import com.furama.model.facility.RentType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IRentTypeService {
    List<RentType> getListRentType();
    void saveRentType(RentType rentType);
    void deleteRentType(int id);

}
