package com.example.crud_boot_security_proj.dao;

import com.example.crud_boot_security_proj.configs.WebSecurityConfig;
import com.example.crud_boot_security_proj.entity.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Users> getUsersAll() {
        return entityManager.createQuery(
                "select users from Users users", Users.class
        ).getResultList();
    }

    @Override
    public Users findUserByUsername(String login) {
        return entityManager.find(Users.class, login);
    }

    @Override
    public void updateUserByUsername(String login, Users user) {

        entityManager.merge(user);

    }

    @Override
    public void deleteUserByUsername(String login) {
        entityManager.createQuery("DELETE from Users where login = :login")
                .setParameter("login", login)
                .executeUpdate();
    }

    @Override
    public void saveUser(Users user) {
        entityManager.persist(user);
    }


}
