package com.example.crud_boot_security_proj.service;

import com.example.crud_boot_security_proj.configs.WebSecurityConfig;
import com.example.crud_boot_security_proj.dao.UserDao;
import com.example.crud_boot_security_proj.entity.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class UserServiceImpl implements UserService{
    private final UserDao userDao;//Для commit
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(UserDao userDao, WebSecurityConfig webSecurityConfig) {
        this.userDao = userDao;
        this.passwordEncoder = webSecurityConfig.passwordEncoder();
    }

    @Override
    @Transactional
    public List<Users> getUsersAll() {
        return userDao.getUsersAll();
    }

    @Override
    public Users findUserByUsername(String login) {
        return userDao.findUserByUsername(login);
    }

    @Transactional
    @Override
    public void updateUserByUsername(String login, Users user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userDao.updateUserByUsername(login, user);

    }

    @Transactional
    @Override
    public void deleteUserByUsername(String login) {
        userDao.deleteUserByUsername(login);
    }

    @Override
    public void saveUser(Users user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userDao.saveUser(user);
    }
}
