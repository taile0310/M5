package com.furama.controller;

import com.furama.dto.EmployeeDto;
import com.furama.model.employee.Employee;
import com.furama.service.*;
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
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private IEmployeeService employeeService;
    @Autowired
    private IPositionService positionService;
    @Autowired
    private IEducationService educationService;
    @Autowired
    private IDivisionService divisionService;

    @Autowired
    private IUserService userService;

    @GetMapping("")
    public String getListEmployee(Model model,
                                  @PageableDefault(size = 3, page = 0, sort = "id"
                                          , direction = Sort.Direction.ASC) Pageable pageable,
                                  @RequestParam(required = false, defaultValue = "") String nameSearch) {
        Page<Employee> employeePage = employeeService.employeePage(nameSearch, pageable);
        model.addAttribute("employeePage", employeePage);
        model.addAttribute("name", nameSearch);
        model.addAttribute("positionService", positionService.positionList());
        model.addAttribute("educationService", educationService.educationList());
        model.addAttribute("divisionService", divisionService.listDivision());
        model.addAttribute("userService", userService.getListUser());
        model.addAttribute("employeeDto", new EmployeeDto());
        return "view/employee/listEmployee";
    }

    @PostMapping("/save")
    public String addNewEmployee(@Validated @ModelAttribute EmployeeDto employeeDto, BindingResult bindingResult,
                                 RedirectAttributes redirectAttributes, Model model,
                                 @PageableDefault(size = 3, page = 0, sort = "id"
                                         , direction = Sort.Direction.ASC) Pageable pageable,
                                 @RequestParam(required = false, defaultValue = "") String nameSearch) {
        Page<Employee> employeePage = employeeService.employeePage(nameSearch, pageable);
        if (bindingResult.hasErrors()) {
            model.addAttribute("employeeDto", employeeDto);
            model.addAttribute("name", nameSearch);
            model.addAttribute("employeePage", employeePage);
            model.addAttribute("positionService", positionService.positionList());
            model.addAttribute("educationService", educationService.educationList());
            model.addAttribute("divisionService", divisionService.listDivision());
            model.addAttribute("userService", userService.getListUser());
            model.addAttribute("hasErr", "true");
            return "view/employee/listEmployee";
        }
        Employee employee = new Employee();
        BeanUtils.copyProperties(employeeDto, employee);
        employeeService.saveEmployee(employee);
        redirectAttributes.addFlashAttribute("mess", "Thêm nhân viên thành công");
        return "redirect:/employee";
    }
}