package com.furama.controller;

import com.furama.dto.CustomerDto;
import com.furama.model.customer.Customer;
import com.furama.model.customer.CustomerType;
import com.furama.service.ICustomerService;
import com.furama.service.ICustomerTypeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private ICustomerService customerService;
    @Autowired
    private ICustomerTypeService customerTypeService;


    @GetMapping("")
    public String getShowListCustomer(
            @RequestParam(required = false, defaultValue = "") String nameSearch,
            @RequestParam(required = false, defaultValue = "") String emailSearch,
            @RequestParam(required = false, defaultValue = "0") int customerTypeSearch,
            @PageableDefault(size = 3, page = 0, sort = "id", direction = Sort.Direction.ASC) Pageable pageable,
            Model model) {
        Page<Customer> customerPage = customerService.customerPage(nameSearch,emailSearch,pageable);
        if (customerTypeSearch == 0) {
            model.addAttribute("customerPage",customerPage);
        } else {
            model.addAttribute("customerPage", customerService.searchForThreeField(nameSearch, emailSearch, customerTypeSearch, pageable));
        }
        model.addAttribute("name", nameSearch);
        model.addAttribute("email", emailSearch);
        model.addAttribute("customerTypeSearch", customerTypeSearch);
        model.addAttribute("getShowListCustomerType", customerTypeService.getListCustomerType());
        model.addAttribute("customerDto", new CustomerDto());
        return "view/customer/listCustomer";
    }

    @PostMapping("/save")
    public String addNewCustomer(@Validated @ModelAttribute CustomerDto customerDto, BindingResult bindingResult,
                                 RedirectAttributes redirectAttributes, Model model,
                                 @RequestParam(required = false, defaultValue = "") String nameSearch,
                                 @RequestParam(required = false, defaultValue = "") String emailSearch,
                                 @RequestParam(required = false, defaultValue = "0") int customerTypeSearch,

                                 @PageableDefault(size = 3, page = 0, sort = "id",
                                         direction = Sort.Direction.ASC) Pageable pageable) {
        Page<Customer> customerPage = customerService.customerPage(nameSearch, emailSearch, pageable);
        if (bindingResult.hasErrors()) {
            model.addAttribute("customerPage", customerPage);
            model.addAttribute("name", nameSearch);
            model.addAttribute("email", emailSearch);
            model.addAttribute("customerDto", customerDto);
            model.addAttribute("customerTypeSearch", customerTypeSearch);
            model.addAttribute("getShowListCustomerType", customerTypeService.getListCustomerType());
            model.addAttribute("hasErr", "true");
            return "view/customer/listCustomer";
        }
        Customer customer = new Customer();
        BeanUtils.copyProperties(customerDto, customer);
        customerService.saveCustomer(customer);
        redirectAttributes.addFlashAttribute("mess", "Thêm mới thành công khách hàng");
        return "redirect:/customer";
    }

    @PostMapping("/update")
    public String updateCustomer(@Validated @ModelAttribute CustomerDto customerDto, BindingResult bindingResult, Customer customer,
                                 @RequestParam(required = false, defaultValue = "") String nameSearch,
                                 @RequestParam(required = false, defaultValue = "") String emailSearch,
                                 @RequestParam(required = false, defaultValue = "0") int customerTypeSearch,
                                 @PageableDefault(size = 3, page = 0, sort = "id",
                                         direction = Sort.Direction.ASC) Pageable pageable,
                                 RedirectAttributes redirectAttributes, Model model) {
        Page<Customer> customerPage = customerService.customerPage(nameSearch, emailSearch, pageable);
        if (bindingResult.hasErrors()) {
            model.addAttribute("customerPage", customerPage);
            model.addAttribute("name", nameSearch);
            model.addAttribute("email", emailSearch);
            model.addAttribute("customerTypeSearch", customerTypeSearch);
            model.addAttribute("customerDto", customerDto);
            model.addAttribute("getShowListCustomerType", customerTypeService.getListCustomerType());
            model.addAttribute("hasError", "true");
            return "view/customer/listCustomer";
        }
        BeanUtils.copyProperties(customerDto, customer);
        customerService.saveCustomer(customer);
        redirectAttributes.addFlashAttribute("mess", "Sửa khách hàng thành công");
        return "redirect:/customer";
    }

    @PostMapping("/delete")
    public String deleteCustomer(@RequestParam int id, RedirectAttributes redirectAttributes) {
        customerService.deleteCustomer(id);
        redirectAttributes.addFlashAttribute("mess", "Xóa thành công khách hàng");
        return "redirect:/customer";
    }

}
