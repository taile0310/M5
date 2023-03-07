package com.furama.controller;

import com.furama.model.customer.CustomerType;

import com.furama.service.ICustomerTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/customer-type")
public class CustomerTypeController {
    @Autowired
    private ICustomerTypeService customerTypeService;

    @GetMapping("")
    public String getListCustomerType(Model model){
        model.addAttribute("customerService", customerTypeService.getListCustomerType());
        return "view/customer/listCustomerType";
    }

    @PostMapping("/save")
    public String addNewCustomerType(@ModelAttribute CustomerType customerType, RedirectAttributes redirectAttributes){
        customerTypeService.saveCustomerType(customerType);
        redirectAttributes.addFlashAttribute("mess", "Thêm thành công");
        return "redirect:/customer-type";
    }
}
