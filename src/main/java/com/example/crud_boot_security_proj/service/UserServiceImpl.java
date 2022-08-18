package com.example.crud_boot_security_proj.service;

import com.example.crud_boot_security_proj.dao.UserDao;
import com.example.crud_boot_security_proj.entity.Role;
import com.example.crud_boot_security_proj.entity.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService{
    private final UserDao userDao;


    @Autowired
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public List<Users> getUsersAll() {
        return userDao.getUsersAll();
    }

    @Override
    public Users findUserByUsername(String login) {
        return userDao.findUserByUsername(login);
    }

    public void updateUserByUsername(String login,Users user){
        userDao.updateUserByUsername(login,user);
    }

    public void deleteUserByUsername(String login){
        userDao.deleteUserByUsername(login);
    }

    public void saveUser(Users user){
        userDao.saveUser(user);
    }
}
