package com.furama.controller;


import com.furama.dto.FacilityDto;
import com.furama.model.facility.Facility;
import com.furama.service.IFacilityService;
import com.furama.service.IFacilityTypeService;
import com.furama.service.IRentTypeService;
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
@RequestMapping("/facility")
public class FacilityController {
    @Autowired
    private IFacilityService facilityService;
    @Autowired
    private IFacilityTypeService facilityTypeService;

    @Autowired
    private IRentTypeService rentTypeService;

    @GetMapping("")
    public String getListFacility(@RequestParam(required = false, defaultValue = "") String nameSearch,
                                  @RequestParam(required = false, defaultValue = "0") int facilityTypeSearch,
                                  @PageableDefault(size = 3, page = 0, sort = "id", direction = Sort.Direction.ASC) Pageable pageable,
                                  Model model) {
        Page<Facility> facilityPage = facilityService.findByNameContaining(nameSearch, pageable);
        if (facilityTypeSearch == 0) {
            model.addAttribute("facilityPage",facilityPage);
        } else {
            model.addAttribute("facilityPage",facilityService.searchForTwoField(nameSearch, facilityTypeSearch, pageable));
        }
        model.addAttribute("name", nameSearch);
        model.addAttribute("facilityType", facilityTypeSearch);
        model.addAttribute("getListFacilityType", facilityTypeService.getListFacilityType());
        model.addAttribute("rentTypeService", rentTypeService.getListRentType());
        model.addAttribute("facilityDto", new FacilityDto());
        return "view/facility/listFacility";
    }

    @PostMapping("/save")
    public String addNewFacility(@Validated @ModelAttribute FacilityDto facilityDto, BindingResult bindingResult,
                                 RedirectAttributes redirectAttributes, Model model,
                                 @RequestParam(required = false, defaultValue = "") String nameSearch,
                                 @RequestParam(required = false, defaultValue = "0") int facilityTypeSearch,
                                 @PageableDefault(size = 3, page = 0, sort = "id",
                                         direction = Sort.Direction.ASC) Pageable pageable) {
        Page<Facility> facilityPage = facilityService.searchForTwoField(nameSearch, facilityTypeSearch, pageable);
        if (bindingResult.hasErrors()) {
            model.addAttribute("facilityPage", facilityPage);
            model.addAttribute("name", nameSearch);
            model.addAttribute("facilityType", facilityTypeSearch);
            model.addAttribute("facilityDto", facilityDto);
            model.addAttribute("getListFacilityType", facilityTypeService.getListFacilityType());
            model.addAttribute("rentTypeService", rentTypeService.getListRentType());
            model.addAttribute("hasErr", "true");
            return "view/facility/listFacility";
        }
        Facility facility = new Facility();
        BeanUtils.copyProperties(facilityDto, facility);
        facilityService.saveFacility(facility);
        redirectAttributes.addFlashAttribute("mess", "Thêm mới thành công cơ sở hạ tầng");
        return "redirect:/facility";
    }

    @PostMapping("/update")
    public String updateFacility(@Validated @ModelAttribute FacilityDto facilityDto, BindingResult bindingResult,
                                 RedirectAttributes redirectAttributes, Model model,
                                 @RequestParam(required = false, defaultValue = "") String nameSearch,
                                 @RequestParam(required = false, defaultValue = "0") int facilityTypeSearch,
                                 @PageableDefault(size = 3, page = 0, sort = "id",
                                         direction = Sort.Direction.ASC) Pageable pageable, Facility facility) {
        Page<Facility> facilityPage = facilityService.searchForTwoField(nameSearch, facilityTypeSearch, pageable);
        if (bindingResult.hasErrors()) {
            model.addAttribute("facilityPage", facilityPage);
            model.addAttribute("name", nameSearch);
            model.addAttribute("facilityType", facilityTypeSearch);
            model.addAttribute("facilityDto", facilityDto);
            model.addAttribute("getListFacilityType", facilityTypeService.getListFacilityType());
            model.addAttribute("rentTypeService", rentTypeService.getListRentType());
            model.addAttribute("hasError", "true");
            return "view/facility/listFacility";
        }
        BeanUtils.copyProperties(facilityDto, facility);
        facilityService.saveFacility(facility);
        redirectAttributes.addFlashAttribute("mess", "Sửa thành công cơ sở hạ tầng");
        return "redirect:/facility";
    }

    @PostMapping("/delete")
    public String deleteFacility(@RequestParam int id, RedirectAttributes redirectAttributes) {
        facilityService.deleteFacility(id);
        redirectAttributes.addFlashAttribute("mess", "Xóa cơ sở thành cồng");
        return "redirect:/facility";
    }
}
