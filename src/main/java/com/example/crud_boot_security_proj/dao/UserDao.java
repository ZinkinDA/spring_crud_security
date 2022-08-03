package com.example.crud_boot_security_proj.dao;

import com.example.crud_boot_security_proj.entity.Users;
import org.springframework.stereotype.Repository;

import java.util.List;
public interface UserDao {

    List<Users> getUsersAll();

    Users findUserByUsername(String login);
    public void updateUserByUsername(String login,Users user);
    public void deleteUserByUsername(String login);

    void saveUser(Users user);



}
