package com.example.crud_boot_security_proj.service;

import com.example.crud_boot_security_proj.dao.UserDao;
import com.example.crud_boot_security_proj.entity.Users;
import org.springframework.context.annotation.Bean;

import java.util.List;

public interface UserService {

    List<Users> getUsersAll();

    Users findUserByUsername(String login);

    void updateUserByUsername(String login, Users user);

    void deleteUserByUsername(String login);

    void saveUser(Users user);
}
