package com.example.crud_boot_security_proj.entity;

import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "role")
public class Role implements GrantedAuthority {

    public Role(){

    }

    public Role(int id,String role){
        this.id = id;
        this.role = role;
    }

    public Role(String role){
        this.role = role;
    }


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "role")
    private String role;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        String role;
        if(this.role.contains("ROLE_ADMIN")){
            if(this.role.contains("ROLE_USER")) {
                role = "ADMIN, USER";
            } else {
                role = "ADMIN";
            }
        } else {
            role = "USER";
        }
        return role;
    }

    @Override
    public String getAuthority() {
        return getRole();
    }
}
