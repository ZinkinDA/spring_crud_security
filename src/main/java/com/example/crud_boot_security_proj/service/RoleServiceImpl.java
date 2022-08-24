package com.example.crud_boot_security_proj.service;

import com.example.crud_boot_security_proj.dao.RoleDao;
import com.example.crud_boot_security_proj.entity.Role;
import com.example.crud_boot_security_proj.entity.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Set;

@Service
@Transactional
public class RoleServiceImpl implements RoleService {


    private final RoleDao roleDao;

    @Autowired
    public RoleServiceImpl(RoleDao roleDao) {
        this.roleDao = roleDao;
    }

    @Override
    public List<Role> getAllRoles() {
        return roleDao.getAllRoles();
    }

    @Override
    public void addRole(Role role) {
        roleDao.addRole(role);
    }

    @Override
    public Role findById(long id) {
        return roleDao.findById(id);
    }

    @Override
    public Set<Role> findByIdRoles(List<Integer> id) {
        return roleDao.findByIdRoles(id);
    }

}
