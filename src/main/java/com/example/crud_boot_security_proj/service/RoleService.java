package com.example.crud_boot_security_proj.service;

import com.example.crud_boot_security_proj.entity.Role;

import java.util.List;
import java.util.Set;

public interface RoleService {
    List<Role> getAllRoles ();
    void addRole(Role role);
    Role findById(long id);
    Set<Role> findByIdRoles(List<Integer>roles);

}
