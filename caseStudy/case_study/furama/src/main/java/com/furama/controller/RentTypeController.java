package com.furama.controller;


import com.furama.service.IRentTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/rent-type")
public class RentTypeController {
    @Autowired
    private IRentTypeService rentTypeService;

    @GetMapping("")
    public String getListRentType(Model model){
        model.addAttribute("getListRentType", rentTypeService.getListRentType());
        return "/view/facility/listRentType";
    }
}
