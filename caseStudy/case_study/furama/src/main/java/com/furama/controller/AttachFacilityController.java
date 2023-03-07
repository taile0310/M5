package com.furama.controller;

import com.furama.model.contract.AttachFacility;
import com.furama.model.contract.Contract;
import com.furama.model.contract.ContractDetail;
import com.furama.service.IAttachFacilityService;
import com.furama.service.IContractDetailService;
import com.furama.service.IContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api")
public class AttachFacilityController {
    @Autowired
    private IAttachFacilityService attachFacilityService;
    @Autowired
    private IContractService contractService;
    @Autowired
    private IContractDetailService contractDetailService;

    @GetMapping("/attach-facility")
    public ResponseEntity<List<AttachFacility>> getListAttachFacility(@RequestParam int idContract) {
        Contract contract = contractService.findById(idContract);
        List<AttachFacility> attachFacilityList = new ArrayList<>();
        for (ContractDetail contractDetail : contract.getContractDetailSet()) {
            attachFacilityList.add(contractDetail.getAttachFacility());
        }
        return new ResponseEntity<>(attachFacilityList, HttpStatus.OK);
    }

    @GetMapping("")
    public ResponseEntity<List<AttachFacility>> getAll() {
        List<AttachFacility> attachFacilityList = attachFacilityService.getListAttachFacility();
        if (attachFacilityList.isEmpty()) {
            return new ResponseEntity<>(attachFacilityList, HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(attachFacilityList, HttpStatus.OK);
        }
    }


    @GetMapping("/addContractDetail")
    public ResponseEntity addContractDetail(@RequestParam(defaultValue = "0") int quantity,
                                            @RequestParam(defaultValue = "0") int attachFacilityId,
                                            @RequestParam(defaultValue = "0") int contractId) {

        ContractDetail contractDetail = new ContractDetail(quantity, contractService.findById(contractId),
                attachFacilityService.findById(attachFacilityId));
        contractDetailService.addContractDetail(contractDetail);
        return new ResponseEntity<>(HttpStatus.OK);
    }


    @GetMapping("/total")
    public ResponseEntity<Double> getTotal(@RequestParam(value = "quantity", defaultValue = "0") int quantity,
                                           @RequestParam(value = "attachFacilityId", defaultValue = "0") int attachFacilityId,
                                           @RequestParam(value = "facilityId", defaultValue = "0") int facilityId) {
        double total = 0;
        if (quantity == 0) {
            total=attachFacilityService.getCostFacility(facilityId);

        }else {
            total= attachFacilityService.getTotalMoneyAdd(quantity, attachFacilityId, facilityId);
        }
        return new ResponseEntity<>(total, HttpStatus.OK);

    }
}
