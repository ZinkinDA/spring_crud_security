package com.example.crud_boot_security_proj.dao;

import com.example.crud_boot_security_proj.entity.Role;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.swing.text.html.parser.Entity;
import java.util.List;
import java.util.Set;

public interface RoleDao {
    List<Role> getAllRoles();

    void addRole(Role role);

    Role findById(long id);

    Set<Role> findByIdRoles(List<Integer> roles);

}
