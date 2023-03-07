package com.furama.controller;

import com.furama.service.IEducationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/education")
public class EducationController {

    @Autowired
    private IEducationService educationService;
    @GetMapping("")
    public String getListEducation(Model model){
        model.addAttribute("educationList", educationService.educationList());
        return "/view/employee/listEducaion";
    }

}
