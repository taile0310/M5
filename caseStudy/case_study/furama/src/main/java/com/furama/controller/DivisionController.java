package com.furama.controller;

import com.furama.service.IDivisionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/division")
public class DivisionController {
    @Autowired
    private IDivisionService divisionService;

    @GetMapping("")
    public String getListDivision(Model model){
        model.addAttribute("listDivision", divisionService.listDivision());
        return "view/employee/listDivision";
    }
}
