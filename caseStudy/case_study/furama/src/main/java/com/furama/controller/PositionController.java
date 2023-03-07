package com.furama.controller;

import com.furama.service.IPositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/position")
public class PositionController {
    @Autowired
    private IPositionService positionService;

    @GetMapping("")
    public String getListPosition(Model model){
        model.addAttribute("positionList", positionService.positionList());
        return "/view/employee/position";
    }
}
