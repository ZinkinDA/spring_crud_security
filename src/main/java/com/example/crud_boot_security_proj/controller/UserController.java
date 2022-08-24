package com.example.crud_boot_security_proj.controller;

import com.example.crud_boot_security_proj.entity.Users;
import com.example.crud_boot_security_proj.service.RoleService;
import com.example.crud_boot_security_proj.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
@RequestMapping(value = "/")
public class UserController {

    private final UserService userService;
    private final RoleService roleService;

    @Autowired
    public UserController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @GetMapping("/users/userView")
    public String getPageUserForm(Model model, Principal principal) {
        model.addAttribute("thisUser", userService.findUserByUsername(principal.getName()));
        return "/userView";
    }

    @GetMapping("/index")
    public String getUserById(Model model, Principal principal) {
        model.addAttribute("newUser", new Users());
        model.addAttribute("users", userService.getUsersAll());
        model.addAttribute("roles", roleService.getAllRoles());
        model.addAttribute("principalUser", userService.findUserByUsername(principal.getName()));
        return "/index";
    }
}
