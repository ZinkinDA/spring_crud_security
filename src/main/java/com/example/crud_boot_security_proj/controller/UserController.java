package com.example.crud_boot_security_proj.controller;

import com.example.crud_boot_security_proj.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;

@Controller
@RequestMapping(value = "/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/userView")
    public String getPageUserForm(Model model, Principal principal){
        model.addAttribute("thisUser",userService.findUserByUsername(principal.getName()));
        return "/userView";
    }
}
