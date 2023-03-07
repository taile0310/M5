package com.furama.controller;

import com.furama.service.IFacilityTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/facility-type")
public class FacilityTypeController {
    @Autowired
    private IFacilityTypeService facilityTypeService;

    @GetMapping("")
    public String getListFacilityType(Model model){
        model.addAttribute("getListFacilityType", facilityTypeService.getListFacilityType());
        return "view/facility/listFacilityType";
    }
}
