package com.furama.controller;

import com.furama.dto.ContractDto;
import com.furama.model.contract.AttachFacility;
import com.furama.model.contract.Contract;
import com.furama.model.contract.ContractDetail;
import com.furama.service.*;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/contract")
public class ContractController {
    @Autowired
    private IContractService contractService;

    @Autowired
    private IEmployeeService employeeService;

    @Autowired
    private ICustomerService customerService;

    @Autowired
    private IFacilityService facilityService;

    @Autowired
    private IAttachFacilityService attachFacilityService;

    @Autowired
    private IContractDetailService contractDetailService;

    @GetMapping("")
    public String getListContract(Model model,
                                  @PageableDefault(size = 3, page = 0, sort = "id",
                                          direction = Sort.Direction.ASC) Pageable pageable) {
        Page<Contract> contractPage = contractService.findAll(pageable);
        model.addAttribute("contractPage", contractPage);
        model.addAttribute("listEmployee", employeeService.listEmployee());
        model.addAttribute("listCustomer", customerService.customerList());
        model.addAttribute("listFacility", facilityService.getListFacility());
        model.addAttribute("attachFacilityService", attachFacilityService.getListAttachFacility());
        model.addAttribute("contractDto", new ContractDto());
        return "/view/contract/listContract";
    }

    @PostMapping("/save")
    public String addNewContract(@Validated @ModelAttribute ContractDto contractDto, BindingResult bindingResult,
                                 RedirectAttributes redirectAttributes, Model model,
                                 @RequestParam("listAttachFacility") int[] listId,
                                 @RequestParam("listQuantity") int[] listQuantity) {

        if (bindingResult.hasErrors()) {
            model.addAttribute("contractDto", contractDto);
            model.addAttribute("listEmployee", employeeService.listEmployee());
            model.addAttribute("listCustomer", customerService.customerList());
            model.addAttribute("listFacility", facilityService.getListFacility());
            model.addAttribute("attachFacilityService", attachFacilityService.getListAttachFacility());
            model.addAttribute("hasErr", "true");
            return "/view/contract/listContract";
        }
        Contract contract = new Contract();
        BeanUtils.copyProperties(contractDto, contract);
        contractService.saveContract(contract);
        addContractDetail(listId,listQuantity, contract.getId());
        redirectAttributes.addFlashAttribute("mess", "Thêm hợp đồng thành công");
        return "redirect:/contract";
    }

    public void addContractDetail(int[] listId, int[] listQuantity, int idContract) {
        for (int i = 0; i < listId.length; i++) {
            Contract contract = contractService.findById(idContract);
            AttachFacility attachFacility = attachFacilityService.findById(listId[i]);
            ContractDetail contractDetail = new ContractDetail(listQuantity[i], contract, attachFacility);
            contractDetailService.addContractDetail(contractDetail);
        }
    }

    @PostMapping("/delete")
    public String deleteContract(@RequestParam int id,RedirectAttributes redirectAttributes){
        contractService.deleteContract(id);
        redirectAttributes.addFlashAttribute("mess", "Xóa hợp đồng thành công");
        return "redirect:/contract";

    }


}
