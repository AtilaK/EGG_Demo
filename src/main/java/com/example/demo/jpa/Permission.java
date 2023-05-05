package com.example.demo.jpa;

import jakarta.persistence.*;

@Entity
@Table(name = "PERMISSION")
public class Permission {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;

    @ManyToOne
    @JoinColumn(name="role_id", nullable=false)
    private Role role;

    private String name;

    public Permission(Role role, String name) {
        this.role = role;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Permission() {
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


}
