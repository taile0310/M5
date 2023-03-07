package com.furama.repository;

import com.furama.model.contract.AttachFacility;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface IAttachFacilityRepository extends JpaRepository<AttachFacility, Integer> {

    @Query(nativeQuery = true, value = "select fc.cost + (af.cost * :quantity) from facility fc \n " +
            "join attach_facility af where fc.id = :facilityId and af.id = :attachFacilityId"
    )
    double getTotalMoneyAdd(@Param("quantity") int quantity
            , @Param("attachFacilityId") int attachFacility
                , @Param("facilityId") int facility);

    @Query(nativeQuery = true, value = "select facility.cost from facility where facility.id = :facilityId")
    double getCostFacility(@Param("facilityId") int facilityId);
}
