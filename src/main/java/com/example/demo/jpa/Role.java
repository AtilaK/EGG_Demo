package com.example.demo.jpa;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "ROLE")
public class Role {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String name;

    @OneToMany(mappedBy = "role")
    private Set<Permission> permissions;


    public Set<Permission> getPermissions() {
        return permissions;
    }

    public void setPermissions(Set<Permission> permissions) {
        this.permissions = permissions;
    }

    public Role() {
    }

    public Role(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return String.format("Role[id=%d, name='%s']", id, name);
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
