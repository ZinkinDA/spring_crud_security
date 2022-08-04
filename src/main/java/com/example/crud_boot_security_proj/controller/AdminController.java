package com.example.crud_boot_security_proj.controller;

import com.example.crud_boot_security_proj.entity.Role;
import com.example.crud_boot_security_proj.entity.Users;
import com.example.crud_boot_security_proj.service.RoleService;
import com.example.crud_boot_security_proj.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.persistence.PersistenceContext;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private final UserService userService;
    private RoleService roleService;
    @Autowired
    public AdminController(UserService userService,RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }


    @GetMapping("/users")
    public String getUsers(Model model){
        model.addAttribute("users",userService.getUsersAll());
        return "users";
    }

    @GetMapping("/users/{login}")
    public String getUserByLogin(@PathVariable("login") String login, Model model){
        model.addAttribute("user",userService.findUserByUsername(login));
        return "/user";
    }

    @GetMapping("/users/newUser")
    public String createNewUser(Model model){
        model.addAttribute("newUser", new Users());
        model.addAttribute("rolesUser",roleService.getAllRoles());
        return "newUser";
    }

    @PostMapping("/users/newUser")
    public String saveNewUser(@ModelAttribute("newUser") Users user, @RequestParam("rolesUser")
                              ArrayList<Integer> id){
        user.setRoles(roleService.findByIdRoles(id));
        userService.saveUser(user);
        return "redirect:/users";
    }

    @GetMapping("/users/{login}/edit")
    public String getUpdateUser(@PathVariable("login") String login,Model model){
        model.addAttribute("updateUser",userService.findUserByUsername(login));
        model.addAttribute("roles",roleService.getAllRoles());
        return "edit";
    }

    @PostMapping("/users/{login}")
    public String updateUser(@PathVariable("login") String login,@ModelAttribute("updateUser") Users user,
                                @RequestParam("roles") ArrayList<Integer> id){
        user.setRoles(roleService.findByIdRoles(id));
        userService.updateUserByUsername(login,user);
        return "redirect:/admin/users";
    }

    @DeleteMapping("/users/{login}")
    public String deleteUser(@PathVariable("login") String login){
        userService.deleteUserByUsername(login);
        return "redirect:/admin/users";
    }

}
