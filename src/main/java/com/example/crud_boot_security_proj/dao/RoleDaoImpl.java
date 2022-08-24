package com.example.crud_boot_security_proj.dao;

import com.example.crud_boot_security_proj.entity.Role;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Repository
public class RoleDaoImpl implements RoleDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Role> getAllRoles() {
        return entityManager.createQuery("select r from Role r").getResultList();
    }

    @Override
    public void addRole(Role role) {
        entityManager.persist(role);
    }

    @Override
    public Role findById(long id) {
        return entityManager.find(Role.class, id);
    }

    @Override
    public Set<Role> findByIdRoles(List<Integer> id) {
        TypedQuery<Role> q = entityManager.createQuery("select r from Role r where r.id in :id", Role.class);
        q.setParameter("id", id);
        return new HashSet<>(q.getResultList());
    }
}
