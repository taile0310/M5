package com.furama.controller;


import com.furama.model.login.User;
import com.furama.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
public class LoginController {
    @Autowired
    private IUserService userService;

    @GetMapping("/home")
    public String goHome() {
        return "furama";
    }

//    @GetMapping("/login")
//    public String goLogin() {
//        return "login";
//    }
//
//    @PostMapping("/sign-up")
//    public String signUpAccount (@ModelAttribute User user, RedirectAttributes redirectAttributes, Model model){
//        model.addAttribute("user", new User());
//        userService.addAccount(user);
//        redirectAttributes.addFlashAttribute("mess", "Đăng kí tài khoản thành công");
//        return "redirect:/sign-up";
//    }
}

