package com.furama.repository;

import com.furama.model.customer.Customer;
import com.furama.model.facility.Facility;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IFacilityRepository extends JpaRepository<Facility,Integer> {


//    @Query(value = "select * from facility where name like concat('%',:name,'%') and facility_type_id like concat('%',:facilityType,'%')" , nativeQuery = true)
//    Page<Facility> findByNameContainingAndFacilityType(@Param("name") String name,@Param("facilityType") String facilityType, Pageable pageable);

    Page<Facility> findByNameContainingAndFacilityType_Id(String name, int facilityType,Pageable pageable);
    Page<Facility> findByNameContaining(String name,Pageable pageable);
}
